package coffee.cypher.kettle

/**
 * Marks parts of the API that are still in the development process,
 * and may change unpredictably.
 */
@RequiresOptIn(
    "This API is unstable and can be deprecated or removed in a minor version update",
    level = RequiresOptIn.Level.WARNING
)
public annotation class UnstableApi
