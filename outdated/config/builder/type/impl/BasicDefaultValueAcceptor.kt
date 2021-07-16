package coffee.cypher.kettle.config.builder.type.impl

import coffee.cypher.kettle.config.builder.type.DefaultValueAcceptor

internal class BasicDefaultValueAcceptor<T : Any> : DefaultValueAcceptor<T> {
    var defaultValueSupplier: (() -> T)? = null
        private set

    override fun defaultValue(defaultValueSupplier: () -> T) {
        this.defaultValueSupplier = defaultValueSupplier
    }

    override fun defaultValue(defaultValue: T) {
        defaultValue {
            defaultValue
        }
    }

}