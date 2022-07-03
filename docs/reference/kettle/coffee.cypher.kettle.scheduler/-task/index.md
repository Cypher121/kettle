---
title: Task
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)
/[Task](index.html)

# Task

[jvm]\
interface [Task](index.html)
&lt;[T](index.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)
&gt;

A task that can be run on a [TickingScheduler](../-ticking-scheduler/index.html)
. Entirely self-contained and can be moved between schedulers at will. Can be
paused, stopped, and restarted from outside the task. Attempting to do so from
inside the task will
throw [IllegalStateException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-state-exception/index.html)
. Use [TaskContext.sleepFor](../-task-context/sleep-for.html)
and [TaskContext.waitUntil](../-task-context/wait-until.html) instead.

A task can be created using [Task.create](-companion/create.html) or using
the [task](../task.html) DSL.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.html) | [jvm]<br>object [Companion](-companion/index.html) |
| [State](-state/index.html) | [jvm]<br>sealed class [State](-state/index.html) |

## Functions

| Name | Summary |
|---|---|
| [copy](copy.html) | [jvm]<br>abstract fun [copy](copy.html)(): [Task](index.html)&lt;[T](index.html)&gt; |
| [forceResume](force-resume.html) | [jvm]<br>abstract fun [forceResume](force-resume.html)() |
| [pause](pause.html) | [jvm]<br>abstract fun [pause](pause.html)() |
| [reset](reset.html) | [jvm]<br>abstract fun [reset](reset.html)() |
| [restart](restart.html) | [jvm]<br>open fun [restart](restart.html)() |
| [resume](resume.html) | [jvm]<br>abstract fun [resume](resume.html)() |
| [start](start.html) | [jvm]<br>abstract fun [start](start.html)() |
| [stop](stop.html) | [jvm]<br>abstract fun [stop](stop.html)() |

## Properties

| Name | Summary |
|---|---|
| [isExecuting](is-executing.html) | [jvm]<br>abstract val [isExecuting](is-executing.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isSleeping](is-sleeping.html) | [jvm]<br>abstract val [isSleeping](is-sleeping.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isWaiting](is-waiting.html) | [jvm]<br>abstract val [isWaiting](is-waiting.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [name](name.html) | [jvm]<br>abstract val [name](name.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [state](state.html) | [jvm]<br>abstract val [state](state.html): [Task.State](-state/index.html) |

