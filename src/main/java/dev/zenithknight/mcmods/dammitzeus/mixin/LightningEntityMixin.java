package dev.zenithknight.mcmods.dammitzeus.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static dev.zenithknight.mcmods.dammitzeus.DammitZeus.LIGHTNING_CREATES_FIRE;
import static dev.zenithknight.mcmods.dammitzeus.DammitZeus.LIGHTNING_CLEARS_OXIDATION;


@Mixin(LightningEntity.class)
public abstract class LightningEntityMixin extends Entity {
    public LightningEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "spawnFire", at = @At("HEAD"), cancellable = true)
    public void spawnFireMixin(int spreadAttempts, CallbackInfo ci) {
        if (!this.getWorld().getGameRules().getBoolean(LIGHTNING_CREATES_FIRE)) {
            ci.cancel();
        }
    }
    @Inject(method = "cleanOxidation", at = @At("HEAD"), cancellable = true)
    private static void cleanOxidationMixin(World world, BlockPos pos, CallbackInfo ci) {
        if (!world.getGameRules().getBoolean(LIGHTNING_CLEARS_OXIDATION)) {
            ci.cancel();
        }
    }
}
