package coffee.cypher.kettle.config.builder.value

import coffee.cypher.kettle.config.builder.type.ValuePredicateAcceptor
import coffee.cypher.kettle.config.builder.type.impl.BasicValuePredicateAcceptor
import coffee.cypher.kettle.config.value.ConfigValueProvider
import coffee.cypher.kettle.config.value.ValueProvider
import net.minecraftforge.common.ForgeConfigSpec

open class SingleValueProviderBuilder<T : Any> private constructor(
    path: List<String>,
    private val clazz: Class<T>,
    private val predicateAcceptorDelegate: BasicValuePredicateAcceptor<T>
) : AbstractValueProviderBuilder<T>(path), ValuePredicateAcceptor<T> by predicateAcceptorDelegate {
    @PublishedApi
    internal constructor(path: List<String>, clazz: Class<T>) : this(path, clazz, BasicValuePredicateAcceptor())

    @Suppress("UNCHECKED_CAST")
    override fun doBuild(builder: ForgeConfigSpec.Builder): ValueProvider<T> {
        return ConfigValueProvider(
            builder.define(
                path,
                { defaultValueSupplier!!.invoke() },
                { clazz.isAssignableFrom(it.javaClass) && predicateAcceptorDelegate.predicate?.invoke(it as T) != false },
                clazz
            )
        )
    }
}