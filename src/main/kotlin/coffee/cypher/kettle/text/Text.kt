package coffee.cypher.kettle.text

import net.minecraft.text.LiteralText
import net.minecraft.text.TranslatableText

public fun String.toLiteralText(): LiteralText = LiteralText(this)
public fun String.toTranslatableText(vararg formatArgs: Any): TranslatableText = TranslatableText(this, *formatArgs)