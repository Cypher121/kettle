//[kettle](../../index.md)/[coffee.cypher.kettle.math](index.md)

# Package coffee.cypher.kettle.math

## Functions

| Name | Summary |
|---|---|
| [boxTo](box-to.md) | [jvm]<br>infix fun Vec3d.[boxTo](box-to.md)(that: Vec3d): Box<br>infix fun Vec3i.[boxTo](box-to.md)(that: Vec3i): Box |
| [component1](component1.md) | [jvm]<br>operator fun Box.[component1](component1.md)(): Vec3d<br>operator fun Vec3d.[component1](component1.md)(): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>operator fun Vec3i.[component1](component1.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [component2](component2.md) | [jvm]<br>operator fun Box.[component2](component2.md)(): Vec3d<br>operator fun Vec3d.[component2](component2.md)(): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>operator fun Vec3i.[component2](component2.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [component3](component3.md) | [jvm]<br>operator fun Vec3d.[component3](component3.md)(): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>operator fun Vec3i.[component3](component3.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [copy](copy.md) | [jvm]<br>fun Vec3d.[copy](copy.md)(x: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = this.x, y: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = this.y, z: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = this.z): Vec3d<br>fun Vec3i.[copy](copy.md)(x: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = this.x, y: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = this.y, z: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = this.z): Vec3i |
| [div](div.md) | [jvm]<br>operator fun Vec3d.[div](div.md)(factor: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)): Vec3d |
| [length](length.md) | [jvm]<br>fun Vec3i.[length](length.md)(): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [minus](minus.md) | [jvm]<br>operator fun Vec3d.[minus](minus.md)(that: Vec3d): Vec3d<br>operator fun Vec3i.[minus](minus.md)(that: Vec3i): Vec3i |
| [plus](plus.md) | [jvm]<br>operator fun Vec3d.[plus](plus.md)(that: Vec3d): Vec3d<br>operator fun Vec3i.[plus](plus.md)(that: Vec3i): Vec3i |
| [times](times.md) | [jvm]<br>operator fun Vec3d.[times](times.md)(factor: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)): Vec3d<br>operator fun Vec3i.[times](times.md)(factor: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): Vec3i |
| [toBlockPos](to-block-pos.md) | [jvm]<br>fun Vec3i.[toBlockPos](to-block-pos.md)(): BlockPos |
| [toDoubleVector](to-double-vector.md) | [jvm]<br>fun Vec3i.[toDoubleVector](to-double-vector.md)(): Vec3d |
| [toTriple](to-triple.md) | [jvm]<br>fun Vec3d.[toTriple](to-triple.md)(): [Triple](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-triple/index.html)<[Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)><br>fun Vec3i.[toTriple](to-triple.md)(): [Triple](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-triple/index.html)<[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)> |
| [toVector](to-vector.md) | [jvm]<br>fun [Triple](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-triple/index.html)<[Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)>.[toVector](to-vector.md)(): Vec3d<br>fun [Triple](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-triple/index.html)<[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)>.[toVector](to-vector.md)(): Vec3i |
| [unaryMinus](unary-minus.md) | [jvm]<br>operator fun Vec3d.[unaryMinus](unary-minus.md)(): Vec3d<br>operator fun Vec3i.[unaryMinus](unary-minus.md)(): Vec3i |

## Properties

| Name | Summary |
|---|---|
| [horizontalNeighbors](horizontal-neighbors.md) | [jvm]<br>val BlockPos.[horizontalNeighbors](horizontal-neighbors.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<BlockPos> |
| [neighbors](neighbors.md) | [jvm]<br>val BlockPos.[neighbors](neighbors.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<BlockPos> |
