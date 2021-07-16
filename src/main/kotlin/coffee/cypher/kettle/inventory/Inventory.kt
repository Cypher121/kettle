package coffee.cypher.kettle.inventory

import net.minecraft.inventory.Inventory
import net.minecraft.item.Item
import net.minecraft.item.ItemStack

public val Inventory.slotRange: IntRange
    get() = 0 until size()

public operator fun Inventory.iterator(): Iterator<ItemStack> =
    object : Iterator<ItemStack> {
        var currentIndex = 0

        override fun hasNext() = currentIndex < size()

        override fun next() = getStack(currentIndex++)
    }

public fun Inventory.asSequence(): Sequence<ItemStack> = Sequence(::iterator)
public fun Inventory.asIterable(): Iterable<ItemStack> = Iterable(this::iterator)
public fun Inventory.asList(): List<ItemStack> = iterator().asSequence().toList()


public operator fun Inventory.get(slot: Int): ItemStack = getStack(slot)
public operator fun Inventory.set(slot: Int, stack: ItemStack): Unit = setStack(slot, stack)
public operator fun Inventory.contains(item: Item): Boolean = count(item) > 0
