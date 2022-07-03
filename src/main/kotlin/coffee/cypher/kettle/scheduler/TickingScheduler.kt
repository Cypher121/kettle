package coffee.cypher.kettle.scheduler

public class TickingScheduler<T : Any> {
    public val tasks: List<Task<T>>
        get() = _tasks.toList()

    private val _tasks = mutableSetOf<TaskInternals<T>>()

    public fun tick(newContext: () -> T, updateContext: (T) -> Unit = {}) {
        _tasks.forEach {
            it.tick(ContextForTask(newContext, updateContext))
        }
    }

    public fun addTask(task: Task<T>, start: Boolean = false) {
        _tasks += task.internal()

        if (start) {
            task.start()
        }
    }

    public fun removeTask(task: Task<T>) {
        _tasks -= task.internal()
    }

    private inner class ContextForTask(
        private val newContext: () -> T,
        private val updateContext: (T) -> Unit
    ) : ExecutionContext<T> {
        override val executionStartedAt = System.nanoTime() / 1e6

        override val currentScheduler = this@TickingScheduler

        override fun newContext() = newContext.invoke()
        override fun updateContext(context: T) = updateContext.invoke(context)
    }
}

public fun TickingScheduler<Unit>.tick() {
    tick({})
}
