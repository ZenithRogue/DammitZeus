package dev.zenithknight.mcmods.dammitzeus;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.GameRules;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;

public class DammitZeus implements ModInitializer {
    public static final GameRules.Key<GameRules.BooleanRule> LIGHTNING_CONVERTS_VILLAGERS = GameRuleRegistry.register("lightningConvertsVillagers", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
    public static final GameRules.Key<GameRules.BooleanRule> LIGHTNING_CONVERTS_PIGS = GameRuleRegistry.register("lightningConvertsPigs", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
    public static final GameRules.Key<GameRules.BooleanRule> LIGHTNING_CONVERTS_MOOSHROOMS = GameRuleRegistry.register("lightningConvertsMooshrooms", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
    public static final GameRules.Key<GameRules.BooleanRule> LIGHTNING_CONVERTS_GUARDIANS = GameRuleRegistry.register("lightningConvertsGuardians", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(false));
    public static final GameRules.Key<GameRules.BooleanRule> LIGHTNING_CHARGES_CREEPERS = GameRuleRegistry.register("lightningChargesCreepers", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
    public static final GameRules.Key<GameRules.BooleanRule> LIGHTNING_DAMAGE = GameRuleRegistry.register("lightningDamage", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
    public static final GameRules.Key<GameRules.BooleanRule> LIGHTNING_CREATES_FIRE = GameRuleRegistry.register("lightningFire", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
    public static final GameRules.Key<GameRules.BooleanRule> LIGHTNING_GROWS_SLIMES = GameRuleRegistry.register("lightningGrowsSlimes", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(false));
    public static final GameRules.Key<GameRules.IntRule> LIGHTNING_SLIME_SIZE = GameRuleRegistry.register("lightningSlimeSize", GameRules.Category.MOBS, GameRuleFactory.createIntRule(12));
    @Override
    public void onInitialize() {

    }
}
