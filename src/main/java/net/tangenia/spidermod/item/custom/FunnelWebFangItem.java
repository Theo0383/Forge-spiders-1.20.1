package net.tangenia.spidermod.item.custom;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.tangenia.spidermod.effect.ModEffects;

public class FunnelWebFangItem extends Item {
    public FunnelWebFangItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        pPlayer.getCooldowns().addCooldown(this, 10);
        if(!pLevel.isClientSide) {
            pPlayer.addEffect(new MobEffectInstance(ModEffects.FUNNEL_WEB_EFFECT.get(), 80, 1));
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if(!pPlayer.getAbilities().instabuild) {
            itemStack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemStack, pLevel.isClientSide());
    }
}
