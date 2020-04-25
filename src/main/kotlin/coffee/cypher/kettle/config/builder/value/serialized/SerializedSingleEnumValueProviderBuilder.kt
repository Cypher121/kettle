package coffee.cypher.kettle.config.builder.value.serialized

import coffee.cypher.kettle.config.builder.type.EnumConfigurator
import coffee.cypher.kettle.config.builder.type.impl.BasicValueConverter
import coffee.cypher.kettle.config.builder.value.SingleEnumValueProviderBuilder

class SerializedSingleEnumValueProviderBuilder<T : Any, S : Enum<S>> private constructor(
    baseProvider: SingleEnumValueProviderBuilder<S>
) : SerializedSingleValueProviderBuilder<T, S>(BasicValueConverter(), baseProvider),
        EnumConfigurator by baseProvider {
    @PublishedApi
    internal constructor(path: List<String>, clazz: Class<S>) : this(SingleEnumValueProviderBuilder(path, clazz))
}