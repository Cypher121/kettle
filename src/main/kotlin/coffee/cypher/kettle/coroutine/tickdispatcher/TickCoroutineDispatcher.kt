package coffee.cypher.kettle.coroutine.tickdispatcher

import coffee.cypher.kettle.UnstableApi
import coffee.cypher.kettle.coroutine.tickdispatcher.ExecutionConfiguration.Companion.once
import coffee.cypher.kettle.coroutine.tickdispatcher.TaskHandle.TaskAction.*
import kotlin.coroutines.*

class TickCoroutineDispatcher {
    private val currentContinuations = mutableMapOf<TaskHandle, Continuation<Unit>>()

    val tasks: List<TaskHandle>
        get() = _tasks.toList()

    private val _tasks = mutableSetOf<TaskHandle>()

    private var tickStartedAt = -1.0
    private var currentYieldThreshold = -1.0

    fun tick() {
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
                val action: TaskHandle.TaskAction = handle.actionQueue.pop()

                when (action) {
                    START -> currentContinuations[handle] = handle.createCoroutine(TaskExecutor(handle))
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

    inner class TaskExecutor(val taskHandle: TaskHandle) {
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

        @UnstableApi
        fun <T> obtain(key: String): T? = taskHandle.dataStore[key]

        @UnstableApi
        fun store(key: String, value: Any, lifespan: TaskDataStore.Lifespan) {
            taskHandle.dataStore.store(key, value, lifespan)
        }

        @UnstableApi
        fun recordExists(key: String) = key in taskHandle.dataStore

        @UnstableApi
        fun remove(key: String) {
            taskHandle.dataStore -= key
        }
    }
}