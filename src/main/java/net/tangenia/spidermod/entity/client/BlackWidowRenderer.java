package net.tangenia.spidermod.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.tangenia.spidermod.SpiderMod;
import net.tangenia.spidermod.entity.custom.BlackWidowEntity;
import net.tangenia.spidermod.entity.layers.ModModelLayers;

public class BlackWidowRenderer extends MobRenderer<BlackWidowEntity, BlackWidowModel<BlackWidowEntity>> {
    private static final ResourceLocation BLACK_WIDOW_LOCATION = new ResourceLocation(SpiderMod.MODID, "textures/entity/black_widow_texture.png");
    public BlackWidowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BlackWidowModel<>(pContext.bakeLayer(ModModelLayers.BLACK_WIDOW_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(BlackWidowEntity pEntity) {
        return BLACK_WIDOW_LOCATION;
    }
}
