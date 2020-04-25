package coffee.cypher.kettle.config.builder.value.serialized

import coffee.cypher.kettle.config.builder.type.ValueConverter
import coffee.cypher.kettle.config.builder.type.ValuePredicateAcceptor
import coffee.cypher.kettle.config.builder.type.impl.BasicValueConverter
import coffee.cypher.kettle.config.builder.value.SingleValueProviderBuilder
import coffee.cypher.kettle.config.value.SerializedValueProvider
import coffee.cypher.kettle.config.value.ValueProvider
import net.minecraftforge.common.ForgeConfigSpec

open class SerializedSingleValueProviderBuilder<T : Any, S : Any> internal constructor(
    private val serializationDelegate: BasicValueConverter<T, S>,
    baseProvider: SingleValueProviderBuilder<S>
) : AbstractSerializedValueProviderBuilder<T, S, SingleValueProviderBuilder<S>>(baseProvider),
    ValueConverter<T, S> by serializationDelegate, ValuePredicateAcceptor<T> {

    @PublishedApi
    internal constructor(path: List<String>, clazz: Class<S>) : this(
        BasicValueConverter(),
        SingleValueProviderBuilder(path, clazz)
    )

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