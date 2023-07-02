---
title: TickingScheduler
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[TickingScheduler](index.html)



# TickingScheduler



[jvm]\
class [TickingScheduler](index.html)&lt;[T](index.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;

A scheduler object capable of executing multiple [Task](../-task/index.html)s and providing them with contexts of type [T](index.html).



## Constructors


| | |
|---|---|
| [TickingScheduler](-ticking-scheduler.html) | [jvm]<br>constructor() |


## Properties


| Name | Summary |
|---|---|
| [tasks](tasks.html) | [jvm]<br>val [tasks](tasks.html): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Task](../-task/index.html)&lt;[T](index.html)&gt;&gt;<br>[Task](../-task/index.html)s currently being managed by this scheduler. |


## Functions


| Name | Summary |
|---|---|
| [addTask](add-task.html) | [jvm]<br>fun [addTask](add-task.html)(task: [Task](../-task/index.html)&lt;[T](index.html)&gt;, start: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)<br>Adds a new [task](add-task.html) to this scheduler. |
| [removeTask](remove-task.html) | [jvm]<br>fun [removeTask](remove-task.html)(task: [Task](../-task/index.html)&lt;[T](index.html)&gt;)<br>Removes the specified [task](remove-task.html) from this scheduler. |
| [task](../task.html) | [jvm]<br>fun &lt;[T](../task.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [TickingScheduler](index.html)&lt;[T](../task.html)&gt;.[task](../task.html)(config: [AttachedTaskBuilder](../-attached-task-builder/index.html)&lt;[T](../task.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Task](../-task/index.html)&lt;[T](../task.html)&gt;<br>Creates a new task on the receiver scheduler described by the provided [config](../task.html) with the use of other DSL functions. |
| [tick](tick.html) | [jvm]<br>fun [tick](tick.html)(newContext: () -&gt; [T](index.html), updateContext: ([T](index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {})<br>Executes all tasks registered on this scheduler until they finish or suspend. |
| [tick](../tick.html) | [jvm]<br>fun [TickingScheduler](index.html)&lt;[Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)&gt;.[tick](../tick.html)()<br>Advances all tasks registered on this scheduler until they finish or suspend. |

