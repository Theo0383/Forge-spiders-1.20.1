package net.tangenia.spidermod.entity.client;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.tangenia.spidermod.entity.animations.WidowAnimationDefinitions;
import net.tangenia.spidermod.entity.custom.BlackWidowEntity;

import javax.swing.text.html.parser.Entity;

public class BlackWidowModel<T extends BlackWidowEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "blackwidowmodel"), "main");
	private final ModelPart body;

	public BlackWidowModel(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 20).addBox(-3.0F, -5.0F, -4.0F, 6.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 0.0F));

		PartDefinition back = body.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -6.5F, 0.5F, 10.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 2.5F, 0.1309F, 0.0F, 0.0F));

		PartDefinition l_1_leg = body.addOrReplaceChild("l_1_leg", CubeListBuilder.create().texOffs(22, 20).addBox(0.0F, -0.5634F, -0.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8303F, -2.4366F, -3.317F, -0.1309F, 0.7854F, -0.1745F));

		PartDefinition l_1_shin = l_1_leg.addOrReplaceChild("l_1_shin", CubeListBuilder.create().texOffs(0, 33).addBox(0.0F, -0.0634F, -1.0F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.3054F));

		PartDefinition l_1_tip = l_1_shin.addOrReplaceChild("l_1_tip", CubeListBuilder.create().texOffs(36, 36).addBox(0.0F, -0.0634F, -0.5F, 9.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.4363F));

		PartDefinition l_2_leg = body.addOrReplaceChild("l_2_leg", CubeListBuilder.create().texOffs(19, 34).addBox(0.0F, 0.0F, -0.8333F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -3.0F, -1.1667F, -0.0436F, 0.3491F, -0.0873F));

		PartDefinition l_2_shin = l_2_leg.addOrReplaceChild("l_2_shin", CubeListBuilder.create().texOffs(33, 10).addBox(0.0F, 0.0F, -0.75F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -0.0833F, 0.0F, 0.0F, 0.3054F));

		PartDefinition l_2_tip = l_2_shin.addOrReplaceChild("l_2_tip", CubeListBuilder.create().texOffs(37, 35).addBox(0.0F, 0.0F, -0.5F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -0.25F, 0.0F, 0.0F, 0.3054F));

		PartDefinition l_3_leg = body.addOrReplaceChild("l_3_leg", CubeListBuilder.create().texOffs(33, 8).addBox(0.0F, 0.0191F, -0.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0024F, -3.0191F, 0.8403F, 0.0F, -0.1745F, -0.0873F));

		PartDefinition l_3_shin = l_3_leg.addOrReplaceChild("l_3_shin", CubeListBuilder.create().texOffs(0, 35).addBox(0.0F, -0.7176F, -1.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.8F, 0.7366F, 0.5F, 0.0F, 0.0F, 0.3054F));

		PartDefinition l_3_tip = l_3_shin.addOrReplaceChild("l_3_tip", CubeListBuilder.create().texOffs(32, 37).addBox(0.0F, -0.7176F, -0.5F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.7F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3054F));

		PartDefinition l_4_leg = body.addOrReplaceChild("l_4_leg", CubeListBuilder.create().texOffs(22, 24).addBox(0.0F, -0.2231F, -0.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6092F, -2.7769F, 3.6548F, 0.0873F, -0.6981F, -0.2182F));

		PartDefinition l_4_shin = l_4_leg.addOrReplaceChild("l_4_shin", CubeListBuilder.create().texOffs(22, 28).addBox(0.0F, -0.2545F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.8488F, 0.0314F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition l_4_tip = l_4_shin.addOrReplaceChild("l_4_tip", CubeListBuilder.create().texOffs(33, 12).addBox(0.3123F, -0.2856F, -0.5F, 9.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.6F, -0.1F, 1.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition r_1_leg = body.addOrReplaceChild("r_1_leg", CubeListBuilder.create().texOffs(22, 22).addBox(-12.0F, -0.5F, -0.3333F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7F, -2.5F, -3.6667F, -0.0873F, -0.7854F, 0.1309F));

		PartDefinition r_1_shin = r_1_leg.addOrReplaceChild("r_1_shin", CubeListBuilder.create().texOffs(31, 32).addBox(-9.0F, -0.5F, -0.25F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.0F, -0.0833F, 0.0F, 0.0F, -0.3054F));

		PartDefinition r_1_tip = r_1_shin.addOrReplaceChild("r_1_tip", CubeListBuilder.create().texOffs(36, 34).addBox(-9.0F, -0.5F, 0.0F, 9.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.3054F));

		PartDefinition r_2_leg = body.addOrReplaceChild("r_2_leg", CubeListBuilder.create().texOffs(33, 6).addBox(-8.0F, -0.5F, -0.3333F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.5F, -1.6667F, 0.0F, -0.2618F, 0.1309F));

		PartDefinition r_2_shin = r_2_leg.addOrReplaceChild("r_2_shin", CubeListBuilder.create().texOffs(33, 4).addBox(-8.0F, -0.5F, -0.25F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, -0.0833F, 0.0F, 0.0F, -0.3927F));

		PartDefinition r_2_tip = r_2_shin.addOrReplaceChild("r_2_tip", CubeListBuilder.create().texOffs(16, 37).addBox(-8.0F, -0.5F, 0.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.3054F));

		PartDefinition r_3_leg = body.addOrReplaceChild("r_3_leg", CubeListBuilder.create().texOffs(33, 2).addBox(-8.0F, -0.5F, -0.6667F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.5F, 1.1667F, 0.0436F, 0.1309F, 0.1309F));

		PartDefinition r_3_shin = r_3_leg.addOrReplaceChild("r_3_shin", CubeListBuilder.create().texOffs(33, 0).addBox(-8.0F, -0.5F, -0.75F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 0.0833F, 0.0F, 0.0F, -0.3927F));

		PartDefinition r_3_tip = r_3_shin.addOrReplaceChild("r_3_tip", CubeListBuilder.create().texOffs(0, 37).addBox(-8.0F, -0.5F, 0.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 0.25F, 0.0F, 0.0F, -0.3054F));

		PartDefinition r_4_leg = body.addOrReplaceChild("r_4_leg", CubeListBuilder.create().texOffs(22, 26).addBox(-12.0F, -0.5F, -0.6667F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.5F, 4.1667F, 0.0873F, 0.6981F, 0.2182F));

		PartDefinition r_4_shin = r_4_leg.addOrReplaceChild("r_4_shin", CubeListBuilder.create().texOffs(32, 30).addBox(-9.0F, -0.5F, -0.75F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.0F, 0.0833F, 0.0F, 0.0F, -0.48F));

		PartDefinition r_4_tip = r_4_shin.addOrReplaceChild("r_4_tip", CubeListBuilder.create().texOffs(18, 36).addBox(-9.0F, -0.5F, 0.0F, 9.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.25F, 0.0F, 0.0F, -0.2182F));

		PartDefinition rightfang = body.addOrReplaceChild("rightfang", CubeListBuilder.create().texOffs(4, 3).addBox(-0.75F, 0.0F, -1.5F, 1.5F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.05F, -3.0F, -3.5F));

		PartDefinition righttooth = rightfang.addOrReplaceChild("righttooth", CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.45F, 2.5F, 0.5F));

		PartDefinition leftfang = body.addOrReplaceChild("leftfang", CubeListBuilder.create().texOffs(0, 0).addBox(-0.75F, -0.1F, -1.9F, 1.5F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.05F, -2.9F, -3.1F));

		PartDefinition lefttooth = leftfang.addOrReplaceChild("lefttooth", CubeListBuilder.create().texOffs(0, 3).addBox(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.45F, 2.4F, 0.1F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(BlackWidowEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(WidowAnimationDefinitions.WIDOW_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(entity.idleAnimationState, WidowAnimationDefinitions.WIDOW_IDLE, ageInTicks, 1f);
		this.animate(entity.attackAnimationState, WidowAnimationDefinitions.WIDOW_ATTACK, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return body;
	}
}