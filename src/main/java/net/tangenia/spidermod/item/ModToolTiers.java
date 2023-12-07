package net.tangenia.spidermod.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.tangenia.spidermod.SpiderMod;
import net.tangenia.spidermod.item.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier FANG = TierSortingRegistry.registerTier(
            new ForgeTier(2, 200, 10f, 2f, 18,
                    ModTags.Blocks.NEEDS_FANG, () -> Ingredient.of(Items.STRING.getDefaultInstance().getItem())),
            new ResourceLocation(SpiderMod.MODID, "fang"), List.of(Tiers.STONE), List.of()
    );
}
