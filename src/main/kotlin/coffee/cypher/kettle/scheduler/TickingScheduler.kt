package coffee.cypher.kettle.scheduler

/**
 * A scheduler object capable of executing multiple [Task]s
 * and providing them with contexts of type [T].
 */
public class TickingScheduler<T : Any> {
    /**
     * [Task]s currently being managed by this scheduler.
     */
    public val tasks: List<Task<T>>
        get() = _tasks.toList()

    private val _tasks = mutableSetOf<TaskInternals<T>>()

    /**
     * Executes all tasks registered on this scheduler until they
     * finish or suspend.
     *
     * Tasks executing for the first time will be provided a context
     * created by [newContext].
     *
     * Tasks that already have a context will instead have it updated
     * using [updateContext], if provided.
     */
    public fun tick(newContext: () -> T, updateContext: (T) -> Unit = {}) {
        _tasks.forEach {
            it.tick(ContextForTask(newContext, updateContext))
        }
    }

    /**
     * Adds a new [task] to this scheduler.
     *
     * If [start] is set to `true`, the task will start executing
     * on the next tick.
     */
    public fun addTask(task: Task<T>, start: Boolean = false) {
        _tasks += task.internal()

        if (start) {
            task.start()
        }
    }

    /**
     * Removes the specified [task] from this scheduler.
     */
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

/**
 * Advances all tasks registered on this scheduler
 * until they finish or suspend.
 */
public fun TickingScheduler<Unit>.tick() {
    tick({})
}
