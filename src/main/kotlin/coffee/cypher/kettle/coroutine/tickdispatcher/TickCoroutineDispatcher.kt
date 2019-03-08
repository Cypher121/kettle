package coffee.cypher.kettle.coroutine.tickdispatcher

import coffee.cypher.kettle.coroutine.tickdispatcher.ExecutionConfiguration.Companion.once
import coffee.cypher.kettle.coroutine.tickdispatcher.TaskHandle.TaskAction.*
import net.minecraft.util.ITickable
import kotlin.coroutines.*

class TickCoroutineDispatcher : ITickable {
    private val currentContinuations = mutableMapOf<TaskHandle, Continuation<Unit>>()

    val tasks: List<TaskHandle>
        get() = _tasks.toList()

    private val _tasks = mutableSetOf<TaskHandle>()
    private val executor = TaskExecutor()

    private var tickStartedAt = -1.0
    private var currentYieldThreshold = -1.0

    override fun tick() {
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

    fun processScheduledActions() {
        tasks.filter {
            it.actionQueue.isNotEmpty()
        }.forEach { handle ->
            while (handle.actionQueue.isNotEmpty()) {
                val action = handle.actionQueue.pop()!!

                when (action) {
                    START -> currentContinuations[handle] = handle.createCoroutine(executor)
                    STOP, RESET -> currentContinuations -= handle
                }

                action.onComplete(handle)
            }
        }
    }

    fun addNewTask(
        name: String,
        configuration: ExecutionConfiguration = once(),
        start: Boolean = false,
        block: suspend TaskExecutor.() -> Unit
    ): TaskHandle {
        val task = TaskHandle.newTask(name, configuration, block)

        addTask(task)

        if (start) {
            task.start()
        }

        return task
    }

    fun addTask(handle: TaskHandle) {
        _tasks += handle
    }

    fun removeTask(handle: TaskHandle) {
        _tasks -= handle
        currentContinuations -= handle
    }

    inner class TaskExecutor {
        suspend fun yield() {
            val timePassed = System.nanoTime() / 1e6 - tickStartedAt

            if (currentYieldThreshold > 0 && timePassed > currentYieldThreshold) {
                endTick()
            }
        }

        suspend fun endTick() {
            sleepFor(1)
        }

        suspend fun sleepFor(ticks: Int) {
            if (ticks > 0) {
                suspendCoroutine<Unit> {
                    it.handle.sleep(ticks)
                    currentContinuations[it.handle] = it
                }
            } else {
                yield()
            }
        }

        suspend fun awaitStatus(checkEvery: Int = 1, checkNow: Boolean = true, check: () -> Boolean) {
            if (checkNow && check()) {
                yield()
                return
            }

            suspendCoroutine<Unit> {
                it.handle.await(checkEvery, check)
                currentContinuations[it.handle] = it
            }
        }

        suspend fun <T> obtain(key: String): T? {
            yield()

            return suspendCoroutine {
                it.resume(it.handle.dataStore[key])
            }
        }

        suspend fun store(key: String, value: Any, lifespan: TaskDataStore.Lifespan) {
            yield()

            suspendCoroutine<Unit> {
                it.handle.dataStore.store(key, value, lifespan)
                it.resume(Unit)
            }
        }

        suspend fun recordExists(key: String): Boolean {
            yield()

            return suspendCoroutine {

                it.resume(key in it.handle.dataStore)
            }
        }

        suspend fun remove(key: String) {
            yield()

            suspendCoroutine<Unit> {
                it.handle.dataStore -= key
                it.resume(Unit)
            }
        }
    }
}