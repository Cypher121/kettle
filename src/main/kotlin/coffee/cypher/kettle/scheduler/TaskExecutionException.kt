package coffee.cypher.kettle.scheduler

public class TaskExecutionException internal constructor(name: String, cause: Throwable) :
    RuntimeException("Exception in task $name", cause)