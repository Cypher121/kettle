---
title: TaskContext
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[TaskContext](index.html)



# TaskContext



[jvm]\
class [TaskContext](index.html)&lt;[T](index.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;

Coroutine context for a [Task](../-task/index.html) containing methods allowing suspension of execution, such as [sleepFor](sleep-for.html) and [waitUntil](wait-until.html).



## Functions


| Name | Summary |
|---|---|
| [endTick](end-tick.html) | [jvm]<br>suspend fun [endTick](end-tick.html)()<br>Suspends the task until the next tick. |
| [rescheduleOn](reschedule-on.html) | [jvm]<br>suspend fun [rescheduleOn](reschedule-on.html)(newScheduler: [TickingScheduler](../-ticking-scheduler/index.html)&lt;[T](index.html)&gt;)<br>Suspends the task, removes it from the current scheduler, and registers it on [the new scheduler](reschedule-on.html), allowing it to resume when it ticks next. |
| [sleepFor](sleep-for.html) | [jvm]<br>suspend fun [sleepFor](sleep-for.html)(ticks: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>Suspends the task for the specified number of [ticks](sleep-for.html). |
| [waitUntil](wait-until.html) | [jvm]<br>suspend fun [waitUntil](wait-until.html)(checkEvery: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, checkNow: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, check: () -&gt; [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>Suspends the task until the [check](wait-until.html) condition is fulfilled. |
| [withContext](with-context.html) | [jvm]<br>inline fun [withContext](with-context.html)(block: [T](index.html).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>Provides the generic context of type [T](index.html) that is available to the task and may change after suspension. |
| [yield](yield.html) | [jvm]<br>suspend fun [yield](yield.html)()<br>Suspends the task if it has been running for longer than [ExecutionConfiguration.yieldsAfterMs](../-execution-configuration/yields-after-ms.html) specified in its configuration. |

