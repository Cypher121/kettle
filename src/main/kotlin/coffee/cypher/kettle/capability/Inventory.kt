package coffee.cypher.kettle.capability

import net.minecraft.item.ItemStack
import net.minecraftforge.items.IItemHandler
import net.minecraftforge.items.ItemStackHandler

val IItemHandler.slotRange: IntRange
    get() = 0 until slots

operator fun IItemHandler.iterator() = object : Iterator<ItemStack> {
    var currentIndex = 0

    override fun hasNext() = currentIndex < slots

    override fun next() = getStackInSlot(currentIndex++)
}

fun IItemHandler.asSequence() = Sequence(::iterator)
fun IItemHandler.asIterable() = Iterable(this::iterator)
fun IItemHandler.asList() = iterator().asSequence().toList()


operator fun IItemHandler.get(slot: Int): ItemStack = getStackInSlot(slot)
operator fun ItemStackHandler.set(slot: Int, stack: ItemStack) = setStackInSlot(slot, stack)
operator fun IItemHandler.contains(stack: ItemStack) = stack in asSequence()
fun IItemHandler.isEmpty() = asSequence().all(ItemStack::isEmpty)
