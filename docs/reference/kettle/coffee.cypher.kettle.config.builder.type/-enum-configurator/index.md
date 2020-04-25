[kettle](../../index.md) / [coffee.cypher.kettle.config.builder.type](../index.md) / [EnumConfigurator](./index.md)

# EnumConfigurator

(jvm) `interface EnumConfigurator` [(source)](https://github.com/Cypher121/kettle/blob/master/src/main/kotlin/coffee/cypher/kettle/config/builder/type/EnumConfigurator.kt#L5)

### Properties

| Name | Summary |
|---|---|
| (jvm) [getMethod](get-method.md) | `abstract val getMethod: EnumGetMethod` |

### Functions

| Name | Summary |
|---|---|
| (jvm) [acceptOrdinals](accept-ordinals.md) | `abstract fun acceptOrdinals(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [ignoreCase](ignore-case.md) | `abstract fun ignoreCase(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [rejectOrdinals](reject-ordinals.md) | `abstract fun rejectOrdinals(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [requireCase](require-case.md) | `abstract fun requireCase(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| (jvm) [SerializedSingleEnumValueProviderBuilder](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-single-enum-value-provider-builder.md) | `class SerializedSingleEnumValueProviderBuilder<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, S : `[`Enum`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)`<S>> : `[`SerializedSingleValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value.serialized/-serialized-single-value-provider-builder/index.md)`<T, S>, `[`EnumConfigurator`](./index.md) |
| (jvm) [SingleEnumValueProviderBuilder](../../coffee.cypher.kettle.config.builder.value/-single-enum-value-provider-builder/index.md) | `class SingleEnumValueProviderBuilder<T : `[`Enum`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)`<T>> : `[`SingleValueProviderBuilder`](../../coffee.cypher.kettle.config.builder.value/-single-value-provider-builder/index.md)`<T>, `[`EnumConfigurator`](./index.md) |
