package coffee.cypher.kettle.tickers

import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

/**
 * Wraps a function taking the arguments for [BlockEntityTicker.tick]
 * into a [BlockEntityTicker].
 */
public fun <T : BlockEntity> ((World, BlockPos, BlockState, T) -> Unit).asSimpleTicker(): BlockEntityTicker<T> =
    BlockEntityTicker { world, blockPos, blockState, be ->
        this(world, blockPos, blockState, be)
    }

/**
 * Casts a [BlockEntityTicker] to the specified [BlockEntity] type [E].
 *
 * Mainly used when returning from [BlockWithEntity.getTicker] to return
 * the correct generic type, when it's expected to match this ticker's.
 */
@Suppress("UNCHECKED_CAST")
public fun <T : BlockEntity, E : BlockEntity> BlockEntityTicker<T>.cast(): BlockEntityTicker<E> =
    BlockEntityTicker { world, blockPos, blockState, be ->
        tick(world, blockPos, blockState, be as T)
    }
