package itamio.mossfix.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.MossBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Port of gamma-02's MossBlockMixin: moss blocks are bonemealable
 * when the block above is not a redstone conductor, instead of
 * requiring air above.
 */
@Mixin(MossBlock.class)
public class MossBlockMixin {
    @Inject(method = "isValidBonemealTarget", at = @At("HEAD"), cancellable = true)
    private void mossfix$shouldBonemeal(LevelReader level, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        BlockState above = level.getBlockState(pos.above());
        cir.setReturnValue(!above.isRedstoneConductor(level, pos.above()));
    }
}
