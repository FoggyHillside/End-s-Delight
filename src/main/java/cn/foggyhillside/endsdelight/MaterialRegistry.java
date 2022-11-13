package cn.foggyhillside.endsdelight;

import cn.foggyhillside.endsdelight.item.ItemRegistry;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

public class MaterialRegistry {
    public static final IItemTier DRAGON_EGG_SHELL = new IItemTier() {
        @Override
        public int getMaxUses() {
            return 1250;
        }

        @Override
        public float getEfficiency() {
            return 4.0F;
        }

        @Override
        public float getAttackDamage() {
            return 2.5F;
        }

        @Override
        public int getHarvestLevel() {
            return 2;
        }

        @Override
        public int getEnchantability() {
            return 5;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(ItemRegistry.LargerDragonEggShell.get());
        }
    };
    public static final IItemTier END_STONE = new IItemTier() {
        @Override
        public int getMaxUses() {
            return 200;
        }

        @Override
        public float getEfficiency() {
            return 4.0F;
        }

        @Override
        public float getAttackDamage() {
            return 1.0F;
        }

        @Override
        public int getHarvestLevel() {
            return 1;
        }

        @Override
        public int getEnchantability() {
            return 5;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(Items.END_STONE);
        }
    };
    public static final IItemTier PURPUR = new IItemTier() {
        @Override
        public int getMaxUses() {
            return 200;
        }

        @Override
        public float getEfficiency() {
            return 4.0F;
        }

        @Override
        public float getAttackDamage() {
            return 1.0F;
        }

        @Override
        public int getHarvestLevel() {
            return 1;
        }

        @Override
        public int getEnchantability() {
            return 5;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(Items.POPPED_CHORUS_FRUIT);
        }
    };
}
