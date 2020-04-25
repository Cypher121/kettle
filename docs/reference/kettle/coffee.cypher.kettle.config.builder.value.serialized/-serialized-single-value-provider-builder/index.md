[kettle](../../index.md) / [coffee.cypher.kettle.config.builder.value.serialized](../index.md) / [SerializedSingleValueProviderBuilder](./index.md)

# SerializedSingleValueProviderBuilder

(jvm) `open class SerializedSingleValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractSerializedValueProviderBuilder`](../-abstract-serialized-value-provider-builder/index.md)`<T, S, `[`SingleValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-single-value-provider-builder/index.md)`<S>>, `[`ValueConverter`](../../coffee.cypher.kettle.config.builder.type/-value-converter.md)`<T, S>, `[`ValuePredicateAcceptor`](../../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<T>` [(source)](https://github.com/Cypher121/kettle/blob/master/src/main/kotlin/coffee/cypher/kettle/config/builder/value/serialized/SerializedSingleValueProviderBuilder.kt#L11)

### Functions

| Name | Summary |
|---|---|
| (jvm) [acceptIf](accept-if.md) | `open fun acceptIf(predicate: (T) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [doBuild](do-build.md) | `open fun doBuild(builder: Builder): `[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<T>` |
| (jvm) [serialize](serialize.md) | `open fun serialize(input: T): S` |

### Extension Functions

| Name | Summary |
|---|---|
| (jvm) [acceptedValues](../../coffee.cypher.kettle.config.builder/accepted-values.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`ValuePredicateAcceptor`](../../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<T>.acceptedValues(values: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<T>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`ValuePredicateAcceptor`](../../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<T>.acceptedValues(vararg value: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [defaultValues](../../coffee.cypher.kettle.config.builder/default-values.md) | `fun <T> `[`DefaultValueAcceptor`](../../coffee.cypher.kettle.config.builder.type/-default-value-acceptor/index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<T>>.defaultValues(vararg value: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| (jvm) [SerializedSingleEnumValueProviderBuilder](../-serialized-single-enum-value-provider-builder.md) | `class SerializedSingleEnumValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Enum`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)`<S>> : `[`SerializedSingleValueProviderBuilder`](./index.md)`<T, S>, `[`EnumConfigurator`](../../coffee.cypher.kettle.config.builder.type/-enum-configurator/index.md) |
