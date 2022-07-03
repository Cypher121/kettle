---
title: TickingScheduler
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[TickingScheduler](index.html)



# TickingScheduler



[jvm]\
class [TickingScheduler](index.html)
&lt;[T](index.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)
&gt;



## Constructors


| | |
|---|---|
| [TickingScheduler](-ticking-scheduler.html) | [jvm]<br>fun [TickingScheduler](-ticking-scheduler.html)() |


## Functions

| Name | Summary |
|---|---|
| [addTask](add-task.html) | [jvm]<br>fun [addTask](add-task.html)(task: [Task](../-task/index.html)&lt;[T](index.html)&gt;, start: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |
| [removeTask](remove-task.html) | [jvm]<br>fun [removeTask](remove-task.html)(task: [Task](../-task/index.html)&lt;[T](index.html)&gt;) |
| [tick](tick.html) | [jvm]<br>fun [tick](tick.html)(newContext: () -&gt; [T](index.html), updateContext: ([T](index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = {}) |


## Properties


| Name | Summary |
|---|---|
| [tasks](tasks.html) | [jvm]<br>val [tasks](tasks.html): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Task](../-task/index.html)&lt;[T](index.html)&gt;&gt; |


## Extensions

| Name | Summary |
|---|---|
| [task](../task.html) | [jvm]<br>fun &lt;[T](../task.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [TickingScheduler](index.html)&lt;[T](../task.html)&gt;.[task](../task.html)(config: [AttachedTaskBuilder](../-attached-task-builder/index.html)&lt;[T](../task.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Task](../-task/index.html)&lt;[T](../task.html)&gt; |
| [tick](../tick.html) | [jvm]<br>fun [TickingScheduler](index.html)&lt;[Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)&gt;.[tick](../tick.html)() |

