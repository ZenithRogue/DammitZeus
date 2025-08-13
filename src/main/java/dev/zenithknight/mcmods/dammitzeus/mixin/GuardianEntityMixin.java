package dev.zenithknight.mcmods.dammitzeus.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.mob.ElderGuardianEntity;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

import static dev.zenithknight.mcmods.dammitzeus.DammitZeus.LIGHTNING_CONVERTS_GUARDIANS;

@Mixin(GuardianEntity.class)
public abstract class GuardianEntityMixin extends HostileEntity {
    protected GuardianEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void onStruckByLightning(ServerWorld world, LightningEntity lightning) {
        if (world.getGameRules().getBoolean(LIGHTNING_CONVERTS_GUARDIANS)) {
            ElderGuardianEntity elderGuardianEntity = (ElderGuardianEntity)EntityType.ELDER_GUARDIAN.create(world);
            if (elderGuardianEntity != null) {
                elderGuardianEntity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), this.getPitch());
                elderGuardianEntity.setAiDisabled(this.isAiDisabled());
                if (this.hasCustomName()) {
                    elderGuardianEntity.setCustomName(this.getCustomName());
                    elderGuardianEntity.setCustomNameVisible(this.isCustomNameVisible());
                }
                elderGuardianEntity.setPersistent();
                world.spawnEntity(elderGuardianEntity);
                this.discard();
            } else {
                super.onStruckByLightning(world, lightning);
            }
        } else {
            super.onStruckByLightning(world, lightning);
        }
    }
}