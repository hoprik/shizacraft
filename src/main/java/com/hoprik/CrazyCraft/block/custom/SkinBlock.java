package com.hoprik.CrazyCraft.block.custom;


import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class SkinBlock extends HorizontalBlock {

    public SkinBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    private static final VoxelShape shape_n = Stream.of(
            Block.box(1, 1, 1, 15, 2, 15),
            Block.box(4.305730223866991, 24, 3.62413702220808, 12.305730223866991, 32, 11.62413702220808),
            Block.box(4.305730223866991, 23.5, 3.62413702220808, 12.305730223866991, 31.5, 11.62413702220808),
            Block.box(4, 12, 5, 12, 24, 9),
            Block.box(4, 12, 5, 12, 24, 9),
            Block.box(11, 10.034203399170494, -0.41006637696246884, 15, 22.034203399170494, 3.589933623037533),
            Block.box(11, 10.034203399170494, -0.41006637696246884, 15, 22.034203399170494, 3.589933623037533),
            Block.box(1, 10.965796600829506, 11.589933623037581, 5, 22.965796600829506, 15.589933623037581),
            Block.box(1, 10.965796600829506, 11.589933623037581, 5, 22.965796600829506, 15.589933623037581),
            Block.box(7.9, 0.9657966008294601, 6.589933623037533, 11.9, 12.96579660082946, 10.589933623037533),
            Block.box(7.9, 0.9657966008294601, 6.589933623037533, 11.9, 12.96579660082946, 10.589933623037533),
            Block.box(4.1, 0.034203399170541715, 2.589933623037533, 8.1, 12.034203399170542, 6.589933623037533),
            Block.box(4.1, 0.034203399170541715, 2.589933623037533, 8.1, 12.034203399170542, 6.589933623037533),
            Block.box(0, 0, 0, 16, 1, 16)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape shape_w = Stream.of(
            Block.box(1, 1, 1, 15, 2, 15),
            Block.box(3.547496280988991, 24, 3.579568801169552, 11.547496280988991, 32, 11.579568801169552),
            Block.box(3.547496280988991, 23.5, 3.579568801169552, 11.547496280988991, 31.5, 11.579568801169552),
            Block.box(5, 12, 4, 9, 24, 12),
            Block.box(5, 12, 4, 9, 24, 12),
            Block.box(-1.921769989550647, 9.63405067112435, 1, 2.078230010449353, 21.63405067112435, 5),
            Block.box(-1.921769989550647, 9.63405067112435, 1, 2.078230010449353, 21.63405067112435, 5),
            Block.box(13.139697469370127, 10.75698558896594, 11, 17.139697469370127, 22.75698558896594, 15),
            Block.box(13.139697469370127, 10.75698558896594, 11, 17.139697469370127, 22.75698558896594, 15),
            Block.box(8.139697469370077, 0.7569855889658772, 4.099999999999998, 12.139697469370077, 12.756985588965877, 8.099999999999998),
            Block.box(8.139697469370077, 0.7569855889658772, 4.099999999999998, 12.139697469370077, 12.756985588965877, 8.099999999999998),
            Block.box(1.078230010449353, -0.36594932887558684, 7.899999999999999, 5.078230010449353, 11.634050671124413, 11.899999999999999),
            Block.box(1.078230010449353, -0.36594932887558684, 7.899999999999999, 5.078230010449353, 11.634050671124413, 11.899999999999999),
            Block.box(0, 0, 0, 16, 1, 16)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape shape_s = Stream.of(
            Block.box(1, 1, 1, 15, 2, 15),
            Block.box(3.579568801169552, 24, 4.452503719011009, 11.579568801169552, 32, 12.452503719011009),
            Block.box(3.579568801169552, 23.5, 4.452503719011009, 11.579568801169552, 31.5, 12.452503719011009),
            Block.box(4, 12, 7, 12, 24, 11),
            Block.box(4, 12, 7, 12, 24, 11),
            Block.box(1, 9.63405067112435, 13.921769989550647, 5, 21.63405067112435, 17.921769989550647),
            Block.box(1, 9.63405067112435, 13.921769989550647, 5, 21.63405067112435, 17.921769989550647),
            Block.box(11, 10.75698558896594, -1.1396974693701267, 15, 22.75698558896594, 2.8603025306298733),
            Block.box(11, 10.75698558896594, -1.1396974693701267, 15, 22.75698558896594, 2.8603025306298733),
            Block.box(4.099999999999998, 0.7569855889658772, 3.860302530629923, 8.099999999999998, 12.756985588965877, 7.860302530629923),
            Block.box(4.099999999999998, 0.7569855889658772, 3.860302530629923, 8.099999999999998, 12.756985588965877, 7.860302530629923),
            Block.box(7.899999999999999, -0.36594932887558684, 10.921769989550647, 11.899999999999999, 11.634050671124413, 14.921769989550647),
            Block.box(7.899999999999999, -0.36594932887558684, 10.921769989550647, 11.899999999999999, 11.634050671124413, 14.921769989550647),
            Block.box(0, 0, 0, 16, 1, 16)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape shape_e = Stream.of(
            Block.box(1, 1, 1, 15, 2, 15),
            Block.box(4.452503719011009, 24, 4.420431198830448, 12.452503719011009, 32, 12.420431198830448),
            Block.box(4.452503719011009, 23.5, 4.420431198830448, 12.452503719011009, 31.5, 12.420431198830448),
            Block.box(7, 12, 4, 11, 24, 12),
            Block.box(7, 12, 4, 11, 24, 12),
            Block.box(13.921769989550647, 9.63405067112435, 11, 17.921769989550647, 21.63405067112435, 15),
            Block.box(13.921769989550647, 9.63405067112435, 11, 17.921769989550647, 21.63405067112435, 15),
            Block.box(-1.1396974693701267, 10.75698558896594, 1, 2.8603025306298733, 22.75698558896594, 5),
            Block.box(-1.1396974693701267, 10.75698558896594, 1, 2.8603025306298733, 22.75698558896594, 5),
            Block.box(3.860302530629923, 0.7569855889658772, 7.900000000000002, 7.860302530629923, 12.756985588965877, 11.900000000000002),
            Block.box(3.860302530629923, 0.7569855889658772, 7.900000000000002, 7.860302530629923, 12.756985588965877, 11.900000000000002),
            Block.box(10.921769989550647, -0.36594932887558684, 4.100000000000001, 14.921769989550647, 11.634050671124413, 8.100000000000001),
            Block.box(10.921769989550647, -0.36594932887558684, 4.100000000000001, 14.921769989550647, 11.634050671124413, 8.100000000000001),
            Block.box(0, 0, 0, 16, 1, 16)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        switch (p_220053_1_.getValue(BlockStateProperties.FACING)){
            case NORTH:
                return shape_n;
            case WEST:
                return shape_w;
            case SOUTH:
                return shape_s;
            case EAST:
                return shape_e;
            default:
                return shape_n;
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

}
