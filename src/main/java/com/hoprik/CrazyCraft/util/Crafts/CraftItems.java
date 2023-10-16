package com.hoprik.CrazyCraft.util.Crafts;

import com.hoprik.CrazyCraft.Main;
import com.hoprik.CrazyCraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = Main.MOD_ID)
public class CraftItems {

    @SubscribeEvent
    public static void Craft(ItemTossEvent event){
        BlockPos Blockpos = new BlockPos(event.getEntityItem().getX(), event.getEntityItem().getY(), event.getEntityItem().getZ());
        Item getDropItem = event.getEntityItem().getItem().getItem();
            if (CraftGrid.items[0] != null) {
                CraftGrid.items[1] = getDropItem;
                if (Objects.equals(CraftGrid.blockPos, Blockpos)){
                    for (Item[] item : CraftGrid.recipes) {
                        if (item[0] == CraftGrid.items[0] && item[1] == CraftGrid.items[1]){
                            event.getPlayer().addItem(new ItemStack(item[2]));
                            event.getEntityItem().kill(); event.getEntity().level.getEntity(CraftGrid.id[0]).kill();
                            break;
                        }
                    }
                    CraftGrid.items[0] = null; CraftGrid.items[1] = null; CraftGrid.blockPos = null; CraftGrid.id[0] = 0;
                }
            }
            else {
                CraftGrid.items[0] = getDropItem;
                CraftGrid.blockPos = Blockpos;
                CraftGrid.id[0] = event.getEntityItem().getId();
            }
        }
}
