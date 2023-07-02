---
title: ConfigurationBuilder
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[ConfigurationBuilder](index.html)



# ConfigurationBuilder

sealed class [ConfigurationBuilder](index.html)

A builder object representing the [Task](../-task/index.html)'s [ExecutionConfiguration](../-execution-configuration/index.html).



#### Inheritors


| |
|---|
| [Once](-once/index.html) |
| [Multiple](-multiple/index.html) |
| [Infinite](-infinite/index.html) |


## Types


| Name | Summary |
|---|---|
| [Infinite](-infinite/index.html) | [jvm]<br>class [Infinite](-infinite/index.html) : [ConfigurationBuilder](index.html)<br>A builder object for an [ExecutionConfiguration](../-execution-configuration/index.html) that will execute infinitely until stopped. |
| [Multiple](-multiple/index.html) | [jvm]<br>class [Multiple](-multiple/index.html) : [ConfigurationBuilder](index.html)<br>A builder object for an [ExecutionConfiguration](../-execution-configuration/index.html) that will execute multiple times. |
| [Once](-once/index.html) | [jvm]<br>class [Once](-once/index.html) : [ConfigurationBuilder](index.html)<br>A builder object for an [ExecutionConfiguration](../-execution-configuration/index.html) that will execute once. |


## Properties


| Name | Summary |
|---|---|
| [initialDelay](initial-delay.html) | [jvm]<br>var [initialDelay](initial-delay.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>delay in ticks before the task first executes |
| [yieldsAfterMs](yields-after-ms.html) | [jvm]<br>var [yieldsAfterMs](yields-after-ms.html): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>number of milliseconds in one execution until [TaskContext.yield](../-task-context/yield.html) suspends the task. |

