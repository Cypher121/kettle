[kettle](../../index.md) / [coffee.cypher.kettle.config.builder.type](../index.md) / [OptionalValueDeserializer](./index.md)

# OptionalValueDeserializer

(jvm) `interface OptionalValueDeserializer<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>` [(source)](https://github.com/Cypher121/kettle/blob/master/src/main/kotlin/coffee/cypher/kettle/config/builder/type/OptionalValueDeserializer.kt#L3)

### Functions

| Name | Summary |
|---|---|
| (jvm) [deserializer](deserializer.md) | `abstract fun deserializer(deserializer: (S) -> T?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [deserializeValue](deserialize-value.md) | `abstract fun deserializeValue(input: S): T?` |

### Extension Functions

| Name | Summary |
|---|---|
| (jvm) [deserializeAsRegistryEntry](../../coffee.cypher.kettle.config.builder/deserialize-as-registry-entry.md) | `fun <T : IForgeRegistryEntry<T>> `[`OptionalValueDeserializer`](./index.md)`<T, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.deserializeAsRegistryEntry(errorOnMissing: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| (jvm) [SerializedListValueProviderBuilder](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md) | `class SerializedListValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractSerializedValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value.serialized/-abstract-serialized-value-provider-builder/index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<T>, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<S>, `[`ListValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-list-value-provider-builder/index.md)`<S>>, `[`ValueSerializer`](../-value-serializer/index.md)`<T, S>, `[`OptionalValueDeserializer`](./index.md)`<T, S>, `[`ValuePredicateAcceptor`](../-value-predicate-acceptor/index.md)`<T>` |
