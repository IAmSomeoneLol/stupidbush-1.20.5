package nel.stupidbush.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SweetBerryBushBlock.class)
public class BushNoPlayerEffectMixin {

	@Inject(method = "onEntityCollision", at = @At("HEAD"), cancellable = true)
	private void skipPlayerEffects(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo ci) {
		if (entity instanceof PlayerEntity) {
			// Cancel vanilla slowdown + damage for players
			ci.cancel();
		}
	}
}
