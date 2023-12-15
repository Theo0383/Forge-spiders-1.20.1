package net.tangenia.spidermod.item.custom;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.tangenia.spidermod.effect.ModEffects;

public class WanderingSpiderSaber extends SwordItem {
    public WanderingSpiderSaber(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity instanceof LivingEntity livingEntity) {
            if(stack.getDamageValue() >= 100) {
                livingEntity.addEffect(new MobEffectInstance(ModEffects.WANDERING_SPIDER_EFFECT.get(), 500, 1), player);
            }
            else {
                livingEntity.addEffect(new MobEffectInstance(ModEffects.WANDERING_SPIDER_EFFECT.get(), 120), player);
            }
        }

        return super.onLeftClickEntity(stack, player, entity);
    }
}
