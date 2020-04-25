[kettle](../../index.md) / [coffee.cypher.kettle.config.builder.value](../index.md) / [AbstractValueProviderBuilder](./index.md)

# AbstractValueProviderBuilder

(jvm) `abstract class AbstractValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ConfigElementBuilder`](../../coffee.cypher.kettle.config.builder.type/-config-element-builder/index.md)`<`[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<T>>, `[`DefaultValueAcceptor`](../../coffee.cypher.kettle.config.builder.type/-default-value-acceptor/index.md)`<T>` [(source)](https://github.com/Cypher121/kettle/blob/master/src/main/kotlin/coffee/cypher/kettle/config/builder/value/AbstractValueProviderBuilder.kt#L9)

### Properties

| Name | Summary |
|---|---|
| (jvm) [combinedPath](combined-path.md) | `val combinedPath: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| (jvm) [comment](comment.md) | `var comment: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?` |
| (jvm) [defaultValueSupplier](default-value-supplier.md) | `val defaultValueSupplier: (() -> T)?` |
| (jvm) [path](path.md) | `val path: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| (jvm) [translationKey](translation-key.md) | `var translationKey: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |

### Functions

| Name | Summary |
|---|---|
| (jvm) [build](build.md) | `fun build(builder: Builder): `[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<T>` |
| (jvm) [comment](comment.md) | `fun comment(vararg comment: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [doBuild](do-build.md) | `abstract fun doBuild(builder: Builder): `[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<T>` |
| (jvm) [translationKey](translation-key.md) | `fun translationKey(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| (jvm) [defaultValues](../../coffee.cypher.kettle.config.builder/default-values.md) | `fun <T> `[`DefaultValueAcceptor`](../../coffee.cypher.kettle.config.builder.type/-default-value-acceptor/index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<T>>.defaultValues(vararg value: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| (jvm) [ListValueProviderBuilder](../-list-value-provider-builder/index.md) | `class ListValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractValueProviderBuilder`](./index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<T>>, `[`ValuePredicateAcceptor`](../../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<T>` |
| (jvm) [SingleValueProviderBuilder](../-single-value-provider-builder/index.md) | `open class SingleValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractValueProviderBuilder`](./index.md)`<T>, `[`ValuePredicateAcceptor`](../../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<T>` |
