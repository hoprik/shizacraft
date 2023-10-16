package com.hoprik.CrazyCraft.item.custom;

import com.hoprik.CrazyCraft.util.sound.sound;
import com.sun.glass.ui.Screen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.IngameGui;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.client.gui.ForgeIngameGui;

public class builder extends Item {
    private long time;

    public builder(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        p_77659_2_.abilities.mayfly = true;;
        p_77659_2_.getCooldowns().addCooldown(this, 40);
        return super.use(p_77659_1_, p_77659_2_, p_77659_3_);
    }

}
