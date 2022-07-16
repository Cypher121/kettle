---
title: Task
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[Task](index.html)



# Task



[jvm]\
interface [Task](index.html)&lt;[T](index.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;

A task that can be run on a [TickingScheduler](../-ticking-scheduler/index.html). Entirely self-contained and can be moved between schedulers at will. Can be paused, stopped, and restarted from outside the task. Attempting to do so from inside the task will throw [IllegalStateException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-state-exception/index.html). Use [TaskContext.sleepFor](../-task-context/sleep-for.html) and [TaskContext.waitUntil](../-task-context/wait-until.html) instead.



A task can be created using [Task.create](-companion/create.html) or using the [task](../task.html) DSL.



## Types


| Name | Summary |
|---|---|
| [Companion](-companion/index.html) | [jvm]<br>object [Companion](-companion/index.html) |
| [State](-state/index.html) | [jvm]<br>sealed class [State](-state/index.html)<br>Represents possible lifecycle states of a task. |


## Functions


| Name | Summary |
|---|---|
| [copy](copy.html) | [jvm]<br>abstract fun [copy](copy.html)(): [Task](index.html)&lt;[T](index.html)&gt;<br>Creates a copy of this task with identical configuration and executed code. |
| [forceResume](force-resume.html) | [jvm]<br>abstract fun [forceResume](force-resume.html)()<br>Resumes the task if it was previously paused with [pause](pause.html). Additionally, cancels any suspension caused by [TaskContext.sleepFor](../-task-context/sleep-for.html) or [TaskContext.waitUntil](../-task-context/wait-until.html). |
| [pause](pause.html) | [jvm]<br>abstract fun [pause](pause.html)()<br>Pauses the task, so it can be resumed later using [resume](resume.html). |
| [reset](reset.html) | [jvm]<br>abstract fun [reset](reset.html)()<br>Resets the task's execution, so it can be started from the beginning using [start](start.html). |
| [restart](restart.html) | [jvm]<br>open fun [restart](restart.html)()<br>[Resets](reset.html) the task and [starts](start.html) it from the beginning. |
| [resume](resume.html) | [jvm]<br>abstract fun [resume](resume.html)()<br>Resumes the task if it was previously paused with [pause](pause.html). |
| [start](start.html) | [jvm]<br>abstract fun [start](start.html)()<br>Starts the task if it is newly created or has been [reset](reset.html). |
| [stop](stop.html) | [jvm]<br>abstract fun [stop](stop.html)()<br>Ends the execution of the task. The task can no longer be resumed, but can be [reset](reset.html) and started again. |


## Properties


| Name | Summary |
|---|---|
| [isExecuting](is-executing.html) | [jvm]<br>abstract val [isExecuting](is-executing.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>`true` if task is running and not waiting for a condition or sleeping, or `false` otherwise |
| [isSleeping](is-sleeping.html) | [jvm]<br>abstract val [isSleeping](is-sleeping.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>`true` if the task is sleeping for a certain amount of ticks, or `false` otherwise |
| [isWaiting](is-waiting.html) | [jvm]<br>abstract val [isWaiting](is-waiting.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>`true` if the task is waiting for a condition, or `false` otherwise |
| [name](name.html) | [jvm]<br>abstract val [name](name.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>name of the task |
| [state](state.html) | [jvm]<br>abstract val [state](state.html): [Task.State](-state/index.html)<br>current external state of the task |

