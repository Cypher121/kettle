package coffee.cypher.kettle.scheduler

import java.util.*
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.createCoroutine
import kotlin.math.max

public class TaskHandle<C : TaskContext<C>> internal constructor(
    public val name: String,
    private val taskBlock: suspend C.() -> Unit,
    public val yieldsAfter: Double
) : AbstractCoroutineContextElement(TaskHandle) {
    internal companion object Key : CoroutineContext.Key<TaskHandle<*>> {
        fun <C: TaskContext<C>> newTask(
            name: String,
            configuration: ExecutionConfiguration = ExecutionConfiguration.once(),
            block: suspend C.() -> Unit
        ) = TaskHandle(name, configuration.buildCoroutine(block), configuration.yieldsAfterMs)
    }

    public val isRunning: Boolean
        get() = isInProgress && !isPaused && !isWaiting

    internal val actionQueue = ArrayDeque<TaskAction>()

    public var isStarted: Boolean = false
        private set

    public var isStopped: Boolean = false
        private set

    public val isInProgress: Boolean
        get() = isStarted && !isStopped

    public var isPaused: Boolean = false
        private set

    public val isWaiting: Boolean
        get() = awaitCheck != null

    public val isSleeping: Boolean
        get() = untilNextExecution > 0

    internal val shouldExecute
        get() = isRunning && !isSleeping && !isPaused

    public fun pause() {
        isPaused = true
    }

    public fun resume() {
        isPaused = false
    }

    internal fun createCoroutine(context: C) =
        taskBlock.createCoroutine(context, TaskCompletionHandler(this))

    public fun await(checkEvery: Int = 1, check: () -> Boolean) {
        require(checkEvery > 0) { "checkEvery must be positive, was $checkEvery" }
        checkDelay = checkEvery
        untilNextCheck = checkEvery
        awaitCheck = check
    }

    public fun abortWait() {
        awaitCheck = null
    }

    public fun start() {
        actionQueue.add(TaskAction.START)
    }

    private fun confirmStart() {
        isStarted = true
        untilNextExecution = 0
    }

    public fun reset() {
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

    public fun restart() {
        reset()
        start()
    }

    public fun stop() {
        actionQueue.add(TaskAction.STOP)
    }

    private fun confirmStop() {
        isStopped = true
    }

    public fun sleep(duration: Int) {
        untilNextExecution = duration
    }

    public fun tick() {
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

    internal enum class TaskAction(val onComplete: (TaskHandle<*>) -> Unit) {
        START(TaskHandle<*>::confirmStart),
        STOP(TaskHandle<*>::confirmStop),
        RESET(TaskHandle<*>::confirmReset)
    }
}

@Suppress("UNCHECKED_CAST")
internal fun <C : TaskContext<C>> Continuation<*>.getHandle(): TaskHandle<C> =
    context[TaskHandle]!! as TaskHandle<C>
