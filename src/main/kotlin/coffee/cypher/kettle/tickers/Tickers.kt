package coffee.cypher.kettle.tickers

import coffee.cypher.kettle.tickers.task.TaskBlockEntityTicker
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

public fun <T : BlockEntity> ((World, BlockPos, BlockState, T) -> Unit).asSimpleTicker(): BlockEntityTicker<T> =
    BlockEntityTicker { world, blockPos, blockState, be ->
        this(world, blockPos, blockState, be)
    }

@Suppress("UNCHECKED_CAST")
public fun <T : BlockEntity, E : BlockEntity> BlockEntityTicker<T>.cast(): BlockEntityTicker<E> =
    BlockEntityTicker { world, blockPos, blockState, be ->
        tick(world, blockPos, blockState, be as T)
    }