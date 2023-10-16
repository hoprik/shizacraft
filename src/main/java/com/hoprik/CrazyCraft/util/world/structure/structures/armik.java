package com.hoprik.CrazyCraft.util.world.structure.structures;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class armik extends Structure<NoFeatureConfig> {
    public armik(Codec<NoFeatureConfig> p_i231997_1_) {
        super(p_i231997_1_);
    }

    @Override
    public IStartFactory<NoFeatureConfig> getStartFactory() {
        return null;
    }

    @Override
    public GenerationStage.Decoration step() {
        return GenerationStage.Decoration.SURFACE_STRUCTURES;
    }

    @Override
    protected boolean isFeatureChunk(ChunkGenerator p_230363_1_, BiomeProvider p_230363_2_, long p_230363_3_,
                                     SharedSeedRandom p_230363_5_, int p_230363_6_, int p_230363_7_,
                                     Biome p_230363_8_, ChunkPos p_230363_9_, NoFeatureConfig p_230363_10_) {
        BlockPos pos_Center = new BlockPos((p_230363_6_ << 4)+7, 0, (p_230363_7_ << 4)+7);

        int landHeight = p_230363_1_.getBaseHeight(pos_Center.getX(), pos_Center.getZ(), Heightmap.Type.WORLD_SURFACE_WG);

        IBlockReader blockReader = p_230363_1_.getBaseColumn(pos_Center.getX(), pos_Center.getZ());
        BlockState state = blockReader.getBlockState(pos_Center.above(landHeight));

        return state.getFluidState().isEmpty();
    }

    public static class StartCreate extends StructureStart<NoFeatureConfig>{

        public StartCreate(Structure<NoFeatureConfig> p_i225876_1_, int p_i225876_2_, int p_i225876_3_,
                           MutableBoundingBox p_i225876_4_, int p_i225876_5_, long p_i225876_6_) {
            super(p_i225876_1_, p_i225876_2_, p_i225876_3_, p_i225876_4_, p_i225876_5_, p_i225876_6_);
        }

        @Override
        public void generatePieces(DynamicRegistries registry, ChunkGenerator chunkGen, TemplateManager templateManager, int chunkX, int chunkZ, Biome biome, NoFeatureConfig featureConfig) {
            int x = (chunkX<<4)+7;
            int z = (chunkZ<<4)+7;

            BlockPos pos = new BlockPos(x, 0, z);
        }
    }
}
