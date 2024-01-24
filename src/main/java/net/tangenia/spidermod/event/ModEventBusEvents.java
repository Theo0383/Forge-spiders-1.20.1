package net.tangenia.spidermod.event;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tangenia.spidermod.SpiderMod;
import net.tangenia.spidermod.entity.ModEntities;
import net.tangenia.spidermod.entity.client.*;
import net.tangenia.spidermod.entity.custom.BlackWidowEntity;
import net.tangenia.spidermod.entity.custom.FunnelWepEntity;
import net.tangenia.spidermod.entity.custom.WanderingSpiderEntity;
import net.tangenia.spidermod.entity.custom.WolfSpiderEntity;
import net.tangenia.spidermod.entity.layers.ModModelLayers;

@Mod.EventBusSubscriber(modid = SpiderMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(ModModelLayers.FUNNELWEP_LAYER, FunnelWepModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.BLACK_WIDOW_LAYER, BlackWidowModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.WANDERING_SPIDER_LAYER, WanderingSpiderModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.WOLF_SPIDER_LAYER, WolfSpiderModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.SPEAR_ENTITY_LAYER, SpearProjectileModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event)
    {
        event.put(ModEntities.FUNNELWEP.get(), FunnelWepEntity.createAttributes().build());
        event.put(ModEntities.BLACKWIDOW.get(), BlackWidowEntity.createAttributes().build());
        event.put(ModEntities.WANDERING_SPIDER.get(), WanderingSpiderEntity.createAttributes().build());
        event.put(ModEntities.WOLF_SPIDER.get(), WolfSpiderEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacement(SpawnPlacementRegisterEvent event)
    {
        event.register(ModEntities.FUNNELWEP.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(ModEntities.WANDERING_SPIDER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING,
                Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
