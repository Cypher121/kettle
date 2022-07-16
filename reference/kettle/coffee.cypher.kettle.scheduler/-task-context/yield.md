---
title: yield
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[TaskContext](index.html)/[yield](yield.html)



# yield



[jvm]\
suspend fun [yield](yield.html)()



Suspends the task if it has been running for longer than [ExecutionConfiguration.yieldsAfterMs](../-execution-configuration/yields-after-ms.html) specified in its configuration.



Should be called often in long-running blocks to mitigate lag.




