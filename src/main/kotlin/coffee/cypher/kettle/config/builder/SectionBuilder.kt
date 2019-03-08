package coffee.cypher.kettle.config.builder

import coffee.cypher.kettle.config.Section
import coffee.cypher.kettle.config.value.ValueProvider
import coffee.cypher.kettle.config.builder.type.ConfigElementBuilder
import coffee.cypher.kettle.config.builder.value.ListValueProviderBuilder
import coffee.cypher.kettle.config.builder.value.serialized.SerializedListValueProviderBuilder
import coffee.cypher.kettle.config.builder.value.serialized.SerializedSingleValueProviderBuilder
import coffee.cypher.kettle.config.builder.value.SingleValueProviderBuilder
import net.minecraftforge.common.ForgeConfigSpec

class SectionBuilder(val name: String) : ConfigElementBuilder<Section> {
    val valueBuilders = mutableListOf<ConfigElementBuilder<out ValueProvider<*>>>()
    val sectionBuilders = mutableListOf<SectionBuilder>()

    var translationRoot: String? = null
        private set

    override fun build(builder: ForgeConfigSpec.Builder): Section {
        val sections = sectionBuilders.map { it.build(builder) }.associateBy { it.name }

        if (name.isNotBlank()) {
            builder.push(name)
        }

        val values = valueBuilders.map { it.build(builder) }.associateBy {
            it.path.joinToString(separator = ".")
        }
        if (name.isNotBlank()) {
            builder.pop(name.split('.').size)
        }

        return Section(name, values, sections)
    }

    inline fun <reified T : Any> value(pathStart: String, vararg pathRest: String, block: SingleValueProviderBuilder<T>.() -> Unit) {
        val pathComponents = listOf(pathStart, *pathRest).flatMap { it.split('.') }
        val value = SingleValueProviderBuilder(pathComponents, T::class.java).apply {
            if (translationRoot != null) {
                translationKey("$translationRoot.$combinedPath")
            }

            block()
        }
        valueBuilders += value
    }

    inline fun <T : Any> valueList(pathStart: String, vararg pathRest: String, block: ListValueProviderBuilder<T>.() -> Unit) {
        val pathComponents = listOf(pathStart, *pathRest).flatMap { it.split('.') }
        val value = ListValueProviderBuilder<T>(pathComponents).apply {
            if (translationRoot != null) {
                translationKey("$translationRoot.$combinedPath")
            }

            block()
        }

        valueBuilders += value
    }

    inline fun <T : Any, reified S : Any> serializedValue(pathStart: String, vararg pathRest: String, block: SerializedSingleValueProviderBuilder<T, S>.() -> Unit) {
        val pathComponents = listOf(pathStart, *pathRest).flatMap { it.split('.') }
        val value = SerializedSingleValueProviderBuilder<T, S>(pathComponents, S::class.java).apply {
            if (translationRoot != null) {
                translationKey("$translationRoot.$combinedPath")
            }

            block()
        }
        valueBuilders += value
    }

    inline fun <T : Any, S : Any> serializedValueList(pathStart: String, vararg pathRest: String, block: SerializedListValueProviderBuilder<T, S>.() -> Unit) {
        val pathComponents = listOf(pathStart, *pathRest).flatMap { it.split('.') }
        val value = SerializedListValueProviderBuilder<T, S>(pathComponents).apply {
            if (translationRoot != null) {
                translationKey("$translationRoot.$combinedPath")
            }

            block()
        }

        valueBuilders += value
    }

    inline fun section(vararg name: String, block: SectionBuilder.() -> Unit) {
        val section = SectionBuilder(name.joinToString(separator = ".")).apply(block)

        if (translationRoot != null) {
            section.translationRoot("$translationRoot.$name")
        }

        sectionBuilders += section
    }

    inline fun subsection(vararg name: String, block: SectionBuilder.() -> Unit) = section(this.name, *name, block = block)

    fun translationRoot(root: String) {
        translationRoot = root
    }
}

