package coffee.cypher.kettle.scheduler

/**
 * Description of a [Task]'s execution pattern dictating how often it will
 * execute, how many times, etc.
 */
public sealed class ExecutionConfiguration(public val initialDelay: Int, public val yieldsAfterMs: Double) {
    public companion object {
        /**
         * Creates an [ExecutionConfiguration] for a task
         * that will execute once after [initialDelay] ticks and
         * yields after executing for at least [yieldsAfterMs] milliseconds.
         */
        public fun once(initialDelay: Int = 0, yieldsAfterMs: Double = 50.0): ExecutionConfiguration {
            require(initialDelay >= 0) { "initialDelay must be non-negative, was $initialDelay" }

            return Once(initialDelay, yieldsAfterMs)
        }

        /**
         * Creates an [ExecutionConfiguration] for a task
         * that will execute infinitely after [initialDelay] ticks,
         * pauses for [pause] ticks after each execution and
         * yields after executing for at least [yieldsAfterMs] milliseconds.
         */
        public fun infinite(
            initialDelay: Int = 0,
            pause: Int = 1,
            yieldsAfterMs: Double = 50.0
        ): ExecutionConfiguration {
            require(initialDelay >= 0) { "initialDelay must be non-negative, was $initialDelay" }
            require(pause > 0) { "pause must be positive, was $pause" }

            return Infinite(initialDelay, pause, yieldsAfterMs)
        }

        /**
         * Creates an [ExecutionConfiguration] for a task
         * that will execute specified number of times [times]
         * after [initialDelay] ticks, pauses for [pause] ticks after each execution and
         * yields after executing for at least [yieldsAfterMs] milliseconds.
         */
        public fun repeat(
            initialDelay: Int = 0,
            pause: Int = 1,
            times: Int = 1,
            yieldsAfterMs: Double = 50.0
        ): ExecutionConfiguration {
            require(initialDelay >= 0) { "initialDelay must be non-negative, was $initialDelay" }
            require(pause > 0) { "pause must be positive, was $pause" }
            require(times > 0) { "times must be positive, was $times" }

            return Repeat(initialDelay, pause, times, yieldsAfterMs)
        }

    }

    internal abstract fun <T : Any> buildCoroutine(block: suspend TaskContext<T>.() -> Unit): suspend TaskContext<T>.() -> Unit

    private class Once(initialDelay: Int, yieldsAfterMs: Double) : ExecutionConfiguration(initialDelay, yieldsAfterMs) {
        override fun <T : Any> buildCoroutine(block: suspend TaskContext<T>.() -> Unit): suspend TaskContext<T>.() -> Unit =
            {
                sleepFor(initialDelay)
                block()
            }

    }

    private class Infinite(initialDelay: Int, val pause: Int, yieldsAfterMs: Double) :
        ExecutionConfiguration(initialDelay, yieldsAfterMs) {
        override fun <T : Any> buildCoroutine(block: suspend TaskContext<T>.() -> Unit): suspend TaskContext<T>.() -> Unit =
            {
                sleepFor(initialDelay)
                while (true) {
                    block()
                    sleepFor(pause)
                }
            }

    }

    private class Repeat(initialDelay: Int, val pause: Int, val times: Int, yieldsAfterMs: Double) :
        ExecutionConfiguration(initialDelay, yieldsAfterMs) {
        override fun <T : Any> buildCoroutine(block: suspend TaskContext<T>.() -> Unit): suspend TaskContext<T>.() -> Unit =
            {
                sleepFor(initialDelay)
                repeat(times) { _ ->
                    block()
                    sleepFor(pause)
                }
            }
    }
}
