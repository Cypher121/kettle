[coffee.cypher.kettle.coroutine.tickdispatcher](../index.md) / [TickCoroutineDispatcher](index.md) / [addNewTask](./add-new-task.md)

# addNewTask

`fun addNewTask(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, configuration: `[`ExecutionConfiguration`](../-execution-configuration/index.md)` = once(), start: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, block: suspend `[`TaskExecutor`](-task-executor/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`TaskHandle`](../-task-handle/index.md)