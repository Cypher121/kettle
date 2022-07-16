package coffee.cypher.kettle.math

import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.Vec3i

/**
 * Converts this [Vec3d] to a [Triple] of its components.
 */
public fun Vec3d.toTriple(): Triple<Double, Double, Double> = Triple(x, y, z)

/**
 * Creates a [Vec3d] from the components of this [Triple].
 */
public fun Triple<Double, Double, Double>.toVector(): Vec3d = Vec3d(first, second, third)

/**
 * Creates a new [Vec3d] with the given [x], [y], [z]
 * components, using this vector's components if not given.
 */
public fun Vec3d.copy(x: Double = this.x, y: Double = this.y, z: Double = this.z): Vec3d = Vec3d(x, y, z)

/**
 * Converts this [Vec3i] to a [Triple] of its components.
 */
public fun Vec3i.toTriple(): Triple<Int, Int, Int> = Triple(x, y, z)

/**
 * Creates a [Vec3i] from the components of this [Triple].
 */
public fun Triple<Int, Int, Int>.toVector(): Vec3i = Vec3i(first, second, third)

/**
 * Converts this [Vec3i] to a [BlockPos].
 */
public fun Vec3i.toBlockPos(): BlockPos = BlockPos(this)

/**
 * Converts this [Vec3i] to a [Vec3d].
 */
public fun Vec3i.toDoubleVector(): Vec3d = Vec3d(x.toDouble(), y.toDouble(), z.toDouble())

/**
 * Creates a new [Vec3i] with the given [x], [y], [z]
 * components, using this vector's components if not given.
 */
public fun Vec3i.copy(x: Int = this.x, y: Int = this.y, z: Int = this.z): Vec3i = Vec3i(x, y, z)

/**
 * Returns a list of all direct neighbors
 * (shared face) of this [BlockPos].
 */
public val BlockPos.neighbors: List<BlockPos>
    get() = enumValues<Direction>().map { offset(it) }

/**
 * Returns a list of horizontal direct neighbors
 * (shared face, same height) of this [BlockPos].
 */
public val BlockPos.horizontalNeighbors: List<BlockPos>
    get() = Direction.Type.HORIZONTAL.map { offset(it) }
