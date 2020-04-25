[kettle](../index.md) / [coffee.cypher.kettle.config.builder.value](./index.md)

## Package coffee.cypher.kettle.config.builder.value

### Types

| Name | Summary |
|---|---|
| (jvm) [AbstractValueProviderBuilder](-abstract-value-provider-builder/index.md) | `abstract class AbstractValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ConfigElementBuilder`](../coffee.cypher.kettle.config.builder.type/-config-element-builder/index.md)`<`[`ValueProvider`](../coffee.cypher.kettle.config.value/-value-provider/index.md)`<T>>, `[`DefaultValueAcceptor`](../coffee.cypher.kettle.config.builder.type/-default-value-acceptor/index.md)`<T>` |
| (jvm) [ListValueProviderBuilder](-list-value-provider-builder/index.md) | `class ListValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractValueProviderBuilder`](-abstract-value-provider-builder/index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<T>>, `[`ValuePredicateAcceptor`](../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<T>` |
| (jvm) [SingleEnumValueProviderBuilder](-single-enum-value-provider-builder/index.md) | `class SingleEnumValueProviderBuilder<T : `[`Enum`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)`<T>> : `[`SingleValueProviderBuilder`](-single-value-provider-builder/index.md)`<T>, `[`EnumConfigurator`](../coffee.cypher.kettle.config.builder.type/-enum-configurator/index.md) |
| (jvm) [SingleValueProviderBuilder](-single-value-provider-builder/index.md) | `open class SingleValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`AbstractValueProviderBuilder`](-abstract-value-provider-builder/index.md)`<T>, `[`ValuePredicateAcceptor`](../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<T>` |
