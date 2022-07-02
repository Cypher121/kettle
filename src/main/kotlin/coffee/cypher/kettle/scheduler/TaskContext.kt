package coffee.cypher.kettle.scheduler

import kotlin.coroutines.RestrictsSuspension
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@RestrictsSuspension
public class TaskContext<T : Any> {
    public lateinit var context: T
        private set

    public fun updateContext(
        newContext: () -> T,
        updateContext: (T) -> Unit
    ) {
        if (this::context.isInitialized) {
            updateContext(context)
        } else {
            context = newContext()
        }
    }

    public suspend fun yield() {
        sleepFor(0)
    }

    public suspend fun endTick() {
        sleepFor(1)
    }

    public suspend fun sleepFor(ticks: Int) {
        suspendCoroutine {
            val task = TaskInternals.of(it)

            if (ticks > 0) {
                task.sleep(ticks, it)
            } else {
                if (task.shouldYield()) {
                    task.yield(it)
                } else {
                    it.resume(Unit)
                }
            }
        }
    }

    public suspend fun rescheduleOn(newScheduler: TickingScheduler<T>) {
        suspendCoroutine<Unit> {
            val task = TaskInternals.of(it)

            task.executionContext.currentScheduler.removeTask(task)
            newScheduler.addTask(task)
        }
    }

    public suspend fun waitUntil(checkEvery: Int = 1, checkNow: Boolean = true, check: () -> Boolean) {
        if (checkNow && check()) {
            yield()
            return
        }

        suspendCoroutine {
            val task = TaskInternals.of(it)
            task.waitUntil(checkEvery, check, it)
        }
    }
}
