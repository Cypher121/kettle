[kettle](../../index.md) / [coffee.cypher.kettle.config.builder.type](../index.md) / [DefaultValueAcceptor](./index.md)

# DefaultValueAcceptor

(jvm) `interface DefaultValueAcceptor<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>` [(source)](https://github.com/Cypher121/kettle/blob/master/src/main/kotlin/coffee/cypher/kettle/config/builder/type/DefaultValueAcceptor.kt#L3)

### Functions

| Name | Summary |
|---|---|
| (jvm) [defaultValue](default-value.md) | `abstract fun defaultValue(defaultValueSupplier: () -> T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`abstract fun defaultValue(defaultValue: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| (jvm) [defaultValues](../../coffee.cypher.kettle.config.builder/default-values.md) | `fun <T> `[`DefaultValueAcceptor`](./index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<T>>.defaultValues(vararg value: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| (jvm) [AbstractSerializedValueProviderBuilder](../../coffee.cypher.kettle.config.builder.value.serialized/-abstract-serialized-value-provider-builder/index.md) | `abstract class AbstractSerializedValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, B : `[`AbstractValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-abstract-value-provider-builder/index.md)`<S>> : `[`ConfigElementBuilder`](../-config-element-builder/index.md)`<`[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<T>>, `[`DefaultValueAcceptor`](./index.md)`<T>` |
| (jvm) [AbstractValueProviderBuilder](../../coffee.cypher.kettle.config.builder.value/-abstract-value-provider-builder/index.md) | `abstract class AbstractValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ConfigElementBuilder`](../-config-element-builder/index.md)`<`[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<T>>, `[`DefaultValueAcceptor`](./index.md)`<T>` |
