//[kettle](../../../index.md)/[coffee.cypher.kettle.scheduler](../index.md)/[BasicTaskContext](index.md)

# BasicTaskContext

[jvm]\
class [BasicTaskContext](index.md)(**scheduler**: [TickingScheduler](../-ticking-scheduler/index.md)<[BasicTaskContext](index.md)>) : [TaskContext](../-task-context/index.md)<[BasicTaskContext](index.md)>

## Functions

| Name | Summary |
|---|---|
| [endTick](../-task-context/end-tick.md) | [jvm]<br>suspend fun [endTick](../-task-context/end-tick.md)() |
| [sleepFor](../-task-context/sleep-for.md) | [jvm]<br>suspend fun [sleepFor](../-task-context/sleep-for.md)(ticks: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [waitForCondition](../-task-context/wait-for-condition.md) | [jvm]<br>suspend fun [waitForCondition](../-task-context/wait-for-condition.md)(checkEvery: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, checkNow: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, check: () -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [yield](../-task-context/yield.md) | [jvm]<br>suspend fun [yield](../-task-context/yield.md)() |
