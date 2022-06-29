---
title: TickingScheduler
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[TickingScheduler](index.html)



# TickingScheduler



[jvm]\
class [TickingScheduler](index.html)&lt;[C](index.html) : [TaskContext](../-task-context/index.html)&lt;[C](index.html)&gt;&gt;(contextFactory: ([TickingScheduler](index.html)&lt;[C](index.html)&gt;) -&gt; [C](index.html))



## Constructors


| | |
|---|---|
| [TickingScheduler](-ticking-scheduler.html) | [jvm]<br>fun &lt;[C](index.html) : [TaskContext](../-task-context/index.html)&lt;[C](index.html)&gt;&gt; [TickingScheduler](-ticking-scheduler.html)(contextFactory: ([TickingScheduler](index.html)&lt;[C](index.html)&gt;) -&gt; [C](index.html)) |


## Functions


| Name | Summary |
|---|---|
| [addNewTask](add-new-task.html) | [jvm]<br>fun [addNewTask](add-new-task.html)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), configuration: [ExecutionConfiguration](../-execution-configuration/index.html) = ExecutionConfiguration.once(), start: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, block: suspend [C](index.html).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [TaskHandle](../-task-handle/index.html)&lt;[C](index.html)&gt; |
| [addTask](add-task.html) | [jvm]<br>fun [addTask](add-task.html)(handle: [TaskHandle](../-task-handle/index.html)&lt;[C](index.html)&gt;) |
| [removeTask](remove-task.html) | [jvm]<br>fun [removeTask](remove-task.html)(handle: [TaskHandle](../-task-handle/index.html)&lt;[C](index.html)&gt;) |
| [tick](tick.html) | [jvm]<br>fun [tick](tick.html)() |


## Properties


| Name | Summary |
|---|---|
| [tasks](tasks.html) | [jvm]<br>val [tasks](tasks.html): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TaskHandle](../-task-handle/index.html)&lt;[C](index.html)&gt;&gt; |


## Extensions


| Name | Summary |
|---|---|
| [task](../task.html) | [jvm]<br>fun &lt;[C](../task.html) : [TaskContext](../-task-context/index.html)&lt;[C](../task.html)&gt;&gt; [TickingScheduler](index.html)&lt;[C](../task.html)&gt;.[task](../task.html)(config: [TaskBuilder](../-task-builder/index.html)&lt;[C](../task.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [TaskHandle](../-task-handle/index.html)&lt;[C](../task.html)&gt; |

