---
title: SchedulerBuilder
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[SchedulerBuilder](index.html)



# SchedulerBuilder



[jvm]\
class [SchedulerBuilder](index.html)&lt;[C](index.html) : [TaskContext](../-task-context/index.html)&lt;[C](index.html)&gt;&gt;



## Functions


| Name | Summary |
|---|---|
| [build](build.html) | [jvm]<br>fun [build](build.html)(): [TickingScheduler](../-ticking-scheduler/index.html)&lt;[C](index.html)&gt; |


## Properties


| Name | Summary |
|---|---|
| [factory](factory.html) | [jvm]<br>lateinit var [factory](factory.html): ([TickingScheduler](../-ticking-scheduler/index.html)&lt;[C](index.html)&gt;) -&gt; [C](index.html) |


## Extensions


| Name | Summary |
|---|---|
| [factory](../factory.html) | [jvm]<br>fun &lt;[C](../factory.html) : [TaskContext](../-task-context/index.html)&lt;[C](../factory.html)&gt;&gt; [SchedulerBuilder](index.html)&lt;[C](../factory.html)&gt;.[factory](../factory.html)(factory: [TickingScheduler](../-ticking-scheduler/index.html)&lt;[C](../factory.html)&gt;.() -&gt; [C](../factory.html)) |
| [tasks](../tasks.html) | [jvm]<br>fun &lt;[C](../tasks.html) : [TaskContext](../-task-context/index.html)&lt;[C](../tasks.html)&gt;&gt; [SchedulerBuilder](index.html)&lt;[C](../tasks.html)&gt;.[tasks](../tasks.html)(config: [TickingScheduler](../-ticking-scheduler/index.html)&lt;[C](../tasks.html)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

