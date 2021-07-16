@file:JvmName("ConfigDslExtensions")
@file:OptIn(ExperimentalTypeInference::class)

package coffee.cypher.kettle.config.builder

import coffee.cypher.kettle.config.builder.type.*
import net.minecraft.util.ResourceLocation
import net.minecraftforge.registries.IForgeRegistry
import net.minecraftforge.registries.IForgeRegistryEntry
import net.minecraftforge.registries.RegistryManager
import kotlin.experimental.ExperimentalTypeInference

@BuilderInference
fun <T : Comparable<T>> ValuePredicateAcceptor<T>.acceptedRange(range: ClosedRange<T>) = acceptIf {
    it in range
}

@BuilderInference
fun <T> DefaultValueAcceptor<List<T>>.defaultValues(vararg value: T) = defaultValue(value.toList())

@BuilderInference
fun <T : IForgeRegistryEntry<T>> ValueSerializer<T, String>.serializeUsingRegistryName() {
    serializer {
        it.registryName?.toString()
            ?: throw IllegalArgumentException("Could not serialize '$it' as a registry entry, as it has a null registry name")
    }
}

@BuilderInference
inline fun <reified T : IForgeRegistryEntry<T>> ValueDeserializer<T, String>.deserializeAsRegistryEntry() {
    deserializer {
        val registry: IForgeRegistry<T> = RegistryManager.ACTIVE.getRegistry(T::class.java)
            ?: throw IllegalStateException(
                "Could not serialize '$it' as a registry entry, as there is no registry for type '${T::class.java.canonicalName}'"
            )

        registry.getValue(ResourceLocation(it))
            ?: throw IllegalArgumentException(
                "Could not serialize '$it' as a registry entry, as it is not present in current registry for type '${T::class.java.canonicalName}'"
            )
    }
}

@BuilderInference
inline fun <reified T : IForgeRegistryEntry<T>> OptionalValueDeserializer<T, String>.deserializeAsRegistryEntry(errorOnMissing: Boolean = false) {
    deserializer {
        val result = RegistryManager.ACTIVE.getRegistry(T::class.java)?.getValue(ResourceLocation(it))

        if (result == null && errorOnMissing) {
            throw IllegalArgumentException("Could not serialize '$it' as a registry entry, as it is not present in current registry for type '${T::class.java.canonicalName}'")
        } else {
            result
        }
    }
}

@BuilderInference
fun <T : Any> ValuePredicateAcceptor<T>.acceptedValues(values: Iterable<T>) {
    acceptIf {
        it in values
    }
}

@BuilderInference
fun <T : Any> ValuePredicateAcceptor<T>.acceptedValues(vararg value: T) {
    acceptedValues(value.asIterable())
}