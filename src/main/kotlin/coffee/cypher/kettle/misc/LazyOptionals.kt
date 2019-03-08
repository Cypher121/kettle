package coffee.cypher.kettle.misc

import net.minecraftforge.common.util.LazyOptional
import kotlin.reflect.KProperty

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
fun <T> LazyOptional<T>.orNull(): T? = this.orElse(null)

operator fun <T> LazyOptional<T>.getValue(thisRef: Any?, prop: KProperty<*>) = this.orNull()