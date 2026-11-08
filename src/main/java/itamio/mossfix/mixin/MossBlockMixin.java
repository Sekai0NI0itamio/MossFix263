package itamio.mossfix.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableFeaturePlacerBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/**
 * Port of gamma-02's MossBlockMixin: moss blocks are bonemealable
 * when the block above is not a redstone conductor, instead of
 * requiring air above. In 26.3 the target class is
 * BonemealableFeaturePlacerBlock (was MossBlock before 1.21.2).
 */
@Mixin(BonemealableFeaturePlacerBlock.class)
public class MossBlockMixin {
    @WrapOperation(method = "isValidBonemealTarget",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;isAir()Z"))
    public boolean mossfix263$shouldBonemeal(BlockState instance,
            Operation<Boolean> original,
            LevelReader levelReader,
            BlockPos blockPos) {
        return !instance.isRedstoneConductor(levelReader, blockPos.above());
    }
}
