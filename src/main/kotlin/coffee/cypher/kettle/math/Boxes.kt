package coffee.cypher.kettle.math

import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.Vec3i

operator fun AxisAlignedBB.component1() = Vec3d(minX, minY, minZ)

operator fun AxisAlignedBB.component2() = Vec3d(maxX, maxY, maxZ)

infix fun Vec3i.aabb(that: Vec3i) = AxisAlignedBB(BlockPos(this), BlockPos(that))

infix fun Vec3d.aabb(that: Vec3d) = AxisAlignedBB(x, y, z, that.x, that.y, that.z)