package net.tangenia.spidermod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.gui.screens.Overlay;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.tangenia.spidermod.SpiderMod;
import net.tangenia.spidermod.entity.custom.SpearProjectileEntity;
import net.tangenia.spidermod.entity.layers.ModModelLayers;

public class SpearProjectileRenderer extends EntityRenderer<SpearProjectileEntity> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(SpiderMod.MODID, "textures/entity/spear_entity_texture.png");
    protected SpearProjectileModel model;
    public SpearProjectileRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        model = new SpearProjectileModel(pContext.bakeLayer(ModModelLayers.SPEAR_ENTITY_LAYER));
        //this.shadowRadius = 0.5f;
    }

    public void render(SpearProjectileEntity entity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTick, entity.yRotO, entity.getYRot()) - 90.0F));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTick, entity.xRotO, entity.getXRot()) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(this.getTextureLocation(entity)), false, false);

        this.model.renderToBuffer(pPoseStack, vertexConsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
        pPoseStack.popPose();
        super.render(entity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(SpearProjectileEntity pEntity) {
        return TEXTURE;
    }
}
