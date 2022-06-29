package coffee.cypher.kettle.accessors

import coffee.cypher.kettle.scheduler.TickingScheduler
import coffee.cypher.kettle.tickers.task.TaskTicker
import java.util.*

internal interface BlockEntitySchedulerAccessor {
    @Suppress("FunctionName")
    fun `kettle$getTaskTickerSchedulerMap`(): WeakHashMap<TaskTicker<*>, TickingScheduler<*>>
}
