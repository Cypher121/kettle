package coffee.cypher.kettle.text

import net.minecraft.util.text.StringTextComponent
import net.minecraft.util.text.TranslationTextComponent

fun String.toTextComponent() = StringTextComponent(this)
fun String.toTranslatedComponent(vararg formatArgs: Any) = TranslationTextComponent(this, *formatArgs)