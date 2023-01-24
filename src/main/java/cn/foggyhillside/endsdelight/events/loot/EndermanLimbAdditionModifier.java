package cn.foggyhillside.endsdelight.events.loot;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;

public class EndermanLimbAdditionModifier extends LootModifier {
    private final Item item;

    protected EndermanLimbAdditionModifier(LootItemCondition[] conditionsIn, Item item) {
        super(conditionsIn);
        this.item = item;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        generatedLoot.add(new ItemStack(item, 1));
        if (context.getRandom().nextFloat() > 0.7) {
            generatedLoot.add(new ItemStack(item, 1));
        };
        if (context.getRandom().nextFloat() > 0.7) {
            generatedLoot.add(new ItemStack(item, 1));
        };
        if (context.getRandom().nextFloat() > 0.7) {
            generatedLoot.add(new ItemStack(item, 1));
        };
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<EndermanLimbAdditionModifier> {

        @Override
        public EndermanLimbAdditionModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditionsIn) {
            Item item = ForgeRegistries.ITEMS.getValue(
                    new ResourceLocation(GsonHelper.getAsString(object, "item")));
            return new EndermanLimbAdditionModifier(conditionsIn, item);
        }

        @Override
        public JsonObject write(EndermanLimbAdditionModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("item", ForgeRegistries.ITEMS.getKey(instance.item).toString());
            return json;
        }
    }
}
