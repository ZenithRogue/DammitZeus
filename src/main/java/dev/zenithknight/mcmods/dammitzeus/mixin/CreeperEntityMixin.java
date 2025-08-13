package dev.zenithknight.mcmods.dammitzeus.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static dev.zenithknight.mcmods.dammitzeus.DammitZeus.LIGHTNING_CHARGES_CREEPERS;

@Mixin(CreeperEntity.class)
public abstract class CreeperEntityMixin extends Entity {
    public CreeperEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "onStruckByLightning", at = @At("HEAD"), cancellable = true)
    public void onStruckByLightningMixin(ServerWorld world, LightningEntity lightning, CallbackInfo ci) {
        if (!world.getGameRules().getBoolean(LIGHTNING_CHARGES_CREEPERS)) {
            super.onStruckByLightning(world, lightning);
            ci.cancel();
        }
    }
}