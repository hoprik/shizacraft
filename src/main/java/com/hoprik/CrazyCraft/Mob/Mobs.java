package com.hoprik.CrazyCraft.Mob;

import com.hoprik.CrazyCraft.Main;
import com.hoprik.CrazyCraft.Mob.mobs.Smile1;
import com.hoprik.CrazyCraft.Mob.mobs.Smile2;
import com.hoprik.CrazyCraft.Mob.mobs.TyaletMonster;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Mobs {

    public static final DeferredRegister<EntityType<?>> MOBS = DeferredRegister.create(ForgeRegistries.ENTITIES, Main.MOD_ID);

    public static final RegistryObject<EntityType<TyaletMonster>> TYALET = MOBS.register("tyaletmonster", () -> EntityType.Builder.of(TyaletMonster::new,
            EntityClassification.MONSTER).sized(1f, 1f).build(new ResourceLocation(Main.MOD_ID, "tyaletmonster").toString()));

    public static final RegistryObject<EntityType<Smile1>> SMILE1 = MOBS.register("smile1", () -> EntityType.Builder.of(Smile1::new,
            EntityClassification.MONSTER).sized(1f, 1f).build(new ResourceLocation(Main.MOD_ID, "smile1").toString()));

    public static final RegistryObject<EntityType<Smile2>> SMILE2 = MOBS.register("smile2", () -> EntityType.Builder.of(Smile2::new,
            EntityClassification.MONSTER).sized(1f, 1f).build(new ResourceLocation(Main.MOD_ID, "smile2").toString()));


    public static void MobsRegister(IEventBus eventBus) {
        MOBS.register(eventBus);
    }

}
