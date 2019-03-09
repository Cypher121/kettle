[coffee.cypher.kettle.config.builder.value](../index.md) / [AbstractValueProviderBuilder](./index.md)

# AbstractValueProviderBuilder

`abstract class AbstractValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ConfigElementBuilder`](../../coffee.cypher.kettle.config.builder.type/-config-element-builder/index.md)`<`[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<`[`T`](index.md#T)`>>, `[`DefaultValueAcceptor`](../../coffee.cypher.kettle.config.builder.type/-default-value-acceptor/index.md)`<`[`T`](index.md#T)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AbstractValueProviderBuilder(path: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>)` |

### Properties

| Name | Summary |
|---|---|
| [combinedPath](combined-path.md) | `val combinedPath: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [comment](comment.md) | `var comment: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?` |
| [defaultValueSupplier](default-value-supplier.md) | `val defaultValueSupplier: () -> `[`T`](index.md#T) |
| [path](path.md) | `val path: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [translationKey](translation-key.md) | `var translationKey: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(builder: Builder): `[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<`[`T`](index.md#T)`>` |
| [comment](comment.md) | `fun comment(vararg comment: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [doBuild](do-build.md) | `abstract fun doBuild(builder: Builder): `[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<`[`T`](index.md#T)`>` |
| [translationKey](translation-key.md) | `fun translationKey(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [apply](../../coffee.cypher.kettle.config.builder.type/-config-element-builder/apply.md) | `open fun apply(t: Builder): `[`T`](../../coffee.cypher.kettle.config.builder.type/-config-element-builder/index.md#T) |

### Inheritors

| Name | Summary |
|---|---|
| [ListValueProviderBuilder](../-list-value-provider-builder/index.md) | `class ListValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractValueProviderBuilder`](./index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](../-list-value-provider-builder/index.md#T)`>>, `[`ValuePredicateAcceptor`](../../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<`[`T`](../-list-value-provider-builder/index.md#T)`>` |
| [SingleValueProviderBuilder](../-single-value-provider-builder/index.md) | `class SingleValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractValueProviderBuilder`](./index.md)`<`[`T`](../-single-value-provider-builder/index.md#T)`>, `[`ValuePredicateAcceptor`](../../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<`[`T`](../-single-value-provider-builder/index.md#T)`>` |
