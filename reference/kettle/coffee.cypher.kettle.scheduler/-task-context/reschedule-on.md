---
title: rescheduleOn
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[TaskContext](index.html)/[rescheduleOn](reschedule-on.html)



# rescheduleOn



[jvm]\
suspend fun [rescheduleOn](reschedule-on.html)(newScheduler: [TickingScheduler](../-ticking-scheduler/index.html)&lt;[T](index.html)&gt;)



Suspends the task, removes it from the current scheduler, and registers it on [the new scheduler](reschedule-on.html), allowing it to resume when it ticks next.




