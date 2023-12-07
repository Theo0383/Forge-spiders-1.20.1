package net.tangenia.spidermod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tangenia.spidermod.SpiderMod;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SpiderMod.MODID);

    public static final RegistryObject<MobEffect> FUNNEL_WEB_EFFECT = MOB_EFFECTS.register("funnel_web_venom",
            () -> new FunnelWebVenomEffect(MobEffectCategory.HARMFUL, 0x1c1815));

    public static final RegistryObject<MobEffect> FUNNEL_WEB_AFFINITY_EFFECT = MOB_EFFECTS.register("funnel_web_affinity",
            () -> new FunnelWebAffinityEffect(MobEffectCategory.BENEFICIAL, 0x2e1500));

    public static final RegistryObject<MobEffect> BLACK_WIDOW_EFFECT = MOB_EFFECTS.register("black_widow_venom",
            () -> new BlackWidowVenomEffect(MobEffectCategory.HARMFUL, 0x474100));

    public static final RegistryObject<MobEffect> BLACK_WIDOW_AFFINITY_EFFECT = MOB_EFFECTS.register("black_widow_affinity",
            () -> new BlackWidowAffinityEffect(MobEffectCategory.BENEFICIAL, 0x475e00));

    public static final RegistryObject<MobEffect> WANDERING_SPIDER_EFFECT = MOB_EFFECTS.register("wandering_spider_venom",
            () -> new WanderingSpiderVenomEffect(MobEffectCategory.HARMFUL, 0x6e0000));

    public static void register(IEventBus eventBus)
    {
        MOB_EFFECTS.register(eventBus);
    }
}
