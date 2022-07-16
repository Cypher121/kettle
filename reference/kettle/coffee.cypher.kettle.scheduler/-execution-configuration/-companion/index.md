---
title: Companion
---
//[kettle](../../../../index.html)/[coffee.cypher.kettle.scheduler](../../index.html)/[ExecutionConfiguration](../index.html)/[Companion](index.html)



# Companion



[jvm]\
object [Companion](index.html)



## Functions


| Name | Summary |
|---|---|
| [infinite](infinite.html) | [jvm]<br>fun [infinite](infinite.html)(initialDelay: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, pause: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, yieldsAfterMs: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 50.0): [ExecutionConfiguration](../index.html)<br>Creates an [ExecutionConfiguration](../index.html) for a task that will execute infinitely after [initialDelay](infinite.html) ticks, pauses for [pause](infinite.html) ticks after each execution and yields after executing for at least [yieldsAfterMs](infinite.html) milliseconds. |
| [once](once.html) | [jvm]<br>fun [once](once.html)(initialDelay: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, yieldsAfterMs: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 50.0): [ExecutionConfiguration](../index.html)<br>Creates an [ExecutionConfiguration](../index.html) for a task that will execute once after [initialDelay](once.html) ticks and yields after executing for at least [yieldsAfterMs](once.html) milliseconds. |
| [repeat](repeat.html) | [jvm]<br>fun [repeat](repeat.html)(initialDelay: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, pause: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, times: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, yieldsAfterMs: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 50.0): [ExecutionConfiguration](../index.html)<br>Creates an [ExecutionConfiguration](../index.html) for a task that will execute specified number of times [times](repeat.html) after [initialDelay](repeat.html) ticks, pauses for [pause](repeat.html) ticks after each execution and yields after executing for at least [yieldsAfterMs](repeat.html) milliseconds. |

