package coffee.cypher.kettle.world

import net.minecraft.block.entity.BlockEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView
import net.minecraft.world.WorldView

public inline fun <reified T : BlockEntity> BlockView.typedBlockEntity(pos: BlockPos): T? = getBlockEntity(pos) as? T

public inline fun BlockEntity.onServer(toRun: () -> Unit) {
    world?.onServer(toRun)
}

public inline fun BlockEntity.onClient(toRun: () -> Unit) {
    world?.onClient(toRun)
}

public inline fun WorldView.onServer(toRun: () -> Unit) {
    if (!isClient) {
        toRun()
    }
}

public inline fun WorldView.onClient(toRun: () -> Unit) {
    if (isClient) {
        toRun()
    }
}