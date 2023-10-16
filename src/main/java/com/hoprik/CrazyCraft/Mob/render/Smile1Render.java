package com.hoprik.CrazyCraft.Mob.render;

import com.hoprik.CrazyCraft.Main;
import com.hoprik.CrazyCraft.Mob.mobs.Smile1;
import com.hoprik.CrazyCraft.Mob.mobs.TyaletMonster;
import com.hoprik.CrazyCraft.Mob.model.Smile1Model;
import com.hoprik.CrazyCraft.Mob.model.TyaletMonsterModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class Smile1Render extends MobRenderer<Smile1, Smile1Model<Smile1>> {


    private static final ResourceLocation SKIN = new ResourceLocation(Main.MOD_ID, "textures/entity/smile1.png");

    public Smile1Render(EntityRendererManager p_i50961_1_) {
        super(p_i50961_1_, new Smile1Model(), 0.75F);
    }

    @Override
    public ResourceLocation getTextureLocation(Smile1 p_110775_1_) {
        return SKIN;
    }
}
