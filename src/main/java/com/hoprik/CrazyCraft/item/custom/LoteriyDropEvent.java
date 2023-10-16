package com.hoprik.CrazyCraft.item.custom;


import com.hoprik.CrazyCraft.Main;
import com.hoprik.CrazyCraft.item.Items;
import com.hoprik.CrazyCraft.util.random;
import com.hoprik.CrazyCraft.util.sound.sound;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.GameType;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID)
public class LoteriyDropEvent {

    @SubscribeEvent
    public static void loteria(ItemTossEvent event){
        int x = random.random(1, 5);
        if (event.getEntityItem().getItem().getItem() == Items.loteria.get()){
            switch (x){
                case 1:
                    event.getEntity().getCommandSenderWorld().playSound(event.getPlayer(), new BlockPos(event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ()), sound.amogus.get(), SoundCategory.BLOCKS, 1, 0);
                    break;
                case 2:
                    event.getEntity().getCommandSenderWorld().setBlock(new BlockPos(event.getPlayer().getX(), event.getPlayer().getY()+10, event.getPlayer().getZ()), Blocks.ANVIL.defaultBlockState(), 3);
                    break;
                case 3:
                    event.getPlayer().sendMessage(new StringTextComponent("no"), event.getPlayer().getUUID());
                    break;
                case 4:
                    event.getPlayer().setGameMode(GameType.ADVENTURE);
                    event.getPlayer().sendMessage(new StringTextComponent("your gamemode adventure!"), event.getPlayer().getUUID());
                    break;
                case 5:
                    event.getPlayer().addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 10, 10));
                    break;
                case 6:
                    event.getPlayer().setScore(9999);
                    break;
                case 7:
                    event.getPlayer().playSound(sound.amogus.get(), 1,100);
            }

        }

    }
}
