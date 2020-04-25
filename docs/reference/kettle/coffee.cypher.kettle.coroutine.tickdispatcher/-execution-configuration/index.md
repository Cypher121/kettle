[kettle](../../index.md) / [coffee.cypher.kettle.coroutine.tickdispatcher](../index.md) / [ExecutionConfiguration](./index.md)

# ExecutionConfiguration

(jvm) `sealed class ExecutionConfiguration` [(source)](https://github.com/Cypher121/kettle/blob/master/src/main/kotlin/coffee/cypher/kettle/coroutine/tickdispatcher/ExecutionConfiguration.kt#L3)

### Properties

| Name | Summary |
|---|---|
| (jvm) [initialDelay](initial-delay.md) | `val initialDelay: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| (jvm) [yieldsAfterMs](yields-after-ms.md) | `val yieldsAfterMs: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| (jvm) [infinite](infinite.md) | `fun infinite(initialDelay: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, pause: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, yieldsAfterMs: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 50.0): `[`ExecutionConfiguration`](./index.md) |
| (jvm) [once](once.md) | `fun once(initialDelay: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, yieldsAfterMs: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 50.0): `[`ExecutionConfiguration`](./index.md) |
| (jvm) [repeat](repeat.md) | `fun repeat(initialDelay: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, pause: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, times: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, yieldsAfterMs: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 50.0): `[`ExecutionConfiguration`](./index.md) |
