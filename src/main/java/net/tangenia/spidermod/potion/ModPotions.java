package net.tangenia.spidermod.potion;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tangenia.spidermod.SpiderMod;
import net.tangenia.spidermod.effect.ModEffects;

import java.awt.*;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, SpiderMod.MODID);

    public static final RegistryObject<Potion> FUNNEL_WEB_AFFINITY_POTION =
            POTIONS.register("funnel_web_affinity_potion",
                    () -> new Potion(new MobEffectInstance(ModEffects.FUNNEL_WEB_AFFINITY_EFFECT.get(), 2400, 0)));

    public static final RegistryObject<Potion> BLACK_WIDOW_AFFINITY_POTION =
            POTIONS.register("black_widow_affinity_potion",
                    () -> new Potion(new MobEffectInstance(ModEffects.BLACK_WIDOW_AFFINITY_EFFECT.get(), 2400, 0)));

    public static final RegistryObject<Potion> BLACK_WIDOW_VENOM_POTION =
            POTIONS.register("black_widow_venom_potion",
                    () -> new Potion(new MobEffectInstance(ModEffects.BLACK_WIDOW_EFFECT.get(), 2400, 0)));

    public static final RegistryObject<Potion> WANDERING_SPIDER_AFFINITY_POTION =
            POTIONS.register("wandering_spider_affinity_potion",
                    () -> new Potion(new MobEffectInstance(ModEffects.WANDERING_SPIDER_AFFINITY_EFFECT.get(), 2400, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
