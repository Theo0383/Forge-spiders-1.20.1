package net.tangenia.spidermod.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.tangenia.spidermod.SpiderMod;
import net.tangenia.spidermod.entity.custom.WolfSpiderEntity;
import net.tangenia.spidermod.entity.layers.ModModelLayers;

public class WolfSpiderRenderer extends MobRenderer<WolfSpiderEntity, WolfSpiderModel<WolfSpiderEntity>> {
    private static final ResourceLocation WOLF_SPIDER_LOCATION = new ResourceLocation(SpiderMod.MODID, "textures/entity/wolf_spider_texture.png");

    public WolfSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new WolfSpiderModel<>(pContext.bakeLayer(ModModelLayers.WOLF_SPIDER_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(WolfSpiderEntity pEntity) {
        return WOLF_SPIDER_LOCATION;
    }
}
