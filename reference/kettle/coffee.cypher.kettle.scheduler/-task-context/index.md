---
title: TaskContext
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[TaskContext](index.html)



# TaskContext



[jvm]\
class [TaskContext](index.html)&lt;[T](index.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;



## Functions


| Name | Summary |
|---|---|
| [endTick](end-tick.html) | [jvm]<br>suspend fun [endTick](end-tick.html)() |
| [rescheduleOn](reschedule-on.html) | [jvm]<br>suspend fun [rescheduleOn](reschedule-on.html)(newScheduler: [TickingScheduler](../-ticking-scheduler/index.html)&lt;[T](index.html)&gt;) |
| [sleepFor](sleep-for.html) | [jvm]<br>suspend fun [sleepFor](sleep-for.html)(ticks: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [updateContext](update-context.html) | [jvm]<br>fun [updateContext](update-context.html)() |
| [waitUntil](wait-until.html) | [jvm]<br>suspend fun [waitUntil](wait-until.html)(checkEvery: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, checkNow: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, check: () -&gt; [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [withContext](with-context.html) | [jvm]<br>inline fun [withContext](with-context.html)(block: [T](index.html).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [yield](yield.html) | [jvm]<br>suspend fun [yield](yield.html)() |

