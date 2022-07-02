package coffee.cypher.kettle.scheduler

import java.util.*

@DslMarker
public annotation class SchedulerDsl

@SchedulerDsl
public open class TaskBuilder<T : Any>
internal constructor() {
    public var name: String = "<unnamed task ${UUID.randomUUID()}>"

    private var configuration: ExecutionConfiguration = ExecutionConfiguration.once()
    internal lateinit var action: TaskBlock<T>

    @SchedulerDsl
    public val run: (configuration: ExecutionConfiguration) -> Unit = {
        this.configuration = it
    }

    internal fun build(): Task<T> = Task.create(name, configuration, action)
}

@SchedulerDsl
public fun <T : Any> task(config: TaskBuilder<T>.() -> Unit): Task<T> =
    TaskBuilder<T>().apply(config).build()

@SchedulerDsl
public class AttachedTaskBuilder<T : Any>
internal constructor() : TaskBuilder<T>() {
    public var start: Boolean = false

    internal fun buildAndSchedule(scheduler: TickingScheduler<T>) =
        build().also { scheduler.addTask(it, start) }
}

@SchedulerDsl
public fun <T : Any> TickingScheduler<T>.task(config: AttachedTaskBuilder<T>.() -> Unit): Task<T> =
    AttachedTaskBuilder<T>().apply(config).buildAndSchedule(this)

@SchedulerDsl
@JvmName("scheduler\$noContext")
public fun scheduler(config: TickingScheduler<Unit>.() -> Unit): TickingScheduler<Unit> =
    TickingScheduler<Unit>().apply(config)

@SchedulerDsl
public fun <T : Any> scheduler(config: TickingScheduler<T>.() -> Unit): TickingScheduler<T> =
    TickingScheduler<T>().apply(config)

@SchedulerDsl
public fun <T : Any> TaskBuilder<T>.action(block: TaskBlock<T>) {
    action = block
}

public sealed class ConfigurationBuilder {
    public var initialDelay: Int = 0
    public var yieldsAfterMs: Double = 50.0

    internal abstract fun build(): ExecutionConfiguration

    public class Once : ConfigurationBuilder() {
        override fun build() = ExecutionConfiguration.once(initialDelay, yieldsAfterMs)
    }

    public class Multiple : ConfigurationBuilder() {
        public var pause: Int = 1
        public var times: Int = 1

        override fun build() = ExecutionConfiguration.repeat(initialDelay, pause, times, yieldsAfterMs)
    }

    public class Infinite : ConfigurationBuilder() {
        public var pause: Int = 1

        override fun build() = ExecutionConfiguration.infinite(initialDelay, pause, yieldsAfterMs)
    }
}

@SchedulerDsl
public infix fun ((ExecutionConfiguration) -> Unit).once(configuration: ConfigurationBuilder.Once.() -> Unit) {
    this(ConfigurationBuilder.Once().apply(configuration).build())
}

@SchedulerDsl
public infix fun ((ExecutionConfiguration) -> Unit).multiple(configuration: ConfigurationBuilder.Multiple.() -> Unit) {
    this(ConfigurationBuilder.Multiple().apply(configuration).build())
}

@SchedulerDsl
public infix fun ((ExecutionConfiguration) -> Unit).infinitely(configuration: ConfigurationBuilder.Infinite.() -> Unit) {
    this(ConfigurationBuilder.Infinite().apply(configuration).build())
}
