package coffee.cypher.kettle.math

import net.minecraft.util.Direction
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.Vec3i
import kotlin.math.sqrt

operator fun Vec3d.times(factor: Double): Vec3d = scale(factor)
operator fun Vec3d.div(factor: Double): Vec3d = scale(1 / factor)
operator fun Vec3d.plus(that: Vec3d): Vec3d = add(that)
operator fun Vec3d.minus(that: Vec3d): Vec3d = subtract(that)
operator fun Vec3d.unaryMinus() = Vec3d(-x, -y, -z)

fun Vec3d.toTriple() = Triple(x, y, z)
fun Triple<Double, Double, Double>.toVector() = Vec3d(first, second, third)

fun Vec3d.copy(x: Double = this.x, y: Double = this.y, z: Double = this.z) = Vec3d(x, y, z)
operator fun Vec3d.component1() = x
operator fun Vec3d.component2() = y
operator fun Vec3d.component3() = z


operator fun Vec3i.times(factor: Int) = Vec3i(x * factor, y * factor, z * factor)
operator fun Vec3i.plus(that: Vec3i) = Vec3i(x + that.x, y + that.y, z + that.z)
operator fun Vec3i.minus(that: Vec3i) = Vec3i(x - that.x, y - that.y, z - that.z)
operator fun Vec3i.unaryMinus() = Vec3i(-x, -y, -z)

fun Vec3i.length() = sqrt((x * x + y * y + z * z).toDouble())

fun Vec3i.toTriple() = Triple(x, y, z)
fun Triple<Int, Int, Int>.toVector() = Vec3i(first, second, third)
fun Vec3i.toBlockPos() = BlockPos(this)
fun Vec3i.toDoubleVector() = Vec3d(this)

fun Vec3i.copy(x: Int = this.x, y: Int = this.y, z: Int = this.z) = Vec3i(x, y, z)
operator fun Vec3i.component1() = x
operator fun Vec3i.component2() = y
operator fun Vec3i.component3() = z


val BlockPos.neighbors
    get() = enumValues<Direction>().map { offset(it) }

val BlockPos.horizontalNeighbors
    get() = enumValues<Direction>().filter { it.horizontalIndex >= 0 }.map { offset(it) }