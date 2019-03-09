[coffee.cypher.kettle.config.builder.value.serialized](../index.md) / [AbstractSerializedValueProviderBuilder](./index.md)

# AbstractSerializedValueProviderBuilder

`abstract class AbstractSerializedValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, B : `[`AbstractValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-abstract-value-provider-builder/index.md)`<`[`S`](index.md#S)`>> : `[`ConfigElementBuilder`](../../coffee.cypher.kettle.config.builder.type/-config-element-builder/index.md)`<`[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<`[`T`](index.md#T)`>>, `[`DefaultValueAcceptor`](../../coffee.cypher.kettle.config.builder.type/-default-value-acceptor/index.md)`<`[`T`](index.md#T)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AbstractSerializedValueProviderBuilder(baseBuilder: `[`B`](index.md#B)`)` |

### Properties

| Name | Summary |
|---|---|
| [baseBuilder](base-builder.md) | `val baseBuilder: `[`B`](index.md#B) |
| [combinedPath](combined-path.md) | `val combinedPath: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [comment](comment.md) | `val comment: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?` |
| [translationKey](translation-key.md) | `val translationKey: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(builder: Builder): `[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<`[`T`](index.md#T)`>` |
| [comment](comment.md) | `fun comment(vararg comment: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [defaultValue](default-value.md) | `open fun defaultValue(defaultValueSupplier: () -> `[`T`](index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun defaultValue(defaultValue: `[`T`](index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [doBuild](do-build.md) | `abstract fun doBuild(builder: Builder): `[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<`[`T`](index.md#T)`>` |
| [serialize](serialize.md) | `abstract fun serialize(input: `[`T`](index.md#T)`): `[`S`](index.md#S) |
| [translationKey](translation-key.md) | `fun translationKey(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [apply](../../coffee.cypher.kettle.config.builder.type/-config-element-builder/apply.md) | `open fun apply(t: Builder): `[`T`](../../coffee.cypher.kettle.config.builder.type/-config-element-builder/index.md#T) |

### Inheritors

| Name | Summary |
|---|---|
| [SerializedListValueProviderBuilder](../-serialized-list-value-provider-builder/index.md) | `class SerializedListValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractSerializedValueProviderBuilder`](./index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](../-serialized-list-value-provider-builder/index.md#T)`>, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`S`](../-serialized-list-value-provider-builder/index.md#S)`>, `[`ListValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-list-value-provider-builder/index.md)`<`[`S`](../-serialized-list-value-provider-builder/index.md#S)`>>, `[`ValueSerializer`](../../coffee.cypher.kettle.config.builder.type/-value-serializer/index.md)`<`[`T`](../-serialized-list-value-provider-builder/index.md#T)`, `[`S`](../-serialized-list-value-provider-builder/index.md#S)`>, `[`ValueDeserializer`](../../coffee.cypher.kettle.config.builder.type/-value-deserializer/index.md)`<`[`T`](../-serialized-list-value-provider-builder/index.md#T)`?, `[`S`](../-serialized-list-value-provider-builder/index.md#S)`>, `[`ValuePredicateAcceptor`](../../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<`[`T`](../-serialized-list-value-provider-builder/index.md#T)`>` |
| [SerializedSingleValueProviderBuilder](../-serialized-single-value-provider-builder/index.md) | `class SerializedSingleValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractSerializedValueProviderBuilder`](./index.md)`<`[`T`](../-serialized-single-value-provider-builder/index.md#T)`, `[`S`](../-serialized-single-value-provider-builder/index.md#S)`, `[`SingleValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-single-value-provider-builder/index.md)`<`[`S`](../-serialized-single-value-provider-builder/index.md#S)`>>, `[`ValueConverter`](../../coffee.cypher.kettle.config.builder.type/-value-converter.md)`<`[`T`](../-serialized-single-value-provider-builder/index.md#T)`, `[`S`](../-serialized-single-value-provider-builder/index.md#S)`>, `[`ValuePredicateAcceptor`](../../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<`[`T`](../-serialized-single-value-provider-builder/index.md#T)`>` |
