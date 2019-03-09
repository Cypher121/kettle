[coffee.cypher.kettle.config.builder.value.serialized](../index.md) / [SerializedListValueProviderBuilder](./index.md)

# SerializedListValueProviderBuilder

`class SerializedListValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractSerializedValueProviderBuilder`](../-abstract-serialized-value-provider-builder/index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](index.md#T)`>, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`S`](index.md#S)`>, `[`ListValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-list-value-provider-builder/index.md)`<`[`S`](index.md#S)`>>, `[`ValueSerializer`](../../coffee.cypher.kettle.config.builder.type/-value-serializer/index.md)`<`[`T`](index.md#T)`, `[`S`](index.md#S)`>, `[`ValueDeserializer`](../../coffee.cypher.kettle.config.builder.type/-value-deserializer/index.md)`<`[`T`](index.md#T)`?, `[`S`](index.md#S)`>, `[`ValuePredicateAcceptor`](../../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<`[`T`](index.md#T)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SerializedListValueProviderBuilder(path: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>)` |

### Inherited Properties

| Name | Summary |
|---|---|
| [baseBuilder](../-abstract-serialized-value-provider-builder/base-builder.md) | `val baseBuilder: `[`B`](../-abstract-serialized-value-provider-builder/index.md#B) |
| [combinedPath](../-abstract-serialized-value-provider-builder/combined-path.md) | `val combinedPath: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [comment](../-abstract-serialized-value-provider-builder/comment.md) | `val comment: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?` |
| [translationKey](../-abstract-serialized-value-provider-builder/translation-key.md) | `val translationKey: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |

### Functions

| Name | Summary |
|---|---|
| [acceptIf](accept-if.md) | `fun acceptIf(predicate: (`[`T`](index.md#T)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [doBuild](do-build.md) | `fun doBuild(builder: Builder): `[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](index.md#T)`>>` |
| [serialize](serialize.md) | `fun serialize(input: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](index.md#T)`>): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`S`](index.md#S)`>` |

### Inherited Functions

| Name | Summary |
|---|---|
| [acceptedValues](../../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/accepted-values.md) | `open fun acceptedValues(vararg value: `[`T`](../../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun acceptedValues(values: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`T`](../../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md#T)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [build](../-abstract-serialized-value-provider-builder/build.md) | `fun build(builder: Builder): `[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<`[`T`](../-abstract-serialized-value-provider-builder/index.md#T)`>` |
| [comment](../-abstract-serialized-value-provider-builder/comment.md) | `fun comment(vararg comment: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [defaultValue](../-abstract-serialized-value-provider-builder/default-value.md) | `open fun defaultValue(defaultValueSupplier: () -> `[`T`](../-abstract-serialized-value-provider-builder/index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun defaultValue(defaultValue: `[`T`](../-abstract-serialized-value-provider-builder/index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [translationKey](../-abstract-serialized-value-provider-builder/translation-key.md) | `fun translationKey(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [acceptedRange](../../coffee.cypher.kettle.config.builder/accepted-range.md) | `fun <T : `[`Comparable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)`<`[`T`](../../coffee.cypher.kettle.config.builder/accepted-range.md#T)`>> `[`ValuePredicateAcceptor`](../../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder/accepted-range.md#T)`>.acceptedRange(range: `[`ClosedRange`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-closed-range/index.html)`<`[`T`](../../coffee.cypher.kettle.config.builder/accepted-range.md#T)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [deserializeAsRegistryEntry](../../coffee.cypher.kettle.config.builder/deserialize-as-registry-entry.md) | `fun <T : IForgeRegistryEntry<`[`T`](../../coffee.cypher.kettle.config.builder/deserialize-as-registry-entry.md#T)`>> `[`ValueDeserializer`](../../coffee.cypher.kettle.config.builder.type/-value-deserializer/index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder/deserialize-as-registry-entry.md#T)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.deserializeAsRegistryEntry(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun <T : IForgeRegistryEntry<`[`T`](../../coffee.cypher.kettle.config.builder/deserialize-as-registry-entry.md#T)`>> `[`ValueDeserializer`](../../coffee.cypher.kettle.config.builder.type/-value-deserializer/index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder/deserialize-as-registry-entry.md#T)`?, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.deserializeAsRegistryEntry(errorOnMissing: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [serializeUsingRegistryName](../../coffee.cypher.kettle.config.builder/serialize-using-registry-name.md) | `fun <T : IForgeRegistryEntry<`[`T`](../../coffee.cypher.kettle.config.builder/serialize-using-registry-name.md#T)`>> `[`ValueSerializer`](../../coffee.cypher.kettle.config.builder.type/-value-serializer/index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder/serialize-using-registry-name.md#T)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.serializeUsingRegistryName(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
