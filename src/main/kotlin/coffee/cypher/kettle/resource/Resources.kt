package coffee.cypher.kettle.resource

import net.minecraft.client.Minecraft
import net.minecraft.resources.IResource
import net.minecraft.util.ResourceLocation
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn

@OnlyIn(Dist.CLIENT)
fun ResourceLocation.getClientResource(): IResource = Minecraft.getInstance().resourceManager.getResource(this)