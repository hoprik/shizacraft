package com.hoprik.CrazyCraft.block.custom;

import com.hoprik.CrazyCraft.Main;
import com.hoprik.CrazyCraft.item.Items;
import com.hoprik.CrazyCraft.item.custom.CustomTier;
import com.hoprik.CrazyCraft.item.custom.SwortBlockItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class weaponBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);

    public static final RegistryObject<Block> bolnoBudet = registryBlock("bolno_budet_esli_ypadi", () -> new BolnoBudet_esli_ypadit(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops().strength(2f).noOcclusion()));

    private static<T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryBlockItems(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registryBlockItems(String name, Supplier<T> block){
        Items.ITEMS.register(name, () -> new SwortBlockItem(CustomTier.AMETHYST, 999, 999 ,block.get(), new Item.Properties().tab(Main.CRAZY_GROUP)));


    }
    public static void registerBloc(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
