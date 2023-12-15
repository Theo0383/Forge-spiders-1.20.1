package net.tangenia.spidermod.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tangenia.spidermod.SpiderMod;
import net.tangenia.spidermod.entity.ModEntities;
import net.tangenia.spidermod.item.custom.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SpiderMod.MODID);

    public static final RegistryObject<Item> FUNNEL_WEB_SPAWN_EGG = ITEMS.register("funnel_web_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.FUNNELWEP, 0x1c1815, 0x0f0d0b,
                    new Item.Properties()));

    public static final RegistryObject<Item> FUNNEL_WEB_CARAPACE = ITEMS.register("funnel_web_carapace",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FUNNEL_WEB_LEG = ITEMS.register("funnel_web_leg",
            () -> new Item(new Item.Properties().food(ModFoodProperties.FUNNEL_WEB_LEG)));

    public static final RegistryObject<Item> FUNNEL_WEB_FANG = ITEMS.register("funnel_web_fang",
            () -> new FunnelWebFangItem(new Item.Properties()));
    public static final RegistryObject<Item> BLACK_WIDOW_FANG = ITEMS.register("black_widow_fang",
            () -> new BlackWidowFangItem(new Item.Properties()));
    public static final RegistryObject<Item> WANDERING_SPIDER_FANG = ITEMS.register("wandering_spider_fang",
            () -> new WanderingSpiderFangItem(new Item.Properties()));

    public static final RegistryObject<Item> FUNNEL_WEB_FANG_DAGGER = ITEMS.register("funnel_web_fang_dagger",
            () -> new FunnelWebFangDagger(ModToolTiers.FANG, 2, -2, new Item.Properties().durability(180)));

    public static final RegistryObject<Item> BLACK_WIDOW_MACE = ITEMS.register("black_widow_mace",
            () -> new BlackWidowFangMace(ModToolTiers.FANG, 4, -3, new Item.Properties().durability(220)));

    public static final RegistryObject<Item> FUNNEL_WEB_CARAPACE_HELMET = ITEMS.register("funnel_web_carapace_helmet",
            () -> new ModItemArmor(ModArmorMaterials.FUNNEL_WEB_CARAPACE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> FUNNEL_WEB_CARAPACE_CHESTPLATE = ITEMS.register("funnel_web_carapace_chestplate",
            () -> new ModItemArmor(ModArmorMaterials.FUNNEL_WEB_CARAPACE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> FUNNEL_WEB_CARAPACE_LEGGINGS = ITEMS.register("funnel_web_carapace_leggings",
            () -> new ModItemArmor(ModArmorMaterials.FUNNEL_WEB_CARAPACE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> FUNNEL_WEB_CARAPACE_BOOTS = ITEMS.register("funnel_web_carapace_boots",
            () -> new ModItemArmor(ModArmorMaterials.FUNNEL_WEB_CARAPACE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> WANDERING_SPIDER_CARAPACE_HELMET = ITEMS.register("wandering_spider_carapace_helmet",
            () -> new ModItemArmor(ModArmorMaterials.WANDERING_SPIDER_CARAPACE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> WANDERING_SPIDER_CARAPACE_CHESTPLATE = ITEMS.register("wandering_spider_carapace_chestplate",
            () -> new ModItemArmor(ModArmorMaterials.WANDERING_SPIDER_CARAPACE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> WANDERING_SPIDER_CARAPACE_LEGGINGS = ITEMS.register("wandering_spider_carapace_leggings",
            () -> new ModItemArmor(ModArmorMaterials.WANDERING_SPIDER_CARAPACE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> WANDERING_SPIDER_CARAPACE_BOOTS = ITEMS.register("wandering_spider_carapace_boots",
            () -> new ModItemArmor(ModArmorMaterials.WANDERING_SPIDER_CARAPACE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> BLACK_WIDOW_SPAWN_EGG = ITEMS.register("black_widow_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.BLACKWIDOW, 0x0f0100, 0x9c0a00,
                    new Item.Properties()));

    public static final RegistryObject<Item> WANDERING_SPIDER_SPAWN_EGG = ITEMS.register("wandering_spider_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.WANDERING_SPIDER, 0x360b04, 0xff0800,
                    new Item.Properties()));

    public static final RegistryObject<Item> WANDERING_SPIDER_HAIR = ITEMS.register("wandering_spider_hair",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WANDERING_SPIDER_SABER = ITEMS.register("wandering_spider_saber",
            () -> new WanderingSpiderSaber(ModToolTiers.FANG, 2, -2.4f, new Item.Properties().durability(160)));

    public static final RegistryObject<Item> LOCATOR = ITEMS.register("locator",
            () -> new LocatorItem(new Item.Properties()));

    public static final RegistryObject<Item> WANDERING_SPIDER_CARAPACE = ITEMS.register("wandering_spider_carapace",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WANDERING_SPIDER_LEG = ITEMS.register("wandering_spider_leg",
            () -> new Item(new Item.Properties().food(ModFoodProperties.WANDERING_SPIDER_LEG)));

    public static void register(IEventBus eventbus)
    {
        ITEMS.register(eventbus);
    }
}
