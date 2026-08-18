package cn.foggyhillside.ends_delight.block;

import cn.foggyhillside.ends_delight.utility.Utils;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.block.PieBlock;

import java.util.Iterator;
import java.util.function.Supplier;

public class ChorusFruitPieBlock extends PieBlock {
    public ChorusFruitPieBlock(Properties properties, Supplier<Item> pieSlice) {
        super(properties, pieSlice);
    }

    protected InteractionResult consumeBite(Level level, BlockPos pos, BlockState state, Player playerIn) {
        if (!playerIn.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            ItemStack sliceStack = this.getPieSliceItem();
            FoodProperties sliceFood = sliceStack.getItem().getFoodProperties();
            playerIn.getFoodData().eat(sliceStack.getItem(), sliceStack);
            if (playerIn.isShiftKeyDown()) {
                Utils.BlockChorusFruitTeleport(level, playerIn);
            }
            if (this.getPieSliceItem().getItem().isEdible() && sliceFood != null) {
                Iterator var7 = sliceFood.getEffects().iterator();

                while(var7.hasNext()) {
                    Pair<MobEffectInstance, Float> pair = (Pair)var7.next();
                    if (!level.isClientSide && pair.getFirst() != null && level.random.nextFloat() < (Float)pair.getSecond()) {
                        playerIn.addEffect(new MobEffectInstance((MobEffectInstance)pair.getFirst()));
                    }
                }
            }

            int bites = (Integer)state.getValue(BITES);
            if (bites < this.getMaxBites() - 1) {
                level.setBlock(pos, (BlockState)state.setValue(BITES, bites + 1), 3);
            } else {
                level.removeBlock(pos, false);
            }

            level.playSound((Player)null, pos, SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);
            return InteractionResult.SUCCESS;
        }
    }
}
