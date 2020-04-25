[kettle](../../index.md) / [coffee.cypher.kettle.config.builder.value](../index.md) / [SingleValueProviderBuilder](./index.md)

# SingleValueProviderBuilder

(jvm) `open class SingleValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractValueProviderBuilder`](../-abstract-value-provider-builder/index.md)`<T>, `[`ValuePredicateAcceptor`](../../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<T>` [(source)](https://github.com/Cypher121/kettle/blob/master/src/main/kotlin/coffee/cypher/kettle/config/builder/value/SingleValueProviderBuilder.kt#L9)

### Functions

| Name | Summary |
|---|---|
| (jvm) [doBuild](do-build.md) | `open fun doBuild(builder: Builder): `[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<T>` |

### Extension Functions

| Name | Summary |
|---|---|
| (jvm) [acceptedValues](../../coffee.cypher.kettle.config.builder/accepted-values.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`ValuePredicateAcceptor`](../../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<T>.acceptedValues(values: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<T>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`ValuePredicateAcceptor`](../../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<T>.acceptedValues(vararg value: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [defaultValues](../../coffee.cypher.kettle.config.builder/default-values.md) | `fun <T> `[`DefaultValueAcceptor`](../../coffee.cypher.kettle.config.builder.type/-default-value-acceptor/index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<T>>.defaultValues(vararg value: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| (jvm) [SingleEnumValueProviderBuilder](../-single-enum-value-provider-builder/index.md) | `class SingleEnumValueProviderBuilder<T : `[`Enum`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)`<T>> : `[`SingleValueProviderBuilder`](./index.md)`<T>, `[`EnumConfigurator`](../../coffee.cypher.kettle.config.builder.type/-enum-configurator/index.md) |
