package net.tangenia.spidermod.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.tangenia.spidermod.SpiderMod;
import net.tangenia.spidermod.entity.custom.FunnelWepEntity;
import net.tangenia.spidermod.entity.custom.WanderingSpiderEntity;
import net.tangenia.spidermod.entity.layers.ModModelLayers;

public class WanderingSpiderRenderer extends MobRenderer<WanderingSpiderEntity, WanderingSpiderModel<WanderingSpiderEntity>> {
    private static final ResourceLocation WANDERING_SPIDER_LOCATION = new ResourceLocation(SpiderMod.MODID, "textures/entity/wandering_spider_texture.png");
    public WanderingSpiderRenderer(EntityRendererProvider.Context pContext)
    {
        super(pContext, new WanderingSpiderModel<>(pContext.bakeLayer(ModModelLayers.WANDERING_SPIDER_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(WanderingSpiderEntity WanderingSpiderEntity) {
        return WANDERING_SPIDER_LOCATION;
    }
}
