---
title: TaskBuilder
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[TaskBuilder](index.html)



# TaskBuilder



[jvm]\
open class [TaskBuilder](index.html)&lt;[T](index.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;

A builder object used with DSL extensions to create a [Task](../-task/index.html).



## Properties


| Name | Summary |
|---|---|
| [name](name.html) | [jvm]<br>var [name](name.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>the name of the created task |
| [run](run.html) | [jvm]<br>val [run](run.html): (configuration: [ExecutionConfiguration](../-execution-configuration/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Configuration setter for this builder. |


## Inheritors


| Name |
|---|
| [AttachedTaskBuilder](../-attached-task-builder/index.html) |


## Extensions


| Name | Summary |
|---|---|
| [action](../action.html) | [jvm]<br>fun &lt;[T](../action.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [TaskBuilder](index.html)&lt;[T](../action.html)&gt;.[action](../action.html)(block: [TaskBlock](../index.html#-583629849%2FClasslikes%2F863300109)&lt;[T](../action.html)&gt;)<br>Sets the function executed by the [Task](../-task/index.html) to the provided [block](../action.html). |

