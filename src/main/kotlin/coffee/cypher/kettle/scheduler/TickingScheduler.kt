package coffee.cypher.kettle.scheduler

import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

public class TickingScheduler<C : TaskContext<C>>(
    private val contextFactory: () -> C
) {
    private val currentContinuations = mutableMapOf<TaskHandle<C>, Continuation<Unit>>()

    public val tasks: List<TaskHandle<C>>
        get() = _tasks.toList()

    private val _tasks = mutableSetOf<TaskHandle<C>>()

    private var tickStartedAt = -1.0
    private var currentYieldThreshold = -1.0

    public fun tick() {
        processScheduledActions()

        val toRun = currentContinuations.filter {
            it.key.shouldExecute
        }

        currentContinuations -= toRun.keys

        toRun.forEach {
            tickStartedAt = System.nanoTime() / 1e6
            currentYieldThreshold = it.key.yieldsAfter
            it.key.schedulerContext = ContextForTask(it.key)
            it.value.resume(Unit)
        }

        currentContinuations.forEach {
            it.key.tick()
        }
    }

    private fun processScheduledActions() {
        tasks.filter {
            it.actionQueue.isNotEmpty()
        }.forEach { handle ->
            while (handle.actionQueue.isNotEmpty()) {
                val action: TaskHandle.TaskAction = handle.actionQueue.pop()

                when (action) {
                    TaskHandle.TaskAction.START -> currentContinuations[handle] =
                        handle.createCoroutine(contextFactory())

                    TaskHandle.TaskAction.STOP, TaskHandle.TaskAction.RESET -> currentContinuations -= handle
                }

                action.onComplete(handle)
            }
        }
    }

    public fun addNewTask(
        name: String,
        configuration: ExecutionConfiguration = ExecutionConfiguration.once(),
        start: Boolean = false,
        block: suspend C.() -> Unit
    ): TaskHandle<C> {
        val task = TaskHandle.newTask(name, configuration, block)

        addTask(task)

        if (start) {
            task.start()
        }

        return task
    }

    public fun addTask(handle: TaskHandle<C>) {
        _tasks += handle
    }

    public fun removeTask(handle: TaskHandle<C>) {
        _tasks -= handle
        currentContinuations -= handle
    }

    private inner class ContextForTask(private val task: TaskHandle<C>) : SchedulerContext {
        override fun registerContinuation(continuation: Continuation<Unit>) {
            currentContinuations[task] = continuation
        }

        override fun shouldYield(): Boolean {
            val timePassed = System.nanoTime() / 1e6 - tickStartedAt

            return currentYieldThreshold > 0 && timePassed > currentYieldThreshold
        }

    }
}

public open class TaskContext<C : TaskContext<C>> {
    public suspend fun yield() {
        sleepFor(0)
    }

    public suspend fun endTick() {
        sleepFor(1)
    }

    public suspend fun sleepFor(ticks: Int) {
        suspendCoroutine {
            val handle = it.getHandle<C>()

            if (ticks > 0) {
                handle.sleep(ticks)
                handle.schedulerContext.registerContinuation(it)
            } else {
                if (handle.schedulerContext.shouldYield()) {
                    handle.schedulerContext.registerContinuation(it)
                } else {
                    it.resume(Unit)
                }
            }
        }
    }

    public suspend fun waitUntil(checkEvery: Int = 1, checkNow: Boolean = true, check: () -> Boolean) {
        if (checkNow && check()) {
            yield()
            return
        }

        suspendCoroutine {
            val handle = it.getHandle<C>()
            handle.waitUntil(checkEvery, check)
            handle.schedulerContext.registerContinuation(it)
        }
    }
}

public class BasicTaskContext : TaskContext<BasicTaskContext>()
