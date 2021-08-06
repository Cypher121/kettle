package coffee.cypher.kettle.config.builder.type

interface ValuePredicateAcceptor<T : Any> {
    fun acceptIf(predicate: (T) -> Boolean)

}