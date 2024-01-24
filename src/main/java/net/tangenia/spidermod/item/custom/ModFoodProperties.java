package net.tangenia.spidermod.item.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.tangenia.spidermod.effect.ModEffects;

public class ModFoodProperties {
    public static final FoodProperties FUNNEL_WEB_LEG = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.25f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 100), 0.1f).build();

    public static final FoodProperties WANDERING_SPIDER_LEG = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.25f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100), 0.1f).build();

    public static final FoodProperties WOLF_SPIDER_MEAT = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.5f).effect(() -> new MobEffectInstance(MobEffects.POISON, 100), 0.5f).build();

    public static final FoodProperties WOLF_SPIDER_TREAT = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.5f).effect(() -> new MobEffectInstance(ModEffects.WOLF_SPIDER_EFFECT.get(), 60), 0.2f).build();
}
