package coffee.cypher.kettle.config.builder.type

interface ValueConverter<T : Any, S : Any> : ValueSerializer<T, S>, ValueDeserializer<T, S>