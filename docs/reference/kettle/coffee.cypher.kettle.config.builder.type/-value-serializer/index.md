[kettle](../../index.md) / [coffee.cypher.kettle.config.builder.type](../index.md) / [ValueSerializer](./index.md)

# ValueSerializer

(jvm) `interface ValueSerializer<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>` [(source)](https://github.com/Cypher121/kettle/blob/master/src/main/kotlin/coffee/cypher/kettle/config/builder/type/ValueSerializer.kt#L3)

### Functions

| Name | Summary |
|---|---|
| (jvm) [serializer](serializer.md) | `abstract fun serializer(serializer: (T) -> S): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [serializeValue](serialize-value.md) | `abstract fun serializeValue(input: T): S` |

### Extension Functions

| Name | Summary |
|---|---|
| (jvm) [serializeUsingRegistryName](../../coffee.cypher.kettle.config.builder/serialize-using-registry-name.md) | `fun <T : IForgeRegistryEntry<T>> `[`ValueSerializer`](./index.md)`<T, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.serializeUsingRegistryName(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| (jvm) [SerializedListValueProviderBuilder](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-list-value-provider-builder/index.md) | `class SerializedListValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractSerializedValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value.serialized/-abstract-serialized-value-provider-builder/index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<T>, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<S>, `[`ListValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-list-value-provider-builder/index.md)`<S>>, `[`ValueSerializer`](./index.md)`<T, S>, `[`OptionalValueDeserializer`](../-optional-value-deserializer/index.md)`<T, S>, `[`ValuePredicateAcceptor`](../-value-predicate-acceptor/index.md)`<T>` |
| (jvm) [ValueConverter](../-value-converter.md) | `interface ValueConverter<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ValueSerializer`](./index.md)`<T, S>, `[`ValueDeserializer`](../-value-deserializer/index.md)`<T, S>` |
