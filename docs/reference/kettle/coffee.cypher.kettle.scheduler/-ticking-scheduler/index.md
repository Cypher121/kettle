//[kettle](../../../index.md)/[coffee.cypher.kettle.scheduler](../index.md)/[TickingScheduler](index.md)

# TickingScheduler

[jvm]\
class [TickingScheduler](index.md)<[C](index.md) : [TaskContext](../-task-context/index.md)<[C](index.md)>>(**contextFactory**: ([TickingScheduler](index.md)<[C](index.md)>) -> [C](index.md))

## Functions

| Name | Summary |
|---|---|
| [addNewTask](add-new-task.md) | [jvm]<br>fun [addNewTask](add-new-task.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), configuration: [ExecutionConfiguration](../-execution-configuration/index.md) = ExecutionConfiguration.once(), start: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, block: suspend [C](index.md).() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [TaskHandle](../-task-handle/index.md)<[C](index.md)> |
| [addTask](add-task.md) | [jvm]<br>fun [addTask](add-task.md)(handle: [TaskHandle](../-task-handle/index.md)<[C](index.md)>) |
| [removeTask](remove-task.md) | [jvm]<br>fun [removeTask](remove-task.md)(handle: [TaskHandle](../-task-handle/index.md)<[C](index.md)>) |
| [tick](tick.md) | [jvm]<br>fun [tick](tick.md)() |

## Properties

| Name | Summary |
|---|---|
| [tasks](tasks.md) | [jvm]<br>val [tasks](tasks.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TaskHandle](../-task-handle/index.md)<[C](index.md)>> |
