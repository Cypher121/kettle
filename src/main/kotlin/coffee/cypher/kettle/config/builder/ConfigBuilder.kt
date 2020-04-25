package coffee.cypher.kettle.config.builder

import coffee.cypher.kettle.config.Config
import coffee.cypher.kettle.config.builder.type.ConfigElementBuilder
import net.minecraft.util.Direction
import net.minecraftforge.common.ForgeConfigSpec

fun config(block: SectionBuilder.() -> Unit) = ConfigBuilder().apply { rootSectionBuilder.block() }.build()

class ConfigBuilder internal constructor() : ConfigElementBuilder<Config> {
    internal val rootSectionBuilder = SectionBuilder("")

    override fun build(builder: ForgeConfigSpec.Builder): Config {
        val (rootSection, spec) = builder.configure(rootSectionBuilder)
        return Config(rootSection, spec)
    }

    fun build() = build(ForgeConfigSpec.Builder())
}
