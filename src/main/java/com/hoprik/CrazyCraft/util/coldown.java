package com.hoprik.CrazyCraft.util;


import com.hoprik.CrazyCraft.Main;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID)
public class coldown {
    public static boolean is_coldown = false;
    public static int tick = 0;
    public static double maxtick = 0;

    public static void clodown(double time){
        is_coldown = true;
        maxtick = time * 20;
    }

    @SubscribeEvent
    public static void tickTack (TickEvent.PlayerTickEvent event){
        if (is_coldown && tick <= maxtick && event.phase == TickEvent.Phase.END){
            tick++;
        }
        else if (tick > maxtick){
            is_coldown = false;
            tick = 0;
        }

    }
}
