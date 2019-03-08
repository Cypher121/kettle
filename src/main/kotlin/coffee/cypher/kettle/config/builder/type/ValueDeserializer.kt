package coffee.cypher.kettle.config.builder.type

interface ValueDeserializer<T, S> {
    fun deserializeValue(input: S): T
    fun deserializer(deserializer: (S) -> T)
}