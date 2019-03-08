package coffee.cypher.kettle.coroutine.tickdispatcher

class TaskDataStore {
    private val map = mutableMapOf<String, Pair<Lifespan, Any>>()

    operator fun <T> get(key: String): T? {
        val value = map[key]

        if (value?.first == Lifespan.SINGLE_ACCESS) {
            map -= key
        }

        @Suppress("UNCHECKED_CAST")
        return value?.second as? T
    }

    operator fun contains(key: String) = key in map

    operator fun minusAssign(key: String) {
        map -= key
    }

    fun remove(key: String) {
        minusAssign(key)
    }

    fun store(key: String, value: Any, lifespan: Lifespan) {
        map[key] = lifespan to value
    }

    fun clearExecutionLocalData() {
        val toRemove = map.filterValues { it.first == Lifespan.EXECUTION_LOCAL }.keys
        map -= toRemove
    }

    enum class Lifespan {
        SINGLE_ACCESS,
        EXECUTION_LOCAL,
        PERSISTENT
    }
}