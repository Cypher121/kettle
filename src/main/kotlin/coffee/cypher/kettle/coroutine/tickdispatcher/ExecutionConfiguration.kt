package coffee.cypher.kettle.coroutine.tickdispatcher

sealed class ExecutionConfiguration(val initialDelay: Int, val yieldsAfterMs: Double) {
    companion object {
        fun once(initialDelay: Int = 1, yieldsAfterMs: Double = 50.0): ExecutionConfiguration {
            require(initialDelay >= 0) { "initialDelay must be non-negative, was $initialDelay" }

            return Once(initialDelay, yieldsAfterMs)
        }

        fun infinite(initialDelay: Int = 0, pause: Int = 1, yieldsAfterMs: Double = 50.0): ExecutionConfiguration {
            require(initialDelay >= 0) { "initialDelay must be non-negative, was $initialDelay" }
            require(pause > 0) { "pause must be positive, was $pause" }

            return Infinite(initialDelay, pause, yieldsAfterMs)
        }

        fun repeat(initialDelay: Int = 0, pause: Int = 1, times: Int = 1, yieldsAfterMs: Double = 50.0): ExecutionConfiguration {
            require(initialDelay >= 0) { "initialDelay must be non-negative, was $initialDelay" }
            require(pause > 0) { "pause must be positive, was $pause" }
            require(times > 0) { "times must be positive, was $times" }

            return Repeat(initialDelay, pause, times, yieldsAfterMs)
        }

    }

    internal abstract fun buildCoroutine(block: suspend TickCoroutineDispatcher.TaskExecutor.() -> Unit): suspend TickCoroutineDispatcher.TaskExecutor.() -> Unit

    private class Once(initialDelay: Int, yieldsAfterMs: Double) : ExecutionConfiguration(initialDelay, yieldsAfterMs) {
        override fun buildCoroutine(block: suspend TickCoroutineDispatcher.TaskExecutor.() -> Unit): suspend TickCoroutineDispatcher.TaskExecutor.() -> Unit = {
            sleepFor(initialDelay)
            block()
        }

    }

    private class Infinite(initialDelay: Int, val pause: Int, yieldsAfterMs: Double) : ExecutionConfiguration(initialDelay, yieldsAfterMs) {
        override fun buildCoroutine(block: suspend TickCoroutineDispatcher.TaskExecutor.() -> Unit): suspend TickCoroutineDispatcher.TaskExecutor.() -> Unit = {
            sleepFor(initialDelay)
            while (true) {
                block()
                sleepFor(pause)
            }
        }

    }

    private class Repeat(initialDelay: Int, val pause: Int, val times: Int, yieldsAfterMs: Double) : ExecutionConfiguration(initialDelay, yieldsAfterMs) {
        override fun buildCoroutine(block: suspend TickCoroutineDispatcher.TaskExecutor.() -> Unit): suspend TickCoroutineDispatcher.TaskExecutor.() -> Unit = {
            sleepFor(initialDelay)
            repeat(times) {
                block()
                sleepFor(pause)
            }
        }
    }
}