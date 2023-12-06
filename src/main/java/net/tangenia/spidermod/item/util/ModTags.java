package net.tangenia.spidermod.item.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.tangenia.spidermod.SpiderMod;

public class ModTags {
    public static class Items {
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(SpiderMod.MODID, name));
        }

        private static TagKey<Item> forgeTags(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> NEEDS_FANG = tag("needs_fang_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(SpiderMod.MODID, name));
        }

        private static TagKey<Block> forgeTags(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}
