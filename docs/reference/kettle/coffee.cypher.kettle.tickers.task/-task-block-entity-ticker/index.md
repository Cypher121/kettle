---
title: TaskBlockEntityTicker
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.tickers.task](../index.html)/[TaskBlockEntityTicker](index.html)



# TaskBlockEntityTicker



[jvm]\
class [TaskBlockEntityTicker](index.html)&lt;[T](index.html) : BlockEntity&gt;(config: [TickingScheduler](../../coffee.cypher.kettle.scheduler/-ticking-scheduler/index.html)&lt;[BlockEntityTaskContext](../-block-entity-task-context/index.html)&lt;[T](index.html)&gt;&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) : BlockEntityTicker&lt;[T](index.html)&gt;



## Constructors


| | |
|---|---|
| [TaskBlockEntityTicker](-task-block-entity-ticker.html) | [jvm]<br>fun &lt;[T](index.html) : BlockEntity&gt; [TaskBlockEntityTicker](-task-block-entity-ticker.html)(config: [TickingScheduler](../../coffee.cypher.kettle.scheduler/-ticking-scheduler/index.html)&lt;[BlockEntityTaskContext](../-block-entity-task-context/index.html)&lt;[T](index.html)&gt;&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [tick](tick.html) | [jvm]<br>open override fun [tick](tick.html)(world: World, pos: BlockPos, state: BlockState, blockEntity: [T](index.html)) |

