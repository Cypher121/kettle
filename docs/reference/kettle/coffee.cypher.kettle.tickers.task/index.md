---
title: coffee.cypher.kettle.tickers.task
---
//[kettle](../../index.html)/[coffee.cypher.kettle.tickers.task](index.html)



# Package coffee.cypher.kettle.tickers.task



## Types


| Name | Summary |
|---|---|
| [BlockEntityTaskContext](-block-entity-task-context/index.html) | [jvm]<br>class [BlockEntityTaskContext](-block-entity-task-context/index.html)&lt;[T](-block-entity-task-context/index.html) : BlockEntity&gt;(scheduler: [TickingScheduler](../coffee.cypher.kettle.scheduler/-ticking-scheduler/index.html)&lt;[BlockEntityTaskContext](-block-entity-task-context/index.html)&lt;[T](-block-entity-task-context/index.html)&gt;&gt;, val blockEntity: [T](-block-entity-task-context/index.html)) : [TaskContext](../coffee.cypher.kettle.scheduler/-task-context/index.html)&lt;[BlockEntityTaskContext](-block-entity-task-context/index.html)&lt;[T](-block-entity-task-context/index.html)&gt;&gt; |
| [TaskBlockEntityTicker](-task-block-entity-ticker/index.html) | [jvm]<br>class [TaskBlockEntityTicker](-task-block-entity-ticker/index.html)&lt;[T](-task-block-entity-ticker/index.html) : BlockEntity&gt;(config: [TickingScheduler](../coffee.cypher.kettle.scheduler/-ticking-scheduler/index.html)&lt;[BlockEntityTaskContext](-block-entity-task-context/index.html)&lt;[T](-task-block-entity-ticker/index.html)&gt;&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) : BlockEntityTicker&lt;[T](-task-block-entity-ticker/index.html)&gt; |
| [TickerTask](index.html#-1973214425%2FClasslikes%2F863300109) | [jvm]<br>typealias [TickerTask](index.html#-1973214425%2FClasslikes%2F863300109)&lt;[T](index.html#-1973214425%2FClasslikes%2F863300109)&gt; = [BlockEntityTaskContext](-block-entity-task-context/index.html)&lt;[T](index.html#-1973214425%2FClasslikes%2F863300109)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |


## Functions


| Name | Summary |
|---|---|
| [taskTicker](task-ticker.html) | [jvm]<br>fun &lt;[T](task-ticker.html) : BlockEntity&gt; [taskTicker](task-ticker.html)(config: [TickingScheduler](../coffee.cypher.kettle.scheduler/-ticking-scheduler/index.html)&lt;[BlockEntityTaskContext](-block-entity-task-context/index.html)&lt;[T](task-ticker.html)&gt;&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [TaskBlockEntityTicker](-task-block-entity-ticker/index.html)&lt;[T](task-ticker.html)&gt; |

