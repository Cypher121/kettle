[coffee.cypher.kettle.config.builder.type](../index.md) / [ConfigElementBuilder](./index.md)

# ConfigElementBuilder

`interface ConfigElementBuilder<T> : `[`Function`](http://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)`<Builder, `[`T`](index.md#T)`>`

### Functions

| Name | Summary |
|---|---|
| [apply](apply.md) | `open fun apply(t: Builder): `[`T`](index.md#T) |
| [build](build.md) | `abstract fun build(builder: Builder): `[`T`](index.md#T) |

### Inheritors

| Name | Summary |
|---|---|
| [AbstractSerializedValueProviderBuilder](../../coffee.cypher.kettle.config.builder.value.serialized/-abstract-serialized-value-provider-builder/index.md) | `abstract class AbstractSerializedValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, B : `[`AbstractValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-abstract-value-provider-builder/index.md)`<`[`S`](../../coffee.cypher.kettle.config.builder.value.serialized/-abstract-serialized-value-provider-builder/index.md#S)`>> : `[`ConfigElementBuilder`](./index.md)`<`[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder.value.serialized/-abstract-serialized-value-provider-builder/index.md#T)`>>, `[`DefaultValueAcceptor`](../-default-value-acceptor/index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder.value.serialized/-abstract-serialized-value-provider-builder/index.md#T)`>` |
| [AbstractValueProviderBuilder](../../coffee.cypher.kettle.config.builder.value/-abstract-value-provider-builder/index.md) | `abstract class AbstractValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ConfigElementBuilder`](./index.md)`<`[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder.value/-abstract-value-provider-builder/index.md#T)`>>, `[`DefaultValueAcceptor`](../-default-value-acceptor/index.md)`<`[`T`](../../coffee.cypher.kettle.config.builder.value/-abstract-value-provider-builder/index.md#T)`>` |
| [ConfigBuilder](../../coffee.cypher.kettle.config.builder/-config-builder/index.md) | `class ConfigBuilder : `[`ConfigElementBuilder`](./index.md)`<`[`Config`](../../coffee.cypher.kettle.config/-config/index.md)`>` |
| [SectionBuilder](../../coffee.cypher.kettle.config.builder/-section-builder/index.md) | `class SectionBuilder : `[`ConfigElementBuilder`](./index.md)`<`[`Section`](../../coffee.cypher.kettle.config/-section/index.md)`>` |
