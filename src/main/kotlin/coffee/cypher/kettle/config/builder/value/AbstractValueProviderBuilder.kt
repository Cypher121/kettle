package coffee.cypher.kettle.config.builder.value

import coffee.cypher.kettle.config.value.ValueProvider
import coffee.cypher.kettle.config.builder.type.ConfigElementBuilder
import coffee.cypher.kettle.config.builder.type.DefaultValueAcceptor
import coffee.cypher.kettle.config.builder.type.impl.BasicDefaultValueAcceptor
import net.minecraftforge.common.ForgeConfigSpec

abstract class AbstractValueProviderBuilder<T : Any> private constructor(
        val path: List<String>,
        private val defaultValueDelegate: BasicDefaultValueAcceptor<T>
) : ConfigElementBuilder<ValueProvider<T>>, DefaultValueAcceptor<T> by defaultValueDelegate {

    constructor(path: List<String>) : this(path, BasicDefaultValueAcceptor())

    protected val defaultValueSupplier: (() -> T)?
        get() = defaultValueDelegate.defaultValueSupplier

    var comment: Array<out String>? = null
        private set

    var translationKey: String? = null
        private set

    val combinedPath: String
        get() = path.joinToString(separator = ".")

    fun comment(vararg comment: String) {
        this.comment = comment
    }

    fun translationKey(key: String) {
        translationKey = key
    }

    private fun preBuildCheck() {
        require(defaultValueDelegate.defaultValueSupplier != null) { "Default value or default value supplier must be set" }
    }

    final override fun build(builder: ForgeConfigSpec.Builder): ValueProvider<T> {
        preBuildCheck()
        registerDescription(builder)

        return doBuild(builder)
    }

    abstract fun doBuild(builder: ForgeConfigSpec.Builder): ValueProvider<T>

    private fun registerDescription(builder: ForgeConfigSpec.Builder) {
        if (comment != null) {
            builder.comment(*comment!!)
        }

        if (translationKey != null) {
            builder.translation(translationKey)
        }
    }
}

