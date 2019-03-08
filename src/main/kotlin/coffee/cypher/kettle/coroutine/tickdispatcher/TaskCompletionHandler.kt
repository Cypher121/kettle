package coffee.cypher.kettle.coroutine.tickdispatcher

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext

internal class TaskCompletionHandler(taskHandle: CoroutineContext) : Continuation<Unit> {
    override val context = taskHandle

    override fun resumeWith(result: Result<Unit>) {
        handle.stop()
        result.onFailure {
            throw TaskExecutionException(handle.name, it)
        }
    }
}

