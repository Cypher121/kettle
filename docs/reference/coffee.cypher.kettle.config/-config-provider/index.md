[coffee.cypher.kettle.config](../index.md) / [ConfigProvider](./index.md)

# ConfigProvider

`interface ConfigProvider`

### Properties

| Name | Summary |
|---|---|
| [spec](spec.md) | `abstract val spec: ForgeConfigSpec` |

### Functions

| Name | Summary |
|---|---|
| [refresh](refresh.md) | `abstract fun refresh(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [value](value.md) | `abstract fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> value(vararg path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<`[`T`](value.md#T)`>` |

### Extension Functions

| Name | Summary |
|---|---|
| [manage](../manage.md) | `fun `[`ConfigProvider`](./index.md)`.manage(eventBus: IEventBus?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [register](../register.md) | `fun `[`ConfigProvider`](./index.md)`.register(type: Type): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [registerAndManage](../register-and-manage.md) | `fun `[`ConfigProvider`](./index.md)`.registerAndManage(type: Type, eventBus: IEventBus? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [Config](../-config/index.md) | `class Config : `[`ConfigProvider`](./index.md) |
