package coffee.cypher.kettle.scheduler

import java.lang.IllegalStateException
import kotlin.coroutines.*

internal class TaskInternals<T : Any> internal constructor(
    override val name: String,
    private val configuration: ExecutionConfiguration,
    private val taskBlock: TaskBlock<T>
) : AbstractCoroutineContextElement(TaskInternals), Task<T> {
    companion object Key : CoroutineContext.Key<TaskInternals<*>> {
        context(TaskContext<T>)
        fun <T : Any> of(continuation: Continuation<*>): TaskInternals<T> {
            @Suppress("UNCHECKED_CAST")
            return continuation.context[TaskInternals]!! as TaskInternals<T>
        }
    }

    internal var lockedForExecution = false

    internal val context = TaskContext<T>()

    internal lateinit var executionContext: ExecutionContext<T>

    fun shouldYield(): Boolean {
        val currentMs = (System.nanoTime() / 1e6)

        return (currentMs - executionContext.executionStartedAt) > configuration.yieldsAfterMs
    }

    override var state: Task.State = CreatedInternal
        private set
    private var suspension: Suspension? = null

    override val isExecuting: Boolean
        get() = state is RunningInternal && suspension == null

    override val isWaiting: Boolean
        get() = suspension is Suspension.Wait

    override val isSleeping: Boolean
        get() = suspension is Suspension.Sleep

    override fun copy(): TaskInternals<T> = TaskInternals(name, configuration, taskBlock)

    private fun requireSuspended() {
        require(!lockedForExecution) { "Operation cannot be performed from inside the task" }
    }

    override fun pause() {
        requireSuspended()

        val currentState = state
        if (currentState is RunningInternal) {
            state = currentState.toPaused()
        }
    }

    override fun resume() {
        requireSuspended()

        val currentState = state
        if (currentState is PausedInternal) {
            state = currentState.toRunning()
        }
    }

    private fun createCoroutine() =
        configuration.buildCoroutine(taskBlock).createCoroutine(
            context,
            Continuation(EmptyCoroutineContext) { result ->
                stop()

                result.onFailure {
                    throw TaskExecutionException(name, it)
                }
            }
        )

    fun waitUntil(checkEvery: Int = 1, check: () -> Boolean, continuation: Continuation<Unit>) {
        require(checkEvery > 0) { "checkEvery must be positive, was $checkEvery" }
        suspension = Suspension.Wait(checkEvery, checkEvery, check)
        state = RunningInternal(continuation, this)
    }

    override fun forceResume() {
        requireSuspended()

        resume()
        suspension = null
    }

    override fun start() {
        requireSuspended()

        if (state is Task.State.Created) {
            state = RunningInternal(createCoroutine(), this)
        }
    }

    override fun reset() {
        requireSuspended()

        if (state !is Task.State.Created) {
            state = CreatedInternal
            suspension = null
        }
    }

    override fun stop() {
        requireSuspended()

        if (state !is Task.State.Stopped) {
            state = StoppedInternal
            suspension = null
        }
    }

    fun sleep(duration: Int, continuation: Continuation<Unit>) {
        suspension = Suspension.Sleep(duration)
        state = RunningInternal(continuation, this)
    }

    fun yield(continuation: Continuation<Unit>) {
        state = RunningInternal(continuation, this)
    }

    fun advanceWaitTimers() {
        if (state !is Task.State.Running) {
            return
        }

        when (val current = suspension) {
            is Suspension.Wait -> {
                current.untilNextCheck--

                if (current.untilNextCheck <= 0) {
                    if (current.condition()) {
                        suspension = null
                    } else {
                        current.untilNextCheck = current.checkEvery
                    }
                }
            }

            is Suspension.Sleep -> {
                current.untilExecution--
                if (current.untilExecution <= 0) {
                    suspension = null
                }
            }

            null -> {}
        }
    }

    internal object CreatedInternal : Task.State.Created()
    internal object StoppedInternal : Task.State.Created()

    internal class RunningInternal internal constructor(
        private val continuation: Continuation<Unit>,
        private val task: TaskInternals<*>
    ) : Task.State.Running() {
        internal fun toPaused() = PausedInternal(continuation, task)

        internal fun withContinuation(action: (Continuation<Unit>) -> Unit) {
            task.lockedForExecution = true
            action(continuation)
            task.lockedForExecution = false
        }
    }

    internal class PausedInternal internal constructor(
        private val continuation: Continuation<Unit>,
        private val task: TaskInternals<*>
    ) : Task.State.Paused() {
        internal fun toRunning() = RunningInternal(continuation, task)
    }

    private sealed class Suspension {
        class Sleep(
            var untilExecution: Int
        ) : Suspension()

        class Wait(
            val checkEvery: Int,
            var untilNextCheck: Int,
            val condition: (() -> Boolean)
        ) : Suspension()
    }
}

internal fun <T : Any> Task<T>.internal(): TaskInternals<T> {
    return this as? TaskInternals<T>
        ?: throw IllegalStateException("Unknown task implementation found: do not implement Task yourself")
}
