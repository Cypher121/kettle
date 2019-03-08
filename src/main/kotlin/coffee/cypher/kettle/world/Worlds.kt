package coffee.cypher.kettle.world

import net.minecraft.block.Block
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockReader
import net.minecraft.world.IWorld

inline fun <reified T : Block> IBlockReader.getBlock(pos: BlockPos): T? = getBlockState(pos).block as? T
inline fun <reified T : TileEntity> IBlockReader.getTile(pos: BlockPos) = getTileEntity(pos) as? T

inline fun TileEntity.onServer(toRun: () -> Unit) {
    world?.onServer(toRun)
}

inline fun TileEntity.onClient(toRun: () -> Unit) {
    world?.onClient(toRun)
}

inline fun IWorld.onServer(toRun: () -> Unit) {
    if (!isRemote) {
        toRun()
    }
}

inline fun IWorld.onClient(toRun: () -> Unit) {
    if (isRemote) {
        toRun()
    }
}