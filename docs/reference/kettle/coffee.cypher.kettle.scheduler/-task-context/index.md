---
title: TaskContext
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[TaskContext](index.html)



# TaskContext



[jvm]\
open class [TaskContext](index.html)&lt;[C](index.html) : [TaskContext](index.html)&lt;[C](index.html)&gt;&gt;(scheduler: [TickingScheduler](../-ticking-scheduler/index.html)&lt;[C](index.html)&gt;)



## Constructors


| | |
|---|---|
| [TaskContext](-task-context.html) | [jvm]<br>fun &lt;[C](index.html) : [TaskContext](index.html)&lt;[C](index.html)&gt;&gt; [TaskContext](-task-context.html)(scheduler: [TickingScheduler](../-ticking-scheduler/index.html)&lt;[C](index.html)&gt;) |


## Functions


| Name | Summary |
|---|---|
| [endTick](end-tick.html) | [jvm]<br>suspend fun [endTick](end-tick.html)() |
| [sleepFor](sleep-for.html) | [jvm]<br>suspend fun [sleepFor](sleep-for.html)(ticks: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [waitForCondition](wait-for-condition.html) | [jvm]<br>suspend fun [waitForCondition](wait-for-condition.html)(checkEvery: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, checkNow: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, check: () -&gt; [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [yield](yield.html) | [jvm]<br>suspend fun [yield](yield.html)() |


## Inheritors


| Name |
|---|
| [BasicTaskContext](../-basic-task-context/index.html) |
| [BlockEntityTaskContext](../../coffee.cypher.kettle.tickers.task/-block-entity-task-context/index.html) |

