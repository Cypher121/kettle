---
title: BlockEntityTaskContext
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.tickers.task](../index.html)/[BlockEntityTaskContext](index.html)



# BlockEntityTaskContext



[jvm]\
class [BlockEntityTaskContext](index.html)&lt;[T](index.html) : BlockEntity&gt;(scheduler: [TickingScheduler](../../coffee.cypher.kettle.scheduler/-ticking-scheduler/index.html)&lt;[BlockEntityTaskContext](index.html)&lt;[T](index.html)&gt;&gt;, val blockEntity: [T](index.html)) : [TaskContext](../../coffee.cypher.kettle.scheduler/-task-context/index.html)&lt;[BlockEntityTaskContext](index.html)&lt;[T](index.html)&gt;&gt;



## Constructors


| | |
|---|---|
| [BlockEntityTaskContext](-block-entity-task-context.html) | [jvm]<br>fun &lt;[T](index.html) : BlockEntity&gt; [BlockEntityTaskContext](-block-entity-task-context.html)(scheduler: [TickingScheduler](../../coffee.cypher.kettle.scheduler/-ticking-scheduler/index.html)&lt;[BlockEntityTaskContext](index.html)&lt;[T](index.html)&gt;&gt;, blockEntity: [T](index.html)) |


## Functions


| Name | Summary |
|---|---|
| [endTick](../../coffee.cypher.kettle.scheduler/-task-context/end-tick.html) | [jvm]<br>suspend fun [endTick](../../coffee.cypher.kettle.scheduler/-task-context/end-tick.html)() |
| [sleepFor](../../coffee.cypher.kettle.scheduler/-task-context/sleep-for.html) | [jvm]<br>suspend fun [sleepFor](../../coffee.cypher.kettle.scheduler/-task-context/sleep-for.html)(ticks: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [waitForCondition](../../coffee.cypher.kettle.scheduler/-task-context/wait-for-condition.html) | [jvm]<br>suspend fun [waitForCondition](../../coffee.cypher.kettle.scheduler/-task-context/wait-for-condition.html)(checkEvery: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, checkNow: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, check: () -&gt; [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [yield](../../coffee.cypher.kettle.scheduler/-task-context/yield.html) | [jvm]<br>suspend fun [yield](../../coffee.cypher.kettle.scheduler/-task-context/yield.html)() |


## Properties


| Name | Summary |
|---|---|
| [blockEntity](block-entity.html) | [jvm]<br>val [blockEntity](block-entity.html): [T](index.html) |

