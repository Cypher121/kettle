---
title: TaskTicker
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.tickers.task](../index.html)/[TaskTicker](index.html)



# TaskTicker



[jvm]\
class [TaskTicker](index.html)&lt;[T](index.html) : BlockEntity&gt;(config: [TaskTickerScheduler](../index.html#-1067649280%2FClasslikes%2F863300109)&lt;[T](index.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) : BlockEntityTicker&lt;[T](index.html)&gt; 

A type of [TickingScheduler](../../coffee.cypher.kettle.scheduler/-ticking-scheduler/index.html) suitable for use as a BlockEntityTicker for entities of type [T](index.html).



## Constructors


| | |
|---|---|
| [TaskTicker](-task-ticker.html) | [jvm]<br>constructor(config: [TaskTickerScheduler](../index.html#-1067649280%2FClasslikes%2F863300109)&lt;[T](index.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [cast](../../coffee.cypher.kettle.tickers/cast.html) | [jvm]<br>fun &lt;[T](../../coffee.cypher.kettle.tickers/cast.html) : BlockEntity, [E](../../coffee.cypher.kettle.tickers/cast.html) : BlockEntity&gt; BlockEntityTicker&lt;[T](../../coffee.cypher.kettle.tickers/cast.html)&gt;.[cast](../../coffee.cypher.kettle.tickers/cast.html)(): BlockEntityTicker&lt;[E](../../coffee.cypher.kettle.tickers/cast.html)&gt;<br>Casts a BlockEntityTicker to the specified BlockEntity type [E](../../coffee.cypher.kettle.tickers/cast.html). |
| [tick](tick.html) | [jvm]<br>open override fun [tick](tick.html)(world: World, pos: BlockPos, state: BlockState, blockEntity: [T](index.html)) |

