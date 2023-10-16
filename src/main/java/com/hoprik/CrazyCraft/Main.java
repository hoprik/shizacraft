package com.hoprik.CrazyCraft;

import com.hoprik.CrazyCraft.Mob.Mobs;
import com.hoprik.CrazyCraft.Mob.mobs.Smile1;
import com.hoprik.CrazyCraft.Mob.mobs.Smile2;
import com.hoprik.CrazyCraft.Mob.mobs.TyaletMonster;
import com.hoprik.CrazyCraft.Mob.render.Smile1Render;
import com.hoprik.CrazyCraft.Mob.render.Smile2Render;
import com.hoprik.CrazyCraft.Mob.render.TyaletMonsterRender;
import com.hoprik.CrazyCraft.block.custom.weaponBlocks;
import com.hoprik.CrazyCraft.item.Items;
import com.hoprik.CrazyCraft.util.sound.sound;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.renderer.entity.CatRenderer;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.*;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("cc")
public class Main {
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "cc";

    public Main() {


        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Items.registerItems(eventBus);
        com.hoprik.CrazyCraft.block.Blocks.registerBlocks(eventBus);
        weaponBlocks.registerBloc(eventBus);
        sound.registerSound(eventBus);
        Mobs.MobsRegister(eventBus);
        //Mobs.MobsRegister(eventBus);
        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);
        eventBus.addListener(this::final_setup);



        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);




        //Make sure the mod being absent on the other network side does not cause the client to display the server as incompatible
        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));
    }

    private void setup(final FMLCommonSetupEvent event) {
        //DeferredWorkQueue.runLater(()->{
        //    GlobalEntityTypeAttributes.put(Mobs.TYALET.get(), TyaletMonster.setCustomAttributes().build());
        //});
    }

    private void final_setup(final FMLLoadCompleteEvent event){
        playSound(sound.gimngermany.get(), 0, SoundCategory.MUSIC);
        LOGGER.info("yes");
    }

    @OnlyIn(Dist.CLIENT)
    public static void playSound(SoundEvent soundEvent, float pitch, SoundCategory categoryName)
    {
        SoundEvent sound = ForgeRegistries.SOUND_EVENTS.getValue(soundEvent.getLocation());
        Minecraft.getInstance().getSoundManager().play(new SimpleSound(sound == null ? sound.getLocation() : sound.getRegistryName(), categoryName, 0.25F, pitch, false, 0, ISound.AttenuationType.NONE, 0.0D, 0.0D, 0.0D, true));

        if(soundEvent == null)
        {
            LOGGER.log(Level.WARN, "Could not find sound but attempted to play anyway: {}", soundEvent.getLocation());
        }
    }
    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(Mobs.TYALET.get(), TyaletMonsterRender::new);
        RenderingRegistry.registerEntityRenderingHandler(Mobs.SMILE1.get(), Smile1Render::new);
        RenderingRegistry.registerEntityRenderingHandler(Mobs.SMILE2.get(), Smile2Render::new);
    }


    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m -> m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }

        @SubscribeEvent
        public static void RegisterAritebutes(EntityAttributeCreationEvent event){
            event.put(Mobs.TYALET.get(), TyaletMonster.setCustomAttributes().build());
            event.put(Mobs.SMILE1.get(), Smile1.setCustomAttributes().build());
            event.put(Mobs.SMILE2.get(), Smile2.setCustomAttributes().build());
        }

    }


    public static final ItemGroup CRAZY_GROUP = new ItemGroup("CrazyCraft") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.sword_alexandr_six.get());
        }


    };

}