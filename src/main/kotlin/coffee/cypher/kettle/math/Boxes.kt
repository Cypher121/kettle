package coffee.cypher.kettle.math

import net.minecraft.util.math.*
import kotlin.math.ceil
import kotlin.math.floor

/**
 * Returns the starting [Vec3d] of this [Box].
 */
public operator fun Box.component1(): Vec3d = Vec3d(minX, minY, minZ)

/**
 * Returns the ending [Vec3d] of this [Box].
 */
public operator fun Box.component2(): Vec3d = Vec3d(maxX, maxY, maxZ)

private fun openIntSeq(start: Double, end: Double, expand: Boolean) =
    if (expand)
        (floor(start).toInt() until ceil(end).toInt()).asSequence()
    else
        (ceil(start).toInt() until floor(end).toInt()).asSequence()


/**
 * Returns a [Sequence] of all [BlockPos] contained within this [Box].
 * If [includePartial] is set to `true` (or by default),
 * includes positions that are only partially contained within the box.
 */
public fun Box.getContainedBlockPos(includePartial: Boolean = true): Sequence<BlockPos> =
    openIntSeq(minX, maxX, includePartial).flatMap { x ->
        openIntSeq(minY, maxY, includePartial).flatMap { y ->
            openIntSeq(minZ, maxZ, includePartial).map { z ->
                BlockPos(x, y, z)
            }
        }
    }

/**
 * Creates a [Box] between two [Vec3i].
 */
public infix fun Vec3i.boxTo(that: Vec3i): Box = Box(BlockPos(this), BlockPos(that))

/**
 * Creates a [Box] between two [Vec3d].
 */
public infix fun Vec3d.boxTo(that: Vec3d): Box = Box(x, y, z, that.x, that.y, that.z)
