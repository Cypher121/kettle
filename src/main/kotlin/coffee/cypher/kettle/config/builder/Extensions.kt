@file:JvmName("ConfigDslExtensions")

package coffee.cypher.kettle.config.builder

import coffee.cypher.kettle.config.builder.type.DefaultValueAcceptor
import coffee.cypher.kettle.config.builder.type.ValuePredicateAcceptor
import coffee.cypher.kettle.config.builder.type.ValueDeserializer
import coffee.cypher.kettle.config.builder.type.ValueSerializer
import net.minecraft.util.ResourceLocation
import net.minecraftforge.registries.IForgeRegistry
import net.minecraftforge.registries.IForgeRegistryEntry
import net.minecraftforge.registries.RegistryManager

fun <T : Comparable<T>> ValuePredicateAcceptor<T>.acceptedRange(range: ClosedRange<T>) = acceptIf {
    it in range
}

fun <T> DefaultValueAcceptor<List<T>>.defaultValues(vararg value: T) = defaultValue(value.toList())

fun <T : IForgeRegistryEntry<T>> ValueSerializer<T, String>.serializeUsingRegistryName() {
    serializer {
        it.registryName?.toString()
                ?: throw IllegalArgumentException("Could not serialize '$it' as a registry entry, as it has a null registry name")
    }
}

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

inline fun <reified T : IForgeRegistryEntry<T>> ValueDeserializer<T?, String>.deserializeAsRegistryEntry(errorOnMissing: Boolean = false) {
    deserializer {
        val result = RegistryManager.ACTIVE.getRegistry(T::class.java)?.getValue(ResourceLocation(it))

        if (result == null && errorOnMissing) {
            throw IllegalArgumentException("Could not serialize '$it' as a registry entry, as it is not present in current registry for type '${T::class.java.canonicalName}'")
        } else {
            result
        }
    }
}