package com.hoprik.CrazyCraft.Mob.render;

import com.hoprik.CrazyCraft.Main;
import com.hoprik.CrazyCraft.Mob.mobs.Smile2;
import com.hoprik.CrazyCraft.Mob.model.Smile2Model;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class Smile2Render extends MobRenderer<Smile2, Smile2Model<Smile2>> {


    private static final ResourceLocation SKIN = new ResourceLocation(Main.MOD_ID, "textures/entity/smile2.png");

    public Smile2Render(EntityRendererManager p_i50961_1_) {
        super(p_i50961_1_, new Smile2Model(), 0.75F);
    }

    @Override
    public ResourceLocation getTextureLocation(Smile2 p_110775_1_) {
        return SKIN;
    }
}
