---
title: coffee.cypher.kettle.scheduler
---
//[kettle](../../index.html)/[coffee.cypher.kettle.scheduler](index.html)



# Package coffee.cypher.kettle.scheduler



## Types


| Name | Summary |
|---|---|
| [BasicTaskContext](-basic-task-context/index.html) | [jvm]<br>class [BasicTaskContext](-basic-task-context/index.html)(scheduler: [TickingScheduler](-ticking-scheduler/index.html)&lt;[BasicTaskContext](-basic-task-context/index.html)&gt;) : [TaskContext](-task-context/index.html)&lt;[BasicTaskContext](-basic-task-context/index.html)&gt; |
| [ExecutionConfiguration](-execution-configuration/index.html) | [jvm]<br>sealed class [ExecutionConfiguration](-execution-configuration/index.html) |
| [SchedulerBuilder](-scheduler-builder/index.html) | [jvm]<br>class [SchedulerBuilder](-scheduler-builder/index.html)&lt;[C](-scheduler-builder/index.html) : [TaskContext](-task-context/index.html)&lt;[C](-scheduler-builder/index.html)&gt;&gt; |
| [SchedulerDsl](-scheduler-dsl/index.html) | [jvm]<br>annotation class [SchedulerDsl](-scheduler-dsl/index.html) |
| [TaskBuilder](-task-builder/index.html) | [jvm]<br>class [TaskBuilder](-task-builder/index.html)&lt;[C](-task-builder/index.html) : [TaskContext](-task-context/index.html)&lt;[C](-task-builder/index.html)&gt;&gt; |
| [TaskContext](-task-context/index.html) | [jvm]<br>open class [TaskContext](-task-context/index.html)&lt;[C](-task-context/index.html) : [TaskContext](-task-context/index.html)&lt;[C](-task-context/index.html)&gt;&gt;(scheduler: [TickingScheduler](-ticking-scheduler/index.html)&lt;[C](-task-context/index.html)&gt;) |
| [TaskExecutionException](-task-execution-exception/index.html) | [jvm]<br>class [TaskExecutionException](-task-execution-exception/index.html) : [RuntimeException](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/RuntimeException.html) |
| [TaskHandle](-task-handle/index.html) | [jvm]<br>class [TaskHandle](-task-handle/index.html)&lt;[C](-task-handle/index.html) : [TaskContext](-task-context/index.html)&lt;[C](-task-handle/index.html)&gt;&gt; : [AbstractCoroutineContextElement](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-abstract-coroutine-context-element/index.html) |
| [TickingScheduler](-ticking-scheduler/index.html) | [jvm]<br>class [TickingScheduler](-ticking-scheduler/index.html)&lt;[C](-ticking-scheduler/index.html) : [TaskContext](-task-context/index.html)&lt;[C](-ticking-scheduler/index.html)&gt;&gt;(contextFactory: ([TickingScheduler](-ticking-scheduler/index.html)&lt;[C](-ticking-scheduler/index.html)&gt;) -&gt; [C](-ticking-scheduler/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [execute](execute.html) | [jvm]<br>fun &lt;[C](execute.html) : [TaskContext](-task-context/index.html)&lt;[C](execute.html)&gt;&gt; [TaskBuilder](-task-builder/index.html)&lt;[C](execute.html)&gt;.[execute](execute.html)(config: suspend [C](execute.html).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [factory](factory.html) | [jvm]<br>fun &lt;[C](factory.html) : [TaskContext](-task-context/index.html)&lt;[C](factory.html)&gt;&gt; [SchedulerBuilder](-scheduler-builder/index.html)&lt;[C](factory.html)&gt;.[factory](factory.html)(factory: [TickingScheduler](-ticking-scheduler/index.html)&lt;[C](factory.html)&gt;.() -&gt; [C](factory.html)) |
| [scheduler](scheduler.html) | [jvm]<br>fun &lt;[C](scheduler.html) : [TaskContext](-task-context/index.html)&lt;[C](scheduler.html)&gt;&gt; [scheduler](scheduler.html)(config: [SchedulerBuilder](-scheduler-builder/index.html)&lt;[C](scheduler.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [TickingScheduler](-ticking-scheduler/index.html)&lt;[C](scheduler.html)&gt; |
| [task](task.html) | [jvm]<br>fun &lt;[C](task.html) : [TaskContext](-task-context/index.html)&lt;[C](task.html)&gt;&gt; [TickingScheduler](-ticking-scheduler/index.html)&lt;[C](task.html)&gt;.[task](task.html)(config: [TaskBuilder](-task-builder/index.html)&lt;[C](task.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [TaskHandle](-task-handle/index.html)&lt;[C](task.html)&gt; |
| [tasks](tasks.html) | [jvm]<br>fun &lt;[C](tasks.html) : [TaskContext](-task-context/index.html)&lt;[C](tasks.html)&gt;&gt; [SchedulerBuilder](-scheduler-builder/index.html)&lt;[C](tasks.html)&gt;.[tasks](tasks.html)(config: [TickingScheduler](-ticking-scheduler/index.html)&lt;[C](tasks.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

