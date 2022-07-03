package coffee.cypher.kettle.testmod

import coffee.cypher.kettle.math.getContainedBlockPos
import coffee.cypher.kettle.scheduler.action
import coffee.cypher.kettle.scheduler.infinitely
import coffee.cypher.kettle.scheduler.task
import coffee.cypher.kettle.tickers.cast
import coffee.cypher.kettle.tickers.task.taskTicker
import coffee.cypher.kettle.world.typedBlockEntity
import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.item.BlockItem
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Box
import net.minecraft.util.registry.Registry
import net.minecraft.world.World
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qkl.wrapper.qsl.blocks.blockSettingsOf
import org.quiltmc.qkl.wrapper.qsl.blocks.materialOf
import org.quiltmc.qkl.wrapper.qsl.items.itemSettingsOf
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer

object SchedulerTestMod : ModInitializer {
    override fun onInitialize(mod: ModContainer) {
        Registry.register(Registry.BLOCK, Identifier("kettle_test", "test_block"), TestBlock)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Identifier("kettle_test", "test_be"), testBEType)
        Registry.register(
            Registry.ITEM, Identifier("kettle_test", "test_block"), BlockItem(TestBlock, itemSettingsOf())
        )
    }
}

val testTicker = taskTicker {
    task {
        run infinitely {
            pause = 100
            yieldsAfterMs = 50.0
        }

        name = "Chain detonate!"
        start = true

        action {
            withContext {
                waitUntil {
                    world.getReceivedRedstonePower(pos) > 0 && world.isAir(pos.up())
                }

                val tntPositions = mutableListOf<BlockPos>()

                do {
                    tntPositions += pos.up()
                    world.setBlockState(pos.up(), Blocks.TNT.defaultState)

                    sleepFor(20)

                    val positions = Box(pos).expand(10.0).getContainedBlockPos().toList()
                    val next = positions.filter {
                        (world.isAir(it.up()) && world.typedBlockEntity<TestBlockEntity>(it)
                            ?.findScheduler() != null).also { yield() }
                    }.minByOrNull { pos.getSquaredDistance(it) }
                        ?.let { world.typedBlockEntity<TestBlockEntity>(it)?.findScheduler() }

                    next?.let { rescheduleOn(it) }
                } while (next != null)

                tntPositions.forEach {
                    if (world.getBlockState(it).block == Blocks.TNT) {
                        world.removeBlock(it, false)
                        TntBlock.primeTnt(world, it)
                    }
                }
            }
        }
    }
}

class TestBlockEntity(blockPos: BlockPos, blockState: BlockState) : BlockEntity(
    testBEType, blockPos, blockState
)

val testBEType: BlockEntityType<TestBlockEntity> by lazy {
    BlockEntityType(::TestBlockEntity, setOf(TestBlock), null)
}

object TestBlock : BlockWithEntity(
    blockSettingsOf(materialOf(MapColor.BLACK))
) {
    override fun createBlockEntity(pos: BlockPos, state: BlockState) = TestBlockEntity(pos, state)

    override fun getRenderType(state: BlockState?) = BlockRenderType.MODEL

    override fun <T : BlockEntity> getTicker(
        world: World, state: BlockState, type: BlockEntityType<T>
    ): BlockEntityTicker<T> = testTicker.cast()
}
