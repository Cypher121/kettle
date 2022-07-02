package coffee.cypher.kettle.scheduler

import kotlin.coroutines.resume

public class TickingScheduler<T : Any> {
    public val tasks: List<Task<T>>
        get() = _tasks.toList()

    private val _tasks = mutableSetOf<TaskInternals<T>>()

    public fun tick(newContext: () -> T, updateContext: (T) -> Unit = {}) {
        _tasks.forEach {
            it.context.updateContext(newContext, updateContext)
            it.advanceWaitTimers()

            if (it.isExecuting) {
                it.executionContext = ContextForTask()

                (it.state as? TaskInternals.RunningInternal)?.withContinuation { c ->
                    c.resume(Unit)
                }
            }
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

    private inner class ContextForTask : ExecutionContext<T> {
        override val executionStartedAt = System.nanoTime() / 1e6

        override val currentScheduler = this@TickingScheduler
    }
}

public fun TickingScheduler<Unit>.tick() {
    tick({})
}
