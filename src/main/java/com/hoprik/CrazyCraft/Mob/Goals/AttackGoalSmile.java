package com.hoprik.CrazyCraft.Mob.Goals;

import com.hoprik.CrazyCraft.Main;
import com.hoprik.CrazyCraft.Mob.Mobs;
import com.hoprik.CrazyCraft.Mob.mobs.Smile1;
import com.hoprik.CrazyCraft.Mob.mobs.Smile2;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.MonsterEntity;

public class AttackGoalSmile extends MeleeAttackGoal{
    private final MonsterEntity zombie;
    private int raiseArmTicks;

    public AttackGoalSmile(MonsterEntity p_i46803_1_, double p_i46803_2_, boolean p_i46803_4_) {
        super(p_i46803_1_, p_i46803_2_, p_i46803_4_);
        this.zombie = p_i46803_1_;
    }

    public void start() {
        super.start();
        this.raiseArmTicks = 0;
        Smile2 smile2 = new Smile2(Mobs.SMILE2.get(), zombie.level);
        smile2.setPos(zombie.getX(), zombie.getY(), zombie.getZ());
        zombie.level.addFreshEntity(smile2);
    }

    public void stop() {
        super.stop();
        this.zombie.setAggressive(false);
    }

    public void tick() {
        super.tick();
        ++this.raiseArmTicks;
        if (this.raiseArmTicks >= 5 && this.getTicksUntilNextAttack() < this.getAttackInterval() / 2) {
            this.zombie.setAggressive(true);
        } else {
            this.zombie.setAggressive(false);
        }

    }
}
