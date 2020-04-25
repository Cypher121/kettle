[kettle](../../index.md) / [coffee.cypher.kettle.config.builder.value.serialized](../index.md) / [AbstractSerializedValueProviderBuilder](./index.md)

# AbstractSerializedValueProviderBuilder

(jvm) `abstract class AbstractSerializedValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, B : `[`AbstractValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-abstract-value-provider-builder/index.md)`<S>> : `[`ConfigElementBuilder`](../../coffee.cypher.kettle.config.builder.type/-config-element-builder/index.md)`<`[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<T>>, `[`DefaultValueAcceptor`](../../coffee.cypher.kettle.config.builder.type/-default-value-acceptor/index.md)`<T>` [(source)](https://github.com/Cypher121/kettle/blob/master/src/main/kotlin/coffee/cypher/kettle/config/builder/value/serialized/AbstractSerializedValueProviderBuilder.kt#L9)

### Properties

| Name | Summary |
|---|---|
| (jvm) [baseBuilder](base-builder.md) | `val baseBuilder: B` |
| (jvm) [combinedPath](combined-path.md) | `val combinedPath: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| (jvm) [comment](comment.md) | `val comment: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?` |
| (jvm) [translationKey](translation-key.md) | `val translationKey: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |

### Functions

| Name | Summary |
|---|---|
| (jvm) [build](build.md) | `fun build(builder: Builder): `[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<T>` |
| (jvm) [comment](comment.md) | `fun comment(vararg comment: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [defaultValue](default-value.md) | `open fun defaultValue(defaultValueSupplier: () -> T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun defaultValue(defaultValue: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [doBuild](do-build.md) | `abstract fun doBuild(builder: Builder): `[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<T>` |
| (jvm) [serialize](serialize.md) | `abstract fun serialize(input: T): S` |
| (jvm) [translationKey](translation-key.md) | `fun translationKey(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| (jvm) [defaultValues](../../coffee.cypher.kettle.config.builder/default-values.md) | `fun <T> `[`DefaultValueAcceptor`](../../coffee.cypher.kettle.config.builder.type/-default-value-acceptor/index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<T>>.defaultValues(vararg value: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| (jvm) [SerializedListValueProviderBuilder](../-serialized-list-value-provider-builder/index.md) | `class SerializedListValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractSerializedValueProviderBuilder`](./index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<T>, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<S>, `[`ListValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-list-value-provider-builder/index.md)`<S>>, `[`ValueSerializer`](../../coffee.cypher.kettle.config.builder.type/-value-serializer/index.md)`<T, S>, `[`OptionalValueDeserializer`](../../coffee.cypher.kettle.config.builder.type/-optional-value-deserializer/index.md)`<T, S>, `[`ValuePredicateAcceptor`](../../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<T>` |
| (jvm) [SerializedSingleValueProviderBuilder](../-serialized-single-value-provider-builder/index.md) | `open class SerializedSingleValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractSerializedValueProviderBuilder`](./index.md)`<T, S, `[`SingleValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-single-value-provider-builder/index.md)`<S>>, `[`ValueConverter`](../../coffee.cypher.kettle.config.builder.type/-value-converter.md)`<T, S>, `[`ValuePredicateAcceptor`](../../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<T>` |
