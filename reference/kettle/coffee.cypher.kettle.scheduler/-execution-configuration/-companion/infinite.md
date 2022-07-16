---
title: infinite
---
//[kettle](../../../../index.html)/[coffee.cypher.kettle.scheduler](../../index.html)/[ExecutionConfiguration](../index.html)/[Companion](index.html)/[infinite](infinite.html)



# infinite



[jvm]\
fun [infinite](infinite.html)(initialDelay: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, pause: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, yieldsAfterMs: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 50.0): [ExecutionConfiguration](../index.html)



Creates an [ExecutionConfiguration](../index.html) for a task that will execute infinitely after [initialDelay](infinite.html) ticks, pauses for [pause](infinite.html) ticks after each execution and yields after executing for at least [yieldsAfterMs](infinite.html) milliseconds.




