package coffee.cypher.kettle.math

import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.Vec3i
import kotlin.math.sqrt

public operator fun Vec3d.times(factor: Double): Vec3d = multiply(factor)
public operator fun Vec3d.div(factor: Double): Vec3d = multiply(1 / factor)
public operator fun Vec3d.plus(that: Vec3d): Vec3d = add(that)
public operator fun Vec3d.minus(that: Vec3d): Vec3d = subtract(that)
public operator fun Vec3d.unaryMinus(): Vec3d = Vec3d(-x, -y, -z)

public fun Vec3d.toTriple(): Triple<Double, Double, Double> = Triple(x, y, z)
public fun Triple<Double, Double, Double>.toVector(): Vec3d = Vec3d(first, second, third)

public fun Vec3d.copy(x: Double = this.x, y: Double = this.y, z: Double = this.z): Vec3d = Vec3d(x, y, z)
public operator fun Vec3d.component1(): Double = x
public operator fun Vec3d.component2(): Double = y
public operator fun Vec3d.component3(): Double = z

public operator fun Vec3i.times(factor: Int): Vec3i = Vec3i(x * factor, y * factor, z * factor)
public operator fun Vec3i.plus(that: Vec3i): Vec3i = Vec3i(x + that.x, y + that.y, z + that.z)
public operator fun Vec3i.minus(that: Vec3i): Vec3i = Vec3i(x - that.x, y - that.y, z - that.z)
public operator fun Vec3i.unaryMinus(): Vec3i = Vec3i(-x, -y, -z)

public fun Vec3i.length(): Double = sqrt((x * x + y * y + z * z).toDouble())

public fun Vec3i.toTriple(): Triple<Int, Int, Int> = Triple(x, y, z)
public fun Triple<Int, Int, Int>.toVector(): Vec3i = Vec3i(first, second, third)
public fun Vec3i.toBlockPos(): BlockPos = BlockPos(this)
public fun Vec3i.toDoubleVector(): Vec3d = Vec3d(x.toDouble(), y.toDouble(), z.toDouble())

public fun Vec3i.copy(x: Int = this.x, y: Int = this.y, z: Int = this.z): Vec3i = Vec3i(x, y, z)
public operator fun Vec3i.component1(): Int = x
public operator fun Vec3i.component2(): Int = y
public operator fun Vec3i.component3(): Int = z


public val BlockPos.neighbors: List<BlockPos>
    get() = enumValues<Direction>().map { offset(it) }

public val BlockPos.horizontalNeighbors: List<BlockPos>
    get() = enumValues<Direction>().filter { it.horizontal >= 0 }.map { offset(it) }