package com.hoprik.CrazyCraft.util.world.dimishon;

import com.hoprik.CrazyCraft.block.Blocks;
import com.hoprik.CrazyCraft.block.custom.blockkoterynechegonedelaet;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class Teleporter implements ITeleporter {
    public static BlockPos thisPos = BlockPos.ZERO;
    public static boolean insideDimension = true;

    public Teleporter(BlockPos pos, boolean insideDim) {
        thisPos = pos;
        insideDimension = insideDim;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destinationWorld,
                              float yaw, Function<Boolean, Entity> repositionEntity) {
        entity = repositionEntity.apply(false);
        double y = 61;

        if (!insideDimension) {
            y = thisPos.getY();
        }

        BlockPos destinationPos = new BlockPos(thisPos.getX(), y, thisPos.getZ());

        int tries = 0;
        while ((destinationWorld.getBlockState(destinationPos).getMaterial() != Material.AIR) &&
                !destinationWorld.getBlockState(destinationPos).canBeReplaced(Fluids.WATER) &&
                destinationWorld.getBlockState(destinationPos.above()).getMaterial() != Material.AIR &&
                !destinationWorld.getBlockState(destinationPos.above()).canBeReplaced(Fluids.WATER) && tries < 25) {
            destinationPos = destinationPos.above(2);
            tries++;
        }

        entity.setPos(destinationPos.getX(), destinationPos.getY(), destinationPos.getZ());

        if (insideDimension) {
            boolean doSetBlock = true;
            for (BlockPos checkPos : BlockPos.betweenClosed(destinationPos.below(10).west(10), destinationPos.above(10).east(10))) {
                if (destinationWorld.getBlockState(checkPos).getBlock() instanceof blockkoterynechegonedelaet) {
                    doSetBlock = false;
                    break;
                }
            }
            if (doSetBlock) {
                for (double y_ = destinationPos.getY()-1; y_==destinationPos.getY()+2;y_++){
                    for (double x_ = destinationPos.getX()-1; x_==destinationPos.getX()+2;x_++){
                        for (double z_ = destinationPos.getZ()-1; z_==destinationPos.getZ()+2;z_++){
                            destinationWorld.destroyBlock(new BlockPos(x_,y_,z_), true);
                        }
                    }
                }
                destinationWorld.setBlock(destinationPos, Blocks.BlockKatoriyNechegoNedelaet.get().defaultBlockState(), 3);
            }
        }

        return entity;
    }
}
