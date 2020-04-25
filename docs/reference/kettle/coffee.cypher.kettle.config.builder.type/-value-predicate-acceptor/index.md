[kettle](../../index.md) / [coffee.cypher.kettle.config.builder.type](../index.md) / [ValuePredicateAcceptor](./index.md)

# ValuePredicateAcceptor

(jvm) `interface ValuePredicateAcceptor<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>` [(source)](https://github.com/Cypher121/kettle/blob/master/src/main/kotlin/coffee/cypher/kettle/config/builder/type/ValuePredicateAcceptor.kt#L3)

### Functions

| Name | Summary |
|---|---|
| (jvm) [acceptIf](accept-if.md) | `abstract fun acceptIf(predicate: (T) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| (jvm) [acceptedRange](../../coffee.cypher.kettle.config.builder/accepted-range.md) | `fun <T : `[`Comparable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)`<T>> `[`ValuePredicateAcceptor`](./index.md)`<T>.acceptedRange(range: `[`ClosedRange`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-closed-range/index.html)`<T>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [acceptedValues](../../coffee.cypher.kettle.config.builder/accepted-values.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`ValuePredicateAcceptor`](./index.md)`<T>.acceptedValues(values: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<T>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`ValuePredicateAcceptor`](./index.md)`<T>.acceptedValues(vararg value: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| (jvm) [ListValueProviderBuilder](../../coffee.cypher.kettle.config.builder.value/-list-value-provider-builder/index.md) | `class ListValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-abstract-value-provider-builder/index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<T>>, `[`ValuePredicateAcceptor`](./index.md)`<T>` |
| (jvm) [SerializedListValueProviderBuilder](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md) | `class SerializedListValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractSerializedValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value.serialized/-abstract-serialized-value-provider-builder/index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<T>, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<S>, `[`ListValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-list-value-provider-builder/index.md)`<S>>, `[`ValueSerializer`](../-value-serializer/index.md)`<T, S>, `[`OptionalValueDeserializer`](../-optional-value-deserializer/index.md)`<T, S>, `[`ValuePredicateAcceptor`](./index.md)`<T>` |
| (jvm) [SerializedSingleValueProviderBuilder](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-single-value-provider-builder/index.md) | `open class SerializedSingleValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractSerializedValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value.serialized/-abstract-serialized-value-provider-builder/index.md)`<T, S, `[`SingleValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-single-value-provider-builder/index.md)`<S>>, `[`ValueConverter`](../-value-converter.md)`<T, S>, `[`ValuePredicateAcceptor`](./index.md)`<T>` |
| (jvm) [SingleValueProviderBuilder](../../coffee.cypher.kettle.config.builder.value/-single-value-provider-builder/index.md) | `open class SingleValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-abstract-value-provider-builder/index.md)`<T>, `[`ValuePredicateAcceptor`](./index.md)`<T>` |
