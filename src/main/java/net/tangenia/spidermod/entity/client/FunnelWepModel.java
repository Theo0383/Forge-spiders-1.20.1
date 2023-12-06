package net.tangenia.spidermod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.tangenia.spidermod.entity.animations.ModAnimationDefinitions;
import net.tangenia.spidermod.entity.custom.FunnelWepEntity;

import javax.swing.text.html.parser.Entity;

public class FunnelWepModel<T extends FunnelWepEntity> extends HierarchicalModel<T> {
	private final ModelPart body;

	public FunnelWepModel(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition backBody = body.addOrReplaceChild("backBody", CubeListBuilder.create().texOffs(60, 0).addBox(-5.0F, -10.0F, 8.0F, 10.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition backMass = backBody.addOrReplaceChild("backMass", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -5.5F, 0.0F, 14.0F, 11.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.5F, 9.0F));

		PartDefinition frill = backMass.addOrReplaceChild("frill", CubeListBuilder.create().texOffs(36, 0).addBox(-4.0F, -10.0F, 25.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.5F, -9.0F));

		PartDefinition frontBody = body.addOrReplaceChild("frontBody", CubeListBuilder.create().texOffs(0, 27).addBox(-7.0F, -11.0F, -8.0F, 14.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = frontBody.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(44, 31).addBox(-4.0F, -10.0F, -12.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition cube_r2 = frontBody.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(46, 13).addBox(-5.0F, -13.1F, -8.4F, 10.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition rmandible = frontBody.addOrReplaceChild("rmandible", CubeListBuilder.create(), PartPose.offset(-2.5F, -9.6645F, -7.0843F));

		PartDefinition cube_r3 = rmandible.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 27).addBox(-4.5F, -3.0F, -12.6F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 9.6645F, 7.0843F, -0.6981F, 0.0F, 0.0F));

		PartDefinition rfang = rmandible.addOrReplaceChild("rfang", CubeListBuilder.create().texOffs(0, 8).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.6645F, -3.3157F));

		PartDefinition lmandible = frontBody.addOrReplaceChild("lmandible", CubeListBuilder.create(), PartPose.offset(2.5F, -9.6645F, -7.0843F));

		PartDefinition cube_r4 = lmandible.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(20, 82).addBox(0.5F, -3.0F, -12.6F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 9.6645F, 7.0843F, -0.6981F, 0.0F, 0.0F));

		PartDefinition lfang = lmandible.addOrReplaceChild("lfang", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.6645F, -3.3157F));

		PartDefinition r4leg = frontBody.addOrReplaceChild("r4leg", CubeListBuilder.create().texOffs(0, 49).addBox(-10.5F, -1.5F, -1.5F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5F, -8.5F, 6.5F, 0.202F, 0.3066F, 0.5515F));

		PartDefinition r4sgm3 = r4leg.addOrReplaceChild("r4sgm3", CubeListBuilder.create().texOffs(0, 85).addBox(-6.5F, -1.5F, -1.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition r4sgm2 = r4sgm3.addOrReplaceChild("r4sgm2", CubeListBuilder.create().texOffs(66, 31).addBox(-8.5F, -1.5F, -1.5F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition r4sgm1 = r4sgm2.addOrReplaceChild("r4sgm1", CubeListBuilder.create().texOffs(44, 64).addBox(-8.5F, -1.5F, -1.5F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition r3leg = frontBody.addOrReplaceChild("r3leg", CubeListBuilder.create().texOffs(28, 49).addBox(-9.5F, -1.5F, -1.5F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, -8.5F, 2.5F, 0.0437F, 0.0756F, 0.5253F));

		PartDefinition r3sgm3 = r3leg.addOrReplaceChild("r3sgm3", CubeListBuilder.create().texOffs(36, 85).addBox(-6.5F, -1.5F, -1.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition r3sgm2 = r3sgm3.addOrReplaceChild("r3sgm2", CubeListBuilder.create().texOffs(69, 38).addBox(-8.5F, -1.5F, -1.5F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.48F));

		PartDefinition r3sgm1 = r3sgm2.addOrReplaceChild("r3sgm1", CubeListBuilder.create().texOffs(65, 67).addBox(-8.5F, -1.5F, -1.5F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition r2leg = frontBody.addOrReplaceChild("r2leg", CubeListBuilder.create().texOffs(53, 52).addBox(-10.5F, -1.5F, -1.5F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5F, -8.5F, -1.5F, -0.0766F, -0.1947F, 0.5315F));

		PartDefinition r2sgm3 = r2leg.addOrReplaceChild("r2sgm3", CubeListBuilder.create().texOffs(56, 85).addBox(-6.5F, -1.5F, -1.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition r2sgm2 = r2sgm3.addOrReplaceChild("r2sgm2", CubeListBuilder.create().texOffs(0, 72).addBox(-8.5F, -1.5F, -1.5F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6545F));

		PartDefinition r2sgm1 = r2sgm2.addOrReplaceChild("r2sgm1", CubeListBuilder.create().texOffs(41, 70).addBox(-8.5F, -1.5F, -1.5F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition r1leg = frontBody.addOrReplaceChild("r1leg", CubeListBuilder.create().texOffs(0, 55).addBox(-10.5F, -1.5F, -1.5F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5F, -8.5F, -5.5F, -0.2789F, -0.381F, 0.569F));

		PartDefinition r1sgm3 = r1leg.addOrReplaceChild("r1sgm3", CubeListBuilder.create().texOffs(76, 85).addBox(-6.5F, -1.5F, -1.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition r1sgm2 = r1sgm3.addOrReplaceChild("r1sgm2", CubeListBuilder.create().texOffs(21, 76).addBox(-8.5F, -1.5F, -1.5F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.829F));

		PartDefinition r1sgm1 = r1sgm2.addOrReplaceChild("r1sgm1", CubeListBuilder.create().texOffs(62, 73).addBox(-8.5F, -1.5F, -1.5F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition l4leg = frontBody.addOrReplaceChild("l4leg", CubeListBuilder.create().texOffs(28, 55).addBox(-0.5F, -1.5F, -1.5F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -8.5F, 6.5F, 0.2209F, -0.3044F, -0.5335F));

		PartDefinition l4sgm3 = l4leg.addOrReplaceChild("l4sgm3", CubeListBuilder.create().texOffs(87, 76).addBox(-0.5F, -1.5F, -1.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition l4sgm2 = l4sgm3.addOrReplaceChild("l4sgm2", CubeListBuilder.create().texOffs(78, 55).addBox(-0.5F, -1.5F, -1.5F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition l4sgm1 = l4sgm2.addOrReplaceChild("l4sgm1", CubeListBuilder.create().texOffs(78, 61).addBox(-0.5F, -1.5F, -1.5F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition l3leg = frontBody.addOrReplaceChild("l3leg", CubeListBuilder.create().texOffs(57, 5).addBox(-0.5F, -1.5F, -1.5F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -8.5F, 2.5F, 0.0436F, -0.0873F, -0.5236F));

		PartDefinition l3sgm3 = l3leg.addOrReplaceChild("l3sgm3", CubeListBuilder.create().texOffs(90, 31).addBox(-0.5F, -1.5F, -1.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition l3sgm2 = l3sgm3.addOrReplaceChild("l3sgm2", CubeListBuilder.create().texOffs(0, 79).addBox(-0.5F, -1.5F, -1.5F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition l3sgm1 = l3sgm2.addOrReplaceChild("l3sgm1", CubeListBuilder.create().texOffs(42, 79).addBox(-0.5F, -1.5F, -1.5F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition l2leg = frontBody.addOrReplaceChild("l2leg", CubeListBuilder.create().texOffs(57, 46).addBox(-0.5F, -1.5F, -1.5F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -8.5F, -1.5F, -0.0873F, 0.1745F, -0.5236F));

		PartDefinition l2sgm3 = l2leg.addOrReplaceChild("l2sgm3", CubeListBuilder.create().texOffs(0, 91).addBox(-0.5F, -1.5F, -1.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6981F));

		PartDefinition l2sgm2 = l2sgm3.addOrReplaceChild("l2sgm2", CubeListBuilder.create().texOffs(66, 79).addBox(-0.5F, -1.5F, -1.5F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition l2sgm1 = l2sgm2.addOrReplaceChild("l2sgm1", CubeListBuilder.create().texOffs(80, 11).addBox(-0.5F, -1.5F, -1.5F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition l1leg = frontBody.addOrReplaceChild("l1leg", CubeListBuilder.create().texOffs(53, 58).addBox(-0.5F, -1.5F, -1.5F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -8.5F, -5.5F, -0.2282F, 0.399F, -0.5638F));

		PartDefinition l1sgm3 = l1leg.addOrReplaceChild("l1sgm3", CubeListBuilder.create().texOffs(36, 91).addBox(-0.5F, -1.5F, -1.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition l1sgm2 = l1sgm3.addOrReplaceChild("l1sgm2", CubeListBuilder.create().texOffs(82, 0).addBox(-0.5F, -1.5F, -1.5F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.829F));

		PartDefinition l1sgm1 = l1sgm2.addOrReplaceChild("l1sgm1", CubeListBuilder.create().texOffs(80, 17).addBox(-0.5F, -1.5F, -1.5F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition RightFeeler = frontBody.addOrReplaceChild("RightFeeler", CubeListBuilder.create().texOffs(0, 61).addBox(-1.4128F, -1.673F, -6.9811F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5824F, -5.4759F, -8.6556F, 0.0436F, 0.1745F, 0.0F));

		PartDefinition rfsgm2 = RightFeeler.addOrReplaceChild("rfsgm2", CubeListBuilder.create().texOffs(79, 46).addBox(-1.5F, -1.5F, -6.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0872F, -0.173F, -6.9811F, 0.0F, -0.48F, 0.0F));

		PartDefinition rfsgm1 = rfsgm2.addOrReplaceChild("rfsgm1", CubeListBuilder.create().texOffs(44, 8).addBox(-1.5F, -1.5F, -4.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.5F, 0.1745F, 0.0F, 0.0F));

		PartDefinition LeftFeeler = frontBody.addOrReplaceChild("LeftFeeler", CubeListBuilder.create().texOffs(22, 61).addBox(-1.5F, -1.5F, -8.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5329F, -5.4759F, -7.5226F, 0.0436F, -0.1745F, 0.0F));

		PartDefinition lfsgm2 = LeftFeeler.addOrReplaceChild("lfsgm2", CubeListBuilder.create().texOffs(83, 67).addBox(-1.5F, -1.5F, -6.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.48F, 0.0F));

		PartDefinition lfsgm1 = lfsgm2.addOrReplaceChild("lfsgm1", CubeListBuilder.create().texOffs(14, 61).addBox(-1.5F, -1.5F, -4.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.5F, 0.1745F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(FunnelWepEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(ModAnimationDefinitions.MODEL_WALK, limbSwing, limbSwingAmount, 3.5f, 2.5f);
		this.animate(entity.idleAnimationState, ModAnimationDefinitions.MODEL_IDLE, ageInTicks, 1f);
		this.animate(entity.attackAnimationState, ModAnimationDefinitions.MODEL_ATTACK, ageInTicks, 1f);
		this.animate(entity.burrowAnimationState, ModAnimationDefinitions.MODEL_BURRY, ageInTicks, 1f);
		this.animate(entity.unBurrowAnimationState, ModAnimationDefinitions.MODEL_UNBURRY, ageInTicks, 1f);
		this.animate(entity.surpriceAttackAnimationState, ModAnimationDefinitions.MODEL_SURPRICE, ageInTicks, 1f);
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