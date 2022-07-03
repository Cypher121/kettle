---
title: coffee.cypher.kettle.tickers.task
---
//[kettle](../../index.html)/[coffee.cypher.kettle.tickers.task](index.html)



# Package coffee.cypher.kettle.tickers.task



## Types


| Name | Summary |
|---|---|
| [BlockEntityTickerScheduler](index.html#-1692308171%2FClasslikes%2F863300109) | [jvm]<br>typealias [BlockEntityTickerScheduler](index.html#-1692308171%2FClasslikes%2F863300109)&lt;[T](index.html#-1692308171%2FClasslikes%2F863300109)&gt; = [TickingScheduler](../coffee.cypher.kettle.scheduler/-ticking-scheduler/index.html)&lt;[TickerAdditionalContext](-ticker-additional-context/index.html)&lt;[T](index.html#-1692308171%2FClasslikes%2F863300109)&gt;&gt; |
| [BlockEntityTickerTask](index.html#1719300493%2FClasslikes%2F863300109) | [jvm]<br>typealias [BlockEntityTickerTask](index.html#1719300493%2FClasslikes%2F863300109)&lt;[T](index.html#1719300493%2FClasslikes%2F863300109)&gt; = [TaskContext](../coffee.cypher.kettle.scheduler/-task-context/index.html)&lt;[TickerAdditionalContext](-ticker-additional-context/index.html)&lt;[T](index.html#1719300493%2FClasslikes%2F863300109)&gt;&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [TaskTicker](-task-ticker/index.html) | [jvm]<br>class [TaskTicker](-task-ticker/index.html)&lt;[T](-task-ticker/index.html) : BlockEntity&gt;(config: [BlockEntityTickerScheduler](index.html#-1692308171%2FClasslikes%2F863300109)&lt;[T](-task-ticker/index.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) : BlockEntityTicker&lt;[T](-task-ticker/index.html)&gt; |
| [TickerAdditionalContext](-ticker-additional-context/index.html) | [jvm]<br>class [TickerAdditionalContext](-ticker-additional-context/index.html)&lt;[T](-ticker-additional-context/index.html) : BlockEntity&gt;(world: World, pos: BlockPos, state: BlockState, val blockEntity: [T](-ticker-additional-context/index.html), tickerRef: [WeakReference](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/ref/WeakReference.html)&lt;[TaskTicker](-task-ticker/index.html)&lt;[T](-ticker-additional-context/index.html)&gt;&gt;) |


## Functions


| Name | Summary |
|---|---|
| [taskTicker](task-ticker.html) | [jvm]<br>fun &lt;[T](task-ticker.html) : BlockEntity&gt; [taskTicker](task-ticker.html)(config: [BlockEntityTickerScheduler](index.html#-1692308171%2FClasslikes%2F863300109)&lt;[T](task-ticker.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [TaskTicker](-task-ticker/index.html)&lt;[T](task-ticker.html)&gt; |

