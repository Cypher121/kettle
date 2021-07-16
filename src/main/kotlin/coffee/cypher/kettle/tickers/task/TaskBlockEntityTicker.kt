package coffee.cypher.kettle.tickers.task

import coffee.cypher.kettle.scheduler.TaskContext
import coffee.cypher.kettle.scheduler.TickingScheduler
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

public class TaskBlockEntityTicker<T : BlockEntity>(
    private val config: TickingScheduler<BlockEntityTaskContext<T>>.() -> Unit
) : BlockEntityTicker<T> {
    private val schedulers: MutableMap<T, TickingScheduler<BlockEntityTaskContext<T>>> = mutableMapOf()

    override fun tick(world: World, pos: BlockPos, state: BlockState, blockEntity: T) {
        val scheduler = schedulers.getOrPut(blockEntity) {
            TickingScheduler<BlockEntityTaskContext<T>> {
                BlockEntityTaskContext(it, blockEntity)
            }.apply(config)
        }

        scheduler.tick()
    }
}

public class BlockEntityTaskContext<T : BlockEntity>(
    scheduler: TickingScheduler<BlockEntityTaskContext<T>>,
    public val blockEntity: T
) : TaskContext<BlockEntityTaskContext<T>>(scheduler) {

}

public typealias TickerTask<T> = BlockEntityTaskContext<T>.() -> Unit