---
title: stop
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[Task](index.html)/[stop](stop.html)



# stop



[jvm]\
abstract fun [stop](stop.html)()



Ends the execution of the task. The task can no longer be resumed, but can be [reset](reset.html) and started again.



Throws an exception if called while the task is executing.




