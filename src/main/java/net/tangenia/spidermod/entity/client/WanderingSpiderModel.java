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
import net.tangenia.spidermod.entity.animations.ModAnimationDefinitions;
import net.tangenia.spidermod.entity.animations.WanderAnimationDefinitions;
import net.tangenia.spidermod.entity.custom.WanderingSpiderEntity;

import javax.swing.text.html.parser.Entity;

public class WanderingSpiderModel<T extends WanderingSpiderEntity> extends HierarchicalModel<T> {
	private final ModelPart body;

	public WanderingSpiderModel(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -4.0F));

		PartDefinition axis = body.addOrReplaceChild("axis", CubeListBuilder.create().texOffs(39, 34).addBox(-5.0F, -10.0F, -7.0F, 10.0F, 5.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = axis.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -0.3F, 8.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.4783F, 4.1478F, 0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r2 = axis.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 5).addBox(-4.0F, 0.0F, -0.2F, 8.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.3783F, -0.9522F, 0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r3 = axis.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 10).addBox(-4.0F, 0.0F, -0.1F, 8.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.2783F, -6.0522F, 0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r4 = axis.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -14.0F, -11.6F, 8.0F, 6.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition back = axis.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 27).addBox(-6.0F, 0.0F, -3.5F, 12.0F, 9.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, 13.5F, 0.1309F, 0.0F, 0.0F));

		PartDefinition back_hairs1 = back.addOrReplaceChild("back_hairs1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0582F, -1.9635F));

		PartDefinition cube_r5 = back_hairs1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(77, 13).addBox(-6.0F, -0.5F, -2.0F, 12.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0582F, 1.9635F, 0.2618F, 0.0F, 0.0F));

		PartDefinition back_hairs2 = back.addOrReplaceChild("back_hairs2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.087F, 3.2115F));

		PartDefinition cube_r6 = back_hairs2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(70, 0).addBox(-6.0F, 0.9F, 3.0F, 12.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.087F, -3.2115F, 0.2618F, 0.0F, 0.0F));

		PartDefinition back_hairs3 = back.addOrReplaceChild("back_hairs3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0125F, 9.5518F));

		PartDefinition cube_r7 = back_hairs3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 53).addBox(-6.0F, 2.5F, 9.1F, 12.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0125F, -9.5518F, 0.2618F, 0.0F, 0.0F));

		PartDefinition feeler_right = axis.addOrReplaceChild("feeler_right", CubeListBuilder.create(), PartPose.offset(5.3F, -9.0F, -6.5F));

		PartDefinition cube_r8 = feeler_right.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(83, 97).addBox(-1.0F, -5.0F, -3.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.1F, -1.0F, 0.8727F, 0.0F, 0.0F));

		PartDefinition feeler_right2 = feeler_right.addOrReplaceChild("feeler_right2", CubeListBuilder.create().texOffs(32, 102).addBox(-0.9F, -0.25F, -0.95F, 1.8F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.75F, -5.75F));

		PartDefinition feeler_right3 = feeler_right2.addOrReplaceChild("feeler_right3", CubeListBuilder.create().texOffs(10, 98).addBox(-0.8F, -1.0F, -0.2F, 1.6F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.65F, 0.25F));

		PartDefinition feeler_left = axis.addOrReplaceChild("feeler_left", CubeListBuilder.create(), PartPose.offset(-5.3F, -9.3F, -6.5F));

		PartDefinition cube_r9 = feeler_left.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 96).addBox(-1.0F, -5.0F, -3.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.8F, -1.0F, 0.8727F, 0.0F, 0.0F));

		PartDefinition feeler_left2 = feeler_left.addOrReplaceChild("feeler_left2", CubeListBuilder.create().texOffs(24, 102).addBox(-0.9F, -0.45F, -1.05F, 1.8F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.25F, -5.65F));

		PartDefinition feeler_left3 = feeler_left2.addOrReplaceChild("feeler_left3", CubeListBuilder.create().texOffs(93, 97).addBox(-0.8F, -1.0F, 0.0F, 1.6F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.45F, -0.05F));

		PartDefinition mouth_1 = axis.addOrReplaceChild("mouth_1", CubeListBuilder.create().texOffs(41, 33).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -11.0F, -9.0F));

		PartDefinition fang1 = mouth_1.addOrReplaceChild("fang1", CubeListBuilder.create().texOffs(0, 27).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 7.0F, 2.0F));

		PartDefinition mouth_2 = axis.addOrReplaceChild("mouth_2", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -11.0F, -9.0F));

		PartDefinition fang_2 = mouth_2.addOrReplaceChild("fang_2", CubeListBuilder.create().texOffs(0, 15).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 7.0F, 2.0F));

		PartDefinition leg1 = axis.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(78, 45).addBox(0.0F, -1.25F, -1.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -9.75F, -4.5F, -0.488F, 1.1748F, -0.5555F));

		PartDefinition cube_r10 = leg1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(83, 94).addBox(0.0F, 0.0F, -14.5F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(11, 95).addBox(5.0F, 1.1F, -14.5F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -1.25F, 13.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition leg12 = leg1.addOrReplaceChild("leg12", CubeListBuilder.create().texOffs(46, 58).addBox(0.0F, -1.25F, -1.5F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(30, 7).addBox(0.0F, -0.25F, -3.5F, 20.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition leg123 = leg12.addOrReplaceChild("leg123", CubeListBuilder.create().texOffs(30, 82).addBox(0.0F, -1.5F, -1.0F, 13.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, 0.25F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition leg1234 = leg123.addOrReplaceChild("leg1234", CubeListBuilder.create().texOffs(35, 98).addBox(0.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 0.5F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition leg12345 = leg1234.addOrReplaceChild("leg12345", CubeListBuilder.create().texOffs(0, 92).addBox(0.0F, 0.0F, -2.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition leg2 = axis.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(78, 39).addBox(0.0F, -1.25F, -1.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -9.75F, -0.5F, -0.2347F, 0.8908F, -0.3458F));

		PartDefinition cube_r11 = leg2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(23, 95).addBox(0.0F, 0.0F, -10.5F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(35, 95).addBox(5.0F, 1.1F, -10.5F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -1.25F, 9.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition leg22 = leg2.addOrReplaceChild("leg22", CubeListBuilder.create().texOffs(0, 64).addBox(0.0F, -1.25F, -1.5F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition leg223 = leg22.addOrReplaceChild("leg223", CubeListBuilder.create().texOffs(0, 87).addBox(0.0F, -1.5F, -1.0F, 13.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, 0.25F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition leg2234 = leg223.addOrReplaceChild("leg2234", CubeListBuilder.create().texOffs(100, 82).addBox(0.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 0.5F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition leg22345 = leg2234.addOrReplaceChild("leg22345", CubeListBuilder.create().texOffs(86, 90).addBox(0.0F, 0.0F, -2.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition leg3 = axis.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(77, 7).addBox(0.0F, -1.25F, -1.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -9.75F, 4.5F, -0.243F, -0.1636F, -0.4336F));

		PartDefinition cube_r12 = leg3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(47, 95).addBox(0.0F, 0.0F, -5.5F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(59, 95).addBox(5.0F, 1.1F, -5.5F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -1.25F, 4.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition leg32 = leg3.addOrReplaceChild("leg32", CubeListBuilder.create().texOffs(0, 70).addBox(0.0F, -1.25F, -1.5F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0036F));

		PartDefinition leg323 = leg32.addOrReplaceChild("leg323", CubeListBuilder.create().texOffs(60, 87).addBox(0.0F, -1.5F, -1.0F, 13.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, 0.25F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition leg3234 = leg323.addOrReplaceChild("leg3234", CubeListBuilder.create().texOffs(101, 0).addBox(0.05F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.95F, 0.5F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition leg32345 = leg3234.addOrReplaceChild("leg32345", CubeListBuilder.create().texOffs(88, 66).addBox(0.0F, 0.0F, -2.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.05F, 0.0F, 0.0F, 0.3043F, 0.0262F, -0.1705F));

		PartDefinition leg4 = axis.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(78, 33).addBox(0.0032F, -1.25F, -1.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9968F, -9.75F, 8.5F, 0.6819F, -0.9338F, -0.7903F));

		PartDefinition cube_r13 = leg4.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(71, 95).addBox(5.0F, 1.1F, -1.5F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(95, 94).addBox(0.0F, 0.0F, -1.5F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0032F, -1.25F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition leg42 = leg4.addOrReplaceChild("leg42", CubeListBuilder.create().texOffs(46, 64).addBox(0.0F, -1.25F, -1.5F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0032F, 0.0F, 0.0F, 0.0F, 0.0F, 0.9163F));

		PartDefinition leg423 = leg42.addOrReplaceChild("leg423", CubeListBuilder.create().texOffs(87, 26).addBox(0.0F, -1.8333F, -1.0F, 13.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, 0.5833F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition leg4234 = leg423.addOrReplaceChild("leg4234", CubeListBuilder.create().texOffs(100, 86).addBox(-0.05F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.05F, 0.1667F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition leg42345 = leg4234.addOrReplaceChild("leg42345", CubeListBuilder.create().texOffs(88, 62).addBox(0.0F, 0.0F, -2.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.95F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition leg5 = axis.addOrReplaceChild("leg5", CubeListBuilder.create().texOffs(46, 70).addBox(-16.0F, -1.25F, -1.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -9.75F, -4.5F, -0.5365F, -1.1615F, 0.5751F));

		PartDefinition cube_r14 = leg5.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(11, 92).addBox(-5.6F, -0.65F, 5.0F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(59, 92).addBox(-0.6F, 0.45F, 5.0F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5935F, -1.7849F, 6.5F, 0.0F, 3.1416F, 0.2182F));

		PartDefinition leg52 = leg5.addOrReplaceChild("leg52", CubeListBuilder.create().texOffs(37, 14).addBox(-20.0F, -1.6F, -1.5F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(30, 0).addBox(-20.0F, -0.6F, -3.5F, 20.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, 0.35F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition leg523 = leg52.addOrReplaceChild("leg523", CubeListBuilder.create().texOffs(0, 82).addBox(-13.0F, -1.8333F, -1.0F, 13.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 0.2333F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition leg5234 = leg523.addOrReplaceChild("leg5234", CubeListBuilder.create().texOffs(19, 98).addBox(-5.95F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.05F, 0.1667F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition leg52345 = leg5234.addOrReplaceChild("leg52345", CubeListBuilder.create().texOffs(25, 53).addBox(-5.0F, 0.0F, -2.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.95F, 0.0F, 0.0F));

		PartDefinition leg6 = axis.addOrReplaceChild("leg6", CubeListBuilder.create().texOffs(0, 76).addBox(-16.0F, -1.25F, -1.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -9.75F, -0.5F, -0.2524F, -0.8449F, 0.3321F));

		PartDefinition cube_r15 = leg6.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(23, 92).addBox(-5.6F, -0.65F, 1.0F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(71, 92).addBox(-0.6F, 0.45F, 1.0F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5935F, -1.7849F, 2.5F, 0.0F, 3.1416F, 0.2182F));

		PartDefinition leg62 = leg6.addOrReplaceChild("leg62", CubeListBuilder.create().texOffs(41, 27).addBox(-20.0F, -1.75F, -1.5F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, 0.5F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition leg623 = leg62.addOrReplaceChild("leg623", CubeListBuilder.create().texOffs(84, 70).addBox(-13.0F, -1.5F, -1.0F, 13.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, -0.25F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition leg6234 = leg623.addOrReplaceChild("leg6234", CubeListBuilder.create().texOffs(67, 98).addBox(-5.95F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.05F, 0.5F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition leg62345 = leg6234.addOrReplaceChild("leg62345", CubeListBuilder.create().texOffs(86, 82).addBox(-5.0F, 0.0F, -2.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.95F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition leg7 = axis.addOrReplaceChild("leg7", CubeListBuilder.create().texOffs(76, 76).addBox(-16.0F, -1.25F, -1.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -9.75F, 4.5F, -0.2448F, 0.1763F, 0.406F));

		PartDefinition cube_r16 = leg7.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(35, 92).addBox(-5.6F, -0.65F, -4.0F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(94, 51).addBox(-0.6F, 0.45F, -4.0F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5935F, -1.7849F, -2.5F, 0.0F, 3.1416F, 0.2182F));

		PartDefinition leg72 = leg7.addOrReplaceChild("leg72", CubeListBuilder.create().texOffs(58, 20).addBox(-20.0F, -1.75F, -1.5F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, 0.5F, 0.0F, 0.0F, 0.0F, -1.0036F));

		PartDefinition leg723 = leg72.addOrReplaceChild("leg723", CubeListBuilder.create().texOffs(30, 87).addBox(-13.0F, -1.8333F, -1.0F, 13.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 0.0833F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition leg7234 = leg723.addOrReplaceChild("leg7234", CubeListBuilder.create().texOffs(100, 90).addBox(-6.05F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.95F, 0.1667F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition leg72345 = leg7234.addOrReplaceChild("leg72345", CubeListBuilder.create().texOffs(86, 86).addBox(-5.0F, 0.0F, -2.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.05F, 0.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition leg8 = axis.addOrReplaceChild("leg8", CubeListBuilder.create().texOffs(38, 76).addBox(-16.0F, -1.25F, -1.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -9.75F, 8.5F, 0.7691F, 0.9018F, 1.0373F));

		PartDefinition cube_r17 = leg8.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(47, 92).addBox(-5.6F, -0.65F, -8.0F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(94, 54).addBox(-0.6F, 0.45F, -8.0F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5935F, -1.7849F, -6.5F, 0.0F, 3.1416F, 0.2182F));

		PartDefinition leg82 = leg8.addOrReplaceChild("leg82", CubeListBuilder.create().texOffs(0, 58).addBox(-20.0F, -1.75F, -1.5F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, 0.5F, 0.0F, 0.0F, 0.0F, -1.0472F));

		PartDefinition leg823 = leg82.addOrReplaceChild("leg823", CubeListBuilder.create().texOffs(60, 82).addBox(-13.0F, -1.8333F, -1.0F, 13.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 0.0833F, 0.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition leg8234 = leg823.addOrReplaceChild("leg8234", CubeListBuilder.create().texOffs(51, 98).addBox(-6.05F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.95F, 0.1667F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition leg82345 = leg8234.addOrReplaceChild("leg82345", CubeListBuilder.create().texOffs(88, 58).addBox(-5.0F, 0.0F, -2.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.05F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(WanderingSpiderEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(WanderAnimationDefinitions.WANDER_WALK, limbSwing, limbSwingAmount, 3.5f, 2.5f);
		this.animate(entity.idleAnimationState, WanderAnimationDefinitions.WANDER_IDLE, ageInTicks, 1f);
		this.animate(entity.attackAnimationState, WanderAnimationDefinitions.WANDER_ATTACK, ageInTicks, 1f);
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