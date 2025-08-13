package dev.zenithknight.mcmods.dammitzeus.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.mob.ElderGuardianEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import static dev.zenithknight.mcmods.dammitzeus.DammitZeus.LIGHTNING_GROWS_SLIMES;
import static dev.zenithknight.mcmods.dammitzeus.DammitZeus.LIGHTNING_SLIME_SIZE;

@Mixin(SlimeEntity.class)
public abstract class SlimeEntityMixin extends MobEntity {
    @Shadow public abstract void setSize(int size, boolean heal);

    protected SlimeEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void onStruckByLightning(ServerWorld world, LightningEntity lightning) {
        if (world.getGameRules().getBoolean(LIGHTNING_GROWS_SLIMES)) {
            this.setSize(world.getGameRules().getInt(LIGHTNING_SLIME_SIZE), false);
        }
        super.onStruckByLightning(world, lightning);
    }
}
