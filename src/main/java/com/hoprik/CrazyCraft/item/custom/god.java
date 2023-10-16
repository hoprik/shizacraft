package com.hoprik.CrazyCraft.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.GameType;
import net.minecraft.world.World;

public class god extends Item {
    private long time;

    public god(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        p_77659_2_.abilities.mayfly = true;
        p_77659_2_.abilities.invulnerable = true;
        p_77659_2_.abilities.instabuild = true;
        p_77659_2_.getCooldowns().addCooldown(this, 40);
        return super.use(p_77659_1_, p_77659_2_, p_77659_3_);
    }

}
