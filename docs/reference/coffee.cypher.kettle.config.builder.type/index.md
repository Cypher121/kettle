[coffee.cypher.kettle.config.builder.type](./index.md)

## Package coffee.cypher.kettle.config.builder.type

### Types

| Name | Summary |
|---|---|
| [ConfigElementBuilder](-config-element-builder/index.md) | `interface ConfigElementBuilder<T> : `[`Function`](http://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)`<Builder, `[`T`](-config-element-builder/index.md#T)`>` |
| [DefaultValueAcceptor](-default-value-acceptor/index.md) | `interface DefaultValueAcceptor<T>` |
| [ValueConverter](-value-converter.md) | `interface ValueConverter<T, S> : `[`ValueSerializer`](-value-serializer/index.md)`<`[`T`](-value-converter.md#T)`, `[`S`](-value-converter.md#S)`>, `[`ValueDeserializer`](-value-deserializer/index.md)`<`[`T`](-value-converter.md#T)`, `[`S`](-value-converter.md#S)`>` |
| [ValueDeserializer](-value-deserializer/index.md) | `interface ValueDeserializer<T, S>` |
| [ValuePredicateAcceptor](-value-predicate-acceptor/index.md) | `interface ValuePredicateAcceptor<T>` |
| [ValueSerializer](-value-serializer/index.md) | `interface ValueSerializer<T, S>` |
