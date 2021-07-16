package coffee.cypher.kettle.config.value

internal class SerializedValueProvider<T : Any, S : Any>(
        private val configValue: ValueProvider<S>,
        private val deserializer: (S) -> T
) : ValueProvider<T> {
    override fun get() = deserializer(configValue.get())

    override val path = configValue.path
}