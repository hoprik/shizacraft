package com.hoprik.CrazyCraft.Mob.model;

import com.hoprik.CrazyCraft.Mob.mobs.TyaletMonster;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TyaletMonsterModel <T extends TyaletMonster> extends EntityModel<T> {
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;

	public TyaletMonsterModel() {
		texWidth = 32;
		texHeight = 32;

		bb_main = new ModelRenderer(this);
		bb_main.setPos(0.0F, 24.0F, 0.0F);
		bb_main.texOffs(9, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(-2.5F, -4.0F, -2.5F, 5.0F, 1.0F, 4.0F, 0.0F, false);
		bb_main.texOffs(14, 0).addBox(1.5F, -5.0F, -2.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bb_main.texOffs(13, 6).addBox(-2.5F, -5.0F, -2.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bb_main.texOffs(0, 9).addBox(-2.5F, -9.0F, 0.5F, 5.0F, 5.0F, 1.0F, 0.0F, false);
		bb_main.texOffs(12, 10).addBox(-1.5F, -5.0F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, -5.0F, 0.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.5236F, 0.0F, 0.0F);
		cube_r1.texOffs(0, 5).addBox(-2.5F, -1.0F, -2.75F, 5.0F, 1.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}