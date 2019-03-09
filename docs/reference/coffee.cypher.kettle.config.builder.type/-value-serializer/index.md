[coffee.cypher.kettle.config.builder.type](../index.md) / [ValueSerializer](./index.md)

# ValueSerializer

`interface ValueSerializer<T, S>`

### Functions

| Name | Summary |
|---|---|
| [serializeValue](serialize-value.md) | `abstract fun serializeValue(input: `[`T`](index.md#T)`): `[`S`](index.md#S) |
| [serializer](serializer.md) | `abstract fun serializer(serializer: (`[`T`](index.md#T)`) -> `[`S`](index.md#S)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [serializeUsingRegistryName](../../coffee.cypher.kettle.config.builder/serialize-using-registry-name.md) | `fun <T : IForgeRegistryEntry<`[`T`](../../coffee.cypher.kettle.config.builder/serialize-using-registry-name.md#T)`>> `[`ValueSerializer`](./index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder/serialize-using-registry-name.md#T)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.serializeUsingRegistryName(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [SerializedListValueProviderBuilder](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md) | `class SerializedListValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractSerializedValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value.serialized/-abstract-serialized-value-provider-builder/index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md#T)`>, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`S`](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md#S)`>, `[`ListValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-list-value-provider-builder/index.md)`<`[`S`](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md#S)`>>, `[`ValueSerializer`](./index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md#T)`, `[`S`](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md#S)`>, `[`ValueDeserializer`](../-value-deserializer/index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md#T)`?, `[`S`](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md#S)`>, `[`ValuePredicateAcceptor`](../-value-predicate-acceptor/index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md#T)`>` |
| [ValueConverter](../-value-converter.md) | `interface ValueConverter<T, S> : `[`ValueSerializer`](./index.md)`<`[`T`](../-value-converter.md#T)`, `[`S`](../-value-converter.md#S)`>, `[`ValueDeserializer`](../-value-deserializer/index.md)`<`[`T`](../-value-converter.md#T)`, `[`S`](../-value-converter.md#S)`>` |
