package coffee.cypher.kettle.misc

import net.minecraft.util.NonNullList

fun <T> List<T>.toNonNullList() = NonNullList.create<T>().addAll(this)
