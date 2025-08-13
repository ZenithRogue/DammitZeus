package dev.zenithknight.mcmods.dammitzeus.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.entity.passive.VillagerEntity;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static dev.zenithknight.mcmods.dammitzeus.DammitZeus.LIGHTNING_CONVERTS_VILLAGERS;

@Mixin(VillagerEntity.class)
public abstract class VillagerEntityMixin extends Entity {
    public VillagerEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "onStruckByLightning", at = @At("HEAD"), cancellable = true)
    public void onStruckByLightningMixin(ServerWorld world, LightningEntity lightning, CallbackInfo ci) {
        if (!world.getGameRules().getBoolean(LIGHTNING_CONVERTS_VILLAGERS)) {
            super.onStruckByLightning(world, lightning);
            ci.cancel();
        }
    }
}