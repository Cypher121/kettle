//[kettle](../../../index.md)/[coffee.cypher.kettle.scheduler](../index.md)/[TaskHandle](index.md)

# TaskHandle

[jvm]\
class [TaskHandle](index.md)<[C](index.md) : [TaskContext](../-task-context/index.md)<[C](index.md)>> : [AbstractCoroutineContextElement](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-abstract-coroutine-context-element/index.html)

## Functions

| Name | Summary |
|---|---|
| [abortWait](abort-wait.md) | [jvm]<br>fun [abortWait](abort-wait.md)() |
| [await](await.md) | [jvm]<br>fun [await](await.md)(checkEvery: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, check: () -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [fold](index.md#466442070%2FFunctions%2F-1216412040) | [jvm]<br>open override fun <[R](index.md#466442070%2FFunctions%2F-1216412040)> [fold](index.md#466442070%2FFunctions%2F-1216412040)(initial: [R](index.md#466442070%2FFunctions%2F-1216412040), operation: ([R](index.md#466442070%2FFunctions%2F-1216412040), [CoroutineContext.Element](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/-element/index.html)) -> [R](index.md#466442070%2FFunctions%2F-1216412040)): [R](index.md#466442070%2FFunctions%2F-1216412040) |
| [get](index.md#232613081%2FFunctions%2F-1216412040) | [jvm]<br>open operator override fun <[E](index.md#232613081%2FFunctions%2F-1216412040) : [CoroutineContext.Element](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/-element/index.html)> [get](index.md#232613081%2FFunctions%2F-1216412040)(key: [CoroutineContext.Key](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/-key/index.html)<[E](index.md#232613081%2FFunctions%2F-1216412040)>): [E](index.md#232613081%2FFunctions%2F-1216412040)? |
| [minusKey](index.md#-1830620809%2FFunctions%2F-1216412040) | [jvm]<br>open override fun [minusKey](index.md#-1830620809%2FFunctions%2F-1216412040)(key: [CoroutineContext.Key](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/-key/index.html)<*>): [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html) |
| [pause](pause.md) | [jvm]<br>fun [pause](pause.md)() |
| [plus](index.md#1141296693%2FFunctions%2F-1216412040) | [jvm]<br>open operator fun [plus](index.md#1141296693%2FFunctions%2F-1216412040)(context: [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html)): [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html) |
| [reset](reset.md) | [jvm]<br>fun [reset](reset.md)() |
| [restart](restart.md) | [jvm]<br>fun [restart](restart.md)() |
| [resume](resume.md) | [jvm]<br>fun [resume](resume.md)() |
| [sleep](sleep.md) | [jvm]<br>fun [sleep](sleep.md)(duration: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [start](start.md) | [jvm]<br>fun [start](start.md)() |
| [stop](stop.md) | [jvm]<br>fun [stop](stop.md)() |
| [tick](tick.md) | [jvm]<br>fun [tick](tick.md)() |

## Properties

| Name | Summary |
|---|---|
| [isInProgress](is-in-progress.md) | [jvm]<br>val [isInProgress](is-in-progress.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isPaused](is-paused.md) | [jvm]<br>var [isPaused](is-paused.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [isRunning](is-running.md) | [jvm]<br>val [isRunning](is-running.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isSleeping](is-sleeping.md) | [jvm]<br>val [isSleeping](is-sleeping.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isStarted](is-started.md) | [jvm]<br>var [isStarted](is-started.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [isStopped](is-stopped.md) | [jvm]<br>var [isStopped](is-stopped.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [isWaiting](is-waiting.md) | [jvm]<br>val [isWaiting](is-waiting.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [key](index.md#-863594238%2FProperties%2F-1216412040) | [jvm]<br>open override val [key](index.md#-863594238%2FProperties%2F-1216412040): [CoroutineContext.Key](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/-key/index.html)<*> |
| [name](name.md) | [jvm]<br>val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [yieldsAfter](yields-after.md) | [jvm]<br>val [yieldsAfter](yields-after.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
