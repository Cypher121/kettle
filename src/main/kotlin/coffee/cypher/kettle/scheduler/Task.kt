package coffee.cypher.kettle.scheduler

public typealias TaskBlock<T> = suspend TaskContext<T>.() -> Unit

/**
 * A task that can be run on a [TickingScheduler].
 * Entirely self-contained and can be moved between schedulers at will.
 * Can be paused, stopped, and restarted from outside the task.
 * Attempting to do so from inside the task will throw [IllegalStateException].
 * Use [TaskContext.sleepFor] and [TaskContext.waitUntil] instead.
 *
 * A task can be created using [Task.create] or using the [task] DSL.
 */
public sealed interface Task<T : Any> {
    public val name: String

    public val state: State

    public val isExecuting: Boolean
    public val isWaiting: Boolean
    public val isSleeping: Boolean

    public fun copy(): Task<T>

    public fun pause()
    public fun resume()
    public fun forceResume()

    public fun start()
    public fun reset()
    public fun stop()

    public fun restart() {
        reset()
        start()
    }

    public companion object {
        public fun <T : Any> create(
            name: String,
            configuration: ExecutionConfiguration = ExecutionConfiguration.once(),
            taskBlock: TaskBlock<T>
        ): Task<T> = TaskInternals(name, configuration, taskBlock)
    }

    public sealed class State {
        public sealed class Created : State()
        public sealed class Stopped : State()

        public sealed class Running : State()
        public sealed class Paused : State()
    }
}
