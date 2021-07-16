package coffee.cypher.kettle.config.builder.type.impl

import coffee.cypher.kettle.config.builder.type.ValuePredicateAcceptor

internal class BasicValuePredicateAcceptor<T : Any> : ValuePredicateAcceptor<T> {
    var predicate: ((T) -> Boolean)? = null
        private set

    override fun acceptIf(predicate: (T) -> Boolean) {
        this.predicate = predicate
    }

}