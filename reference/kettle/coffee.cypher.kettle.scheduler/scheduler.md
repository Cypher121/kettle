---
title: scheduler
---
//[kettle](../../index.html)/[coffee.cypher.kettle.scheduler](index.html)/[scheduler](scheduler.html)



# scheduler



[jvm]\




@[JvmName](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-name/index.html)(name = &quot;scheduler$noContext&quot;)



fun [scheduler](scheduler.html)(config: [TickingScheduler](-ticking-scheduler/index.html)&lt;[Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [TickingScheduler](-ticking-scheduler/index.html)&lt;[Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)&gt;



Creates a new [TickingScheduler](-ticking-scheduler/index.html) with no additional task context configured with the provided [config](scheduler.html).





[jvm]\
fun &lt;[T](scheduler.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [scheduler](scheduler.html)(config: [TickingScheduler](-ticking-scheduler/index.html)&lt;[T](scheduler.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [TickingScheduler](-ticking-scheduler/index.html)&lt;[T](scheduler.html)&gt;



Creates a [TickingScheduler](-ticking-scheduler/index.html) with the additional context of type [T](scheduler.html) configured with the provided [config](scheduler.html).




