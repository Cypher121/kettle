package coffee.cypher.kettle.scheduler

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

public class TaskContext<T : Any>
internal constructor(private val task: TaskInternals<T>) {
    @PublishedApi
    internal lateinit var context: T
        private set

    @OptIn(ExperimentalContracts::class)
    public inline fun withContext(block: T.() -> Unit) {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }

        return with(context) {
            block()
        }
    }

    public fun updateContext() {
        if (this::context.isInitialized) {
            task.executionContext.updateContext(context)
        } else {
            context = task.executionContext.newContext()
        }
    }

    public suspend fun yield() {
        suspendCoroutine {
            if (task.shouldYield()) {
                task.yield(it)
            } else {
                it.resume(Unit)
            }
        }
    }

    public suspend fun endTick() {
        sleepFor(1)
    }

    public suspend fun sleepFor(ticks: Int) {
        if (ticks > 0) {
            suspendCoroutine {
                task.sleep(ticks, it)
            }
        } else {
            yield()
        }
    }

    public suspend fun rescheduleOn(newScheduler: TickingScheduler<T>) {
        suspendCoroutine {
            task.executionContext.currentScheduler.removeTask(task)
            newScheduler.addTask(task)

            task.yield(it)
        }
    }

    public suspend fun waitUntil(checkEvery: Int = 1, checkNow: Boolean = true, check: () -> Boolean) {
        if (checkNow && check()) {
            yield()
            return
        }

        suspendCoroutine {
            task.waitUntil(checkEvery, check, it)
        }
    }
}
