//[kettle](../../index.md)/[coffee.cypher.kettle.tickers.task](index.md)

# Package coffee.cypher.kettle.tickers.task

## Types

| Name | Summary |
|---|---|
| [BlockEntityTaskContext](-block-entity-task-context/index.md) | [jvm]<br>class [BlockEntityTaskContext](-block-entity-task-context/index.md)<[T](-block-entity-task-context/index.md) : BlockEntity>(**scheduler**: [TickingScheduler](../coffee.cypher.kettle.scheduler/-ticking-scheduler/index.md)<[BlockEntityTaskContext](-block-entity-task-context/index.md)<[T](-block-entity-task-context/index.md)>>, **blockEntity**: [T](-block-entity-task-context/index.md)) : [TaskContext](../coffee.cypher.kettle.scheduler/-task-context/index.md)<[BlockEntityTaskContext](-block-entity-task-context/index.md)<[T](-block-entity-task-context/index.md)>> |
| [TaskBlockEntityTicker](-task-block-entity-ticker/index.md) | [jvm]<br>class [TaskBlockEntityTicker](-task-block-entity-ticker/index.md)<[T](-task-block-entity-ticker/index.md) : BlockEntity>(**config**: [TickingScheduler](../coffee.cypher.kettle.scheduler/-ticking-scheduler/index.md)<[BlockEntityTaskContext](-block-entity-task-context/index.md)<[T](-task-block-entity-ticker/index.md)>>.() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) : BlockEntityTicker<[T](-task-block-entity-ticker/index.md)> |
| [TickerTask](index.md#-1973214425%2FClasslikes%2F-1216412040) | [jvm]<br>typealias [TickerTask](index.md#-1973214425%2FClasslikes%2F-1216412040)<[T](index.md#-1973214425%2FClasslikes%2F-1216412040)> = [BlockEntityTaskContext](-block-entity-task-context/index.md)<[T](index.md#-1973214425%2FClasslikes%2F-1216412040)>.() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

## Functions

| Name | Summary |
|---|---|
| [taskTicker](task-ticker.md) | [jvm]<br>fun <[T](task-ticker.md) : BlockEntity> [taskTicker](task-ticker.md)(config: [TickingScheduler](../coffee.cypher.kettle.scheduler/-ticking-scheduler/index.md)<[BlockEntityTaskContext](-block-entity-task-context/index.md)<[T](task-ticker.md)>>.() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [TaskBlockEntityTicker](-task-block-entity-ticker/index.md)<[T](task-ticker.md)> |
