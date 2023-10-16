package com.hoprik.CrazyCraft.block.custom;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class BolnoBudet_esli_ypadit extends FallingBlock {

    public BolnoBudet_esli_ypadit(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }


    private static final VoxelShape shape_ns = Stream.of(
            Block.box(0, 0, 3, 16, 6, 13)).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape shape_we = Stream.of(
            Block.box(3, 0, 0, 13, 6, 16)).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();


    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        switch (p_220053_1_.getValue(BlockStateProperties.FACING)) {
            case NORTH:
                return shape_ns;
            case EAST:
                return shape_we;
            case SOUTH:
                return shape_ns;
            case WEST:
                return shape_we;
            default:
                return shape_ns;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(BlockStateProperties.FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return this.defaultBlockState().setValue(BlockStateProperties.FACING, p_196258_1_.getHorizontalDirection().getClockWise());
    }

    protected void falling(FallingBlockEntity p_149829_1_) {
        p_149829_1_.setHurtsEntities(true);
    }

    public void onLand(World p_176502_1_, BlockPos p_176502_2_, BlockState p_176502_3_, BlockState p_176502_4_, FallingBlockEntity p_176502_5_) {
        if (!p_176502_5_.isSilent()) {
            p_176502_1_.levelEvent(1031, p_176502_2_, 0);
        }

    }

    public void onBroken(World p_190974_1_, BlockPos p_190974_2_, FallingBlockEntity p_190974_3_) {
        if (!p_190974_3_.isSilent()) {
            p_190974_1_.levelEvent(1029, p_190974_2_, 0);
        }

    }
}
