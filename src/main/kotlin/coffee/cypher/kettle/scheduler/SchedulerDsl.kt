package coffee.cypher.kettle.scheduler

import java.util.*

/**
 * Marks functions and types belonging to the
 * scheduler creation DSL.
 */
@DslMarker
public annotation class SchedulerDsl

/**
 * A builder object used with DSL extensions
 * to create a [Task].
 *
 * @property name the name of the created task
 */
@SchedulerDsl
public open class TaskBuilder<T : Any>
internal constructor() {
    public var name: String = "<unnamed task ${UUID.randomUUID()}>"

    private var configuration: ExecutionConfiguration = ExecutionConfiguration.once()
    internal lateinit var action: TaskBlock<T>

    /**
     * Configuration setter for this builder.
     *
     * Can be used with extension functions [infinitely], [once], and [multiple].
     *
     * Example:
     * ```
     * run once {
     *     initialDelay = 5
     * }
     * ```
     */
    @SchedulerDsl
    public val run: (configuration: ExecutionConfiguration) -> Unit = {
        this.configuration = it
    }

    internal fun build(): Task<T> = Task.create(name, configuration, action)
}

/**
 * Creates a new task described by the provided
 * [config] with the use of other DSL functions.
 */
@SchedulerDsl
public fun <T : Any> task(config: TaskBuilder<T>.() -> Unit): Task<T> =
    TaskBuilder<T>().apply(config).build()

/**
 * Creates a [Task] attached to a specific [TickingScheduler].
 *
 * @property start `true` if the task should be started immediately,
 * or `false` otherwise
 *
 * @see TaskBuilder
 */
@SchedulerDsl
public class AttachedTaskBuilder<T : Any>
internal constructor() : TaskBuilder<T>() {
    public var start: Boolean = false

    internal fun buildAndSchedule(scheduler: TickingScheduler<T>) =
        build().also { scheduler.addTask(it, start) }
}

/**
 * Creates a new task on the receiver scheduler
 * described by the provided [config]
 * with the use of other DSL functions.
 */
@SchedulerDsl
public fun <T : Any> TickingScheduler<T>.task(config: AttachedTaskBuilder<T>.() -> Unit): Task<T> =
    AttachedTaskBuilder<T>().apply(config).buildAndSchedule(this)

/**
 * Creates a new [TickingScheduler] with no additional task context
 * configured with the provided [config].
 */
@SchedulerDsl
@JvmName("scheduler\$noContext")
public fun scheduler(config: TickingScheduler<Unit>.() -> Unit): TickingScheduler<Unit> =
    TickingScheduler<Unit>().apply(config)

/**
 * Creates a [TickingScheduler] with the additional context
 * of type [T] configured with the provided [config].
 */
@SchedulerDsl
public fun <T : Any> scheduler(config: TickingScheduler<T>.() -> Unit): TickingScheduler<T> =
    TickingScheduler<T>().apply(config)

/**
 * Sets the function executed by the [Task]
 * to the provided [block].
 */
@SchedulerDsl
public fun <T : Any> TaskBuilder<T>.action(block: TaskBlock<T>) {
    action = block
}

/**
 * A builder object representing the [Task]'s
 * [ExecutionConfiguration].
 *
 * @property initialDelay delay in ticks before the task first executes
 * @property yieldsAfterMs number of milliseconds in one execution
 * until [TaskContext.yield] suspends the task.
 */
public sealed class ConfigurationBuilder {
    public var initialDelay: Int = 0
    public var yieldsAfterMs: Double = 50.0

    internal abstract fun build(): ExecutionConfiguration

    /**
     * A builder object for an [ExecutionConfiguration]
     * that will execute once.
     */
    public class Once : ConfigurationBuilder() {
        override fun build() = ExecutionConfiguration.once(initialDelay, yieldsAfterMs)
    }

    /**
     * A builder object for an [ExecutionConfiguration]
     * that will execute multiple times.
     *
     * @property times number of times to execute the task
     * @property pause delay in ticks between each execution
     */
    public class Multiple : ConfigurationBuilder() {
        public var pause: Int = 1
        public var times: Int = 1

        override fun build() = ExecutionConfiguration.repeat(initialDelay, pause, times, yieldsAfterMs)
    }

    /**
     * A builder object for an [ExecutionConfiguration]
     * that will execute infinitely until stopped.
     *
     * @property pause delay in ticks between each execution
     */
    public class Infinite : ConfigurationBuilder() {
        public var pause: Int = 1

        override fun build() = ExecutionConfiguration.infinite(initialDelay, pause, yieldsAfterMs)
    }
}

/**
 * Creates an [ExecutionConfiguration] that executes the task once,
 * further configured with the provided [configuration].
 *
 * @see [TaskBuilder.run]
 */
@SchedulerDsl
public infix fun ((ExecutionConfiguration) -> Unit).once(configuration: ConfigurationBuilder.Once.() -> Unit) {
    this(ConfigurationBuilder.Once().apply(configuration).build())
}

/**
 * Creates an [ExecutionConfiguration] that executes the task multiple times,
 * further configured with the provided [configuration].
 *
 * @see [TaskBuilder.run]
 */
@SchedulerDsl
public infix fun ((ExecutionConfiguration) -> Unit).multiple(configuration: ConfigurationBuilder.Multiple.() -> Unit) {
    this(ConfigurationBuilder.Multiple().apply(configuration).build())
}
/**
 * Creates an [ExecutionConfiguration] that executes the task infinitely,
 * further configured with the provided [configuration].
 *
 * @see [TaskBuilder.run]
 */
@SchedulerDsl
public infix fun ((ExecutionConfiguration) -> Unit).infinitely(configuration: ConfigurationBuilder.Infinite.() -> Unit) {
    this(ConfigurationBuilder.Infinite().apply(configuration).build())
}
