package coffee.cypher.kettle.tickers.task

import coffee.cypher.kettle.accessors.BlockEntitySchedulerAccessor
import coffee.cypher.kettle.scheduler.*
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

public class TaskTicker<T : BlockEntity>(
    private val config: TickingScheduler<BlockEntityTaskContext<T>>.() -> Unit
) : BlockEntityTicker<T> {
    override fun tick(world: World, pos: BlockPos, state: BlockState, blockEntity: T) {
        val schedulers = (blockEntity as BlockEntitySchedulerAccessor).`kettle$getTaskTickerSchedulerMap`()

        val scheduler = schedulers.getOrPut(this) {
            TickingScheduler<BlockEntityTaskContext<T>> {
                BlockEntityTaskContext(blockEntity)
            }.apply(config)
        }

        scheduler.tick()
    }
}

public class BlockEntityTaskContext<T : BlockEntity>(
    public val blockEntity: T
) : TaskContext<BlockEntityTaskContext<T>>()

public typealias TickerTask<T> = BlockEntityTaskContext<T>.() -> Unit

@SchedulerDsl
public fun <T : BlockEntity> taskTicker(
    config: TickingScheduler<BlockEntityTaskContext<T>>.() -> Unit
): TaskTicker<T> = TaskTicker(config)
