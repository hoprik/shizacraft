package com.hoprik.CrazyCraft.util;


import com.hoprik.CrazyCraft.Main;
import com.hoprik.CrazyCraft.item.Items;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID)
public class eventRazn {
    @SubscribeEvent
    public static void smartkirochka(BlockEvent.BreakEvent event){
        BlockState block = event.getState().getBlockState();
        if (event.getPlayer().getItemInHand(Hand.MAIN_HAND).getItem() == Items.smartkirachka.get()){
            if (block == Blocks.IRON_ORE.defaultBlockState()){
                event.setCanceled(true);
                event.getWorld().destroyBlock(event.getPos(), false);
                event.getPlayer().addItem(new ItemStack(net.minecraft.item.Items.IRON_INGOT));
            }
            else if (block == Blocks.GOLD_ORE.defaultBlockState()){
                event.setCanceled(true);
                event.getWorld().destroyBlock(event.getPos(), false);
                event.getPlayer().addItem(new ItemStack(net.minecraft.item.Items.GOLD_INGOT));
            }
            else if (block == Blocks.ANCIENT_DEBRIS.defaultBlockState()){
                event.setCanceled(true);
                event.getWorld().destroyBlock(event.getPos(), false);
                event.getPlayer().addItem(new ItemStack(net.minecraft.item.Items.NETHERITE_SCRAP));
            }
        }
    }
}
