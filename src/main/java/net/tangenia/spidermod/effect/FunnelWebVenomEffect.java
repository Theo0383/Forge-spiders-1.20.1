package net.tangenia.spidermod.effect;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

public class FunnelWebVenomEffect extends MobEffect {
    public FunnelWebVenomEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier)
    {
        if(pLivingEntity.isUsingItem() == true && pLivingEntity instanceof Player)
        {
            Item selectedItem = pLivingEntity.getItemInHand(InteractionHand.MAIN_HAND).getItem();
            Item selectedItem2 = pLivingEntity.getItemInHand(InteractionHand.OFF_HAND).getItem();
            if(selectedItem.isEdible() || selectedItem2.isEdible())
            {
                ((Player)pLivingEntity).getFoodData().addExhaustion(1f * (float)(pAmplifier + 1));
            }
        }
        pLivingEntity.hurt(pLivingEntity.damageSources().drown(), 0.5F * (float)(pAmplifier + 1));
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier)
    {
        return true;
    }
}
