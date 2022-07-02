package coffee.cypher.kettle.mixins;

import coffee.cypher.kettle.tickers.mixinaccessors.BlockEntitySchedulerAccessor;
import coffee.cypher.kettle.scheduler.TickingScheduler;
import coffee.cypher.kettle.tickers.task.TaskTicker;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.WeakHashMap;

@Mixin(BlockEntity.class)
abstract class BlockEntitySchedulerMixin implements BlockEntitySchedulerAccessor {
    private WeakHashMap<TaskTicker<?>, TickingScheduler<?>> kettle$TaskTickerSchedulerMap;

    @Inject(
        method = "<init>",
        at = @At("RETURN")
    )
    public void kettle$constructorInitMap(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, CallbackInfo ci) {
        this.kettle$TaskTickerSchedulerMap = new WeakHashMap<>();
    }

    @Override
    public @NotNull WeakHashMap<TaskTicker<?>, TickingScheduler<?>> kettle$getTaskTickerSchedulerMap() {
        return kettle$TaskTickerSchedulerMap;
    }
}
