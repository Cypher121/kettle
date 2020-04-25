package coffee.cypher.kettle.config.builder.type

interface ValueDeserializer<T : Any, S : Any> {
    fun deserializeValue(input: S): T
    fun deserializer(deserializer: (S) -> T)
}