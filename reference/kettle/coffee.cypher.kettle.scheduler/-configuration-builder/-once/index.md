---
title: Once
---
//[kettle](../../../../index.html)/[coffee.cypher.kettle.scheduler](../../index.html)/[ConfigurationBuilder](../index.html)/[Once](index.html)



# Once



[jvm]\
class [Once](index.html) : [ConfigurationBuilder](../index.html)

A builder object for an [ExecutionConfiguration](../../-execution-configuration/index.html) that will execute once.



## Constructors


| | |
|---|---|
| [Once](-once.html) | [jvm]<br>constructor() |


## Properties


| Name | Summary |
|---|---|
| [initialDelay](../initial-delay.html) | [jvm]<br>var [initialDelay](../initial-delay.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>delay in ticks before the task first executes |
| [yieldsAfterMs](../yields-after-ms.html) | [jvm]<br>var [yieldsAfterMs](../yields-after-ms.html): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>number of milliseconds in one execution until [TaskContext.yield](../../-task-context/yield.html) suspends the task. |

