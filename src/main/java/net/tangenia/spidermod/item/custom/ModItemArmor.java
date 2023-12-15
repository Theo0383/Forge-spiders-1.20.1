package net.tangenia.spidermod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.tangenia.spidermod.effect.ModEffects;

import java.util.Map;

public class ModItemArmor extends ArmorItem {
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ModArmorMaterials.FUNNEL_WEB_CARAPACE, new MobEffectInstance(ModEffects.FUNNEL_WEB_AFFINITY_EFFECT.get(), 40, 0, false, false, false))
                    .put(ModArmorMaterials.WANDERING_SPIDER_CARAPACE, new MobEffectInstance(ModEffects.WANDERING_SPIDER_AFFINITY_EFFECT.get(), 40, 0, false, false, false))
                    .build();

    public ModItemArmor(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
        if(!level.isClientSide && hasFullSuitOfArmorOn(player)) {
            evaluateArmorEffects(player);
        }
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity player, int pSlotId, boolean pIsSelected) {
        if(player instanceof Player) {
            if(!pLevel.isClientSide && hasFullSuitOfArmorOn((Player) player)) {
                evaluateArmorEffects((Player) player);
            }
        }
    }

    private void evaluateArmorEffects(Player player) {
        for(Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapEffect = entry.getValue();

            if(hasPlayerCorrectArmorOn(mapArmorMaterial, player)) {
                addEffectToPlayer(player, mapEffect);
            }
        }
    }

    private void addEffectToPlayer(Player player, MobEffectInstance mapEffect) {
        boolean hasPlayerEffect = player.hasEffect(mapEffect.getEffect());

        if(!hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mapEffect.getEffect(), mapEffect.getDuration(), mapEffect.getAmplifier(), false, false, false));
        }
    }

    private boolean hasPlayerCorrectArmorOn(ArmorMaterial mapArmorMaterial, Player player) {
        for(ItemStack armorStack : player.getArmorSlots()) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return boots.getMaterial() == mapArmorMaterial && leggings.getMaterial() == mapArmorMaterial && chestplate.getMaterial() == mapArmorMaterial && helmet.getMaterial() == mapArmorMaterial;
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }
}

