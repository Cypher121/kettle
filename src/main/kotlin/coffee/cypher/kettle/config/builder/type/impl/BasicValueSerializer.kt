package coffee.cypher.kettle.config.builder.type.impl

import coffee.cypher.kettle.config.builder.type.ValueSerializer

internal class BasicValueSerializer<T, S> : ValueSerializer<T, S> {
    var serializer: ((T) -> S)? = null
        private set

    override fun serializer(serializer: (T) -> S) {
        this.serializer = serializer
    }

    override fun serializeValue(input: T) = serializer!!.invoke(input)
}