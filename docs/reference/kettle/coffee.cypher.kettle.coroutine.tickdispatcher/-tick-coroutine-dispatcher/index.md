[kettle](../../index.md) / [coffee.cypher.kettle.coroutine.tickdispatcher](../index.md) / [TickCoroutineDispatcher](./index.md)

# TickCoroutineDispatcher

(jvm) `class TickCoroutineDispatcher` [(source)](https://github.com/Cypher121/kettle/blob/master/src/main/kotlin/coffee/cypher/kettle/coroutine/tickdispatcher/TickCoroutineDispatcher.kt#L7)

### Types

| Name | Summary |
|---|---|
| (jvm) [TaskExecutor](-task-executor/index.md) | `inner class TaskExecutor` |

### Constructors

| Name | Summary |
|---|---|
| (jvm) [&lt;init&gt;](-init-.md) | `TickCoroutineDispatcher()` |

### Properties

| Name | Summary |
|---|---|
| (jvm) [tasks](tasks.md) | `val tasks: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`TaskHandle`](../-task-handle/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| (jvm) [addNewTask](add-new-task.md) | `fun addNewTask(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, configuration: `[`ExecutionConfiguration`](../-execution-configuration/index.md)` = once(), start: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, block: suspend TaskExecutor.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`TaskHandle`](../-task-handle/index.md) |
| (jvm) [addTask](add-task.md) | `fun addTask(handle: `[`TaskHandle`](../-task-handle/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [processScheduledActions](process-scheduled-actions.md) | `fun processScheduledActions(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [removeTask](remove-task.md) | `fun removeTask(handle: `[`TaskHandle`](../-task-handle/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [tick](tick.md) | `fun tick(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
