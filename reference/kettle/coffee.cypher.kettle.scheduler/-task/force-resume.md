---
title: forceResume
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[Task](index.html)/[forceResume](force-resume.html)



# forceResume



[jvm]\
abstract fun [forceResume](force-resume.html)()



Resumes the task if it was previously paused with [pause](pause.html). Additionally, cancels any suspension caused by [TaskContext.sleepFor](../-task-context/sleep-for.html) or [TaskContext.waitUntil](../-task-context/wait-until.html).



Throws an exception if called while the task is executing.




