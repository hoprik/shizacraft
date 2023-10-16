package com.hoprik.CrazyCraft.util.sound;

import com.hoprik.CrazyCraft.Main;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class sound {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Main.MOD_ID);

    public static final RegistryObject<SoundEvent> gimnrossin = RegisterSoundEvent("gimnrossin");
    public static final RegistryObject<SoundEvent> gimngermany = RegisterSoundEvent("gimngermany");
    public static final RegistryObject<SoundEvent> gimnrossinlast = RegisterSoundEvent("gimnrossinlast");
    public static final RegistryObject<SoundEvent> gimnykraina = RegisterSoundEvent("gimnykraina");
    public static final RegistryObject<SoundEvent> otherside = RegisterSoundEvent("otherside");
    public static final RegistryObject<SoundEvent> oplata_info_true = RegisterSoundEvent("oplata_info_true");
    public static final RegistryObject<SoundEvent> oplata_info_false = RegisterSoundEvent("oplata_info_false");
    public static final RegistryObject<SoundEvent> amogus = RegisterSoundEvent("amogus");
    public static final RegistryObject<SoundEvent> SHORT = RegisterSoundEvent("short");

    private static RegistryObject<SoundEvent> RegisterSoundEvent(String name){
        return SOUNDS.register(name, ()-> new SoundEvent(new ResourceLocation(Main.MOD_ID, name)));
    }


    public static void registerSound(IEventBus eventBus){
        SOUNDS.register(eventBus);
    }
}
