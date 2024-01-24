package net.tangenia.spidermod.entity.client;// Made with Blockbench 4.9.3
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
import net.tangenia.spidermod.entity.animations.WolfAnimationDefinitions;
import net.tangenia.spidermod.entity.custom.WolfSpiderEntity;

import javax.swing.text.html.parser.Entity;

public class WolfSpiderModel<T extends WolfSpiderEntity> extends HierarchicalModel<T> {
	private final ModelPart body;

	public WolfSpiderModel(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition axis = body.addOrReplaceChild("axis", CubeListBuilder.create().texOffs(34, 39).addBox(-5.0F, -12.0F, -6.0F, 10.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = axis.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 31).addBox(-3.5F, -2.4F, -8.6F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 36).addBox(0.5F, -2.4F, -8.6F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 31).addBox(-4.5F, -2.9F, -7.6F, 9.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition mleft = axis.addOrReplaceChild("mleft", CubeListBuilder.create().texOffs(52, 77).addBox(-2.0F, -0.5F, -3.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.4F, -12.5F, -7.0F));

		PartDefinition fangl = mleft.addOrReplaceChild("fangl", CubeListBuilder.create().texOffs(0, 15).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.5F, 1.0F));

		PartDefinition mright = axis.addOrReplaceChild("mright", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -0.5F, -3.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.4F, -12.5F, -7.0F));

		PartDefinition fangr = mright.addOrReplaceChild("fangr", CubeListBuilder.create().texOffs(0, 11).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.5F, 1.0F));

		PartDefinition back = axis.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5F, -8.0F, -0.5F, 13.0F, 12.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 6.5F));

		PartDefinition rLeg4 = axis.addOrReplaceChild("4rLeg", CubeListBuilder.create().texOffs(0, 63).addBox(0.0F, -1.625F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -9.375F, 6.5F, -0.2618F, -2.8362F, 0.6981F));

		PartDefinition bone30 = rLeg4.addOrReplaceChild("bone30", CubeListBuilder.create().texOffs(66, 55).addBox(-0.0333F, -1.6667F, -1.5F, 10.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0333F, 0.0417F, 0.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition bone31 = bone30.addOrReplaceChild("bone31", CubeListBuilder.create().texOffs(32, 31).addBox(0.0F, -1.75F, -1.0F, 15.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.9667F, 0.0833F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition bone32 = bone31.addOrReplaceChild("bone32", CubeListBuilder.create(), PartPose.offsetAndRotation(15.0F, 0.25F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r2 = bone32.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(68, 61).addBox(0.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition rLeg3 = axis.addOrReplaceChild("3rLeg", CubeListBuilder.create().texOffs(63, 33).addBox(0.0F, -1.625F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -9.375F, 2.5F, -0.0873F, -3.0543F, 0.6981F));

		PartDefinition bone26 = rLeg3.addOrReplaceChild("bone26", CubeListBuilder.create().texOffs(0, 69).addBox(-0.0333F, -1.6667F, -1.5F, 10.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0333F, 0.0417F, 0.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition bone27 = bone26.addOrReplaceChild("bone27", CubeListBuilder.create().texOffs(45, 0).addBox(0.0F, -1.75F, -1.0F, 15.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.9667F, 0.0833F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition bone28 = bone27.addOrReplaceChild("bone28", CubeListBuilder.create().texOffs(77, 3).addBox(0.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 0.25F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition rLeg2 = axis.addOrReplaceChild("2rLeg", CubeListBuilder.create().texOffs(64, 15).addBox(0.0F, -1.5F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9159F, -9.3275F, -1.5F, 0.1309F, 2.9671F, 0.6981F));

		PartDefinition bone22 = rLeg2.addOrReplaceChild("bone22", CubeListBuilder.create().texOffs(66, 45).addBox(-0.0333F, -1.6667F, -1.5F, 10.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0333F, 0.1667F, 0.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition bone23 = bone22.addOrReplaceChild("bone23", CubeListBuilder.create().texOffs(45, 5).addBox(0.0F, -1.75F, -1.0F, 15.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.9667F, 0.0833F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition bone24 = bone23.addOrReplaceChild("bone24", CubeListBuilder.create().texOffs(77, 8).addBox(0.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 0.25F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition rLeg1 = axis.addOrReplaceChild("1rLeg", CubeListBuilder.create().texOffs(64, 21).addBox(0.0F, -1.625F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -9.375F, -5.5F, 0.2618F, 2.7925F, 0.6981F));

		PartDefinition bone18 = rLeg1.addOrReplaceChild("bone18", CubeListBuilder.create().texOffs(26, 71).addBox(-0.0333F, -1.6667F, -1.5F, 10.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0333F, 0.0417F, 0.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition bone19 = bone18.addOrReplaceChild("bone19", CubeListBuilder.create().texOffs(45, 10).addBox(0.0F, -1.75F, -1.0F, 15.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.9667F, 0.0833F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition bone20 = bone19.addOrReplaceChild("bone20", CubeListBuilder.create(), PartPose.offsetAndRotation(15.0F, 0.25F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r3 = bone20.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(78, 51).addBox(0.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition lLeg1 = axis.addOrReplaceChild("1lLeg", CubeListBuilder.create().texOffs(66, 39).addBox(0.0F, -1.625F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -9.375F, -5.5F, -0.2618F, 0.3054F, -0.6981F));

		PartDefinition bone2 = lLeg1.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(26, 77).addBox(-0.0333F, -1.6667F, -1.5F, 10.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0333F, 0.0417F, 0.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition bone3 = bone2.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 58).addBox(0.0F, -1.75F, -1.0F, 15.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.9667F, 0.0833F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition bone4 = bone3.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(68, 84).addBox(0.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 0.25F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition lLeg2 = axis.addOrReplaceChild("2lLeg", CubeListBuilder.create().texOffs(60, 65).addBox(0.0F, -1.625F, 2.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -9.375F, -5.5F, -0.1309F, 0.1745F, -0.6981F));

		PartDefinition bone6 = lLeg2.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(75, 74).addBox(-0.0333F, -1.6667F, 2.5F, 10.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0333F, 0.0417F, 0.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition bone7 = bone6.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(32, 55).addBox(0.0F, -1.75F, 3.0F, 15.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.9667F, 0.0833F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition bone8 = bone7.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(20, 83).addBox(0.0F, -1.0F, 3.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 0.25F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition lLeg3 = axis.addOrReplaceChild("3lLeg", CubeListBuilder.create().texOffs(30, 65).addBox(1.0F, -1.5F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5159F, -8.9275F, 2.5F, 0.0873F, -0.0873F, -0.6981F));

		PartDefinition bone10 = lLeg3.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(0, 75).addBox(-0.0333F, -1.6667F, 6.5F, 10.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0333F, 0.1667F, -8.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition bone11 = bone10.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(34, 60).addBox(0.0F, -1.75F, 7.0F, 15.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.9667F, 0.0833F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition bone12 = bone11.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(0, 81).addBox(0.0F, -1.0F, 7.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 0.25F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition lLeg4 = axis.addOrReplaceChild("4lLeg", CubeListBuilder.create().texOffs(64, 27).addBox(-0.1F, -1.5F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5604F, -9.9027F, 6.934F, 0.2618F, -0.3054F, -0.6981F));

		PartDefinition bone14 = lLeg4.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(52, 71).addBox(-0.0333F, -1.6667F, 6.5F, 10.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.9333F, 0.1667F, -8.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition bone15 = bone14.addOrReplaceChild("bone15", CubeListBuilder.create().texOffs(0, 51).addBox(0.0F, -1.75F, 7.0F, 15.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.9667F, 0.0833F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition bone16 = bone15.addOrReplaceChild("bone16", CubeListBuilder.create(), PartPose.offsetAndRotation(15.0F, 0.25F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r4 = bone16.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(68, 80).addBox(0.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, 0.0F, 0.0F, -0.0873F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(WolfSpiderEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(WolfAnimationDefinitions.WOLF_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(entity.idleAnimationState, WolfAnimationDefinitions.WOLF_IDLE, ageInTicks, 1f);
		this.animate(entity.attackAnimationState, WolfAnimationDefinitions.WOLF_ATTACK, ageInTicks, 1f);
		this.animate(entity.sitAnimationState, WolfAnimationDefinitions.WOLF_SIT, ageInTicks, 1f);
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