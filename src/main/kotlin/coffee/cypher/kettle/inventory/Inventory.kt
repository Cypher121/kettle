package coffee.cypher.kettle.inventory

import net.minecraft.inventory.Inventory
import net.minecraft.inventory.SidedInventory
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.math.Direction

/**
 * Returns a range of all slot indices of this [Inventory].
 */
public val Inventory.slotRange: IntRange
    get() = 0 until size()

/**
 * Returns the [Iterator] for this [Inventory]'s slots.
 */
public operator fun Inventory.iterator(): Iterator<ItemStack> =
    object : Iterator<ItemStack> {
        var currentIndex = 0

        override fun hasNext() = currentIndex < size()

        override fun next() = getStack(currentIndex++)
    }

/**
 * Returns this [Inventory]'s slots as a
 * [Sequence] of [ItemStack]s contained within.
 */
public fun Inventory.asSequence(): Sequence<ItemStack> = Sequence(::iterator)

/**
 * Returns this [Inventory]'s slots as an
 * [Iterable] of [ItemStack]s contained within.
 */
public fun Inventory.asIterable(): Iterable<ItemStack> = Iterable(this::iterator)

/**
 * Returns the [ItemStack] contents
 * of this [Inventory]'s slots collected into a [List].
 */
public fun Inventory.toList(): List<ItemStack> = iterator().asSequence().toList()

/**
 * Returns the [ItemStack] contained in the
 * given [slot] of this [Inventory].
 *
 * @see Inventory.getStack
 */
public operator fun Inventory.get(slot: Int): ItemStack = getStack(slot)

/**
 * Sets the [ItemStack] contained in the given [slot]
 * of this [Inventory] to the provided [stack].
 *
 * @see Inventory.setStack
 */
public operator fun Inventory.set(slot: Int, stack: ItemStack): Unit =
    setStack(slot, stack)

/**
 * Returns `true` if any slots of this
 * [Inventory] contain an [ItemStack] of the
 * given [item], or `false` otherwise.
 */
public operator fun Inventory.contains(item: Item): Boolean = count(item) > 0

/**
 * Creates a proxy [Inventory] that only
 * represents slots of this Inventory available
 * from the specified [side].
 *
 * Any changes to the proxy's contents will
 * be applied to the base inventory's corresponding slots,
 * and vice versa.
 *
 * The size and slots of the proxy can change, if
 * the base inventory changes which slots are accessible
 * from the specified [side].
 */
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

    override fun setStack(slot: Int, stack: ItemStack) {
        base[getActualSlots()[slot]] = stack
    }
}
