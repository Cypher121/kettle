package coffee.cypher.kettle.config

import coffee.cypher.kettle.config.value.ValueProvider
import net.minecraftforge.common.ForgeConfigSpec
import java.util.*

class Config internal constructor(
        private val rootSection: Section,
        override val spec: ForgeConfigSpec
) : ConfigProvider {
    private var token = UUID.randomUUID()

    override fun <T : Any> value(vararg path: String): ValueProvider<T> {
        val combinedPath = path.joinToString(separator = ".")
        val valueFound = rootSection.value<T>(combinedPath)

        return valueFound?.let { CachingValueProvider(it) }
                ?: throw NoSuchElementException("No config value with name '$combinedPath' was found")
    }


    override fun refresh() {
        token = UUID.randomUUID()
    }

    private inner class CachingValueProvider<T : Any>(private val provider: ValueProvider<T>) : ValueProvider<T> {
        private var lastRefreshToken: UUID? = null

        private lateinit var cache: T

        override val path = provider.path

        override fun get(): T {
            if (token != lastRefreshToken) {
                refresh()
            }

            return cache
        }

        private fun refresh() {
            cache = provider.get()
        }
    }
}