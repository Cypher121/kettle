[coffee.cypher.kettle.config.builder.type](index.md) / [ValueConverter](./-value-converter.md)

# ValueConverter

`interface ValueConverter<T, S> : `[`ValueSerializer`](-value-serializer/index.md)`<`[`T`](-value-converter.md#T)`, `[`S`](-value-converter.md#S)`>, `[`ValueDeserializer`](-value-deserializer/index.md)`<`[`T`](-value-converter.md#T)`, `[`S`](-value-converter.md#S)`>`

### Inherited Functions

| Name | Summary |
|---|---|
| [deserializeValue](-value-deserializer/deserialize-value.md) | `abstract fun deserializeValue(input: `[`S`](-value-deserializer/index.md#S)`): `[`T`](-value-deserializer/index.md#T) |
| [deserializer](-value-deserializer/deserializer.md) | `abstract fun deserializer(deserializer: (`[`S`](-value-deserializer/index.md#S)`) -> `[`T`](-value-deserializer/index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [serializeValue](-value-serializer/serialize-value.md) | `abstract fun serializeValue(input: `[`T`](-value-serializer/index.md#T)`): `[`S`](-value-serializer/index.md#S) |
| [serializer](-value-serializer/serializer.md) | `abstract fun serializer(serializer: (`[`T`](-value-serializer/index.md#T)`) -> `[`S`](-value-serializer/index.md#S)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [deserializeAsRegistryEntry](../coffee.cypher.kettle.config.builder/deserialize-as-registry-entry.md) | `fun <T : IForgeRegistryEntry<`[`T`](../coffee.cypher.kettle.config.builder/deserialize-as-registry-entry.md#T)`>> `[`ValueDeserializer`](-value-deserializer/index.md)`<`[`T`](../coffee.cypher.kettle.config.builder/deserialize-as-registry-entry.md#T)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.deserializeAsRegistryEntry(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun <T : IForgeRegistryEntry<`[`T`](../coffee.cypher.kettle.config.builder/deserialize-as-registry-entry.md#T)`>> `[`ValueDeserializer`](-value-deserializer/index.md)`<`[`T`](../coffee.cypher.kettle.config.builder/deserialize-as-registry-entry.md#T)`?, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.deserializeAsRegistryEntry(errorOnMissing: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [serializeUsingRegistryName](../coffee.cypher.kettle.config.builder/serialize-using-registry-name.md) | `fun <T : IForgeRegistryEntry<`[`T`](../coffee.cypher.kettle.config.builder/serialize-using-registry-name.md#T)`>> `[`ValueSerializer`](-value-serializer/index.md)`<`[`T`](../coffee.cypher.kettle.config.builder/serialize-using-registry-name.md#T)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.serializeUsingRegistryName(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [SerializedSingleValueProviderBuilder](../coffee.cypher.kettle.config.builder.value.serialized/-serialized-single-value-provider-builder/index.md) | `class SerializedSingleValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractSerializedValueProviderBuilder`](../coffee.cypher.kettle.config.builder.value.serialized/-abstract-serialized-value-provider-builder/index.md)`<`[`T`](../coffee.cypher.kettle.config.builder.value.serialized/-serialized-single-value-provider-builder/index.md#T)`, `[`S`](../coffee.cypher.kettle.config.builder.value.serialized/-serialized-single-value-provider-builder/index.md#S)`, `[`SingleValueProviderBuilder`](../coffee.cypher.kettle.config.builder.value/-single-value-provider-builder/index.md)`<`[`S`](../coffee.cypher.kettle.config.builder.value.serialized/-serialized-single-value-provider-builder/index.md#S)`>>, `[`ValueConverter`](./-value-converter.md)`<`[`T`](../coffee.cypher.kettle.config.builder.value.serialized/-serialized-single-value-provider-builder/index.md#T)`, `[`S`](../coffee.cypher.kettle.config.builder.value.serialized/-serialized-single-value-provider-builder/index.md#S)`>, `[`ValuePredicateAcceptor`](-value-predicate-acceptor/index.md)`<`[`T`](../coffee.cypher.kettle.config.builder.value.serialized/-serialized-single-value-provider-builder/index.md#T)`>` |
