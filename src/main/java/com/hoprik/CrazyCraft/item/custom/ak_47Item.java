package com.hoprik.CrazyCraft.item.custom;

import com.hoprik.CrazyCraft.Main;
import com.hoprik.CrazyCraft.util.coldown;
import com.hoprik.CrazyCraft.util.random;
import com.hoprik.CrazyCraft.util.sound.sound;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.command.impl.TeleportCommand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemFrameEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.EntityTeleportEvent;

import java.util.Random;

public class ak_47Item extends Item {
    Minecraft minecraft = Minecraft.getInstance();

    RayTraceResult hit;
    Entity attaking;

    public ak_47Item(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        if (coldown.tick == 0) {
            p_77659_1_.playSound(null, p_77659_2_.getX(), p_77659_2_.getY(), p_77659_2_.getZ(), sound.SHORT.get(), SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + 1 * 0.5F);
            pick(1, 50, p_77659_2_);
            //PlayerEntity player = (PlayerEntity) p_77659_1_.getServer().getLevel(p_77659_1_.dimension()).getEntity(p_77659_2_.getId());
            try {
                Entity entity = p_77659_1_.getEntity(attaking.getId());
                Main.LOGGER.info(entity);
                entity.hurt(DamageSource.GENERIC, 4);
                shake(p_77659_2_);
            }catch (Exception e){
            }

        }
        return super.use(p_77659_1_, p_77659_2_, p_77659_3_);

    }
    public static void shake(PlayerEntity p_77659_2_){
        int operator = com.hoprik.CrazyCraft.util.random.random(1,2);
        if (operator == 2) {
            int scatter = com.hoprik.CrazyCraft.util.random.random(1,20);
            ServerPlayerEntity serverPlayerEntity = p_77659_2_.getServer().getPlayerList().getPlayer(p_77659_2_.getUUID());
            serverPlayerEntity.teleportTo(serverPlayerEntity.getLevel(), serverPlayerEntity.getX(), serverPlayerEntity.getY(), serverPlayerEntity.getZ(), serverPlayerEntity.getViewYRot(0), serverPlayerEntity.getViewXRot(0) - scatter);
        }
        else{
            int scatter = com.hoprik.CrazyCraft.util.random.random(1,20);
            ServerPlayerEntity serverPlayerEntity = p_77659_2_.getServer().getPlayerList().getPlayer(p_77659_2_.getUUID());
            serverPlayerEntity.teleportTo(serverPlayerEntity.getLevel(), p_77659_2_.getX(), p_77659_2_.getY(), p_77659_2_.getZ(), serverPlayerEntity.getViewYRot(0), serverPlayerEntity.getViewXRot(0) + scatter);
        }
    }

    public void pick(float p_78473_1_, double distance , Entity player) {
        Entity entity = this.minecraft.getCameraEntity();
        for (Entity entityPlayer: player.level.players()) {
            if (entity == entityPlayer) {
                if (this.minecraft.level != null) {
                    this.minecraft.getProfiler().push("pick");
                    this.attaking = null;
                    double d0 = distance;
                    this.hit = entity.pick(d0, p_78473_1_, false);
                    Vector3d vector3d = entity.getEyePosition(p_78473_1_);
                    boolean flag = false;
                    int i = 3;
                    double d1 = d0;

                    d1 = d1 * d1;
                    if (this.minecraft.hitResult != null) {
                        d1 = this.hit.getLocation().distanceToSqr(vector3d);
                    }

                    Vector3d vector3d1 = entity.getViewVector(1.0F);
                    Vector3d vector3d2 = vector3d.add(vector3d1.x * d0, vector3d1.y * d0, vector3d1.z * d0);
                    float f = 1.0F;
                    AxisAlignedBB axisalignedbb = entity.getBoundingBox().expandTowards(vector3d1.scale(d0)).inflate(1.0D, 1.0D, 1.0D);
                    EntityRayTraceResult entityraytraceresult = ProjectileHelper.getEntityHitResult(entity, vector3d, vector3d2, axisalignedbb, (p_215312_0_) -> !p_215312_0_.isSpectator() && p_215312_0_.isPickable(), d1);
                    if (entityraytraceresult != null) {
                        Entity entity1 = entityraytraceresult.getEntity();
                        Vector3d vector3d3 = entityraytraceresult.getLocation();
                        double d2 = vector3d.distanceToSqr(vector3d3);
                        if (flag && d2 > 9.0D) {
                            this.hit = BlockRayTraceResult.miss(vector3d3, Direction.getNearest(vector3d1.x, vector3d1.y, vector3d1.z), new BlockPos(vector3d3));
                        } else if (d2 < d1 || this.minecraft.hitResult == null) {
                            this.hit = entityraytraceresult;
                            if (entity1 instanceof LivingEntity || entity1 instanceof ItemFrameEntity) {
                                this.attaking = entity1;
                            }
                        }
                    }

                    this.minecraft.getProfiler().pop();
                }
            }
        }
    }



}
