package com.hoprik.CrazyCraft.block;

import com.hoprik.CrazyCraft.Main;
import com.hoprik.CrazyCraft.block.custom.*;
import com.hoprik.CrazyCraft.item.Items;
import com.hoprik.CrazyCraft.item.custom.CustomTier;
import com.hoprik.CrazyCraft.item.custom.SwortBlockItem;
import com.hoprik.CrazyCraft.util.sound.sound;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.lwjgl.system.CallbackI;

import java.util.function.Supplier;

public class Blocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);

    public static final RegistryObject<Block> test_block = registryBlock("test_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.WOOL).harvestLevel(1).harvestTool(ToolType.PICKAXE).harvestLevel(5)));
    public static final RegistryObject<Block> skin_block = registryBlock("skin_block", () -> new SkinBlock(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).noOcclusion().harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> meme_block = registryBlock("meme_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.WOOL).harvestLevel(1)));
    public static final RegistryObject<Block> oplata_block = registryBlock("oplata_block", () -> new oplata_block(AbstractBlock.Properties.of(Material.HEAVY_METAL).noOcclusion()));
    public static final RegistryObject<Block> amogus_block = registryBlock("amogus_block", () -> new amogus(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.WOOL).harvestLevel(2)));
    public static final RegistryObject<Block> wall_block = registryBlock("wall_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> flower_block = registryBlock("flower_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> popka_block = registryBlock("popka_block", () -> new SkinBlock(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).noOcclusion().harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> BlockKatoriyNechegoNedelaet = registryBlock("blockkoterynechegonedelaet", ()-> new blockkoterynechegonedelaet(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> armik = registryBlock("armik", () -> new Block(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.ANVIL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> lega = registryBlock("lega", () -> new Block(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.ANVIL).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> leon = registryBlock("leon", () -> new SkinBlock(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).noOcclusion().harvestLevel(1).harvestTool(ToolType.PICKAXE)));

    private static<T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryBlockItems(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registryBlockItems(String name, Supplier<T> block){
        Items.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(Main.CRAZY_GROUP)));


    }
    public static void registerBlocks(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
