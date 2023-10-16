package com.hoprik.CrazyCraft.Mob.render;

import com.hoprik.CrazyCraft.Main;
import com.hoprik.CrazyCraft.Mob.mobs.TyaletMonster;
import com.hoprik.CrazyCraft.Mob.model.TyaletMonsterModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class TyaletMonsterRender extends MobRenderer<TyaletMonster, TyaletMonsterModel<TyaletMonster>> {


    private static final ResourceLocation SKIN = new ResourceLocation(Main.MOD_ID, "textures/entity/toiletmonster.png");

    public TyaletMonsterRender(EntityRendererManager p_i50961_1_) {
        super(p_i50961_1_, new TyaletMonsterModel(), 0.75F);
    }

    @Override
    public ResourceLocation getTextureLocation(TyaletMonster p_110775_1_) {
        return SKIN;
    }
}
