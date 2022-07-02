package coffee.cypher.kettle.tickers.mixinaccessors

import coffee.cypher.kettle.scheduler.TickingScheduler
import coffee.cypher.kettle.tickers.task.TaskTicker
import coffee.cypher.kettle.tickers.task.BlockEntityTickerScheduler
import net.minecraft.block.entity.BlockEntity
import java.util.*

internal interface BlockEntitySchedulerAccessor {
    @Suppress("FunctionName")
    fun `kettle$getTaskTickerSchedulerMap`(): WeakHashMap<TaskTicker<*>, TickingScheduler<*>>
}

@Suppress("UNCHECKED_CAST")
internal fun <T : BlockEntity> T.getSchedulers(): WeakHashMap<TaskTicker<T>, BlockEntityTickerScheduler<T>> =
    (this as BlockEntitySchedulerAccessor).`kettle$getTaskTickerSchedulerMap`()
            as WeakHashMap<TaskTicker<T>, BlockEntityTickerScheduler<T>>
