package coffee.cypher.kettle.scheduler

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 * Coroutine context for a [Task] containing methods
 * allowing suspension of execution, such as [sleepFor]
 * and [waitUntil].
 */
public class TaskContext<T : Any>
internal constructor(private val task: TaskInternals<T>) {
    @PublishedApi
    internal lateinit var context: T
        private set

    /**
     * Provides the generic context of type [T] that
     * is available to the task and may change after suspension.
     */
    @OptIn(ExperimentalContracts::class)
    public inline fun withContext(block: T.() -> Unit) {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }

        return with(context) {
            block()
        }
    }

    internal fun updateContext() {
        if (this::context.isInitialized) {
            task.executionContext.updateContext(context)
        } else {
            context = task.executionContext.newContext()
        }
    }

    /**
     * Suspends the task if it has been running
     * for longer than [ExecutionConfiguration.yieldsAfterMs]
     * specified in its configuration.
     *
     * Should be called often in long-running blocks
     * to mitigate lag.
     */
    public suspend fun yield() {
        suspendCoroutine {
            if (task.shouldYield()) {
                task.yield(it)
            } else {
                it.resume(Unit)
            }
        }
    }

    /**
     * Suspends the task until the next tick.
     */
    public suspend fun endTick() {
        suspendCoroutine {
            task.yield(it)
        }
    }

    /**
     * Suspends the task for the specified number of [ticks].
     */
    public suspend fun sleepFor(ticks: Int) {
        if (ticks > 0) {
            suspendCoroutine {
                task.sleep(ticks, it)
            }
        } else {
            yield()
        }
    }

    /**
     * Suspends the task, removes it from the current scheduler,
     * and registers it on [the new scheduler][newScheduler], allowing it to resume
     * when it ticks next.
     */
    public suspend fun rescheduleOn(newScheduler: TickingScheduler<T>) {
        suspendCoroutine {
            task.executionContext.currentScheduler.removeTask(task)
            newScheduler.addTask(task)

            task.yield(it)
        }
    }

    /**
     * Suspends the task until the [check] condition is fulfilled.
     *
     * The condition will be checked once per [checkEvery] ticks (default every tick).
     * If [checkNow] is `true` (or by default), the condition will be checked immediately,
     * and if `true` the task will either [yield] or resume.
     */
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
