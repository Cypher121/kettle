[coffee.cypher.kettle.config](./index.md)

## Package coffee.cypher.kettle.config

### Types

| Name | Summary |
|---|---|
| [Config](-config/index.md) | `class Config : `[`ConfigProvider`](-config-provider/index.md) |
| [ConfigProvider](-config-provider/index.md) | `interface ConfigProvider` |
| [Section](-section/index.md) | `class Section` |

### Functions

| Name | Summary |
|---|---|
| [manage](manage.md) | `fun `[`ConfigProvider`](-config-provider/index.md)`.manage(eventBus: IEventBus?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [register](register.md) | `fun `[`ConfigProvider`](-config-provider/index.md)`.register(type: Type): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [registerAndManage](register-and-manage.md) | `fun `[`ConfigProvider`](-config-provider/index.md)`.registerAndManage(type: Type, eventBus: IEventBus? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
