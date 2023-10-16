package com.hoprik.CrazyCraft.item.custom;

import com.hoprik.CrazyCraft.util.coldown;
import com.hoprik.CrazyCraft.util.random;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import com.hoprik.CrazyCraft.item.Items.*;
import net.minecraftforge.fml.network.FMLPlayMessages;

public class telephone extends Item {
    private long time;

    public telephone(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        if (coldown.tick == 0) {
            int x = com.hoprik.CrazyCraft.util.random.random(1, 8);
            switch (x) {
                case (1):
                    int p = com.hoprik.CrazyCraft.util.random.random(1, 5);
                    switch (p) {
                        case (1):
                            p_77659_2_.inventory.add(new ItemStack(Items.DIAMOND_BLOCK));
                            break;
                        case (2):
                            p_77659_2_.inventory.add(new ItemStack(Items.ACACIA_LOG));
                            break;
                        case (3):
                            p_77659_2_.inventory.add(new ItemStack(Items.ANVIL));
                            break;
                        case (4):
                            p_77659_2_.inventory.add(new ItemStack(Items.DARK_OAK_LEAVES));
                            break;
                        case (5):
                            p_77659_2_.inventory.add(new ItemStack(Items.EMERALD_BLOCK));
                            break;
                    }
                case (2):
                    p_77659_2_.addEffect(new EffectInstance(new EffectInstance(Effects.MOVEMENT_SPEED)));
                case (3):
                    p_77659_2_.kill();
                case (4):
                    p_77659_2_.teleportTo(p_77659_2_.getX(), 500, p_77659_2_.getY());
                case (5):
                    p_77659_2_.sendMessage(new StringTextComponent("?"), p_77659_2_.getUUID());
                case (6):
                    p_77659_2_.setGameMode(GameType.CREATIVE);
                case (8):
                    p_77659_2_.setGameMode(GameType.SURVIVAL);
            }
            coldown.clodown(0.5);
        }
        p_77659_2_.getCooldowns().addCooldown(this, 90);
        return super.use(p_77659_1_, p_77659_2_, p_77659_3_);
    }

}
