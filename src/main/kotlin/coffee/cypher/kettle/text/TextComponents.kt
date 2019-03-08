package coffee.cypher.kettle.text

import net.minecraft.util.text.TextComponentString
import net.minecraft.util.text.TextComponentTranslation

fun String.toTextComponent() = TextComponentString(this)
fun String.toTranslatedComponent(vararg formatArgs: Any) = TextComponentTranslation(this, *formatArgs)