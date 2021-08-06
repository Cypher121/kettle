package coffee.cypher.kettle.scheduler

import kotlin.experimental.ExperimentalTypeInference
import kotlin.properties.Delegates


public annotation class SchedulerDsl

@SchedulerDsl
public class TaskBuilder<C : TaskContext<C>>
internal constructor() {
    public lateinit var name: String
    internal lateinit var configuration: ExecutionConfiguration

    @OptIn(ExperimentalTypeInference::class)
    @BuilderInference
    internal lateinit var execBlock: suspend C.() -> Unit
    public var start: Boolean by Delegates.notNull()

    internal fun buildOnScheduler(ticker: TickingScheduler<C>): TaskHandle<C> =
        ticker.addNewTask(name, configuration, start, execBlock)
}

@SchedulerDsl
public class SchedulerBuilder<C : TaskContext<C>> internal constructor() {
    public lateinit var factory: (TickingScheduler<C>) -> C
    internal lateinit var taskConfig: TickingScheduler<C>.() -> Unit

    public fun build(): TickingScheduler<C> =
        TickingScheduler(factory).apply(taskConfig)
}

@OptIn(ExperimentalTypeInference::class)
@BuilderInference
public fun <C : TaskContext<C>> SchedulerBuilder<C>.tasks(@BuilderInference config: TickingScheduler<C>.() -> Unit) {
    taskConfig = config
}

@OptIn(ExperimentalTypeInference::class)
@BuilderInference
public fun <C : TaskContext<C>> TickingScheduler<C>.task(@BuilderInference config: TaskBuilder<C>.() -> Unit): TaskHandle<C> =
    TaskBuilder<C>().apply(config).buildOnScheduler(this)

@OptIn(ExperimentalTypeInference::class)
@BuilderInference
public fun <C : TaskContext<C>> scheduler(@BuilderInference config: SchedulerBuilder<C>.() -> Unit): TickingScheduler<C> =
    SchedulerBuilder<C>().apply(config).build()

@OptIn(ExperimentalTypeInference::class)
@BuilderInference
public fun <C : TaskContext<C>> TaskBuilder<C>.execute(@BuilderInference config: suspend C.() -> Unit) {
    execBlock = config
}

@OptIn(ExperimentalTypeInference::class)
@BuilderInference
public fun <C : TaskContext<C>> SchedulerBuilder<C>.factory(@BuilderInference factory: TickingScheduler<C>.() -> C) {
    this.factory = factory
}


