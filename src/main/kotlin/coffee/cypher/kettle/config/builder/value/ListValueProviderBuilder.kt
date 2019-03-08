package coffee.cypher.kettle.config.builder.value

import coffee.cypher.kettle.config.builder.type.ValuePredicateAcceptor
import coffee.cypher.kettle.config.builder.type.impl.BasicValuePredicateAcceptor
import coffee.cypher.kettle.config.value.ConfigValueProvider
import coffee.cypher.kettle.config.value.ValueProvider
import net.minecraftforge.common.ForgeConfigSpec

class ListValueProviderBuilder<T : Any> private constructor(
        path: List<String>,
        private val predicateAcceptorDelegate: BasicValuePredicateAcceptor<T>
) : AbstractValueProviderBuilder<List<T>>(path), ValuePredicateAcceptor<T> by predicateAcceptorDelegate {
    constructor(path: List<String>) : this(path, BasicValuePredicateAcceptor())

    @Suppress("UNCHECKED_CAST")
    override fun doBuild(builder: ForgeConfigSpec.Builder): ValueProvider<List<T>> {
        return ConfigValueProvider(
                builder.defineList(path, { defaultValueSupplier!!.invoke() }) { it as? T != null && predicateAcceptorDelegate.predicate?.invoke(it) != false }
        )
    }
}

