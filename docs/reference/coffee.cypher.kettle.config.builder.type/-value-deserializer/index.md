[coffee.cypher.kettle.config.builder.type](../index.md) / [ValueDeserializer](./index.md)

# ValueDeserializer

`interface ValueDeserializer<T, S>`

### Functions

| Name | Summary |
|---|---|
| [deserializeValue](deserialize-value.md) | `abstract fun deserializeValue(input: `[`S`](index.md#S)`): `[`T`](index.md#T) |
| [deserializer](deserializer.md) | `abstract fun deserializer(deserializer: (`[`S`](index.md#S)`) -> `[`T`](index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [deserializeAsRegistryEntry](../../coffee.cypher.kettle.config.builder/deserialize-as-registry-entry.md) | `fun <T : IForgeRegistryEntry<`[`T`](../../coffee.cypher.kettle.config.builder/deserialize-as-registry-entry.md#T)`>> `[`ValueDeserializer`](./index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder/deserialize-as-registry-entry.md#T)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.deserializeAsRegistryEntry(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun <T : IForgeRegistryEntry<`[`T`](../../coffee.cypher.kettle.config.builder/deserialize-as-registry-entry.md#T)`>> `[`ValueDeserializer`](./index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder/deserialize-as-registry-entry.md#T)`?, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.deserializeAsRegistryEntry(errorOnMissing: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [SerializedListValueProviderBuilder](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md) | `class SerializedListValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractSerializedValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value.serialized/-abstract-serialized-value-provider-builder/index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md#T)`>, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`S`](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md#S)`>, `[`ListValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-list-value-provider-builder/index.md)`<`[`S`](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md#S)`>>, `[`ValueSerializer`](../-value-serializer/index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md#T)`, `[`S`](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md#S)`>, `[`ValueDeserializer`](./index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md#T)`?, `[`S`](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md#S)`>, `[`ValuePredicateAcceptor`](../-value-predicate-acceptor/index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md#T)`>` |
| [ValueConverter](../-value-converter.md) | `interface ValueConverter<T, S> : `[`ValueSerializer`](../-value-serializer/index.md)`<`[`T`](../-value-converter.md#T)`, `[`S`](../-value-converter.md#S)`>, `[`ValueDeserializer`](./index.md)`<`[`T`](../-value-converter.md#T)`, `[`S`](../-value-converter.md#S)`>` |
