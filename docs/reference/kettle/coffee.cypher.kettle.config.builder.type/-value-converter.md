[kettle](../index.md) / [coffee.cypher.kettle.config.builder.type](index.md) / [ValueConverter](./-value-converter.md)

# ValueConverter

(jvm) `interface ValueConverter<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ValueSerializer`](-value-serializer/index.md)`<T, S>, `[`ValueDeserializer`](-value-deserializer/index.md)`<T, S>` [(source)](https://github.com/Cypher121/kettle/blob/master/src/main/kotlin/coffee/cypher/kettle/config/builder/type/ValueConverter.kt#L3)

### Inheritors

| Name | Summary |
|---|---|
| (jvm) [SerializedSingleValueProviderBuilder](../coffee.cypher.kettle.config.builder.value.serialized/-serialized-single-value-provider-builder/index.md) | `open class SerializedSingleValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractSerializedValueProviderBuilder`](../coffee.cypher.kettle.config.builder.value.serialized/-abstract-serialized-value-provider-builder/index.md)`<T, S, `[`SingleValueProviderBuilder`](../coffee.cypher.kettle.config.builder.value/-single-value-provider-builder/index.md)`<S>>, `[`ValueConverter`](./-value-converter.md)`<T, S>, `[`ValuePredicateAcceptor`](-value-predicate-acceptor/index.md)`<T>` |
