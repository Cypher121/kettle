---
title: AttachedTaskBuilder
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[AttachedTaskBuilder](index.html)



# AttachedTaskBuilder

class [AttachedTaskBuilder](index.html)&lt;[T](index.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; : [TaskBuilder](../-task-builder/index.html)&lt;[T](index.html)&gt; 

Creates a [Task](../-task/index.html) attached to a specific [TickingScheduler](../-ticking-scheduler/index.html).



#### See also


| |
|---|
| [TaskBuilder](../-task-builder/index.html) |


## Properties


| Name | Summary |
|---|---|
| [name](../-task-builder/name.html) | [jvm]<br>var [name](../-task-builder/name.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>the name of the created task |
| [run](../-task-builder/run.html) | [jvm]<br>val [run](../-task-builder/run.html): (configuration: [ExecutionConfiguration](../-execution-configuration/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Configuration setter for this builder. |
| [start](start.html) | [jvm]<br>var [start](start.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>`true` if the task should be started immediately, or `false` otherwise |


## Functions


| Name | Summary |
|---|---|
| [action](../action.html) | [jvm]<br>fun &lt;[T](../action.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [TaskBuilder](../-task-builder/index.html)&lt;[T](../action.html)&gt;.[action](../action.html)(block: [TaskBlock](../index.html#-583629849%2FClasslikes%2F863300109)&lt;[T](../action.html)&gt;)<br>Sets the function executed by the [Task](../-task/index.html) to the provided [block](../action.html). |

