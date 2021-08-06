package coffee.cypher.kettle.config.builder.type

interface ValueSerializer<T : Any, S : Any> {
    fun serializeValue(input: T): S
    fun serializer(serializer: (T) -> S)
}