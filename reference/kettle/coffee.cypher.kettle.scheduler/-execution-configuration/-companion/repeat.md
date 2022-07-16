---
title: repeat
---
//[kettle](../../../../index.html)/[coffee.cypher.kettle.scheduler](../../index.html)/[ExecutionConfiguration](../index.html)/[Companion](index.html)/[repeat](repeat.html)



# repeat



[jvm]\
fun [repeat](repeat.html)(initialDelay: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, pause: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, times: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, yieldsAfterMs: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 50.0): [ExecutionConfiguration](../index.html)



Creates an [ExecutionConfiguration](../index.html) for a task that will execute specified number of times [times](repeat.html) after [initialDelay](repeat.html) ticks, pauses for [pause](repeat.html) ticks after each execution and yields after executing for at least [yieldsAfterMs](repeat.html) milliseconds.




