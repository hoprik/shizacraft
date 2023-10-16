package com.hoprik.CrazyCraft.block.custom;

import com.hoprik.CrazyCraft.util.world.dimishon.Teleporter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.Dimension;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class blockkoterynechegonedelaet extends Block {
    public blockkoterynechegonedelaet(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    @Override
    public ActionResultType use(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        if (!p_225533_2_.isClientSide()) {
            if (!p_225533_4_.isCrouching()) {
                MinecraftServer server = p_225533_2_.getServer();

                if (server != null) {
                    if (p_225533_2_.dimension() == World.NETHER) {
                        ServerWorld overWorld = server.getLevel(World.OVERWORLD);
                        if (overWorld != null) {
                            p_225533_4_.changeDimension(overWorld, new Teleporter(p_225533_3_, false));
                        }
                    } else {
                        ServerWorld kjDim = server.getLevel(World.NETHER);
                        if (kjDim != null) {
                            p_225533_4_.changeDimension(kjDim, new Teleporter(p_225533_3_, true));
                        }
                    }
                    return ActionResultType.SUCCESS;
                }
            }
        }
        return super.use(p_225533_1_, p_225533_2_, p_225533_3_, p_225533_4_, p_225533_5_, p_225533_6_);
    }
}
