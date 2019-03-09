[coffee.cypher.kettle.config.builder](./index.md)

## Package coffee.cypher.kettle.config.builder

### Types

| Name | Summary |
|---|---|
| [ConfigBuilder](-config-builder/index.md) | `class ConfigBuilder : `[`ConfigElementBuilder`](../coffee.cypher.kettle.config.builder.type/-config-element-builder/index.md)`<`[`Config`](../coffee.cypher.kettle.config/-config/index.md)`>` |
| [SectionBuilder](-section-builder/index.md) | `class SectionBuilder : `[`ConfigElementBuilder`](../coffee.cypher.kettle.config.builder.type/-config-element-builder/index.md)`<`[`Section`](../coffee.cypher.kettle.config/-section/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [acceptedRange](accepted-range.md) | `fun <T : `[`Comparable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)`<`[`T`](accepted-range.md#T)`>> `[`ValuePredicateAcceptor`](../coffee.cypher.kettle.config.builder.type/-value-predicate-acceptor/index.md)`<`[`T`](accepted-range.md#T)`>.acceptedRange(range: `[`ClosedRange`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-closed-range/index.html)`<`[`T`](accepted-range.md#T)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [config](config.md) | `fun config(block: `[`SectionBuilder`](-section-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Config`](../coffee.cypher.kettle.config/-config/index.md) |
| [defaultValues](default-values.md) | `fun <T> `[`DefaultValueAcceptor`](../coffee.cypher.kettle.config.builder.type/-default-value-acceptor/index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](default-values.md#T)`>>.defaultValues(vararg value: `[`T`](default-values.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [deserializeAsRegistryEntry](deserialize-as-registry-entry.md) | `fun <T : IForgeRegistryEntry<`[`T`](deserialize-as-registry-entry.md#T)`>> `[`ValueDeserializer`](../coffee.cypher.kettle.config.builder.type/-value-deserializer/index.md)`<`[`T`](deserialize-as-registry-entry.md#T)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.deserializeAsRegistryEntry(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun <T : IForgeRegistryEntry<`[`T`](deserialize-as-registry-entry.md#T)`>> `[`ValueDeserializer`](../coffee.cypher.kettle.config.builder.type/-value-deserializer/index.md)`<`[`T`](deserialize-as-registry-entry.md#T)`?, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.deserializeAsRegistryEntry(errorOnMissing: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [serializeUsingRegistryName](serialize-using-registry-name.md) | `fun <T : IForgeRegistryEntry<`[`T`](serialize-using-registry-name.md#T)`>> `[`ValueSerializer`](../coffee.cypher.kettle.config.builder.type/-value-serializer/index.md)`<`[`T`](serialize-using-registry-name.md#T)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.serializeUsingRegistryName(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
