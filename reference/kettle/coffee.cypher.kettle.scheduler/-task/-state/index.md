---
title: State
---
//[kettle](../../../../index.html)/[coffee.cypher.kettle.scheduler](../../index.html)/[Task](../index.html)/[State](index.html)



# State

sealed class [State](index.html)

Represents possible lifecycle states of a task.



#### Inheritors


| |
|---|
| [Created](-created/index.html) |
| [Stopped](-stopped/index.html) |
| [Running](-running/index.html) |
| [Paused](-paused/index.html) |


## Types


| Name | Summary |
|---|---|
| [Created](-created/index.html) | [jvm]<br>sealed class [Created](-created/index.html) : [Task.State](index.html)<br>Represents a task that has just been created or has been [reset](../reset.html) to its initial state. |
| [Paused](-paused/index.html) | [jvm]<br>sealed class [Paused](-paused/index.html) : [Task.State](index.html)<br>Represents a task that is running, but is currently [paused](../pause.html). |
| [Running](-running/index.html) | [jvm]<br>sealed class [Running](-running/index.html) : [Task.State](index.html)<br>Represents a task that is currently running. |
| [Stopped](-stopped/index.html) | [jvm]<br>sealed class [Stopped](-stopped/index.html) : [Task.State](index.html)<br>Represents a task that has finished execution or has been [stopped](../stop.html). |

