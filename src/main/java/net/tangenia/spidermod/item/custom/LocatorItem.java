package net.tangenia.spidermod.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class LocatorItem extends Item {

    private LivingEntity target;
    public LocatorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity instanceof LivingEntity) {
            target = (LivingEntity) entity;
        }

        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public InteractionResultHolder use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.getCooldowns().addCooldown(this, 10);
        if(!pLevel.isClientSide) {
            if(target != null) {
                double distanceX = Math.pow(pPlayer.getX() - target.getX(), 2);
                double distanceY = Math.pow(pPlayer.getY() - target.getY(), 2);
                double distanceZ = Math.pow(pPlayer.getZ() - target.getZ(), 2);
                double distance = Math.sqrt(distanceX + distanceY + distanceZ);
                if(target instanceof Player) {
                    pPlayer.displayClientMessage(Component.literal("Target is: (" + I18n.get(target.getScoreboardName()) + ", it is (" + Math.floor(distance) + ") Blocks away and has (" + target.getHealth() + ") health"), true);
                }
                else {
                    pPlayer.displayClientMessage(Component.literal("Target is: Not a player, it is (" + Math.floor(distance) + ") Blocks away and has (" + target.getHealth() + ") health"), true);
                }
            }
            else {
                pPlayer.displayClientMessage(Component.literal("No target found."), true);
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
