package coffee.cypher.kettle.coroutine.tickdispatcher

class TaskExecutionException internal constructor(name: String, cause: Throwable) : RuntimeException("Exception in task $name", cause)