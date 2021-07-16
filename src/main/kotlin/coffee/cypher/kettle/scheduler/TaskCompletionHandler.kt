package coffee.cypher.kettle.scheduler

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext

internal class TaskCompletionHandler(taskHandle: CoroutineContext) : Continuation<Unit> {
    override val context = taskHandle

    override fun resumeWith(result: Result<Unit>) {
        getHandle<Nothing>().stop()
        result.onFailure {
            throw TaskExecutionException(getHandle<Nothing>().name, it)
        }
    }
}

