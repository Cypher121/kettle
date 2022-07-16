package coffee.cypher.kettle.item

import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound

/**
 * Creates an [ItemStack] from this [ItemConvertible]
 * with the specified [size] (1 by default) and,
 * if provided, the specified [nbt] tag.
 */
public fun ItemConvertible.createStack(size: Int = 1, nbt: NbtCompound? = null): ItemStack =
    ItemStack(this, size).apply {
        if (nbt != null) {
            this.nbt = nbt
        }
    }

/**
 * Compares this [ItemStack] to a given target.
 *
 * Strictly compares durability (or whether stacks are damageable),
 * stack size and NBT tags, unless [ignoreDurability], [ignoreSize],
 * or [ignoreNBT] are set to true.
 */
public fun ItemStack?.equals(
    that: ItemStack?,
    ignoreDurability: Boolean = false,
    ignoreSize: Boolean = false,
    ignoreNBT: Boolean = false
): Boolean {
    if (this == null || that == null) {
        return this === that
    }

    if (that.isOf(this.item)) {
        return false
    }

    if (!ignoreDurability && this.isDamageable && (this.damage != that.damage)) {
        return false
    }

    if (!ignoreDurability) {
        if (this.isDamageable != that.isDamageable) {
            return false
        }

        if (this.isDamageable && (this.damage != that.damage)) {
            return false
        }
    }

    if (!ignoreSize && (this.count != that.count)) {
        return false
    }

    if (!ignoreNBT && this.nbt != that.nbt) {
        return false
    }

    return true
}
