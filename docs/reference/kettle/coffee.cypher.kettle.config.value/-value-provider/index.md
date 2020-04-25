[kettle](../../index.md) / [coffee.cypher.kettle.config.value](../index.md) / [ValueProvider](./index.md)

# ValueProvider

(jvm) `interface ValueProvider<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ReadOnlyProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?, T>, () -> T, `[`Supplier`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html)`<T>, NonNullSupplier<T>` [(source)](https://github.com/Cypher121/kettle/blob/master/src/main/kotlin/coffee/cypher/kettle/config/value/ValueProvider.kt#L8)

### Properties

| Name | Summary |
|---|---|
| (jvm) [path](path.md) | `abstract val path: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |

### Functions

| Name | Summary |
|---|---|
| (jvm) [getValue](get-value.md) | `open fun getValue(thisRef: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?, property: `[`KProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-property/index.html)`<*>): T` |
| (jvm) [invoke](invoke.md) | `open fun invoke(): T` |
