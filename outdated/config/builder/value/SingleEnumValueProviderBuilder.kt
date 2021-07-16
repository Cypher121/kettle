package coffee.cypher.kettle.config.builder.value

import coffee.cypher.kettle.config.builder.type.EnumConfigurator
import coffee.cypher.kettle.config.builder.type.impl.BasicEnumConfigurator
import coffee.cypher.kettle.config.builder.type.impl.BasicValuePredicateAcceptor
import coffee.cypher.kettle.config.value.ConfigValueProvider
import coffee.cypher.kettle.config.value.ValueProvider
import net.minecraftforge.common.ForgeConfigSpec

class SingleEnumValueProviderBuilder<T : Enum<T>> private constructor(
    path: List<String>,
    private val clazz: Class<T>,
    private val predicateAcceptorDelegate: BasicValuePredicateAcceptor<T>,
    private val enumConfiguratorDelegate: EnumConfigurator
) : SingleValueProviderBuilder<T>(path, clazz),
    EnumConfigurator by enumConfiguratorDelegate {
    @PublishedApi
    internal constructor(path: List<String>, clazz: Class<T>) : this(path, clazz, BasicValuePredicateAcceptor(), BasicEnumConfigurator())

    @Suppress("UNCHECKED_CAST")
    override fun doBuild(builder: ForgeConfigSpec.Builder): ValueProvider<T> {
        return ConfigValueProvider(
            builder.defineEnum(
                path,
                { defaultValueSupplier!!.invoke() },
                getMethod,
                { it as? T != null && predicateAcceptorDelegate.predicate?.invoke(it) != false },
                clazz
            )
        )
    }
}