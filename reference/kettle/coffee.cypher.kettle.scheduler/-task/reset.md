---
title: reset
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[Task](index.html)/[reset](reset.html)



# reset



[jvm]\
abstract fun [reset](reset.html)()



Resets the task's execution, so it can be started from the beginning using [start](start.html).



If the task was set to [execute multiple times](../-execution-configuration/-companion/repeat.html) the execution count will also reset.



Throws an exception if called while the task is executing.




