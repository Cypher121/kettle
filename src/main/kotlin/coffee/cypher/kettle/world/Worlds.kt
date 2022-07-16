package coffee.cypher.kettle.world

import net.minecraft.block.entity.BlockEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView
import net.minecraft.world.WorldView

/**
 * Returns the [BlockEntity] contained at the given [pos]
 * in this [BlockView], if it exists and is of type [T].
 *
 * Otherwise, returns null.
 */
public inline fun <reified T : BlockEntity> BlockView.typedBlockEntity(pos: BlockPos): T? =
    getBlockEntity(pos) as? T

/**
 * Runs the given [toRun] block if this [BlockEntity] is
 * contained on the logical server.
 */
public inline fun BlockEntity.onServer(toRun: () -> Unit) {
    world?.onServer(toRun)
}

/**
 * Runs the given [toRun] block if this [BlockEntity] is
 * contained on the logical client.
 */
public inline fun BlockEntity.onClient(toRun: () -> Unit) {
    world?.onClient(toRun)
}

/**
 * Runs the given [toRun] block if this [WorldView]
 * represents a world on the logical server.
 */
public inline fun WorldView.onServer(toRun: () -> Unit) {
    if (!isClient) {
        toRun()
    }
}

/**
 * Runs the given [toRun] block if this [WorldView]
 * represents a world on the logical client.
 */
public inline fun WorldView.onClient(toRun: () -> Unit) {
    if (isClient) {
        toRun()
    }
}
