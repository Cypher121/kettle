package coffee.cypher.kettle.scheduler

@DslMarker
public annotation class SchedulerDsl

@SchedulerDsl
public class TaskBuilder<C : TaskContext<C>>
internal constructor() {
    public var name: String = "<unnamed task #${hashCode().toString(16)}>"

    private lateinit var configuration: ExecutionConfiguration

    @SchedulerDsl
    public val run: (configuration: ExecutionConfiguration) -> Unit = {
        this.configuration = it
    }

    internal lateinit var action: suspend C.() -> Unit
    public var start: Boolean = true

    internal fun buildOnScheduler(ticker: TickingScheduler<C>): TaskHandle<C> =
        ticker.addNewTask(name, configuration, start, action)
}

@SchedulerDsl
public fun <C : TaskContext<C>> TickingScheduler<C>.task(config: TaskBuilder<C>.() -> Unit): TaskHandle<C> =
    TaskBuilder<C>().apply(config).buildOnScheduler(this)

@SchedulerDsl
public fun scheduler(config: TickingScheduler<BasicTaskContext>.() -> Unit): TickingScheduler<BasicTaskContext> =
    TickingScheduler(::BasicTaskContext).apply(config)

@SchedulerDsl
public fun <C : TaskContext<C>> scheduler(contextFactory: () -> C, config: TickingScheduler<C>.() -> Unit): TickingScheduler<C> =
    TickingScheduler(contextFactory).apply(config)

@SchedulerDsl
public fun <C : TaskContext<C>> TaskBuilder<C>.action(config: suspend C.() -> Unit) {
    action = config
}

public sealed class ConfigurationBuilder {
    internal abstract fun build(): ExecutionConfiguration

    public class Once : ConfigurationBuilder() {
        public var initialDelay: Int = 0
        public var yieldsAfterMs: Double = 50.0

        override fun build() = ExecutionConfiguration.once(initialDelay, yieldsAfterMs)
    }

    public class Multiple : ConfigurationBuilder() {
        public var initialDelay: Int = 0
        public var pause: Int = 1
        public var times: Int = 1
        public var yieldsAfterMs: Double = 50.0

        override fun build() = ExecutionConfiguration.repeat(initialDelay, pause, times, yieldsAfterMs)
    }

    public class Infinite : ConfigurationBuilder() {
        public var initialDelay: Int = 0
        public var pause: Int = 1
        public var yieldsAfterMs: Double = 50.0

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

