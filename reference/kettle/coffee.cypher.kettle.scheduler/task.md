---
title: task
---
//[kettle](../../index.html)/[coffee.cypher.kettle.scheduler](index.html)/[task](task.html)



# task



[jvm]\
fun &lt;[T](task.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [task](task.html)(config: [TaskBuilder](-task-builder/index.html)&lt;[T](task.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Task](-task/index.html)&lt;[T](task.html)&gt;



Creates a new task described by the provided [config](task.html) with the use of other DSL functions.





[jvm]\
fun &lt;[T](task.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [TickingScheduler](-ticking-scheduler/index.html)&lt;[T](task.html)&gt;.[task](task.html)(config: [AttachedTaskBuilder](-attached-task-builder/index.html)&lt;[T](task.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Task](-task/index.html)&lt;[T](task.html)&gt;



Creates a new task on the receiver scheduler described by the provided [config](task.html) with the use of other DSL functions.



