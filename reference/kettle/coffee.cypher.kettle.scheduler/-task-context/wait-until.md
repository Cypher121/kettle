---
title: waitUntil
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[TaskContext](index.html)/[waitUntil](wait-until.html)



# waitUntil



[jvm]\
suspend fun [waitUntil](wait-until.html)(checkEvery: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, checkNow: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, check: () -&gt; [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))



Suspends the task until the [check](wait-until.html) condition is fulfilled.



The condition will be checked once per [checkEvery](wait-until.html) ticks (default every tick). If [checkNow](wait-until.html) is `true` (or by default), the condition will be checked immediately, and if `true` the task will either [yield](yield.html) or resume.




