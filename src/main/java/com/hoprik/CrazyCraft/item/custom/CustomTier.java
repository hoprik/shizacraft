package com.hoprik.CrazyCraft.item.custom;

import com.hoprik.CrazyCraft.item.Items;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum CustomTier implements IItemTier {

    AMETHYST(9, 999999, 10f, 9999f, 10,
                     () -> Ingredient.of(Items.phone.get())),
    SMALL(9,9999999,99999f,0.1f, 10, () -> Ingredient.of(Items.phone.get())),
    perchantki(9,9999999,1.5f,2f, 10, () -> Ingredient.of(Items.phone.get())),
    PIXAXESBORXHIK(5, 500, 10f, 1f, 10, () -> Ingredient.of(Items.phone.get()));



    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyValue<Ingredient> repairIngredient;

    CustomTier(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyValue<>(repairIngredient);
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return damage;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }
}