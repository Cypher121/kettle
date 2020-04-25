package coffee.cypher.kettle.config.builder.value.serialized

import coffee.cypher.kettle.config.value.ValueProvider
import coffee.cypher.kettle.config.builder.type.ConfigElementBuilder
import coffee.cypher.kettle.config.builder.value.AbstractValueProviderBuilder
import coffee.cypher.kettle.config.builder.type.DefaultValueAcceptor
import net.minecraftforge.common.ForgeConfigSpec

abstract class AbstractSerializedValueProviderBuilder<T : Any, S : Any, B : AbstractValueProviderBuilder<S>> internal constructor(
        protected val baseBuilder: B
) : ConfigElementBuilder<ValueProvider<T>>, DefaultValueAcceptor<T> {

    val combinedPath: String
        get() = baseBuilder.combinedPath

    val comment: Array<out String>?
        get() = baseBuilder.comment

    val translationKey: String?
        get() = baseBuilder.translationKey

    fun comment(vararg comment: String) {
        baseBuilder.comment(*comment)
    }

    fun translationKey(key: String) {
        baseBuilder.translationKey(key)
    }

    override fun defaultValue(defaultValueSupplier: () -> T) {
        baseBuilder.defaultValue { serialize(defaultValueSupplier()) }
    }

    override fun defaultValue(defaultValue: T) {
        defaultValue {
            defaultValue
        }
    }

    final override fun build(builder: ForgeConfigSpec.Builder) = doBuild(builder)

    abstract fun doBuild(builder: ForgeConfigSpec.Builder): ValueProvider<T>

    abstract fun serialize(input: T): S
}