package coffee.cypher.kettle.config.value

import net.minecraftforge.common.util.NonNullSupplier
import java.util.function.Supplier
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

interface ValueProvider<T : Any> : ReadOnlyProperty<Any?, T>, () -> T, Supplier<T>, NonNullSupplier<T> {
    override fun getValue(thisRef: Any?, property: KProperty<*>) = get()
    override fun invoke() = get()

    val path: List<String>
}

