package coffee.cypher.kettle.config.builder.value.serialized

import coffee.cypher.kettle.config.value.SerializedValueProvider
import coffee.cypher.kettle.config.builder.type.ValuePredicateAcceptor
import coffee.cypher.kettle.config.value.ValueProvider
import coffee.cypher.kettle.config.builder.value.SingleValueProviderBuilder
import coffee.cypher.kettle.config.builder.type.ValueConverter
import coffee.cypher.kettle.config.builder.type.impl.BasicValueConverter
import net.minecraftforge.common.ForgeConfigSpec

class SerializedSingleValueProviderBuilder<T : Any, S : Any> private constructor(
        path: List<String>,
        clazz: Class<S>,
        private val serializationDelegate: BasicValueConverter<T, S>
) : AbstractSerializedValueProviderBuilder<T, S, SingleValueProviderBuilder<S>>(SingleValueProviderBuilder(path, clazz)),
        ValueConverter<T, S> by serializationDelegate, ValuePredicateAcceptor<T> {

    constructor(path: List<String>, clazz: Class<S>) : this(path, clazz, BasicValueConverter())

    override fun acceptIf(predicate: (T) -> Boolean) {
        baseBuilder.acceptIf { predicate(serializationDelegate.deserializeValue(it)) }
    }

    override fun doBuild(builder: ForgeConfigSpec.Builder): ValueProvider<T> {
        require(serializationDelegate.serializer != null && serializationDelegate.deserializer != null) { "Serializer and deserializer must be set for value ${baseBuilder.combinedPath}" }

        return SerializedValueProvider(
                baseBuilder.build(builder),
                serializationDelegate.deserializer!!
        )
    }

    override fun serialize(input: T) = serializationDelegate.serializeValue(input)
}