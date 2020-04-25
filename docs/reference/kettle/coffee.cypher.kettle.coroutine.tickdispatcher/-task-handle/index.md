[kettle](../../index.md) / [coffee.cypher.kettle.coroutine.tickdispatcher](../index.md) / [TaskHandle](./index.md)

# TaskHandle

(jvm) `class TaskHandle : `[`AbstractCoroutineContextElement`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-abstract-coroutine-context-element/index.html) [(source)](https://github.com/Cypher121/kettle/blob/master/src/main/kotlin/coffee/cypher/kettle/coroutine/tickdispatcher/TaskHandle.kt#L10)

### Types

| Name | Summary |
|---|---|
| (jvm) [Key](-key/index.md) | `companion object Key : `[`Key`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/-key/index.html)`<`[`TaskHandle`](./index.md)`>` |

### Properties

| Name | Summary |
|---|---|
| (jvm) [dataStore](data-store.md) | `val dataStore: `[`TaskDataStore`](../-task-data-store/index.md) |
| (jvm) [isInProgress](is-in-progress.md) | `val isInProgress: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| (jvm) [isPaused](is-paused.md) | `var isPaused: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| (jvm) [isRunning](is-running.md) | `val isRunning: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| (jvm) [isSleeping](is-sleeping.md) | `val isSleeping: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| (jvm) [isStarted](is-started.md) | `var isStarted: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| (jvm) [isStopped](is-stopped.md) | `var isStopped: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| (jvm) [isWaiting](is-waiting.md) | `val isWaiting: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| (jvm) [name](name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| (jvm) [yieldsAfter](yields-after.md) | `val yieldsAfter: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |

### Functions

| Name | Summary |
|---|---|
| (jvm) [abortWait](abort-wait.md) | `fun abortWait(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [await](await.md) | `fun await(checkEvery: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, check: () -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [pause](pause.md) | `fun pause(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [reset](reset.md) | `fun reset(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [restart](restart.md) | `fun restart(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [resume](resume.md) | `fun resume(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [sleep](sleep.md) | `fun sleep(duration: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [start](start.md) | `fun start(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [stop](stop.md) | `fun stop(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [tick](tick.md) | `fun tick(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| (jvm) [newTask](new-task.md) | `fun newTask(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, configuration: `[`ExecutionConfiguration`](../-execution-configuration/index.md)` = ExecutionConfiguration.once(), block: suspend TaskExecutor.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`TaskHandle`](./index.md) |
