package coffee.cypher.kettle.text

import net.minecraft.text.component.LiteralComponent
import net.minecraft.text.component.TranslatableComponent

public fun String.toLiteralComponent(): LiteralComponent = LiteralComponent(this)
public fun String.toTranslatableComponent(vararg formatArgs: Any): TranslatableComponent =
    TranslatableComponent(this, *formatArgs)
