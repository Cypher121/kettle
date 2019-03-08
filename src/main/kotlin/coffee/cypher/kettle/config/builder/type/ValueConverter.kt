package coffee.cypher.kettle.config.builder.type

interface ValueConverter<T, S> : ValueSerializer<T, S>, ValueDeserializer<T, S>