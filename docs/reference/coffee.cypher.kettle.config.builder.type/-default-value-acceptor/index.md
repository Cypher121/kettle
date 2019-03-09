[coffee.cypher.kettle.config.builder.type](../index.md) / [DefaultValueAcceptor](./index.md)

# DefaultValueAcceptor

`interface DefaultValueAcceptor<T>`

### Functions

| Name | Summary |
|---|---|
| [defaultValue](default-value.md) | `abstract fun defaultValue(defaultValueSupplier: () -> `[`T`](index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`abstract fun defaultValue(defaultValue: `[`T`](index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [defaultValues](../../coffee.cypher.kettle.config.builder/default-values.md) | `fun <T> `[`DefaultValueAcceptor`](./index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](../../coffee.cypher.kettle.config.builder/default-values.md#T)`>>.defaultValues(vararg value: `[`T`](../../coffee.cypher.kettle.config.builder/default-values.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [AbstractSerializedValueProviderBuilder](../../coffee.cypher.kettle.config.builder.value.serialized/-abstract-serialized-value-provider-builder/index.md) | `abstract class AbstractSerializedValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, B : `[`AbstractValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-abstract-value-provider-builder/index.md)`<`[`S`](../../coffee.cypher.kettle.config.builder.value.serialized/-abstract-serialized-value-provider-builder/index.md#S)`>> : `[`ConfigElementBuilder`](../-config-element-builder/index.md)`<`[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder.value.serialized/-abstract-serialized-value-provider-builder/index.md#T)`>>, `[`DefaultValueAcceptor`](./index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder.value.serialized/-abstract-serialized-value-provider-builder/index.md#T)`>` |
| [AbstractValueProviderBuilder](../../coffee.cypher.kettle.config.builder.value/-abstract-value-provider-builder/index.md) | `abstract class AbstractValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ConfigElementBuilder`](../-config-element-builder/index.md)`<`[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder.value/-abstract-value-provider-builder/index.md#T)`>>, `[`DefaultValueAcceptor`](./index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder.value/-abstract-value-provider-builder/index.md#T)`>` |
