[kettle](../index.md) / [coffee.cypher.kettle.config.builder](./index.md)

## Package coffee.cypher.kettle.config.builder

### Types

| Name | Summary |
|---|---|
| (jvm) [ConfigBuilder](-config-builder/index.md) | `class ConfigBuilder : `[`ConfigElementBuilder`](../coffee.cypher.kettle.config.builder.type/-config-element-builder/index.md)`<`[`Config`](../coffee.cypher.kettle.config/-config/index.md)`>` |
| (jvm) [SectionBuilder](-section-builder/index.md) | `class SectionBuilder : `[`ConfigElementBuilder`](../coffee.cypher.kettle.config.builder.type/-config-element-builder/index.md)`<`[`Section`](../coffee.cypher.kettle.config/-section/index.md)`>` |

### Annotations

| Name | Summary |
|---|---|
| (jvm) [UnknownTypeSerialization](-unknown-type-serialization/index.md) | `annotation class UnknownTypeSerialization` |

### Functions

| Name | Summary |
|---|---|
| (jvm) [acceptedRange](accepted-range.md) | `fun <T : `[`Comparable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)`<T>> `[`ValuePredicateAcceptor`](../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<T>.acceptedRange(range: `[`ClosedRange`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-closed-range/index.html)`<T>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [acceptedValues](accepted-values.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`ValuePredicateAcceptor`](../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<T>.acceptedValues(values: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<T>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`ValuePredicateAcceptor`](../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<T>.acceptedValues(vararg value: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [config](config.md) | `fun config(block: `[`SectionBuilder`](-section-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Config`](../coffee.cypher.kettle.config/-config/index.md) |
| (jvm) [defaultValues](default-values.md) | `fun <T> `[`DefaultValueAcceptor`](../coffee.cypher.kettle.config.builder.type/-default-value-acceptor/index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<T>>.defaultValues(vararg value: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [deserializeAsRegistryEntry](deserialize-as-registry-entry.md) | `fun <T : IForgeRegistryEntry<T>> `[`ValueDeserializer`](../coffee.cypher.kettle.config.builder.type/-value-deserializer/index.md)`<T, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.deserializeAsRegistryEntry(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun <T : IForgeRegistryEntry<T>> `[`OptionalValueDeserializer`](../coffee.cypher.kettle.config.builder.type/-optional-value-deserializer/index.md)`<T, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.deserializeAsRegistryEntry(errorOnMissing: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [serializeUsingRegistryName](serialize-using-registry-name.md) | `fun <T : IForgeRegistryEntry<T>> `[`ValueSerializer`](../coffee.cypher.kettle.config.builder.type/-value-serializer/index.md)`<T, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.serializeUsingRegistryName(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
