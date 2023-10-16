package com.hoprik.CrazyCraft.Mob.Goals;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;

public class AttackGoal extends MeleeAttackGoal{
    private final MonsterEntity zombie;
    private int raiseArmTicks;

    public AttackGoal(MonsterEntity p_i46803_1_, double p_i46803_2_, boolean p_i46803_4_) {
        super(p_i46803_1_, p_i46803_2_, p_i46803_4_);
        this.zombie = p_i46803_1_;

    }

    public void start() {
        super.start();
        this.raiseArmTicks = 0;
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
