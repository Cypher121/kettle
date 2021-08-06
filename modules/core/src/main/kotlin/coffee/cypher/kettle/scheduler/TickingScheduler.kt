package coffee.cypher.kettle.scheduler

import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

public class TickingScheduler<C : TaskContext<C>>(
    private val contextFactory: (TickingScheduler<C>) -> C
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
                        handle.createCoroutine(contextFactory(this))

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

    internal fun shouldYield(): Boolean {
        val timePassed = System.nanoTime() / 1e6 - tickStartedAt

        return currentYieldThreshold > 0 && timePassed > currentYieldThreshold
    }

    internal fun registerContinuation(handle: TaskHandle<C>, continuation: Continuation<Unit>) {
        currentContinuations[handle] = continuation
    }
}

public open class TaskContext<C : TaskContext<C>>(
    protected val scheduler: TickingScheduler<C>
) {
    public suspend fun yield() {
        if (scheduler.shouldYield()) {
            endTick()
        }
    }

    public suspend fun endTick() {
        sleepFor(1)
    }

    public suspend fun sleepFor(ticks: Int) {
        if (ticks > 0) {
            suspendCoroutine<Unit> {
                it.getHandle<C>().sleep(ticks)
                scheduler.registerContinuation(it.getHandle(), it)
            }
        } else {
            yield()
        }
    }

    public suspend fun waitForCondition(checkEvery: Int = 1, checkNow: Boolean = true, check: () -> Boolean) {
        if (checkNow && check()) {
            yield()
            return
        }

        suspendCoroutine<Unit> {
            it.getHandle<C>().await(checkEvery, check)
            scheduler.registerContinuation(it.getHandle(), it)
        }
    }
}

public class BasicTaskContext(scheduler: TickingScheduler<BasicTaskContext>) : TaskContext<BasicTaskContext>(scheduler)