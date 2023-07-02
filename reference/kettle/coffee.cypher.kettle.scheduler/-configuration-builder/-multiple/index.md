---
title: Multiple
---
//[kettle](../../../../index.html)/[coffee.cypher.kettle.scheduler](../../index.html)/[ConfigurationBuilder](../index.html)/[Multiple](index.html)



# Multiple



[jvm]\
class [Multiple](index.html) : [ConfigurationBuilder](../index.html)

A builder object for an [ExecutionConfiguration](../../-execution-configuration/index.html) that will execute multiple times.



## Constructors


| | |
|---|---|
| [Multiple](-multiple.html) | [jvm]<br>constructor() |


## Properties


| Name | Summary |
|---|---|
| [initialDelay](../initial-delay.html) | [jvm]<br>var [initialDelay](../initial-delay.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>delay in ticks before the task first executes |
| [pause](pause.html) | [jvm]<br>var [pause](pause.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>delay in ticks between each execution |
| [times](times.html) | [jvm]<br>var [times](times.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>number of times to execute the task |
| [yieldsAfterMs](../yields-after-ms.html) | [jvm]<br>var [yieldsAfterMs](../yields-after-ms.html): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>number of milliseconds in one execution until [TaskContext.yield](../../-task-context/yield.html) suspends the task. |

