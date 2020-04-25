[kettle](../../index.md) / [coffee.cypher.kettle.config.builder.type](../index.md) / [ValueDeserializer](./index.md)

# ValueDeserializer

(jvm) `interface ValueDeserializer<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>` [(source)](https://github.com/Cypher121/kettle/blob/master/src/main/kotlin/coffee/cypher/kettle/config/builder/type/ValueDeserializer.kt#L3)

### Functions

| Name | Summary |
|---|---|
| (jvm) [deserializer](deserializer.md) | `abstract fun deserializer(deserializer: (S) -> T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [deserializeValue](deserialize-value.md) | `abstract fun deserializeValue(input: S): T` |

### Extension Functions

| Name | Summary |
|---|---|
| (jvm) [deserializeAsRegistryEntry](../../coffee.cypher.kettle.config.builder/deserialize-as-registry-entry.md) | `fun <T : IForgeRegistryEntry<T>> `[`ValueDeserializer`](./index.md)`<T, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.deserializeAsRegistryEntry(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| (jvm) [ValueConverter](../-value-converter.md) | `interface ValueConverter<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ValueSerializer`](../-value-serializer/index.md)`<T, S>, `[`ValueDeserializer`](./index.md)`<T, S>` |
