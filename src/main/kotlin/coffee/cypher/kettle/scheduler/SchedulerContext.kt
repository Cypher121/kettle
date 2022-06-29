package coffee.cypher.kettle.scheduler

import kotlin.coroutines.Continuation

internal interface SchedulerContext {
    fun registerContinuation(continuation: Continuation<Unit>)

    fun shouldYield(): Boolean
}
