package cn.foggyhillside.ends_delight.registry;

import cn.foggyhillside.ends_delight.registry.ItemRegistry;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class MaterialRegistry {
    public static final Tier DRAGON_EGG_SHELL = new Tier() {
        @Override
        public int getUses() {
            return 1250;
        }

        @Override
        public float getSpeed() {
            return 4.0F;
        }

        @Override
        public float getAttackDamageBonus() {
            return 2.5F;
        }

        @Override
        public int getLevel() {
            return 2;
        }

        @Override
        public int getEnchantmentValue() {
            return 5;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(ItemRegistry.DragonEggShell.get());
        }
    };
    public static final Tier END_STONE = new Tier() {
        @Override
        public int getUses() {
            return 200;
        }

        @Override
        public float getSpeed() {
            return 4.0F;
        }

        @Override
        public float getAttackDamageBonus() {
            return 1.0F;
        }

        @Override
        public int getLevel() {
            return 1;
        }

        @Override
        public int getEnchantmentValue() {
            return 5;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.END_STONE);
        }
    };
    public static final Tier PURPUR = new Tier() {
        @Override
        public int getUses() {
            return 200;
        }

        @Override
        public float getSpeed() {
            return 4.0F;
        }

        @Override
        public float getAttackDamageBonus() {
            return 1.0F;
        }

        @Override
        public int getLevel() {
            return 1;
        }

        @Override
        public int getEnchantmentValue() {
            return 5;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.POPPED_CHORUS_FRUIT);
        }
    };
    public static final Tier DRAGON_TOOTH = new Tier() {
        @Override
        public int getUses() {
            return 1561;
        }

        @Override
        public float getSpeed() {
            return 4.0F;
        }

        @Override
        public float getAttackDamageBonus() {
            return 4.0F;
        }

        @Override
        public int getLevel() {
            return 2;
        }

        @Override
        public int getEnchantmentValue() {
            return 5;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.BONE_BLOCK);
        }
    };
}
