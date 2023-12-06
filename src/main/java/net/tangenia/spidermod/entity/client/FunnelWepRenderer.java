package net.tangenia.spidermod.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.tangenia.spidermod.SpiderMod;
import net.tangenia.spidermod.entity.custom.FunnelWepEntity;
import net.tangenia.spidermod.entity.layers.ModModelLayers;

public class FunnelWepRenderer extends MobRenderer<FunnelWepEntity, FunnelWepModel<FunnelWepEntity>> {
    private static final ResourceLocation FUNNELWEP_LOCATION = new ResourceLocation(SpiderMod.MODID, "textures/entity/funnel_wep_texture.png");
    public FunnelWepRenderer(EntityRendererProvider.Context pContext)
    {
        super(pContext, new FunnelWepModel<>(pContext.bakeLayer(ModModelLayers.FUNNELWEP_LAYER)), 1f);
    }
    @Override
    public ResourceLocation getTextureLocation(FunnelWepEntity funnelWepEntity) {
        return FUNNELWEP_LOCATION;
    }
}
