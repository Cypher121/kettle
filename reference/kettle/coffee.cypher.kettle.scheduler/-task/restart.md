---
title: restart
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[Task](index.html)/[restart](restart.html)



# restart



[jvm]\
open fun [restart](restart.html)()



[Resets](reset.html) the task and [starts](start.html) it from the beginning.



If the task was set to [execute multiple times](../-execution-configuration/-companion/repeat.html) the execution count will also reset.



Throws an exception if called while the task is executing.




