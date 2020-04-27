package coffee.cypher.kettle.coroutine.tickdispatcher

import coffee.cypher.kettle.UnstableApi
import java.util.*
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.createCoroutine
import kotlin.math.max

class TaskHandle internal constructor(
        val name: String,
        private val taskBlock: suspend TickCoroutineDispatcher.TaskExecutor.() -> Unit,
        val yieldsAfter: Double
) : AbstractCoroutineContextElement(TaskHandle) {
    companion object Key : CoroutineContext.Key<TaskHandle> {
        fun newTask(
            name: String,
            configuration: ExecutionConfiguration = ExecutionConfiguration.once(),
            block: suspend TickCoroutineDispatcher.TaskExecutor.() -> Unit
        ) = TaskHandle(name, configuration.buildCoroutine(block), configuration.yieldsAfterMs)
    }

    val isRunning
        get() = isInProgress && !isPaused && !isWaiting

    internal val actionQueue = ArrayDeque<TaskAction>()

    var isStarted = false
        private set

    var isStopped = false
        private set

    val isInProgress
       get() = isStarted && !isStopped

    var isPaused = false
        private set

    val isWaiting
        get() = awaitCheck != null

    val isSleeping
        get() = untilNextExecution > 0


    @UnstableApi
    val dataStore = TaskDataStore()

    internal val shouldExecute
        get() = isRunning && !isSleeping && !isPaused

    fun pause() {
        isPaused = true
    }

    fun resume() {
        isPaused = false
    }

    internal fun createCoroutine(executor: TickCoroutineDispatcher.TaskExecutor) = taskBlock.createCoroutine(executor, TaskCompletionHandler(this))

    fun await(checkEvery: Int = 1, check: () -> Boolean) {
        require(checkEvery > 0) { "checkEvery must be positive, was $checkEvery" }
        checkDelay = checkEvery
        untilNextCheck = checkEvery
        awaitCheck = check
    }

    fun abortWait() {
        awaitCheck = null
    }

    fun start() {
        actionQueue.add(TaskAction.START)
    }

    private fun confirmStart() {
        isStarted = true
        untilNextExecution = 0
    }

    fun reset() {
        actionQueue.add(TaskAction.RESET)
    }

    private fun confirmReset() {
        isStarted = false
        isStopped = false
        isPaused = false
        awaitCheck = null
        checkDelay = -1
        untilNextCheck = -1
        untilNextExecution = -1
    }

    fun restart() {
        reset()
        start()
    }

    @OptIn(UnstableApi::class)
    fun stop() {
        actionQueue.add(TaskAction.STOP)
        dataStore.clearExecutionLocalData()
    }

    private fun confirmStop() {
        isStopped = true
    }

    fun sleep(duration: Int) {
        untilNextExecution = duration
    }

    fun tick() {
        if (isPaused) {
            return
        }

        if (checkDelay >= 0) {
            untilNextCheck = max(untilNextCheck - 1, 0)

            if (isWaiting && untilNextCheck <= 0) {
                checkWaitCondition()
            }
        }

        if (isRunning) {
            untilNextExecution = max(untilNextExecution - 1, 0)
        }
    }

    private fun checkWaitCondition() {
        if (untilNextCheck <= 0 && awaitCheck?.invoke() == true) {
            awaitCheck = null
            checkDelay = -1
            untilNextCheck = -1
        } else {
            untilNextCheck = checkDelay
        }
    }

    private var untilNextExecution = -1
    private var checkDelay = -1
    private var untilNextCheck = -1

    private var awaitCheck: (() -> Boolean)? = null

    internal enum class TaskAction(val onComplete: (TaskHandle) -> Unit) {
        START(TaskHandle::confirmStart),
        STOP(TaskHandle::confirmStop),
        RESET(TaskHandle::confirmReset)
    }
}

internal val Continuation<*>.handle
    get() = context[TaskHandle]!!
