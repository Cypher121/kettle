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
import java.lang.ref.WeakReference

/**
 * Additional task context providing arguments
 * the current [BlockEntityTicker] was called with.
 *
 * Additionally, allows access to schedulers of this ticker
 * on other block entities of the same type [T].
 *
 * @property state the [BlockState] containing the block entity
 * @property pos the [BlockPos] of the block entity
 * @property world the [World] containing the block entity
 * @property blockEntity the [BlockEntity] being ticked
 */
public class TickerContext<T : BlockEntity>(
    world: World,
    pos: BlockPos,
    state: BlockState,
    blockEntity: T,
    internal var tickerRef: WeakReference<TaskTicker<T>>
) {
    public var state: BlockState = state
        internal set

    public var pos: BlockPos = pos
        internal set

    public var world: World = world
        internal set

    public var blockEntity: T = blockEntity
        internal set

    /**
     * Retrieve the scheduler on the receiver [BlockEntity]
     * belonging to the current [TaskTicker].
     *
     * Can return `null` if the scheduler doesn't exist,
     * e.g. if the receiver block entity has not ticked yet,
     * or uses a different ticker instead.
     */
    public fun T.findScheduler(): TaskTickerScheduler<T>? {
        val ticker = tickerRef.get() ?: return null

        return getSchedulers()[ticker]
    }
}

public typealias TaskTickerAction<T> = TaskContext<TickerContext<T>>.() -> Unit
public typealias TaskTickerScheduler<T> = TickingScheduler<TickerContext<T>>

/**
 * A type of [TickingScheduler] suitable for use
 * as a [BlockEntityTicker] for entities of type [T].
 */
public class TaskTicker<T : BlockEntity>(
    private val config: TaskTickerScheduler<T>.() -> Unit
) : BlockEntityTicker<T> {
    override fun tick(world: World, pos: BlockPos, state: BlockState, blockEntity: T) {
        val schedulers = blockEntity.getSchedulers()

        val scheduler = schedulers.getOrPut(this) {
            TaskTickerScheduler<T>().apply(config)
        }

        scheduler.tick(
            newContext = {
                TickerContext(world, pos, state, blockEntity, WeakReference(this))
            },
            updateContext = {
                it.pos = pos
                it.world = world
                it.state = state
                it.blockEntity = blockEntity
                it.tickerRef = WeakReference(this)
            }
        )
    }
}

/**
 * Creates a [TaskTicker] and configures its
 * [TickingScheduler] with the [config] action.
 */
@SchedulerDsl
public fun <T : BlockEntity> taskTicker(
    config: TaskTickerScheduler<T>.() -> Unit
): TaskTicker<T> = TaskTicker(config)
