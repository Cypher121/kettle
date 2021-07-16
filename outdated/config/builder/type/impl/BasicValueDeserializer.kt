package coffee.cypher.kettle.config.builder.type.impl

import coffee.cypher.kettle.config.builder.type.ValueDeserializer

internal class BasicValueDeserializer<T : Any, S : Any> : ValueDeserializer<T, S> {
    var deserializer: ((S) -> T)? = null
        private set

    override fun deserializer(deserializer: (S) -> T) {
        this.deserializer = deserializer
    }

    override fun deserializeValue(input: S) = deserializer!!.invoke(input)
}