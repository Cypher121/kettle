---
title: TaskHandle
---
//[kettle](../../../index.html)/[coffee.cypher.kettle.scheduler](../index.html)/[TaskHandle](index.html)



# TaskHandle



[jvm]\
class [TaskHandle](index.html)&lt;[C](index.html) : [TaskContext](../-task-context/index.html)&lt;[C](index.html)&gt;&gt; : [AbstractCoroutineContextElement](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-abstract-coroutine-context-element/index.html)



## Functions


| Name | Summary |
|---|---|
| [abortWait](abort-wait.html) | [jvm]<br>fun [abortWait](abort-wait.html)() |
| [await](await.html) | [jvm]<br>fun [await](await.html)(checkEvery: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, check: () -&gt; [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [fold](index.html#466442070%2FFunctions%2F863300109) | [jvm]<br>open override fun &lt;[R](index.html#466442070%2FFunctions%2F863300109)&gt; [fold](index.html#466442070%2FFunctions%2F863300109)(initial: [R](index.html#466442070%2FFunctions%2F863300109), operation: ([R](index.html#466442070%2FFunctions%2F863300109), [CoroutineContext.Element](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/-element/index.html)) -&gt; [R](index.html#466442070%2FFunctions%2F863300109)): [R](index.html#466442070%2FFunctions%2F863300109) |
| [get](index.html#232613081%2FFunctions%2F863300109) | [jvm]<br>open operator override fun &lt;[E](index.html#232613081%2FFunctions%2F863300109) : [CoroutineContext.Element](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/-element/index.html)&gt; [get](index.html#232613081%2FFunctions%2F863300109)(key: [CoroutineContext.Key](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/-key/index.html)&lt;[E](index.html#232613081%2FFunctions%2F863300109)&gt;): [E](index.html#232613081%2FFunctions%2F863300109)? |
| [minusKey](index.html#-1830620809%2FFunctions%2F863300109) | [jvm]<br>open override fun [minusKey](index.html#-1830620809%2FFunctions%2F863300109)(key: [CoroutineContext.Key](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/-key/index.html)&lt;*&gt;): [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html) |
| [pause](pause.html) | [jvm]<br>fun [pause](pause.html)() |
| [plus](index.html#1141296693%2FFunctions%2F863300109) | [jvm]<br>open operator fun [plus](index.html#1141296693%2FFunctions%2F863300109)(context: [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html)): [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html) |
| [reset](reset.html) | [jvm]<br>fun [reset](reset.html)() |
| [restart](restart.html) | [jvm]<br>fun [restart](restart.html)() |
| [resume](resume.html) | [jvm]<br>fun [resume](resume.html)() |
| [sleep](sleep.html) | [jvm]<br>fun [sleep](sleep.html)(duration: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [start](start.html) | [jvm]<br>fun [start](start.html)() |
| [stop](stop.html) | [jvm]<br>fun [stop](stop.html)() |
| [tick](tick.html) | [jvm]<br>fun [tick](tick.html)() |


## Properties


| Name | Summary |
|---|---|
| [isInProgress](is-in-progress.html) | [jvm]<br>val [isInProgress](is-in-progress.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isPaused](is-paused.html) | [jvm]<br>var [isPaused](is-paused.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [isRunning](is-running.html) | [jvm]<br>val [isRunning](is-running.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isSleeping](is-sleeping.html) | [jvm]<br>val [isSleeping](is-sleeping.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isStarted](is-started.html) | [jvm]<br>var [isStarted](is-started.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [isStopped](is-stopped.html) | [jvm]<br>var [isStopped](is-stopped.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [isWaiting](is-waiting.html) | [jvm]<br>val [isWaiting](is-waiting.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [key](index.html#-1762250447%2FProperties%2F863300109) | [jvm]<br>open override val [key](index.html#-1762250447%2FProperties%2F863300109): [CoroutineContext.Key](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/-key/index.html)&lt;*&gt; |
| [name](name.html) | [jvm]<br>val [name](name.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [yieldsAfter](yields-after.html) | [jvm]<br>val [yieldsAfter](yields-after.html): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |

