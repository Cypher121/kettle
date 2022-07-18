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
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Box
import net.minecraft.util.registry.Registry
import net.minecraft.world.World
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer

@Suppress("unused")
object SchedulerTestMod : ModInitializer {
    override fun onInitialize(mod: ModContainer) {
        Registry.register(Registry.BLOCK, Identifier("kettle_test", "test_block"), TestBlock)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Identifier("kettle_test", "test_be"), testBEType)
        Registry.register(
            Registry.ITEM, Identifier("kettle_test", "test_block"), BlockItem(TestBlock, Item.Settings())
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

                nextBlock@while (true) {
                    tntPositions += pos.up()
                    world.setBlockState(pos.up(), Blocks.TNT.defaultState)

                    sleepFor(20)

                    val positions = Box(pos).expand(10.0).getContainedBlockPos().toList().sortedBy {
                        pos.getSquaredDistance(it)
                    }

                    for (candidate in positions) {
                        yield()

                        if (world.isAir(candidate.up())) {
                            continue
                        }

                        val be = world.typedBlockEntity<TestBlockEntity>(candidate) ?: continue
                        val scheduler = be.findScheduler() ?: continue

                        rescheduleOn(scheduler)
                        continue@nextBlock
                    }

                    break
                }

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

@Suppress("unused")
object TestBlock : BlockWithEntity(
    Settings.of(Material.Builder(MapColor.BLACK).build())
) {
    override fun createBlockEntity(pos: BlockPos, state: BlockState) = TestBlockEntity(pos, state)

    override fun getRenderType(state: BlockState?) = BlockRenderType.MODEL

    override fun <T : BlockEntity> getTicker(
        world: World, state: BlockState, type: BlockEntityType<T>
    ): BlockEntityTicker<T> = testTicker.cast()
}
