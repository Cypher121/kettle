---
title: findScheduler
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.tickers.task](../index.html)/[TickerContext](index.html)/[findScheduler](find-scheduler.html)



# findScheduler



[jvm]\
fun [T](index.html).[findScheduler](find-scheduler.html)(): [TaskTickerScheduler](../index.html#-1067649280%2FClasslikes%2F863300109)&lt;[T](index.html)&gt;?



Retrieve the scheduler on the receiver BlockEntity belonging to the current [TaskTicker](../-task-ticker/index.html).



Can return `null` if the scheduler doesn't exist, e.g. if the receiver block entity has not ticked yet, or uses a different ticker instead.




