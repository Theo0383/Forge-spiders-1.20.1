package net.tangenia.spidermod.item.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties FUNNEL_WEB_LEG = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.25f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 100), 0.1f).build();

    public static final FoodProperties WANDERING_SPIDER_LEG = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.25f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100), 0.1f).build();
}
