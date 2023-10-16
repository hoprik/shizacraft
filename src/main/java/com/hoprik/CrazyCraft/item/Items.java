package com.hoprik.CrazyCraft.item;

import com.hoprik.CrazyCraft.Main;
import com.hoprik.CrazyCraft.Mob.Mobs;
import com.hoprik.CrazyCraft.item.custom.*;
import com.hoprik.CrazyCraft.util.sound.sound;
import net.minecraft.item.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.lwjgl.system.CallbackI;

public class Items {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);

    public static final RegistryObject<Item> kirpach = ITEMS.register("bolno_budet_esli_ypadit", () -> new SwordItem(CustomTier.AMETHYST, 9999, 999, new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> phone = ITEMS.register("telephone", () -> new telephone(new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> kostil = ITEMS.register("kostil", ()-> new SwordItem(CustomTier.AMETHYST, 9999, 999, new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> sword_alexandr_six = ITEMS.register("sword_alexandr_six", () -> new SwordItem(CustomTier.AMETHYST, 9999, 999, new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> best_small_sword = ITEMS.register("best_small_sword", () -> new SwordItem(CustomTier.SMALL,-1,9999999, new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> best_safe_sword = ITEMS.register("best_safe_sword", () -> new SwordItem(CustomTier.SMALL,-99999,-999, new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> gimnrossi = ITEMS.register("gimnrossi_disk", () -> new MusicDiscItem(1, () -> sound.gimnrossin.get(), new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> tinkoff_cart = ITEMS.register("tinkoff_cart", () -> new Item(new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> ak_47 = ITEMS.register("ak_47", () -> new ak_47Item(new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> sto_rublei = ITEMS.register("sto_rublei", () -> new MusicDiscItem(1, () -> sound.gimnrossin.get(), new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> gimn_germany = ITEMS.register("gimn_germany", () -> new MusicDiscItem(2, () -> sound.gimngermany.get(), new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> gimn_ykraina = ITEMS.register("gimn_ykraina", () ->new MusicDiscItem(3, () -> sound.gimnykraina.get(), new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> creative = ITEMS.register("creative", () -> new creative(new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> survail = ITEMS.register("survail", () -> new survail(new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> otherside_disk = ITEMS.register("otherside", () -> new MusicDiscItem(2, () -> sound.otherside.get(), new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> builder_craft = ITEMS.register("builder", () -> new builder(new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> god_craft = ITEMS.register("god", () -> new god(new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> loteria = ITEMS.register("loteria", () -> new Item(new Item.Properties().tab(Main.CRAZY_GROUP)));
    //public static final RegistryObject<Item> SpawnEggToiletMonster = ITEMS.register("spawneggtoiletmonster", () -> new SpawnEgg(Mobs.TYALET, 0x722600, 0x712D3A,new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> shavyha = ITEMS.register("shavuha", ()-> new Item(new Item.Properties().food(new Food.Builder().alwaysEat().nutrition(100).saturationMod(100F).fast().meat().build()).tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> perchantki = ITEMS.register("perchatki", () -> new SwordItem(CustomTier.perchantki, 1, 1, new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> gimnrossinlast = ITEMS.register("gimnrossinlast", () ->new MusicDiscItem(3, () -> sound.gimnrossinlast.get(), new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> plsFixKirka = ITEMS.register("plsfixkirka", () -> new PickaxeItem(CustomTier.AMETHYST, 99999, 9999, new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> palochkaveruchalocha = ITEMS.register("palachviruchalochka", () -> new DebugStickItem(new Item.Properties().tab(Main.CRAZY_GROUP)));
    public static final RegistryObject<Item> smartkirachka = ITEMS.register("smartkirachka", () -> new PickaxeItem(CustomTier.PIXAXESBORXHIK, 1, 1, new Item.Properties().tab(Main.CRAZY_GROUP)));

    public static void registerItems(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
