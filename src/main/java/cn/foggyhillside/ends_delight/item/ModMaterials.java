package cn.foggyhillside.ends_delight.item;

import cn.foggyhillside.ends_delight.registry.ModItem;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModMaterials implements ToolMaterial {
    DRAGON_EGG_SHELL(2, 1250, 4.0F, 2.5F, 5, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{ModItem.DragonEggShell.get()});
    }),
    END_STONE(1, 200, 4.0F, 1.0F, 5, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.END_STONE});
    }),
    PURPUR(1, 200, 4.0F, 1.0F, 5, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.POPPED_CHORUS_FRUIT});
    }),
    DRAGON_TOOTH(2, 1561, 4.0F, 4.0F, 5, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.BONE_BLOCK});
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private ModMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy(repairIngredient);
    }


    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
