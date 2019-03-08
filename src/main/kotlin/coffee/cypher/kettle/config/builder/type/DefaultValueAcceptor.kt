package coffee.cypher.kettle.config.builder.type

interface DefaultValueAcceptor<T> {
    fun defaultValue(defaultValueSupplier: () -> T)

    fun defaultValue(defaultValue: T)
}