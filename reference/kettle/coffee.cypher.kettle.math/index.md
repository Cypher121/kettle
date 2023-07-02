---
title: coffee.cypher.kettle.math
---
//[kettle](../../index.html)/[coffee.cypher.kettle.math](index.html)



# Package-level declarations



## Properties


| Name | Summary |
|---|---|
| [horizontalNeighbors](horizontal-neighbors.html) | [jvm]<br>val BlockPos.[horizontalNeighbors](horizontal-neighbors.html): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;BlockPos&gt;<br>Returns a list of horizontal direct neighbors (shared face, same height) of this BlockPos. |
| [neighbors](neighbors.html) | [jvm]<br>val BlockPos.[neighbors](neighbors.html): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;BlockPos&gt;<br>Returns a list of all direct neighbors (shared face) of this BlockPos. |


## Functions


| Name | Summary |
|---|---|
| [boxTo](box-to.html) | [jvm]<br>infix fun Vec3d.[boxTo](box-to.html)(that: Vec3d): Box<br>Creates a Box between two Vec3d.<br>[jvm]<br>infix fun Vec3i.[boxTo](box-to.html)(that: Vec3i): Box<br>Creates a Box between two Vec3i. |
| [component1](component1.html) | [jvm]<br>operator fun Box.[component1](component1.html)(): Vec3d<br>Returns the starting Vec3d of this Box. |
| [component2](component2.html) | [jvm]<br>operator fun Box.[component2](component2.html)(): Vec3d<br>Returns the ending Vec3d of this Box. |
| [copy](copy.html) | [jvm]<br>fun Vec3d.[copy](copy.html)(x: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = this.x, y: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = this.y, z: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = this.z): Vec3d<br>Creates a new Vec3d with the given [x](copy.html), [y](copy.html), [z](copy.html) components, using this vector's components if not given.<br>[jvm]<br>fun Vec3i.[copy](copy.html)(x: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = this.x, y: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = this.y, z: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = this.z): Vec3i<br>Creates a new Vec3i with the given [x](copy.html), [y](copy.html), [z](copy.html) components, using this vector's components if not given. |
| [getContainedBlockPos](get-contained-block-pos.html) | [jvm]<br>fun Box.[getContainedBlockPos](get-contained-block-pos.html)(includePartial: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true): [Sequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/-sequence/index.html)&lt;BlockPos&gt;<br>Returns a [Sequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/-sequence/index.html) of all BlockPos contained within this Box. If [includePartial](get-contained-block-pos.html) is set to `true` (or by default), includes positions that are only partially contained within the box. |
| [toBlockPos](to-block-pos.html) | [jvm]<br>fun Vec3i.[toBlockPos](to-block-pos.html)(): BlockPos<br>Converts this Vec3i to a BlockPos. |
| [toDoubleVector](to-double-vector.html) | [jvm]<br>fun Vec3i.[toDoubleVector](to-double-vector.html)(): Vec3d<br>Converts this Vec3i to a Vec3d. |
| [toTriple](to-triple.html) | [jvm]<br>fun Vec3d.[toTriple](to-triple.html)(): [Triple](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-triple/index.html)&lt;[Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)&gt;<br>Converts this Vec3d to a [Triple](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-triple/index.html) of its components.<br>[jvm]<br>fun Vec3i.[toTriple](to-triple.html)(): [Triple](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-triple/index.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;<br>Converts this Vec3i to a [Triple](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-triple/index.html) of its components. |
| [toVector](to-vector.html) | [jvm]<br>fun [Triple](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-triple/index.html)&lt;[Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)&gt;.[toVector](to-vector.html)(): Vec3d<br>Creates a Vec3d from the components of this [Triple](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-triple/index.html).<br>[jvm]<br>fun [Triple](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-triple/index.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;.[toVector](to-vector.html)(): Vec3i<br>Creates a Vec3i from the components of this [Triple](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-triple/index.html). |

