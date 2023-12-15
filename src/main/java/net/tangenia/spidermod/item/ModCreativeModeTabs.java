package net.tangenia.spidermod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.tangenia.spidermod.SpiderMod;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SpiderMod.MODID);


    public static final RegistryObject<CreativeModeTab> SPIDER_TAB = CREATIVE_MODE_TABS.register("spider_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(Items.COBWEB.getDefaultInstance().getItem()))
            .title(Component.literal("Spider Tab")).displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.FUNNEL_WEB_SPAWN_EGG.get());
                pOutput.accept(ModItems.FUNNEL_WEB_CARAPACE.get());
                pOutput.accept(ModItems.FUNNEL_WEB_LEG.get());
                pOutput.accept(ModItems.FUNNEL_WEB_FANG.get());
                pOutput.accept(ModItems.FUNNEL_WEB_CARAPACE_HELMET.get());
                pOutput.accept(ModItems.FUNNEL_WEB_CARAPACE_CHESTPLATE.get());
                pOutput.accept(ModItems.FUNNEL_WEB_CARAPACE_LEGGINGS.get());
                pOutput.accept(ModItems.FUNNEL_WEB_CARAPACE_BOOTS.get());
                pOutput.accept(ModItems.FUNNEL_WEB_FANG_DAGGER.get());
                pOutput.accept(ModItems.BLACK_WIDOW_SPAWN_EGG.get());
                pOutput.accept(ModItems.BLACK_WIDOW_FANG.get());
                pOutput.accept(ModItems.BLACK_WIDOW_MACE.get());
                pOutput.accept(ModItems.WANDERING_SPIDER_SPAWN_EGG.get());
                pOutput.accept(ModItems.WANDERING_SPIDER_FANG.get());
                pOutput.accept(ModItems.WANDERING_SPIDER_HAIR.get());
                pOutput.accept(ModItems.WANDERING_SPIDER_SABER.get());
                pOutput.accept(ModItems.LOCATOR.get());
                pOutput.accept(ModItems.WANDERING_SPIDER_LEG.get());
                pOutput.accept(ModItems.WANDERING_SPIDER_CARAPACE.get());
                pOutput.accept(ModItems.WANDERING_SPIDER_CARAPACE_HELMET.get());
                pOutput.accept(ModItems.WANDERING_SPIDER_CARAPACE_CHESTPLATE.get());
                pOutput.accept(ModItems.WANDERING_SPIDER_CARAPACE_LEGGINGS.get());
                pOutput.accept(ModItems.WANDERING_SPIDER_CARAPACE_BOOTS.get());
            }).build());
    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}