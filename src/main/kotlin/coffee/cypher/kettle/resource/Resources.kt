package coffee.cypher.kettle.resource

import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.MinecraftClient
import net.minecraft.resource.Resource
import net.minecraft.util.Identifier

/**
 * Retrieves all client [Resource]s associated
 * with this [Identifier].
 *
 * This extension is only available on the physical client.
 */
@Environment(EnvType.CLIENT)
public fun Identifier.getClientResources(): List<Resource> =
    MinecraftClient.getInstance().resourceManager.getAllResources(this)
