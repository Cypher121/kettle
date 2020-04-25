package coffee.cypher.kettle.config

import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.fml.ModContainer
import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.config.ModConfig
import net.minecraftforge.fml.javafmlmod.FMLModContainer
import org.apache.logging.log4j.LogManager

fun ConfigProvider.registerAndManage(type: ModConfig.Type, eventBus: IEventBus? = null) {
    register(type)
    manage(eventBus)
}

fun ConfigProvider.register(type: ModConfig.Type) {
    ModLoadingContext.get().registerConfig(type, this.spec)
}

fun ConfigProvider.manage(eventBus: IEventBus? = null) {
    val container = ModLoadingContext.get().activeContainer

    val bus = eventBus?: container.findBus() ?: throw IllegalStateException(
        "Could not find event bus in '${container.javaClass.simpleName}' for mod '${container.modId}', and no bus was provided manually. " +
                "Please provide a bus as an argument or manage the config manually."
    )

    ConfigManager.ensureSubscribedToBus(bus)
    ConfigManager.addManagedConfig(this)
}

private fun ModContainer.findBus(): IEventBus? {
    if (this is FMLModContainer) {
        return eventBus
    }

    val busGetter = javaClass.methods.find {
        (it.name == "getEventBus" || it.name == "getModEventBus") && it.parameterCount == 0 &&
                IEventBus::class.java.isAssignableFrom(it.returnType)
    }

    return busGetter?.invoke(this) as IEventBus?
}

private val LOGGER = LogManager.getLogger("Kettle Config Manager")

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