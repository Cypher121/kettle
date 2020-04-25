[kettle](../../index.md) / [coffee.cypher.kettle.coroutine.tickdispatcher](../index.md) / [TaskDataStore](./index.md)

# TaskDataStore

(jvm) `class TaskDataStore` [(source)](https://github.com/Cypher121/kettle/blob/master/src/main/kotlin/coffee/cypher/kettle/coroutine/tickdispatcher/TaskDataStore.kt#L3)

### Types

| Name | Summary |
|---|---|
| (jvm) [Lifespan](-lifespan/index.md) | `enum class Lifespan` |

### Constructors

| Name | Summary |
|---|---|
| (jvm) [&lt;init&gt;](-init-.md) | `TaskDataStore()` |

### Functions

| Name | Summary |
|---|---|
| (jvm) [clearExecutionLocalData](clear-execution-local-data.md) | `fun clearExecutionLocalData(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [contains](contains.md) | `operator fun contains(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| (jvm) [get](get.md) | `operator fun <T> get(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): T?` |
| (jvm) [minusAssign](minus-assign.md) | `operator fun minusAssign(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [remove](remove.md) | `fun remove(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [store](store.md) | `fun store(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, lifespan: Lifespan): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
