[kettle](../../index.md) / [coffee.cypher.kettle.config](../index.md) / [Config](./index.md)

# Config

(jvm) `class Config : `[`ConfigProvider`](../-config-provider/index.md) [(source)](https://github.com/Cypher121/kettle/blob/master/src/main/kotlin/coffee/cypher/kettle/config/Config.kt#L7)

### Properties

| Name | Summary |
|---|---|
| (jvm) [spec](spec.md) | `val spec: ForgeConfigSpec` |

### Functions

| Name | Summary |
|---|---|
| (jvm) [refresh](refresh.md) | `fun refresh(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [value](value.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> value(vararg path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ValueProvider`](../../coffee.cypher.kettle.config.value/-value-provider/index.md)`<T>` |

### Extension Functions

| Name | Summary |
|---|---|
| (jvm) [manage](../manage.md) | `fun `[`ConfigProvider`](../-config-provider/index.md)`.manage(eventBus: IEventBus? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [register](../register.md) | `fun `[`ConfigProvider`](../-config-provider/index.md)`.register(type: Type): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| (jvm) [registerAndManage](../register-and-manage.md) | `fun `[`ConfigProvider`](../-config-provider/index.md)`.registerAndManage(type: Type, eventBus: IEventBus? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
