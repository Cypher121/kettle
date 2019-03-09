[coffee.cypher.kettle.coroutine.tickdispatcher](../index.md) / [TaskDataStore](./index.md)

# TaskDataStore

`class TaskDataStore`

### Types

| Name | Summary |
|---|---|
| [Lifespan](-lifespan/index.md) | `enum class Lifespan` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TaskDataStore()` |

### Functions

| Name | Summary |
|---|---|
| [clearExecutionLocalData](clear-execution-local-data.md) | `fun clearExecutionLocalData(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [contains](contains.md) | `operator fun contains(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [get](get.md) | `operator fun <T> get(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`T`](get.md#T)`?` |
| [minusAssign](minus-assign.md) | `operator fun minusAssign(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [remove](remove.md) | `fun remove(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [store](store.md) | `fun store(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, lifespan: `[`Lifespan`](-lifespan/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
