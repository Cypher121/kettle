package coffee.cypher.kettle.config.builder

import coffee.cypher.kettle.config.Section
import coffee.cypher.kettle.config.builder.type.ConfigElementBuilder
import coffee.cypher.kettle.config.builder.value.ListValueProviderBuilder
import coffee.cypher.kettle.config.builder.value.SingleEnumValueProviderBuilder
import coffee.cypher.kettle.config.builder.value.SingleValueProviderBuilder
import coffee.cypher.kettle.config.builder.value.serialized.SerializedListValueProviderBuilder
import coffee.cypher.kettle.config.builder.value.serialized.SerializedSingleEnumValueProviderBuilder
import coffee.cypher.kettle.config.builder.value.serialized.SerializedSingleValueProviderBuilder
import coffee.cypher.kettle.config.value.ValueProvider
import net.minecraftforge.common.ForgeConfigSpec
import java.time.temporal.Temporal
import kotlin.experimental.ExperimentalTypeInference

@OptIn(ExperimentalTypeInference::class)
class SectionBuilder @PublishedApi internal constructor(val name: String) : ConfigElementBuilder<Section> {
    @PublishedApi
    internal val valueBuilders = mutableListOf<ConfigElementBuilder<out ValueProvider<*>>>()

    @PublishedApi
    internal val sectionBuilders = mutableListOf<SectionBuilder>()

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

    @JvmName("stringValue")
    inline fun <reified T : CharSequence> value(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SingleValueProviderBuilder<T>.() -> Unit
    ) = doValue(pathStart, *pathRest, block = block)

    @JvmName("numberValue")
    inline fun <reified T : Number> value(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SingleValueProviderBuilder<T>.() -> Unit
    ) = doValue(pathStart, *pathRest, block = block)

    @JvmName("listValue")
    inline fun <reified T : List<*>> value(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SingleValueProviderBuilder<T>.() -> Unit
    ) = doValue(pathStart, *pathRest, block = block)

    @Suppress("FINAL_UPPER_BOUND")
    @JvmName("booleanValue")
    inline fun <reified T : Boolean> value(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SingleValueProviderBuilder<T>.() -> Unit
    ) = doValue(pathStart, *pathRest, block = block)

    @JvmName("temporalValue")
    inline fun <reified T : Temporal> value(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SingleValueProviderBuilder<T>.() -> Unit
    ) = doValue(pathStart, *pathRest, block = block)

    @JvmName("enumValue")
    inline fun <reified T : Enum<T>> enumValue(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SingleEnumValueProviderBuilder<T>.() -> Unit
    ) {
        val pathComponents = listOf(pathStart, *pathRest).flatMap { it.split('.') }
        val value = SingleEnumValueProviderBuilder(pathComponents, T::class.java).apply {
            if (translationRoot != null) {
                translationKey("$translationRoot.$combinedPath")
            }

            block()
        }
        valueBuilders += value
    }

    @UnknownTypeSerialization("Type used for this call might not be serializable by NightConfig. Add @OptIn(UnknownTypeSerialization::class) to suppress")
    inline fun <reified T : Any> value(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SingleValueProviderBuilder<T>.() -> Unit
    ) = doValue(pathStart, *pathRest, block = block)

    @PublishedApi
    internal inline fun <reified T : Any> doValue(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SingleValueProviderBuilder<T>.() -> Unit
    ) {
        //TODO remove once kotlin resolution bug is fixed
        if (Enum::class.java.isAssignableFrom(T::class.java)) {
            return enumValue(pathStart, *pathRest) { block() }
        }

        val pathComponents = listOf(pathStart, *pathRest).flatMap { it.split('.') }
        val value = SingleValueProviderBuilder(pathComponents, T::class.java).apply {
            if (translationRoot != null) {
                translationKey("$translationRoot.$combinedPath")
            }

            block()
        }
        valueBuilders += value
    }

    @JvmName("stringValueList")
    inline fun <T : CharSequence> valueList(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: ListValueProviderBuilder<T>.() -> Unit
    ) = doValueList(pathStart, *pathRest, block = block)

    @JvmName("numberValueList")
    inline fun <T : Number> valueList(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: ListValueProviderBuilder<T>.() -> Unit
    ) = doValueList(pathStart, *pathRest, block = block)

    @Suppress("FINAL_UPPER_BOUND")
    @JvmName("booleanValueList")
    inline fun <T : Boolean> valueList(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: ListValueProviderBuilder<T>.() -> Unit
    ) = doValueList(pathStart, *pathRest, block = block)

    @JvmName("temporalValueList")
    inline fun <T : Temporal> valueList(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: ListValueProviderBuilder<T>.() -> Unit
    ) = doValueList(pathStart, *pathRest, block = block)

    @UnknownTypeSerialization("Type used for this call might not be serializable by NightConfig. Add @OptIn(UnknownTypeSerialization::class) to suppress")
    inline fun <T : Any> valueList(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: ListValueProviderBuilder<T>.() -> Unit
    ) = doValueList(pathStart, *pathRest, block = block)

    @PublishedApi
    internal inline fun <T : Any> doValueList(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: ListValueProviderBuilder<T>.() -> Unit
    ) {
        val pathComponents = listOf(pathStart, *pathRest).flatMap { it.split('.') }
        val value = ListValueProviderBuilder<T>(pathComponents).apply {
            if (translationRoot != null) {
                translationKey("$translationRoot.$combinedPath")
            }

            block()
        }

        valueBuilders += value
    }

    @JvmName("stringSerializedValue")
    inline fun <T : Any, reified S : CharSequence> serializedValue(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SerializedSingleValueProviderBuilder<T, S>.() -> Unit
    ) = doSerializedValue(pathStart, *pathRest, block = block)

    @JvmName("numberSerializedValue")
    inline fun <T : Any, reified S : Number> serializedValue(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SerializedSingleValueProviderBuilder<T, S>.() -> Unit
    ) = doSerializedValue(pathStart, *pathRest, block = block)

    @JvmName("listSerializedValue")
    inline fun <T : Any, reified S : List<*>> serializedValue(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SerializedSingleValueProviderBuilder<T, S>.() -> Unit
    ) = doSerializedValue(pathStart, *pathRest, block = block)

    @Suppress("FINAL_UPPER_BOUND")
    @JvmName("booleanSerializedValue")
    inline fun <T : Any, reified S : Boolean> serializedValue(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SerializedSingleValueProviderBuilder<T, S>.() -> Unit
    ) = doSerializedValue(pathStart, *pathRest, block = block)

    @JvmName("temporalSerializedValue")
    inline fun <T : Any, reified S : Temporal> serializedValue(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SerializedSingleValueProviderBuilder<T, S>.() -> Unit
    ) = doSerializedValue(pathStart, *pathRest, block = block)

    @JvmName("enumSerializedValue")
    inline fun <T : Any, reified S : Enum<S>> enumSerializedValue(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SerializedSingleEnumValueProviderBuilder<T, S>.() -> Unit
    ) {
        val pathComponents = listOf(pathStart, *pathRest).flatMap { it.split('.') }
        val value = SerializedSingleEnumValueProviderBuilder<T, S>(pathComponents, S::class.java).apply {
            if (translationRoot != null) {
                translationKey("$translationRoot.$combinedPath")
            }

            block()
        }
        valueBuilders += value
    }

    @UnknownTypeSerialization("Type used for this call might not be serializable by NightConfig. Add @OptIn(UnknownTypeSerialization::class) to suppress")
    inline fun <T : Any, reified S : Any> serializedValue(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SerializedSingleValueProviderBuilder<T, S>.() -> Unit
    ) = doSerializedValue(pathStart, *pathRest, block = block)

    @PublishedApi
    internal inline fun <T : Any, reified S : Any> doSerializedValue(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SerializedSingleValueProviderBuilder<T, S>.() -> Unit
    ) {
        //TODO remove once kotlin resolution bug is fixed
        if (Enum::class.java.isAssignableFrom(S::class.java)) {
            return enumSerializedValue(pathStart, *pathRest) { block() }
        }

        val pathComponents = listOf(pathStart, *pathRest).flatMap { it.split('.') }
        val value = SerializedSingleValueProviderBuilder<T, S>(pathComponents, S::class.java).apply {
            if (translationRoot != null) {
                translationKey("$translationRoot.$combinedPath")
            }

            block()
        }
        valueBuilders += value
    }

    @JvmName("stringSerializedValueList")
    inline fun <T : Any, S : CharSequence> serializedValueList(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SerializedListValueProviderBuilder<T, S>.() -> Unit
    ) = doSerializedValueList(pathStart, *pathRest, block = block)

    @JvmName("numberSerializedValueList")
    inline fun <T : Any, S : Number> serializedValueList(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SerializedListValueProviderBuilder<T, S>.() -> Unit
    ) = doSerializedValueList(pathStart, *pathRest, block = block)

    @Suppress("FINAL_UPPER_BOUND")
    @JvmName("booleanSerializedValueList")
    inline fun <T : Any, S : Boolean> serializedValueList(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SerializedListValueProviderBuilder<T, S>.() -> Unit
    ) = doSerializedValueList(pathStart, *pathRest, block = block)

    @JvmName("temporalSerializedValueList")
    inline fun <T : Any, S : Temporal> serializedValueList(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SerializedListValueProviderBuilder<T, S>.() -> Unit
    ) = doSerializedValueList(pathStart, *pathRest, block = block)

    @UnknownTypeSerialization("Type used for this call might not be serializable by NightConfig. Add @OptIn(UnknownTypeSerialization::class) to suppress")
    inline fun <T : Any, S : Any> serializedValueList(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SerializedListValueProviderBuilder<T, S>.() -> Unit
    ) = doSerializedValueList(pathStart, *pathRest, block = block)

    @PublishedApi
    internal inline fun <T : Any, S : Any> doSerializedValueList(
        pathStart: String,
        vararg pathRest: String, @BuilderInference block: SerializedListValueProviderBuilder<T, S>.() -> Unit
    ) {
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

    inline fun subsection(vararg name: String, block: SectionBuilder.() -> Unit) =
        section(this.name, *name, block = block)

    fun translationRoot(root: String) {
        translationRoot = root
    }
}