package coffee.cypher.kettle.config.builder.type

interface ValueSerializer<T, S> {
    fun serializeValue(input: T): S
    fun serializer(serializer: (T) -> S)
}