---
title: equals
---
//[kettle](../../index.html)/[coffee.cypher.kettle.item](index.html)/[equals](equals.html)



# equals



[jvm]\
fun ItemStack?.[equals](equals.html)(that: ItemStack?, ignoreDurability: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, ignoreSize: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, ignoreNBT: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)



Compares this ItemStack to a given target.



Strictly compares durability (or whether stacks are damageable), stack size and NBT tags, unless [ignoreDurability](equals.html), [ignoreSize](equals.html), or [ignoreNBT](equals.html) are set to true.




