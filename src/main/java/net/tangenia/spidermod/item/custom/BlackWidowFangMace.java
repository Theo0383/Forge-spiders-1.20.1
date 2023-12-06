package net.tangenia.spidermod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.tangenia.spidermod.effect.ModEffects;

public class BlackWidowFangMace extends SwordItem {

    public BlackWidowFangMace(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity instanceof LivingEntity livingEntity) {
            if(stack.getDamageValue() >= 50) {
                livingEntity.addEffect(new MobEffectInstance(ModEffects.BLACK_WIDOW_EFFECT.get(), 300, 2), player);
            }
            else {
                livingEntity.addEffect(new MobEffectInstance(ModEffects.BLACK_WIDOW_EFFECT.get(), 160), player);
            }
        }

        return super.onLeftClickEntity(stack, player, entity);
    }
}
