//[kettle](../../index.md)/[coffee.cypher.kettle.scheduler](index.md)

# Package coffee.cypher.kettle.scheduler

## Types

| Name | Summary |
|---|---|
| [BasicTaskContext](-basic-task-context/index.md) | [jvm]<br>class [BasicTaskContext](-basic-task-context/index.md)(**scheduler**: [TickingScheduler](-ticking-scheduler/index.md)<[BasicTaskContext](-basic-task-context/index.md)>) : [TaskContext](-task-context/index.md)<[BasicTaskContext](-basic-task-context/index.md)> |
| [ExecutionConfiguration](-execution-configuration/index.md) | [jvm]<br>sealed class [ExecutionConfiguration](-execution-configuration/index.md) |
| [TaskContext](-task-context/index.md) | [jvm]<br>open class [TaskContext](-task-context/index.md)<[C](-task-context/index.md) : [TaskContext](-task-context/index.md)<[C](-task-context/index.md)>>(**scheduler**: [TickingScheduler](-ticking-scheduler/index.md)<[C](-task-context/index.md)>) |
| [TaskExecutionException](-task-execution-exception/index.md) | [jvm]<br>class [TaskExecutionException](-task-execution-exception/index.md) : [RuntimeException](https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/lang/RuntimeException.html) |
| [TaskHandle](-task-handle/index.md) | [jvm]<br>class [TaskHandle](-task-handle/index.md)<[C](-task-handle/index.md) : [TaskContext](-task-context/index.md)<[C](-task-handle/index.md)>> : [AbstractCoroutineContextElement](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-abstract-coroutine-context-element/index.html) |
| [TickingScheduler](-ticking-scheduler/index.md) | [jvm]<br>class [TickingScheduler](-ticking-scheduler/index.md)<[C](-ticking-scheduler/index.md) : [TaskContext](-task-context/index.md)<[C](-ticking-scheduler/index.md)>>(**contextFactory**: ([TickingScheduler](-ticking-scheduler/index.md)<[C](-ticking-scheduler/index.md)>) -> [C](-ticking-scheduler/index.md)) |
