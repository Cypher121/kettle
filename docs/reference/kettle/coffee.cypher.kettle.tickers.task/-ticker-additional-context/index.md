---
title: TickerAdditionalContext
---
//[kettle](../../../index.html)
/[coffee.cypher.kettle.tickers.task](../index.html)
/[TickerAdditionalContext](index.html)

# TickerAdditionalContext

[jvm]\
class [TickerAdditionalContext](index.html)&lt;[T](index.html) :
BlockEntity&gt;(world: World, pos: BlockPos, state: BlockState, val
blockEntity: [T](index.html),
tickerRef: [WeakReference](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/ref/WeakReference.html)
&lt;[TaskTicker](../-task-ticker/index.html)&lt;[T](index.html)&gt;&gt;)

## Constructors

| | |
|---|---|
| [TickerAdditionalContext](-ticker-additional-context.html) | [jvm]<br>fun &lt;[T](index.html) : BlockEntity&gt; [TickerAdditionalContext](-ticker-additional-context.html)(world: World, pos: BlockPos, state: BlockState, blockEntity: [T](index.html), tickerRef: [WeakReference](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/ref/WeakReference.html)&lt;[TaskTicker](../-task-ticker/index.html)&lt;[T](index.html)&gt;&gt;) |

## Functions

| Name | Summary |
|---|---|
| [findScheduler](find-scheduler.html) | [jvm]<br>fun [T](index.html).[findScheduler](find-scheduler.html)(): [BlockEntityTickerScheduler](../index.html#-1692308171%2FClasslikes%2F863300109)&lt;[T](index.html)&gt;? |

## Properties

| Name | Summary |
|---|---|
| [blockEntity](block-entity.html) | [jvm]<br>val [blockEntity](block-entity.html): [T](index.html) |
| [pos](pos.html) | [jvm]<br>var [pos](pos.html): BlockPos |
| [state](state.html) | [jvm]<br>var [state](state.html): BlockState |
| [world](world.html) | [jvm]<br>var [world](world.html): World |

