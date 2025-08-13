package dev.zenithknight.mcmods.dammitzeus.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static dev.zenithknight.mcmods.dammitzeus.DammitZeus.LIGHTNING_DAMAGE;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method = "onStruckByLightning", at = @At("HEAD"), cancellable = true)
    public void onStruckByLightningMixin(ServerWorld world, LightningEntity lightning, CallbackInfo ci) {
        if (!world.getGameRules().getBoolean(LIGHTNING_DAMAGE)) {
            ci.cancel();
        }
    }
}