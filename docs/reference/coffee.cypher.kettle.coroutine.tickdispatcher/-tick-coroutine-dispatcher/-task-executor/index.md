[coffee.cypher.kettle.coroutine.tickdispatcher](../../index.md) / [TickCoroutineDispatcher](../index.md) / [TaskExecutor](./index.md)

# TaskExecutor

`inner class TaskExecutor`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TaskExecutor()` |

### Functions

| Name | Summary |
|---|---|
| [awaitStatus](await-status.md) | `suspend fun awaitStatus(checkEvery: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, checkNow: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, check: () -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [endTick](end-tick.md) | `suspend fun endTick(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [obtain](obtain.md) | `suspend fun <T> obtain(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`T`](obtain.md#T)`?` |
| [recordExists](record-exists.md) | `suspend fun recordExists(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [remove](remove.md) | `suspend fun remove(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [sleepFor](sleep-for.md) | `suspend fun sleepFor(ticks: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [store](store.md) | `suspend fun store(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, lifespan: `[`Lifespan`](../../-task-data-store/-lifespan/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [yield](yield.md) | `suspend fun yield(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
