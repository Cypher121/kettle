//[kettle](../../index.md)/[coffee.cypher.kettle.scheduler](index.md)

# Package coffee.cypher.kettle.scheduler

## Types

| Name | Summary |
|---|---|
| [BasicTaskContext](-basic-task-context/index.md) | [jvm]<br>class [BasicTaskContext](-basic-task-context/index.md)(**scheduler**: [TickingScheduler](-ticking-scheduler/index.md)<[BasicTaskContext](-basic-task-context/index.md)>) : [TaskContext](-task-context/index.md)<[BasicTaskContext](-basic-task-context/index.md)> |
| [ExecutionConfiguration](-execution-configuration/index.md) | [jvm]<br>sealed class [ExecutionConfiguration](-execution-configuration/index.md) |
| [SchedulerBuilder](-scheduler-builder/index.md) | [jvm]<br>class [SchedulerBuilder](-scheduler-builder/index.md)<[C](-scheduler-builder/index.md) : [TaskContext](-task-context/index.md)<[C](-scheduler-builder/index.md)>> |
| [SchedulerDsl](-scheduler-dsl/index.md) | [jvm]<br>annotation class [SchedulerDsl](-scheduler-dsl/index.md) |
| [TaskBuilder](-task-builder/index.md) | [jvm]<br>class [TaskBuilder](-task-builder/index.md)<[C](-task-builder/index.md) : [TaskContext](-task-context/index.md)<[C](-task-builder/index.md)>> |
| [TaskContext](-task-context/index.md) | [jvm]<br>open class [TaskContext](-task-context/index.md)<[C](-task-context/index.md) : [TaskContext](-task-context/index.md)<[C](-task-context/index.md)>>(**scheduler**: [TickingScheduler](-ticking-scheduler/index.md)<[C](-task-context/index.md)>) |
| [TaskExecutionException](-task-execution-exception/index.md) | [jvm]<br>class [TaskExecutionException](-task-execution-exception/index.md) : [RuntimeException](https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/lang/RuntimeException.html) |
| [TaskHandle](-task-handle/index.md) | [jvm]<br>class [TaskHandle](-task-handle/index.md)<[C](-task-handle/index.md) : [TaskContext](-task-context/index.md)<[C](-task-handle/index.md)>> : [AbstractCoroutineContextElement](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-abstract-coroutine-context-element/index.html) |
| [TickingScheduler](-ticking-scheduler/index.md) | [jvm]<br>class [TickingScheduler](-ticking-scheduler/index.md)<[C](-ticking-scheduler/index.md) : [TaskContext](-task-context/index.md)<[C](-ticking-scheduler/index.md)>>(**contextFactory**: ([TickingScheduler](-ticking-scheduler/index.md)<[C](-ticking-scheduler/index.md)>) -> [C](-ticking-scheduler/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [execute](execute.md) | [jvm]<br>fun <[C](execute.md) : [TaskContext](-task-context/index.md)<[C](execute.md)>> [TaskBuilder](-task-builder/index.md)<[C](execute.md)>.[execute](execute.md)(config: suspend [C](execute.md).() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [factory](factory.md) | [jvm]<br>fun <[C](factory.md) : [TaskContext](-task-context/index.md)<[C](factory.md)>> [SchedulerBuilder](-scheduler-builder/index.md)<[C](factory.md)>.[factory](factory.md)(factory: [TickingScheduler](-ticking-scheduler/index.md)<[C](factory.md)>.() -> [C](factory.md)) |
| [scheduler](scheduler.md) | [jvm]<br>fun <[C](scheduler.md) : [TaskContext](-task-context/index.md)<[C](scheduler.md)>> [scheduler](scheduler.md)(config: [SchedulerBuilder](-scheduler-builder/index.md)<[C](scheduler.md)>.() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [TickingScheduler](-ticking-scheduler/index.md)<[C](scheduler.md)> |
| [task](task.md) | [jvm]<br>fun <[C](task.md) : [TaskContext](-task-context/index.md)<[C](task.md)>> [TickingScheduler](-ticking-scheduler/index.md)<[C](task.md)>.[task](task.md)(config: [TaskBuilder](-task-builder/index.md)<[C](task.md)>.() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [TaskHandle](-task-handle/index.md)<[C](task.md)> |
| [tasks](tasks.md) | [jvm]<br>fun <[C](tasks.md) : [TaskContext](-task-context/index.md)<[C](tasks.md)>> [SchedulerBuilder](-scheduler-builder/index.md)<[C](tasks.md)>.[tasks](tasks.md)(config: [TickingScheduler](-ticking-scheduler/index.md)<[C](tasks.md)>.() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
