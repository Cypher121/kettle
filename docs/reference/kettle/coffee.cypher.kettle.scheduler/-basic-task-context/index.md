---
title: BasicTaskContext
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[BasicTaskContext](index.html)



# BasicTaskContext



[jvm]\
class [BasicTaskContext](index.html)(scheduler: [TickingScheduler](../-ticking-scheduler/index.html)&lt;[BasicTaskContext](index.html)&gt;) : [TaskContext](../-task-context/index.html)&lt;[BasicTaskContext](index.html)&gt;



## Constructors


| | |
|---|---|
| [BasicTaskContext](-basic-task-context.html) | [jvm]<br>fun [BasicTaskContext](-basic-task-context.html)(scheduler: [TickingScheduler](../-ticking-scheduler/index.html)&lt;[BasicTaskContext](index.html)&gt;) |


## Functions


| Name | Summary |
|---|---|
| [endTick](../-task-context/end-tick.html) | [jvm]<br>suspend fun [endTick](../-task-context/end-tick.html)() |
| [sleepFor](../-task-context/sleep-for.html) | [jvm]<br>suspend fun [sleepFor](../-task-context/sleep-for.html)(ticks: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [waitForCondition](../-task-context/wait-for-condition.html) | [jvm]<br>suspend fun [waitForCondition](../-task-context/wait-for-condition.html)(checkEvery: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, checkNow: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, check: () -&gt; [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [yield](../-task-context/yield.html) | [jvm]<br>suspend fun [yield](../-task-context/yield.html)() |

