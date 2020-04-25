package coffee.cypher.kettle.item

import net.minecraft.item.ItemStack
import net.minecraft.nbt.CompoundNBT
import net.minecraft.util.IItemProvider

fun IItemProvider.createStack(size: Int = 1, tag: CompoundNBT? = null) = ItemStack(this, size, tag)

fun ItemStack?.equals(
    that: ItemStack?,
    ignoreDurability: Boolean = false,
    ignoreSize: Boolean = false,
    ignoreNBT: Boolean = false
): Boolean {
    if (this == null || that == null) {
        return this === that
    }

    if (this.item != that.item) {
        return false
    }

    if (!ignoreDurability && this.item.isDamageable && (this.damage != that.damage)) {
        return false
    }

    if (!ignoreSize && (this.count != that.count)) {
        return false
    }

    if (!ignoreNBT && !(this.tag == that.tag && this.areCapsCompatible(that))) {
        return false
    }

    return true
}