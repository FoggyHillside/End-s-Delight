package cn.foggyhillside.ends_delight.loot;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.refabricated.LootModifier;

public class ItemAdditionModifier extends LootModifier {
    private final Item addedItem;
    private final int count;
    private final float bonus1;
    private final float bonus2;

    protected ItemAdditionModifier(LootItemCondition[] conditionsIn, Item addedItemIn, int count, float bonus1, float bonus2) {
        super(conditionsIn);
        this.addedItem = addedItemIn;
        this.count = count;
        this.bonus1 = 1F - bonus1;
        this.bonus2 = 1F - bonus2;
    }

    @NotNull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        ItemStack addedStack = new ItemStack(addedItem, count);
        ItemStack bonusStack = new ItemStack(addedItem, 1);
        addLoot(generatedLoot, addedStack);
        if (context.getRandom().nextFloat() > bonus1) {
            addLoot(generatedLoot, bonusStack);
        }
        if (context.getRandom().nextFloat() > bonus2) {
            addLoot(generatedLoot, bonusStack);
        }

        return generatedLoot;
    }

    private void addLoot(ObjectArrayList<ItemStack> generatedLoot, ItemStack addedStack) {
        if (addedStack.getCount() < addedStack.getMaxStackSize()) {
            generatedLoot.add(addedStack);
        } else {
            int i = addedStack.getCount();

            while (i > 0) {
                ItemStack subStack = addedStack.copy();
                subStack.setCount(Math.min(addedStack.getMaxStackSize(), i));
                i -= subStack.getCount();
                generatedLoot.add(subStack);
            }
        }
    }
}
