//[kettle](../../../index.md)/[coffee.cypher.kettle.tickers.task](../index.md)/[BlockEntityTaskContext](index.md)

# BlockEntityTaskContext

[jvm]\
class [BlockEntityTaskContext](index.md)<[T](index.md) : BlockEntity>(**scheduler**: [TickingScheduler](../../coffee.cypher.kettle.scheduler/-ticking-scheduler/index.md)<[BlockEntityTaskContext](index.md)<[T](index.md)>>, **blockEntity**: [T](index.md)) : [TaskContext](../../coffee.cypher.kettle.scheduler/-task-context/index.md)<[BlockEntityTaskContext](index.md)<[T](index.md)>>

## Functions

| Name | Summary |
|---|---|
| [endTick](../../coffee.cypher.kettle.scheduler/-task-context/end-tick.md) | [jvm]<br>suspend fun [endTick](../../coffee.cypher.kettle.scheduler/-task-context/end-tick.md)() |
| [sleepFor](../../coffee.cypher.kettle.scheduler/-task-context/sleep-for.md) | [jvm]<br>suspend fun [sleepFor](../../coffee.cypher.kettle.scheduler/-task-context/sleep-for.md)(ticks: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [waitForCondition](../../coffee.cypher.kettle.scheduler/-task-context/wait-for-condition.md) | [jvm]<br>suspend fun [waitForCondition](../../coffee.cypher.kettle.scheduler/-task-context/wait-for-condition.md)(checkEvery: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, checkNow: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, check: () -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [yield](../../coffee.cypher.kettle.scheduler/-task-context/yield.md) | [jvm]<br>suspend fun [yield](../../coffee.cypher.kettle.scheduler/-task-context/yield.md)() |

## Properties

| Name | Summary |
|---|---|
| [blockEntity](block-entity.md) | [jvm]<br>val [blockEntity](block-entity.md): [T](index.md) |
