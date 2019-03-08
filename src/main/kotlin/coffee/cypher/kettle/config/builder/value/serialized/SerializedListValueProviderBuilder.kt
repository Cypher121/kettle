package coffee.cypher.kettle.config.builder.value.serialized

import coffee.cypher.kettle.config.value.SerializedValueProvider
import coffee.cypher.kettle.config.value.ValueProvider
import coffee.cypher.kettle.config.builder.type.ValueDeserializer
import coffee.cypher.kettle.config.builder.type.ValuePredicateAcceptor
import coffee.cypher.kettle.config.builder.type.ValueSerializer
import coffee.cypher.kettle.config.builder.type.impl.BasicValueDeserializer
import coffee.cypher.kettle.config.builder.type.impl.BasicValueSerializer
import coffee.cypher.kettle.config.builder.value.ListValueProviderBuilder
import net.minecraftforge.common.ForgeConfigSpec

class SerializedListValueProviderBuilder<T : Any, S : Any> private constructor(
        path: List<String>,
        private val serializationDelegate: BasicValueSerializer<T, S>,
        private val deserializationDelegate: BasicValueDeserializer<T?, S>
) : AbstractSerializedValueProviderBuilder<List<T>, List<S>, ListValueProviderBuilder<S>>(ListValueProviderBuilder(path)),
        ValueSerializer<T, S> by serializationDelegate, ValueDeserializer<T?, S> by deserializationDelegate, ValuePredicateAcceptor<T> {

    constructor(path: List<String>) : this(path, BasicValueSerializer(), BasicValueDeserializer())

    override fun acceptIf(predicate: (T) -> Boolean) {
        baseBuilder.acceptIf {
            val value = deserializeValue(it)
            value == null || predicate(value)
        }
    }

    override fun doBuild(builder: ForgeConfigSpec.Builder): ValueProvider<List<T>> {
        require(serializationDelegate.serializer != null && deserializationDelegate.deserializer != null) { "Serializer and deserializer must be set for value ${baseBuilder.combinedPath}" }

        return SerializedValueProvider(
                baseBuilder.build(builder)
        ) { it.mapNotNull(deserializationDelegate.deserializer!!) }
    }

    override fun serialize(input: List<T>) = input.map(serializationDelegate::serializeValue)
}