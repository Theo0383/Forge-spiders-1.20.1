package net.tangenia.spidermod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tangenia.spidermod.effect.ModEffects;
import net.tangenia.spidermod.entity.ModEntities;
import net.tangenia.spidermod.entity.client.BlackWidowRenderer;
import net.tangenia.spidermod.entity.client.FunnelWepRenderer;
import net.tangenia.spidermod.entity.client.WanderingSpiderRenderer;
import net.tangenia.spidermod.entity.custom.FunnelWepEntity;
import net.tangenia.spidermod.item.ModCreativeModeTabs;
import net.tangenia.spidermod.item.ModItems;
import net.tangenia.spidermod.potion.BetterBrewingRecipe;
import net.tangenia.spidermod.potion.ModPotions;
import org.slf4j.Logger;

import static net.minecraft.world.damagesource.DamageTypes.IN_WALL;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SpiderMod.MODID)
public class SpiderMod
{
    public static final String MODID = "spidermod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SpiderMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        ModCreativeModeTabs.register(modEventBus);

        ModEffects.register(modEventBus);

        ModPotions.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::commonSetup);

        ModEntities.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, ModItems.FUNNEL_WEB_FANG.get(), ModPotions.FUNNEL_WEB_AFFINITY_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, ModItems.BLACK_WIDOW_FANG.get(), ModPotions.BLACK_WIDOW_AFFINITY_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.POISON, ModItems.BLACK_WIDOW_FANG.get(), ModPotions.BLACK_WIDOW_VENOM_POTION.get()));
        });
    }
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            event.enqueueWork(() -> {
                EntityRenderers.register(ModEntities.FUNNELWEP.get(), FunnelWepRenderer::new);
                EntityRenderers.register(ModEntities.BLACKWIDOW.get(), BlackWidowRenderer::new);
                EntityRenderers.register(ModEntities.WANDERING_SPIDER.get(), WanderingSpiderRenderer::new);
            });
        }
    }
}
