package coffee.cypher.kettle.config.builder.type.impl

import coffee.cypher.kettle.config.builder.type.ValueConverter

internal class BasicValueConverter<T : Any, S : Any> : ValueConverter<T, S> {
    var serializer: ((T) -> S)? = null
        private set

    var deserializer: ((S) -> T)? = null
        private set

    override fun serializer(serializer: (T) -> S) {
        this.serializer = serializer
    }

    override fun deserializer(deserializer: (S) -> T) {
        this.deserializer = deserializer
    }

    override fun serializeValue(input: T) = serializer!!.invoke(input)
    override fun deserializeValue(input: S) = deserializer!!.invoke(input)
}