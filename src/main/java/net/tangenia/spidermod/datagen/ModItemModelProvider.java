package net.tangenia.spidermod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.tangenia.spidermod.SpiderMod;
import net.tangenia.spidermod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, SpiderMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        simpleItem(ModItems.FUNNEL_WEB_CARAPACE_HELMET);
        simpleItem(ModItems.FUNNEL_WEB_CARAPACE_CHESTPLATE);
        simpleItem(ModItems.FUNNEL_WEB_CARAPACE_LEGGINGS);
        simpleItem(ModItems.FUNNEL_WEB_CARAPACE_BOOTS);

        simpleItem(ModItems.WANDERING_SPIDER_CARAPACE_HELMET);
        simpleItem(ModItems.WANDERING_SPIDER_CARAPACE_CHESTPLATE);
        simpleItem(ModItems.WANDERING_SPIDER_CARAPACE_LEGGINGS);
        simpleItem(ModItems.WANDERING_SPIDER_CARAPACE_BOOTS);

        handheldItem(ModItems.FUNNEL_WEB_FANG_DAGGER);

        handheldItem(ModItems.BLACK_WIDOW_MACE);

        handheldItem(ModItems.WANDERING_SPIDER_SABER);

        withExistingParent(ModItems.FUNNEL_WEB_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        withExistingParent(ModItems.BLACK_WIDOW_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        withExistingParent(ModItems.WANDERING_SPIDER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        withExistingParent(ModItems.WOLF_SPIDER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SpiderMod.MODID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(SpiderMod.MODID, "item/" + item.getId().getPath()));
    }
}


