package coffee.cypher.kettle.config.builder.type

interface ValuePredicateAcceptor<T> {
    fun acceptIf(predicate: (T) -> Boolean)

    fun acceptedValues(vararg value: T) {
        acceptedValues(value.asIterable())
    }

    fun acceptedValues(values: Iterable<T>) {
        acceptIf {
            it in values
        }
    }
}