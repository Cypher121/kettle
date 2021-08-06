package coffee.cypher.kettle.item

import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound

public fun ItemConvertible.createStack(size: Int = 1, nbt: NbtCompound? = null): ItemStack =
    ItemStack(this, size).apply {
        if (nbt != null) {
            this.nbt = nbt
        }
    }

public fun ItemStack?.equals(
    that: ItemStack?,
    ignoreDurability: Boolean = false,
    ignoreSize: Boolean = false,
    ignoreNBT: Boolean = false
): Boolean {
    if (this == null || that == null) {
        return this === that
    }

    with(that) {}

    if (this.item != that.item) {
        return false
    }

    if (!ignoreDurability && this.item.isDamageable && (this.damage != that.damage)) {
        return false
    }

    if (!ignoreSize && (this.count != that.count)) {
        return false
    }

    if (!ignoreNBT && this.nbt != that.nbt) {
        return false
    }

    return true
}