package coffee.cypher.kettle.config.builder.value.serialized

import coffee.cypher.kettle.config.builder.type.OptionalValueDeserializer
import coffee.cypher.kettle.config.builder.type.ValuePredicateAcceptor
import coffee.cypher.kettle.config.builder.type.ValueSerializer
import coffee.cypher.kettle.config.builder.type.impl.BasicOptionalValueDeserializer
import coffee.cypher.kettle.config.builder.type.impl.BasicValueSerializer
import coffee.cypher.kettle.config.builder.value.ListValueProviderBuilder
import coffee.cypher.kettle.config.value.SerializedValueProvider
import coffee.cypher.kettle.config.value.ValueProvider
import net.minecraftforge.common.ForgeConfigSpec

class SerializedListValueProviderBuilder<T : Any, S : Any> private constructor(
        path: List<String>,
        private val serializationDelegate: BasicValueSerializer<T, S>,
        private val deserializationDelegate: BasicOptionalValueDeserializer<T, S>
) : AbstractSerializedValueProviderBuilder<List<T>, List<S>, ListValueProviderBuilder<S>>(ListValueProviderBuilder(path)),
        ValueSerializer<T, S> by serializationDelegate, OptionalValueDeserializer<T, S> by deserializationDelegate, ValuePredicateAcceptor<T> {

    @PublishedApi
    internal constructor(path: List<String>) : this(path, BasicValueSerializer(), BasicOptionalValueDeserializer())

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