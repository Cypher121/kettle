package coffee.cypher.kettle.config.value

import net.minecraftforge.common.ForgeConfigSpec

internal class ConfigValueProvider<T : Any>(private val configValue: ForgeConfigSpec.ConfigValue<T>) : ValueProvider<T> {
   override fun get(): T = configValue.get()

    override val path: List<String> = configValue.path
}