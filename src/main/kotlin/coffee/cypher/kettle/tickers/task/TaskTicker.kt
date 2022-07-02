package coffee.cypher.kettle.tickers.task

import coffee.cypher.kettle.scheduler.SchedulerDsl
import coffee.cypher.kettle.scheduler.TaskContext
import coffee.cypher.kettle.scheduler.TickingScheduler
import coffee.cypher.kettle.tickers.mixinaccessors.getSchedulers
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

public class TickerAdditionalContext<T : BlockEntity>(
    world: World,
    pos: BlockPos,
    state: BlockState,
    public val blockEntity: T
) {
    public var state: BlockState = state
        internal set

    public var pos: BlockPos = pos
        internal set

    public var world: World = world
        internal set
}

public typealias BlockEntityTickerTask<T> = TaskContext<TickerAdditionalContext<T>>.() -> Unit
public typealias BlockEntityTickerScheduler<T> = TickingScheduler<TickerAdditionalContext<T>>

public class TaskTicker<T : BlockEntity>(
    private val config: BlockEntityTickerScheduler<T>.() -> Unit
) : BlockEntityTicker<T> {
    override fun tick(world: World, pos: BlockPos, state: BlockState, blockEntity: T) {
        val schedulers = blockEntity.getSchedulers()

        val scheduler = schedulers.getOrPut(this) {
            BlockEntityTickerScheduler<T>().apply(config)
        }

        scheduler.tick(
            newContext = {
                TickerAdditionalContext(world, pos, state, blockEntity)
            },
            updateContext = {
                it.pos = pos
                it.world = world
                it.state = state
            }
        )
    }
}

@SchedulerDsl
public fun <T : BlockEntity> taskTicker(
    config: BlockEntityTickerScheduler<T>.() -> Unit
): TaskTicker<T> = TaskTicker(config)
