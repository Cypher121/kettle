---
title: coffee.cypher.kettle.scheduler
---
//[kettle](../../index.html)/[coffee.cypher.kettle.scheduler](index.html)



# Package coffee.cypher.kettle.scheduler



## Types


| Name | Summary |
|---|---|
| [AttachedTaskBuilder](-attached-task-builder/index.html) | [jvm]<br>class [AttachedTaskBuilder](-attached-task-builder/index.html)&lt;[T](-attached-task-builder/index.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; : [TaskBuilder](-task-builder/index.html)&lt;[T](-attached-task-builder/index.html)&gt; |
| [ConfigurationBuilder](-configuration-builder/index.html) | [jvm]<br>sealed class [ConfigurationBuilder](-configuration-builder/index.html) |
| [ExecutionConfiguration](-execution-configuration/index.html) | [jvm]<br>sealed class [ExecutionConfiguration](-execution-configuration/index.html) |
| [SchedulerDsl](-scheduler-dsl/index.html) | [jvm]<br>@[DslMarker](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-dsl-marker/index.html)<br>annotation class [SchedulerDsl](-scheduler-dsl/index.html) |
| [Task](-task/index.html) | [jvm]<br>interface [Task](-task/index.html)&lt;[T](-task/index.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;<br>A task that can be run on a [TickingScheduler](-ticking-scheduler/index.html). Entirely self-contained and can be moved between schedulers at will. Can be paused, stopped, and restarted from outside the task. Attempting to do so from inside the task will throw [IllegalStateException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-state-exception/index.html). Use [TaskContext.sleepFor](-task-context/sleep-for.html) and [TaskContext.waitUntil](-task-context/wait-until.html) instead. |
| [TaskBlock](index.html#-583629849%2FClasslikes%2F863300109) | [jvm]<br>typealias [TaskBlock](index.html#-583629849%2FClasslikes%2F863300109)&lt;[T](index.html#-583629849%2FClasslikes%2F863300109)&gt; = suspend [TaskContext](-task-context/index.html)&lt;[T](index.html#-583629849%2FClasslikes%2F863300109)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [TaskBuilder](-task-builder/index.html) | [jvm]<br>open class [TaskBuilder](-task-builder/index.html)&lt;[T](-task-builder/index.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; |
| [TaskContext](-task-context/index.html) | [jvm]<br>class [TaskContext](-task-context/index.html)&lt;[T](-task-context/index.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; |
| [TaskExecutionException](-task-execution-exception/index.html) | [jvm]<br>class [TaskExecutionException](-task-execution-exception/index.html) : [RuntimeException](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/RuntimeException.html) |
| [TickingScheduler](-ticking-scheduler/index.html) | [jvm]<br>class [TickingScheduler](-ticking-scheduler/index.html)&lt;[T](-ticking-scheduler/index.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; |


## Functions


| Name | Summary |
|---|---|
| [action](action.html) | [jvm]<br>fun &lt;[T](action.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [TaskBuilder](-task-builder/index.html)&lt;[T](action.html)&gt;.[action](action.html)(block: [TaskBlock](index.html#-583629849%2FClasslikes%2F863300109)&lt;[T](action.html)&gt;) |
| [infinitely](infinitely.html) | [jvm]<br>infix fun ([ExecutionConfiguration](-execution-configuration/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html).[infinitely](infinitely.html)(configuration: [ConfigurationBuilder.Infinite](-configuration-builder/-infinite/index.html).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [multiple](multiple.html) | [jvm]<br>infix fun ([ExecutionConfiguration](-execution-configuration/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html).[multiple](multiple.html)(configuration: [ConfigurationBuilder.Multiple](-configuration-builder/-multiple/index.html).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [once](once.html) | [jvm]<br>infix fun ([ExecutionConfiguration](-execution-configuration/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html).[once](once.html)(configuration: [ConfigurationBuilder.Once](-configuration-builder/-once/index.html).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [scheduler](scheduler.html) | [jvm]<br>fun &lt;[T](scheduler.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [scheduler](scheduler.html)(config: [TickingScheduler](-ticking-scheduler/index.html)&lt;[T](scheduler.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [TickingScheduler](-ticking-scheduler/index.html)&lt;[T](scheduler.html)&gt;<br>@[JvmName](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-name/index.html)(name = &quot;scheduler$noContext&quot;)<br>fun [scheduler](scheduler.html)(config: [TickingScheduler](-ticking-scheduler/index.html)&lt;[Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [TickingScheduler](-ticking-scheduler/index.html)&lt;[Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)&gt; |
| [task](task.html) | [jvm]<br>fun &lt;[T](task.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [task](task.html)(config: [TaskBuilder](-task-builder/index.html)&lt;[T](task.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Task](-task/index.html)&lt;[T](task.html)&gt;<br>fun &lt;[T](task.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [TickingScheduler](-ticking-scheduler/index.html)&lt;[T](task.html)&gt;.[task](task.html)(config: [AttachedTaskBuilder](-attached-task-builder/index.html)&lt;[T](task.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Task](-task/index.html)&lt;[T](task.html)&gt; |
| [tick](tick.html) | [jvm]<br>fun [TickingScheduler](-ticking-scheduler/index.html)&lt;[Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)&gt;.[tick](tick.html)() |

