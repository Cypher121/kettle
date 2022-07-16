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
 *
 * @property name name of the task
 * @property state current external state of the task
 *
 * @property isExecuting `true` if task is running and not waiting for a condition
 * or sleeping, or `false` otherwise
 *
 * @property isWaiting `true` if the task is waiting for a condition,
 * or `false` otherwise
 *
 * @property isSleeping `true` if the task is sleeping for a certain amount of
 * ticks, or `false` otherwise
 */
public sealed interface Task<T : Any> {
    public val name: String

    public val state: State

    public val isExecuting: Boolean
    public val isWaiting: Boolean
    public val isSleeping: Boolean

    /**
     * Creates a copy of this task with identical
     * configuration and executed code.
     *
     * Does not copy the current state or progress of the task.
     */
    public fun copy(): Task<T>

    /**
     * Pauses the task, so it can be resumed later using [resume].
     *
     * Throws an exception if called while the task is executing.
     */
    public fun pause()

    /**
     * Resumes the task if it was previously paused with [pause].
     *
     * Throws an exception if called while the task is executing.
     */
    public fun resume()

    /**
     * Resumes the task if it was previously paused with [pause].
     * Additionally, cancels any suspension caused by
     * [TaskContext.sleepFor] or [TaskContext.waitUntil].
     *
     * Throws an exception if called while the task is executing.
     */
    public fun forceResume()

    /**
     * Starts the task if it is newly created or has been [reset].
     *
     * Throws an exception if called while the task is executing.
     */
    public fun start()

    /**
     * Resets the task's execution, so it can be started
     * from the beginning using [start].
     *
     * If the task was set to [execute multiple times][ExecutionConfiguration.repeat]
     * the execution count will also reset.
     *
     * Throws an exception if called while the task is executing.
     */
    public fun reset()

    /**
     * Ends the execution of the task. The task can no longer
     * be resumed, but can be [reset] and started again.
     *
     * Throws an exception if called while the task is executing.
     */
    public fun stop()

    /**
     * [Resets][reset] the task and [starts][start] it from the beginning.
     *
     * If the task was set to [execute multiple times][ExecutionConfiguration.repeat]
     * the execution count will also reset.
     *
     * Throws an exception if called while the task is executing.
     */
    public fun restart() {
        reset()
        start()
    }

    public companion object {
        /**
         * Creates a new [Task] with the given [name] and
         * execution [configuration], that will execute
         * the given [taskBlock] when started.
         */
        public fun <T : Any> create(
            name: String,
            configuration: ExecutionConfiguration = ExecutionConfiguration.once(),
            taskBlock: TaskBlock<T>
        ): Task<T> = TaskInternals(name, configuration, taskBlock)
    }

    /**
     * Represents possible lifecycle states of a task.
     */
    public sealed class State {
        /**
         * Represents a task that has just been created
         * or has been [reset][Task.reset] to its initial state.
         */
        public sealed class Created : State()

        /**
         * Represents a task that has finished execution
         * or has been [stopped][Task.stop].
         */
        public sealed class Stopped : State()

        /**
         * Represents a task that is currently running.
         */
        public sealed class Running : State()

        /**
         * Represents a task that is running,
         * but is currently [paused][Task.pause].
         */
        public sealed class Paused : State()
    }
}
