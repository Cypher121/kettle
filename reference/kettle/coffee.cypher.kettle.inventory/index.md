---
title: coffee.cypher.kettle.inventory
---
//[kettle](../../index.html)/[coffee.cypher.kettle.inventory](index.html)



# Package-level declarations



## Properties


| Name | Summary |
|---|---|
| [slotRange](slot-range.html) | [jvm]<br>val Inventory.[slotRange](slot-range.html): [IntRange](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-int-range/index.html)<br>Returns a range of all slot indices of this Inventory. |


## Functions


| Name | Summary |
|---|---|
| [asIterable](as-iterable.html) | [jvm]<br>fun Inventory.[asIterable](as-iterable.html)(): [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)&lt;ItemStack&gt;<br>Returns this Inventory's slots as an [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html) of ItemStacks contained within. |
| [asSequence](as-sequence.html) | [jvm]<br>fun Inventory.[asSequence](as-sequence.html)(): [Sequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/-sequence/index.html)&lt;ItemStack&gt;<br>Returns this Inventory's slots as a [Sequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/-sequence/index.html) of ItemStacks contained within. |
| [contains](contains.html) | [jvm]<br>operator fun Inventory.[contains](contains.html)(item: Item): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if any slots of this Inventory contain an ItemStack of the given [item](contains.html), or `false` otherwise. |
| [get](get.html) | [jvm]<br>operator fun Inventory.[get](get.html)(slot: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): ItemStack<br>Returns the ItemStack contained in the given [slot](get.html) of this Inventory. |
| [getSideAccess](get-side-access.html) | [jvm]<br>fun Inventory.[getSideAccess](get-side-access.html)(side: Direction): Inventory<br>Creates a proxy Inventory that only represents slots of this Inventory available from the specified [side](get-side-access.html). |
| [iterator](iterator.html) | [jvm]<br>operator fun Inventory.[iterator](iterator.html)(): [Iterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/index.html)&lt;ItemStack&gt;<br>Returns the [Iterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/index.html) for this Inventory's slots. |
| [set](set.html) | [jvm]<br>operator fun Inventory.[set](set.html)(slot: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), stack: ItemStack)<br>Sets the ItemStack contained in the given [slot](set.html) of this Inventory to the provided [stack](set.html). |
| [toList](to-list.html) | [jvm]<br>fun Inventory.[toList](to-list.html)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;ItemStack&gt;<br>Returns the ItemStack contents of this Inventory's slots collected into a [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html). |

