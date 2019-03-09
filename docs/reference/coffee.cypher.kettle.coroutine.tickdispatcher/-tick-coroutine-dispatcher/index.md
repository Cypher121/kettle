[coffee.cypher.kettle.coroutine.tickdispatcher](../index.md) / [TickCoroutineDispatcher](./index.md)

# TickCoroutineDispatcher

`class TickCoroutineDispatcher : ITickable`

### Types

| Name | Summary |
|---|---|
| [TaskExecutor](-task-executor/index.md) | `inner class TaskExecutor` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TickCoroutineDispatcher()` |

### Properties

| Name | Summary |
|---|---|
| [tasks](tasks.md) | `val tasks: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`TaskHandle`](../-task-handle/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [addNewTask](add-new-task.md) | `fun addNewTask(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, configuration: `[`ExecutionConfiguration`](../-execution-configuration/index.md)` = once(), start: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, block: suspend `[`TaskExecutor`](-task-executor/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`TaskHandle`](../-task-handle/index.md) |
| [addTask](add-task.md) | `fun addTask(handle: `[`TaskHandle`](../-task-handle/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [processScheduledActions](process-scheduled-actions.md) | `fun processScheduledActions(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [removeTask](remove-task.md) | `fun removeTask(handle: `[`TaskHandle`](../-task-handle/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [tick](tick.md) | `fun tick(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
