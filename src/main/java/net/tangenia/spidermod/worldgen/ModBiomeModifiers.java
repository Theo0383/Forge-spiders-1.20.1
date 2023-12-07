package net.tangenia.spidermod.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.tangenia.spidermod.SpiderMod;
import net.tangenia.spidermod.entity.ModEntities;

import java.util.List;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> SPAWN_FUNNEL_WEB = registerKey("spawn_funnel_web");
    public static final ResourceKey<BiomeModifier> SPAWN_WANDERING_SPIDER = registerKey("spawn_wandering_spider");

    public static void bootstrap(BootstapContext<BiomeModifier> context)
    {
        var placeFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(SPAWN_FUNNEL_WEB, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_DRY_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.FUNNELWEP.get(), 20, 1, 2 ))
        ));

        context.register(SPAWN_WANDERING_SPIDER, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_DENSE_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.WANDERING_SPIDER.get(), 10, 1, 1 ))
        ));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name)
    {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(SpiderMod.MODID, name));
    }
}