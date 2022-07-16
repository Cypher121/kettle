package coffee.cypher.kettle.scheduler

/**
 * Exception representing a failure that occurred while executing a task.
 */
public class TaskExecutionException internal constructor(name: String, cause: Throwable) :
    RuntimeException("Exception in task $name", cause)
