package cn.foggyhillside.endsdelight.block;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
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
            if (!level.isClientSide && playerIn.isShiftKeyDown()) {
                double d0 = playerIn.getX();
                double d1 = playerIn.getY();
                double d2 = playerIn.getZ();

                for(int i = 0; i < 16; ++i) {
                    double d3 = playerIn.getX() + (playerIn.getRandom().nextDouble() - 0.5D) * 16.0D;
                    double d4 = Mth.clamp(playerIn.getY() + (double)(playerIn.getRandom().nextInt(16) - 8), (double)level.getMinBuildHeight(), (double)(level.getMinBuildHeight() + ((ServerLevel)level).getLogicalHeight() - 1));
                    double d5 = playerIn.getZ() + (playerIn.getRandom().nextDouble() - 0.5D) * 16.0D;
                    if (playerIn.isPassenger()) {
                        playerIn.stopRiding();
                    }

                    net.minecraftforge.event.entity.EntityTeleportEvent.ChorusFruit event = net.minecraftforge.event.ForgeEventFactory.onChorusFruitTeleport(playerIn, d3, d4, d5);
                    if (playerIn.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) {
                        SoundEvent soundevent = SoundEvents.CHORUS_FRUIT_TELEPORT;
                        level.playSound((Player)null, d0, d1, d2, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
                        playerIn.playSound(soundevent, 1.0F, 1.0F);
                        break;
                    }
                }
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





