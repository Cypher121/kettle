---
title: tick
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[TickingScheduler](index.html)/[tick](tick.html)



# tick



[jvm]\
fun [tick](tick.html)(newContext: () -&gt; [T](index.html), updateContext: ([T](index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {})



Executes all tasks registered on this scheduler until they finish or suspend.



Tasks executing for the first time will be provided a context created by [newContext](tick.html).



Tasks that already have a context will instead have it updated using [updateContext](tick.html), if provided.




