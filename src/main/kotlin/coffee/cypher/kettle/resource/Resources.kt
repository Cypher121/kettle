package coffee.cypher.kettle.resource

import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.MinecraftClient
import net.minecraft.resource.Resource
import net.minecraft.util.Identifier

@Environment(EnvType.CLIENT)
public fun Identifier.getClientResources(): List<Resource> = MinecraftClient.getInstance().resourceManager.getAllResources(this)
