---
title: coffee.cypher.kettle.tickers.task
---
//[kettle](../../index.html)/[coffee.cypher.kettle.tickers.task](index.html)



# Package coffee.cypher.kettle.tickers.task



## Types


| Name | Summary |
|---|---|
| [TaskTicker](-task-ticker/index.html) | [jvm]<br>class [TaskTicker](-task-ticker/index.html)&lt;[T](-task-ticker/index.html) : BlockEntity&gt;(config: [TaskTickerScheduler](index.html#-1067649280%2FClasslikes%2F863300109)&lt;[T](-task-ticker/index.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) : BlockEntityTicker&lt;[T](-task-ticker/index.html)&gt; |
| [TaskTickerAction](index.html#107485137%2FClasslikes%2F863300109) | [jvm]<br>typealias [TaskTickerAction](index.html#107485137%2FClasslikes%2F863300109)&lt;[T](index.html#107485137%2FClasslikes%2F863300109)&gt; = [TaskContext](../coffee.cypher.kettle.scheduler/-task-context/index.html)&lt;[TickerContext](-ticker-context/index.html)&lt;[T](index.html#107485137%2FClasslikes%2F863300109)&gt;&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [TaskTickerScheduler](index.html#-1067649280%2FClasslikes%2F863300109) | [jvm]<br>typealias [TaskTickerScheduler](index.html#-1067649280%2FClasslikes%2F863300109)&lt;[T](index.html#-1067649280%2FClasslikes%2F863300109)&gt; = [TickingScheduler](../coffee.cypher.kettle.scheduler/-ticking-scheduler/index.html)&lt;[TickerContext](-ticker-context/index.html)&lt;[T](index.html#-1067649280%2FClasslikes%2F863300109)&gt;&gt; |
| [TickerContext](-ticker-context/index.html) | [jvm]<br>class [TickerContext](-ticker-context/index.html)&lt;[T](-ticker-context/index.html) : BlockEntity&gt;(world: World, pos: BlockPos, state: BlockState, val blockEntity: [T](-ticker-context/index.html), tickerRef: [WeakReference](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/ref/WeakReference.html)&lt;[TaskTicker](-task-ticker/index.html)&lt;[T](-ticker-context/index.html)&gt;&gt;) |


## Functions


| Name | Summary |
|---|---|
| [taskTicker](task-ticker.html) | [jvm]<br>fun &lt;[T](task-ticker.html) : BlockEntity&gt; [taskTicker](task-ticker.html)(config: [TaskTickerScheduler](index.html#-1067649280%2FClasslikes%2F863300109)&lt;[T](task-ticker.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [TaskTicker](-task-ticker/index.html)&lt;[T](task-ticker.html)&gt; |

