package cn.foggyhillside.endsdelight.events.loot;

import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;

public class DragonToothAdditionModifier extends LootModifier {
    private final Item item;

    protected DragonToothAdditionModifier(ILootCondition[] conditionsIn, Item item) {
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
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<DragonToothAdditionModifier> {

        @Override
        public DragonToothAdditionModifier read(ResourceLocation name, JsonObject object, ILootCondition[] conditionsIn) {
            Item item = ForgeRegistries.ITEMS.getValue(
                    new ResourceLocation(JSONUtils.getString(object, "item")));
            return new DragonToothAdditionModifier(conditionsIn, item);
        }

        @Override
        public JsonObject write(DragonToothAdditionModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("item", ForgeRegistries.ITEMS.getKey(instance.item).toString());
            return json;
        }
    }
}
