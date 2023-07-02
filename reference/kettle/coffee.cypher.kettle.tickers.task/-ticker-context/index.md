---
title: TickerContext
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.tickers.task](../index.html)/[TickerContext](index.html)



# TickerContext



[jvm]\
class [TickerContext](index.html)&lt;[T](index.html) : BlockEntity&gt;(world: World, pos: BlockPos, state: BlockState, blockEntity: [T](index.html), tickerRef: [WeakReference](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/ref/WeakReference.html)&lt;[TaskTicker](../-task-ticker/index.html)&lt;[T](index.html)&gt;&gt;)

Additional task context providing arguments the current BlockEntityTicker was called with.



Additionally, allows access to schedulers of this ticker on other block entities of the same type [T](index.html).



## Constructors


| | |
|---|---|
| [TickerContext](-ticker-context.html) | [jvm]<br>constructor(world: World, pos: BlockPos, state: BlockState, blockEntity: [T](index.html), tickerRef: [WeakReference](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/ref/WeakReference.html)&lt;[TaskTicker](../-task-ticker/index.html)&lt;[T](index.html)&gt;&gt;) |


## Properties


| Name | Summary |
|---|---|
| [blockEntity](block-entity.html) | [jvm]<br>var [blockEntity](block-entity.html): [T](index.html)<br>the BlockEntity being ticked |
| [pos](pos.html) | [jvm]<br>var [pos](pos.html): BlockPos<br>the BlockPos of the block entity |
| [state](state.html) | [jvm]<br>var [state](state.html): BlockState<br>the BlockState containing the block entity |
| [world](world.html) | [jvm]<br>var [world](world.html): World<br>the World containing the block entity |


## Functions


| Name | Summary |
|---|---|
| [findScheduler](find-scheduler.html) | [jvm]<br>fun [T](index.html).[findScheduler](find-scheduler.html)(): [TaskTickerScheduler](../index.html#-1067649280%2FClasslikes%2F863300109)&lt;[T](index.html)&gt;?<br>Retrieve the scheduler on the receiver BlockEntity belonging to the current [TaskTicker](../-task-ticker/index.html). |

