package coffee.cypher.kettle.inventory

import net.minecraft.inventory.Inventory
import net.minecraft.inventory.SidedInventory
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.math.Direction

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
public operator fun Inventory.set(slot: Int, stack: ItemStack?): Unit = setStack(slot, stack)
public operator fun Inventory.contains(item: Item): Boolean = count(item) > 0

public fun Inventory.getSideAccess(side: Direction): Inventory =
    if (this is SidedInventory) {
        SideAccessInventory(this, side)
    } else {
        this
    }

private class SideAccessInventory(
    private val base: SidedInventory,
    private val side: Direction
) : Inventory by base {
    private fun getActualSlots() =
        base.getAvailableSlots(side).toList()

    override fun clear() {
        getActualSlots().forEach {
            base[it] = ItemStack.EMPTY
        }
    }

    override fun size(): Int =
        getActualSlots().size

    override fun isEmpty(): Boolean =
        getActualSlots().all {
            base[it].isEmpty
        }

    override fun getStack(slot: Int) =
        base[getActualSlots()[slot]]

    override fun removeStack(slot: Int, amount: Int): ItemStack {
        return base.removeStack(getActualSlots()[slot], amount)
    }

    override fun removeStack(slot: Int): ItemStack =
        base.removeStack(getActualSlots()[slot])

    override fun setStack(slot: Int, stack: ItemStack?) {
        base[getActualSlots()[slot]] = stack
    }
}