package dev.zenithknight.mcmods.dammitzeus.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.server.world.ServerWorld;
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
        World var3 = this.getWorld();
        if (var3 instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) var3;
            if (!serverWorld.getGameRules().getBoolean(LIGHTNING_CREATES_FIRE)) {
                ci.cancel();
            }
        }
    }
    @Inject(method = "cleanOxidation", at = @At("HEAD"), cancellable = true)
    private static void cleanOxidationMixin(World world, BlockPos pos, CallbackInfo ci) {
        World var3 = world;
        if (var3 instanceof ServerWorld) {
            if (!((ServerWorld) var3).getGameRules().getBoolean(LIGHTNING_CLEARS_OXIDATION)) {
                ci.cancel();
            }
        }
    }
}
