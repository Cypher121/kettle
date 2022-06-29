package coffee.cypher.kettle.math

import net.minecraft.util.math.*

public operator fun Box.component1(): Vec3d = Vec3d(minX, minY, minZ)

public operator fun Box.component2(): Vec3d = Vec3d(maxX, maxY, maxZ)

public infix fun Vec3i.boxTo(that: Vec3i): Box = Box(BlockPos(this), BlockPos(that))

public infix fun Vec3d.boxTo(that: Vec3d): Box = Box(x, y, z, that.x, that.y, that.z)