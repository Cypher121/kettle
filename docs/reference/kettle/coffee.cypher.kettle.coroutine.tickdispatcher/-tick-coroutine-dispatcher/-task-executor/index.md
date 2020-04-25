[kettle](../../../index.md) / [coffee.cypher.kettle.coroutine.tickdispatcher](../../index.md) / [TickCoroutineDispatcher](../index.md) / [TaskExecutor](./index.md)

# TaskExecutor

(jvm) `inner class TaskExecutor` [(source)](https://github.com/Cypher121/kettle/blob/master/src/main/kotlin/coffee/cypher/kettle/coroutine/tickdispatcher/TickCoroutineDispatcher.kt#L82)

### Constructors

| Name | Summary |
|---|---|
| (jvm) [&lt;init&gt;](-init-.md) | `TaskExecutor()` |

### Functions

| Name | Summary |
|---|---|
| (jvm) [awaitStatus](await-status.md) | `suspend fun awaitStatus(checkEvery: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, checkNow: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, check: () -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [endTick](end-tick.md) | `suspend fun endTick(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [obtain](obtain.md) | `suspend fun <T> obtain(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): T?` |
| (jvm) [recordExists](record-exists.md) | `suspend fun recordExists(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| (jvm) [remove](remove.md) | `suspend fun remove(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [sleepFor](sleep-for.md) | `suspend fun sleepFor(ticks: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [store](store.md) | `suspend fun store(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, lifespan: Lifespan): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [yield](yield.md) | `suspend fun yield(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
