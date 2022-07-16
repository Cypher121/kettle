---
title: run
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[TaskBuilder](index.html)/[run](run.html)



# run



[jvm]\
val [run](run.html): (configuration: [ExecutionConfiguration](../-execution-configuration/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)



Configuration setter for this builder.



Can be used with extension functions [infinitely](../infinitely.html), [once](../once.html), and [multiple](../multiple.html).



Example:

```kotlin
run once {
    initialDelay = 5
}
```



