package net.tangenia.spidermod.entity.layers;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.tangenia.spidermod.SpiderMod;

public class ModModelLayers {
    public static final ModelLayerLocation FUNNELWEP_LAYER = new ModelLayerLocation(
            new ResourceLocation(SpiderMod.MODID, "funnel_wep_layer"), "funnel_wep_layer");

    public static final ModelLayerLocation BLACK_WIDOW_LAYER = new ModelLayerLocation(
            new ResourceLocation(SpiderMod.MODID, "black_widow_layer"), "black_widow_layer");

    public static final ModelLayerLocation WANDERING_SPIDER_LAYER = new ModelLayerLocation(
            new ResourceLocation(SpiderMod.MODID, "wandering_spider_layer"), "wandering_spider_layer");
}
