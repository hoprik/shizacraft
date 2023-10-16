package com.hoprik.CrazyCraft.block.custom;

import com.hoprik.CrazyCraft.item.Items;
import com.hoprik.CrazyCraft.util.coldown;
import com.hoprik.CrazyCraft.util.sound.sound;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
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

public class oplata_block extends HorizontalBlock {
    public oplata_block(Properties p_i48377_1_) {
        super(p_i48377_1_);
    }

   private static final VoxelShape shape_n = Stream.of(
           Block.box(6.5, 0, 9, 8.5, 1.2, 9.5),
           Block.box(7.3, 0.7, 8, 7.8, 1.2, 8.5),
           Block.box(6.6, 0.7, 8, 7.1, 1.2, 8.5),
           Block.box(8, 0.7, 8, 8.5, 1.2, 8.5),
           Block.box(8, 0.7, 7.3, 8.5, 1.2, 7.8),
           Block.box(7.3, 0.7, 7.3, 7.8, 1.2, 7.8),
           Block.box(6.6, 0.7, 7.3, 7.1, 1.2, 7.8),
           Block.box(8, 0.7, 6.6, 8.5, 1.2, 7.1),
           Block.box(7.3, 0.7, 6.6, 7.8, 1.2, 7.1),
           Block.box(6.6, 0.7, 6.6, 7.1, 1.2, 7.1),
           Block.box(6, 0, 6.6, 6.1, 1.2, 9.1),
           Block.box(5.4, 0, 6, 8.9, 1, 10),
           Block.box(7, 0, 8, 8, 4, 9),
           Block.box(6, 0, 7, 9, 1, 10)

           ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape shape_w = Stream.of(
            Block.box(8.647023973654068, 3.2528091751032617, 7.5, 9.147023973654068, 4.452809175103262, 9.5),
            Block.box(7.647023973654068, 3.952809175103262, 8.2, 8.147023973654068, 4.452809175103262, 8.7),
            Block.box(7.647023973654068, 3.952809175103262, 8.9, 8.147023973654068, 4.452809175103262, 9.4),
            Block.box(7.647023973654068, 3.952809175103262, 7.5, 8.147023973654068, 4.452809175103262, 8),
            Block.box(6.9470239736540655, 3.952809175103262, 7.5, 7.4470239736540655, 4.452809175103262, 8),
            Block.box(6.9470239736540655, 3.952809175103262, 8.2, 7.4470239736540655, 4.452809175103262, 8.7),
            Block.box(6.9470239736540655, 3.952809175103262, 8.9, 7.4470239736540655, 4.452809175103262, 9.4),
            Block.box(6.247023973654061, 3.952809175103262, 7.5, 6.747023973654061, 4.452809175103262, 8),
            Block.box(6.247023973654061, 3.952809175103262, 8.2, 6.747023973654061, 4.452809175103262, 8.7),
            Block.box(6.247023973654061, 3.952809175103262, 8.9, 6.747023973654061, 4.452809175103262, 9.4),
            Block.box(6.247023973654066, 3.2528091751032617, 9.9, 8.747023973654066, 4.452809175103262, 10),
            Block.box(5.647023973654072, 3.2528091751032626, 7.1, 9.647023973654072, 4.252809175103263, 10.6),
            Block.box(7, 0, 8, 8, 4, 9),
            Block.box(6, 0, 7, 9, 1, 10)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();


    private static final VoxelShape shape_s = Stream.of(
            Block.box(6.5, 3.2528091751032617, 6.852976026345932, 8.5, 4.452809175103262, 7.352976026345932),
            Block.box(7.199999999999999, 3.952809175103262, 7.852976026345932, 7.699999999999999, 4.452809175103262, 8.352976026345932),
            Block.box(7.9, 3.952809175103262, 7.852976026345932, 8.4, 4.452809175103262, 8.352976026345932),
            Block.box(6.5, 3.952809175103262, 7.852976026345932, 7, 4.452809175103262, 8.352976026345932),
            Block.box(6.5, 3.952809175103262, 8.552976026345934, 7, 4.452809175103262, 9.052976026345934),
            Block.box(7.199999999999999, 3.952809175103262, 8.552976026345934, 7.699999999999999, 4.452809175103262, 9.052976026345934),
            Block.box(7.9, 3.952809175103262, 8.552976026345934, 8.4, 4.452809175103262, 9.052976026345934),
            Block.box(6.5, 3.952809175103262, 9.252976026345939, 7, 4.452809175103262, 9.752976026345939),
            Block.box(7.199999999999999, 3.952809175103262, 9.252976026345939, 7.699999999999999, 4.452809175103262, 9.752976026345939),
            Block.box(7.9, 3.952809175103262, 9.252976026345939, 8.4, 4.452809175103262, 9.752976026345939),
            Block.box(8.9, 3.2528091751032617, 7.252976026345934, 9, 4.452809175103262, 9.752976026345934),
            Block.box(6.1, 3.2528091751032626, 6.352976026345928, 9.6, 4.252809175103263, 10.352976026345928),
            Block.box(7, 0, 8, 8, 4, 9),
            Block.box(6, 0, 7, 9, 1, 10)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape shape_e = Stream.of(
            Block.box(5.852976026345932, 3.2528091751032617, 7.5, 6.352976026345932, 4.452809175103262, 9.5),
            Block.box(6.852976026345932, 3.952809175103262, 8.3, 7.352976026345932, 4.452809175103262, 8.8),
            Block.box(6.852976026345932, 3.952809175103262, 7.6, 7.352976026345932, 4.452809175103262, 8.1),
            Block.box(6.852976026345932, 3.952809175103262, 9, 7.352976026345932, 4.452809175103262, 9.5),
            Block.box(7.5529760263459345, 3.952809175103262, 9, 8.052976026345934, 4.452809175103262, 9.5),
            Block.box(7.5529760263459345, 3.952809175103262, 8.3, 8.052976026345934, 4.452809175103262, 8.8),
            Block.box(7.5529760263459345, 3.952809175103262, 7.6, 8.052976026345934, 4.452809175103262, 8.1),
            Block.box(8.252976026345939, 3.952809175103262, 9, 8.752976026345939, 4.452809175103262, 9.5),
            Block.box(8.252976026345939, 3.952809175103262, 8.3, 8.752976026345939, 4.452809175103262, 8.8),
            Block.box(8.252976026345939, 3.952809175103262, 7.6, 8.752976026345939, 4.452809175103262, 8.1),
            Block.box(6.252976026345934, 3.2528091751032617, 7, 8.752976026345934, 4.452809175103262, 7.1),
            Block.box(5.352976026345928, 3.2528091751032626, 6.4, 9.352976026345928, 4.252809175103263, 9.9),
            Block.box(7, 0, 8, 8, 4, 9),
            Block.box(6, 0, 7, 9, 1, 10)
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

    @Override
    public ActionResultType use(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        if(coldown.tick == 0){
            int a = 1;
            int b = 10;
            int x= a + (int)(Math.random() * ((b - a) + 1));
            switch (x){
                case 1:
                    p_225533_2_.playSound(null, p_225533_3_, sound.oplata_info_true.get(), SoundCategory.AMBIENT, 100, 0);
                case 2:
                    p_225533_2_.playSound(null, p_225533_3_, sound.oplata_info_true.get(), SoundCategory.AMBIENT, 100, 0);
                case 3:
                    p_225533_2_.playSound(null, p_225533_3_, sound.oplata_info_true.get(), SoundCategory.AMBIENT, 100, 0);
                case 4:
                    p_225533_2_.playSound(null, p_225533_3_, sound.oplata_info_true.get(), SoundCategory.AMBIENT, 100, 0);
                case 5:
                    p_225533_2_.playSound(null, p_225533_3_, sound.oplata_info_true.get(), SoundCategory.AMBIENT, 100, 0);
                case 6:
                    p_225533_2_.playSound(null, p_225533_3_, sound.oplata_info_true.get(), SoundCategory.AMBIENT, 100, 0);
                case 7:
                    p_225533_2_.playSound(null, p_225533_3_, sound.oplata_info_false.get(), SoundCategory.AMBIENT, 100, 0);
                case 8:
                    p_225533_2_.playSound(null, p_225533_3_, sound.oplata_info_true.get(), SoundCategory.AMBIENT, 100, 0);
                case 9:
                    p_225533_2_.playSound(null, p_225533_3_, sound.oplata_info_true.get(), SoundCategory.AMBIENT, 100, 0);
                case 10:
                    p_225533_2_.playSound(null, p_225533_3_, sound.oplata_info_true.get(), SoundCategory.AMBIENT, 100, 0);
                coldown.clodown(0.5);
            }

        }
        return super.use(p_225533_1_, p_225533_2_, p_225533_3_, p_225533_4_, p_225533_5_, p_225533_6_);
    }

}
