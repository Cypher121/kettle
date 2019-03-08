package coffee.cypher.kettle.config.builder.type

import net.minecraftforge.common.ForgeConfigSpec
import java.util.function.Function

interface ConfigElementBuilder<T> : Function<ForgeConfigSpec.Builder, T> {
    override fun apply(t: ForgeConfigSpec.Builder) = build(t)

    fun build(builder: ForgeConfigSpec.Builder): T
}

