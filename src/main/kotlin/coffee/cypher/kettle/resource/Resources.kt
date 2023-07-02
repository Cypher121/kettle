package coffee.cypher.kettle.resource

import net.minecraft.client.MinecraftClient
import net.minecraft.resource.Resource
import net.minecraft.util.Identifier
import org.quiltmc.loader.api.minecraft.ClientOnly

/**
 * Retrieves all client [Resource]s associated
 * with this [Identifier].
 *
 * This extension is only available on the physical client.
 */
@ClientOnly
public fun Identifier.getClientResources(): List<Resource> =
    MinecraftClient.getInstance().resourceManager.getAllResources(this)
