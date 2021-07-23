//[kettle](../../../index.md)/[coffee.cypher.kettle.scheduler](../index.md)/[SchedulerBuilder](index.md)

# SchedulerBuilder

[jvm]\
class [SchedulerBuilder](index.md)<[C](index.md) : [TaskContext](../-task-context/index.md)<[C](index.md)>>

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>fun [build](build.md)(): [TickingScheduler](../-ticking-scheduler/index.md)<[C](index.md)> |

## Properties

| Name | Summary |
|---|---|
| [factory](factory.md) | [jvm]<br>lateinit var [factory](factory.md): ([TickingScheduler](../-ticking-scheduler/index.md)<[C](index.md)>) -> [C](index.md) |

## Extensions

| Name | Summary |
|---|---|
| [factory](../factory.md) | [jvm]<br>fun <[C](../factory.md) : [TaskContext](../-task-context/index.md)<[C](../factory.md)>> [SchedulerBuilder](index.md)<[C](../factory.md)>.[factory](../factory.md)(factory: [TickingScheduler](../-ticking-scheduler/index.md)<[C](../factory.md)>.() -> [C](../factory.md)) |
| [tasks](../tasks.md) | [jvm]<br>fun <[C](../tasks.md) : [TaskContext](../-task-context/index.md)<[C](../tasks.md)>> [SchedulerBuilder](index.md)<[C](../tasks.md)>.[tasks](../tasks.md)(config: [TickingScheduler](../-ticking-scheduler/index.md)<[C](../tasks.md)>.() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
