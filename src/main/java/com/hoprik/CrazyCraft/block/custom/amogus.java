package com.hoprik.CrazyCraft.block.custom;

import com.hoprik.CrazyCraft.util.coldown;
import com.hoprik.CrazyCraft.util.sound.sound;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class amogus extends Block {
    public amogus(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    @Override
    public ActionResultType use(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        if (coldown.tick == 0){
            p_225533_2_.playSound(p_225533_4_, p_225533_3_, sound.amogus.get(), SoundCategory.BLOCKS,100, 0);
            coldown.clodown(1);
        }
        return super.use(p_225533_1_, p_225533_2_, p_225533_3_, p_225533_4_, p_225533_5_, p_225533_6_);
    }

}
