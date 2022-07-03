---
title: coffee.cypher.kettle.math
---
//[kettle](../../index.html)/[coffee.cypher.kettle.math](index.html)



# Package coffee.cypher.kettle.math



## Functions


| Name | Summary |
|---|---|
| [boxTo](box-to.html) | [jvm]<br>infix fun Vec3d.[boxTo](box-to.html)(that: Vec3d): Box<br>infix fun Vec3i.[boxTo](box-to.html)(that: Vec3i): Box |
| [component1](component1.html) | [jvm]<br>operator fun Box.[component1](component1.html)(): Vec3d<br>operator fun Vec3d.[component1](component1.html)(): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>operator fun Vec3i.[component1](component1.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [component2](component2.html) | [jvm]<br>operator fun Box.[component2](component2.html)(): Vec3d<br>operator fun Vec3d.[component2](component2.html)(): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>operator fun Vec3i.[component2](component2.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [component3](component3.html) | [jvm]<br>operator fun Vec3d.[component3](component3.html)(): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>operator fun Vec3i.[component3](component3.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [copy](copy.html) | [jvm]<br>fun Vec3d.[copy](copy.html)(x: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = this.x, y: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = this.y, z: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = this.z): Vec3d<br>fun Vec3i.[copy](copy.html)(x: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = this.x, y: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = this.y, z: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = this.z): Vec3i |
| [div](div.html) | [jvm]<br>operator fun Vec3d.[div](div.html)(factor: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)): Vec3d |
| [getContainedBlockPos](get-contained-block-pos.html) | [jvm]<br>fun Box.[getContainedBlockPos](get-contained-block-pos.html)(includePartial: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true): [Sequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/-sequence/index.html)&lt;BlockPos&gt; |
| [length](length.html) | [jvm]<br>fun Vec3i.[length](length.html)(): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [minus](minus.html) | [jvm]<br>operator fun Vec3d.[minus](minus.html)(that: Vec3d): Vec3d<br>operator fun Vec3i.[minus](minus.html)(that: Vec3i): Vec3i |
| [plus](plus.html) | [jvm]<br>operator fun Vec3d.[plus](plus.html)(that: Vec3d): Vec3d<br>operator fun Vec3i.[plus](plus.html)(that: Vec3i): Vec3i |
| [times](times.html) | [jvm]<br>operator fun Vec3d.[times](times.html)(factor: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)): Vec3d<br>operator fun Vec3i.[times](times.html)(factor: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Vec3i |
| [toBlockPos](to-block-pos.html) | [jvm]<br>fun Vec3i.[toBlockPos](to-block-pos.html)(): BlockPos |
| [toDoubleVector](to-double-vector.html) | [jvm]<br>fun Vec3i.[toDoubleVector](to-double-vector.html)(): Vec3d |
| [toTriple](to-triple.html) | [jvm]<br>fun Vec3d.[toTriple](to-triple.html)(): [Triple](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-triple/index.html)&lt;[Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)&gt;<br>fun Vec3i.[toTriple](to-triple.html)(): [Triple](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-triple/index.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt; |
| [toVector](to-vector.html) | [jvm]<br>fun [Triple](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-triple/index.html)&lt;[Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)&gt;.[toVector](to-vector.html)(): Vec3d<br>fun [Triple](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-triple/index.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;.[toVector](to-vector.html)(): Vec3i |
| [unaryMinus](unary-minus.html) | [jvm]<br>operator fun Vec3d.[unaryMinus](unary-minus.html)(): Vec3d<br>operator fun Vec3i.[unaryMinus](unary-minus.html)(): Vec3i |


## Properties


| Name | Summary |
|---|---|
| [horizontalNeighbors](horizontal-neighbors.html) | [jvm]<br>val BlockPos.[horizontalNeighbors](horizontal-neighbors.html): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;BlockPos&gt; |
| [neighbors](neighbors.html) | [jvm]<br>val BlockPos.[neighbors](neighbors.html): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;BlockPos&gt; |

