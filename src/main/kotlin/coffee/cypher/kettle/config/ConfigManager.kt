package coffee.cypher.kettle.config

import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.config.ModConfig
import net.minecraftforge.fml.javafmlmod.FMLModContainer
import org.apache.logging.log4j.LogManager

fun ConfigProvider.registerAndManage(type: ModConfig.Type, eventBus: IEventBus? = null) {
    val container = ModLoadingContext.get().activeContainer

    val bus = eventBus ?: when (container) {
        is FMLModContainer -> container.eventBus
        else -> null.also {
            LOGGER.warn("Unrecognized container type '${container.javaClass.simpleName}' for mod '${container.modId}', and no bus was provided manually. Config reload events will not be managed for that mod!")
        }
    }

    if (bus != null) {
        ConfigManager.ensureSubscribedToBus(bus)
    }

    register(type)

    ConfigManager.addManagedConfig(this)
}

fun ConfigProvider.register(type: ModConfig.Type) {
    ModLoadingContext.get().registerConfig(type, this.spec)
}

private val LOGGER = LogManager.getLogger("testmod Config Manager")

private object ConfigManager {
    private val registeredBuses = mutableSetOf<IEventBus>()
    private val registeredConfigs = mutableSetOf<ConfigProvider>()

    fun ensureSubscribedToBus(bus: IEventBus) {
        if (bus !in registeredBuses) {
            registeredBuses += bus
            bus.addListener(this::onConfigEvent)
        }
    }

    fun addManagedConfig(configProvider: ConfigProvider) {
        registeredConfigs += configProvider
    }

    fun onConfigEvent(event: ModConfig.ModConfigEvent) {
        registeredConfigs.filter {
            it.spec == event.config.spec
        }.forEach(ConfigProvider::refresh)
    }
}