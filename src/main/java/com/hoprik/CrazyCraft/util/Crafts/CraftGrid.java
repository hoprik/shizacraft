package com.hoprik.CrazyCraft.util.Crafts;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;

public class CraftGrid {
    public static Item[] items = {null, null};
    public static BlockPos blockPos = null;
    public static int[] id = {0};

    public static Item[][] recipes = {
            {Items.REDSTONE.getItem(), Items.IRON_BARS.getItem(), com.hoprik.CrazyCraft.item.Items.phone.get()}, {Items.IRON_BARS.getItem(), Items.REDSTONE.getItem(),  com.hoprik.CrazyCraft.item.Items.phone.get()},
            {com.hoprik.CrazyCraft.item.Items.phone.get(), Items.IRON_BLOCK.getItem(), com.hoprik.CrazyCraft.item.Items.kirpach.get()}, {Items.IRON_BLOCK.getItem(), com.hoprik.CrazyCraft.item.Items.phone.get(), com.hoprik.CrazyCraft.item.Items.kirpach.get()},
            {com.hoprik.CrazyCraft.item.Items.kirpach.get(), Items.COAL.getItem(), Items.DIAMOND_PICKAXE.getItem()}, {Items.COAL.getItem(), com.hoprik.CrazyCraft.item.Items.kirpach.get(), Items.DIAMOND_PICKAXE.getItem()},
    };



}
