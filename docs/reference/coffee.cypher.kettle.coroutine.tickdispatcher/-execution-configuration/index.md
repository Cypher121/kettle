[coffee.cypher.kettle.coroutine.tickdispatcher](../index.md) / [ExecutionConfiguration](./index.md)

# ExecutionConfiguration

`sealed class ExecutionConfiguration`

### Properties

| Name | Summary |
|---|---|
| [initialDelay](initial-delay.md) | `val initialDelay: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [yieldsAfterMs](yields-after-ms.md) | `val yieldsAfterMs: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [infinite](infinite.md) | `fun infinite(initialDelay: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, pause: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, yieldsAfterMs: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 50.0): `[`ExecutionConfiguration`](./index.md) |
| [once](once.md) | `fun once(initialDelay: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, yieldsAfterMs: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 50.0): `[`ExecutionConfiguration`](./index.md) |
| [repeat](repeat.md) | `fun repeat(initialDelay: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, pause: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, times: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, yieldsAfterMs: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 50.0): `[`ExecutionConfiguration`](./index.md) |
