package coffee.cypher.kettle.config

import coffee.cypher.kettle.config.value.ValueProvider
import net.minecraftforge.common.ForgeConfigSpec

interface ConfigProvider {
    val spec: ForgeConfigSpec

    fun <T : Any> value(vararg path: String): ValueProvider<T>

    fun refresh()
}