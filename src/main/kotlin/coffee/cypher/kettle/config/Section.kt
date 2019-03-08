package coffee.cypher.kettle.config

import coffee.cypher.kettle.config.value.ValueProvider

@Suppress("UNCHECKED_CAST")
class Section(
        val name: String,
        private val values: Map<String, ValueProvider<*>>,
        private val sections: Map<String, Section>
) {
    fun <T : Any> value(fullPath: String): ValueProvider<T>? {
        val possibleValues = (listOf(values[fullPath.removePrefix("name.")]) + (sections.filterKeys {
            fullPath.startsWith("$it.")
        }.values.map { section ->
            section.value<T>(fullPath)
        })).filterNotNull()

        if (possibleValues.size > 1) {
            throw IllegalStateException("Multiple values named '$fullPath' were found")
        }

        return possibleValues.firstOrNull() as? ValueProvider<T>
    }
}