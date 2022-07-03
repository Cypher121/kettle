package coffee.cypher.kettle.scheduler

internal interface ExecutionContext<T : Any> {
    val executionStartedAt: Double

    val currentScheduler: TickingScheduler<T>

    fun newContext(): T
    fun updateContext(context: T)
}
