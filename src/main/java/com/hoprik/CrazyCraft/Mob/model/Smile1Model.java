package com.hoprik.CrazyCraft.Mob.model;// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.hoprik.CrazyCraft.Mob.mobs.Smile1;
import com.hoprik.CrazyCraft.Mob.mobs.Smile2;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class Smile1Model<T extends Smile1> extends EntityModel<T>{
	private final ModelRenderer bone;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;

	public Smile1Model() {
		texWidth = 256;
		texHeight = 256;

		bone = new ModelRenderer(this);
		bone.setPos(0.0F, 15.0761F, 0.0F);
		bone.texOffs(0, 32).addBox(-13.0F, -10.0761F, -8.0F, 26.0F, 16.0F, 16.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(-25.992F, -19.0F, -15.7F);
		bone.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 2.4696F);
		cube_r1.texOffs(84, 35).addBox(-15.0365F, -43.887F, 7.95F, 7.0F, 3.0F, 16.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(-25.992F, -19.0F, -15.7F);
		bone.addChild(cube_r2);
		setRotationAngle(cube_r2, -1.5708F, 0.8988F, 1.5708F);
		cube_r2.texOffs(64, 83).addBox(-7.021F, -37.5112F, -34.092F, 7.0F, 3.0F, 16.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(-25.992F, -19.0F, -15.7F);
		bone.addChild(cube_r3);
		setRotationAngle(cube_r3, 1.5708F, -0.8988F, 1.5708F);
		cube_r3.texOffs(68, 16).addBox(17.6311F, -17.902F, 18.092F, 7.0F, 3.0F, 16.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(-25.992F, -19.0F, -15.7F);
		bone.addChild(cube_r4);
		setRotationAngle(cube_r4, -3.1416F, 0.0F, 0.672F);
		cube_r4.texOffs(64, 64).addBox(25.7249F, -11.464F, -23.95F, 7.0F, 3.0F, 16.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(-25.992F, -19.0F, -15.7F);
		bone.addChild(cube_r5);
		setRotationAngle(cube_r5, -3.1416F, 0.0F, -2.4696F);
		cube_r5.texOffs(94, 73).addBox(-36.1696F, -17.3191F, -23.85F, 7.0F, 3.0F, 16.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(-12.996F, -10.038F, -7.85F);
		bone.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, -0.672F);
		cube_r6.texOffs(94, 54).addBox(0.0F, 0.0F, 0.0F, 7.0F, 3.0F, 16.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(-12.996F, -10.038F, -7.85F);
		bone.addChild(cube_r7);
		setRotationAngle(cube_r7, -1.5708F, 0.8988F, -1.5708F);
		cube_r7.texOffs(94, 92).addBox(-16.3534F, -13.0081F, 4.996F, 7.0F, 3.0F, 16.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(-12.996F, -10.038F, -7.85F);
		bone.addChild(cube_r8);
		setRotationAngle(cube_r8, 1.5708F, -0.8988F, -1.5708F);
		cube_r8.texOffs(98, 0).addBox(-4.1447F, -3.2968F, -20.996F, 7.0F, 3.0F, 16.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setPos(-12.996F, -10.038F, -7.85F);
		bone.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, -1.5708F, 0.0F);
		cube_r9.texOffs(0, 64).addBox(-0.15F, -4.038F, -20.996F, 16.0F, 25.0F, 16.0F, 0.0F, false);
		cube_r9.texOffs(0, 0).addBox(-5.15F, -0.038F, -20.996F, 26.0F, 16.0F, 16.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

	}
	

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}