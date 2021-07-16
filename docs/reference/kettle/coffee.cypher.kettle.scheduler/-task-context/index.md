//[kettle](../../../index.md)/[coffee.cypher.kettle.scheduler](../index.md)/[TaskContext](index.md)

# TaskContext

[jvm]\
open class [TaskContext](index.md)<[C](index.md) : [TaskContext](index.md)<[C](index.md)>>(**scheduler**: [TickingScheduler](../-ticking-scheduler/index.md)<[C](index.md)>)

## Functions

| Name | Summary |
|---|---|
| [endTick](end-tick.md) | [jvm]<br>suspend fun [endTick](end-tick.md)() |
| [sleepFor](sleep-for.md) | [jvm]<br>suspend fun [sleepFor](sleep-for.md)(ticks: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [waitForCondition](wait-for-condition.md) | [jvm]<br>suspend fun [waitForCondition](wait-for-condition.md)(checkEvery: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, checkNow: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, check: () -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [yield](yield.md) | [jvm]<br>suspend fun [yield](yield.md)() |

## Inheritors

| Name |
|---|
| [BasicTaskContext](../-basic-task-context/index.md) |
| [BlockEntityTaskContext](../../coffee.cypher.kettle.tickers.task/-block-entity-task-context/index.md) |
