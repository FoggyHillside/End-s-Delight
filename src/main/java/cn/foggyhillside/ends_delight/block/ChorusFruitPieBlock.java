package cn.foggyhillside.ends_delight.block;

import com.mojang.datafixers.util.Pair;
import com.nhoryzon.mc.farmersdelight.block.PieBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Iterator;

public class ChorusFruitPieBlock extends PieBlock {

    public ChorusFruitPieBlock(Item pieSlice) {
        super(pieSlice);
    }

    @Override
    protected ActionResult consumeBite(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canConsume(false)) {
            return ActionResult.PASS;
        } else {
            ItemStack slice = getPieSliceStack();
            FoodComponent sliceFood = slice.getItem().getFoodComponent();
            player.getHungerManager().eat(slice.getItem(), slice);
            if (player.isSneaking()) {
                if (!world.isClient) {
                    double d = player.getX();
                    double e = player.getY();
                    double f = player.getZ();

                    for(int i = 0; i < 16; ++i) {
                        double g = player.getX() + (player.getRandom().nextDouble() - 0.5) * 16.0;
                        double h = MathHelper.clamp(player.getY() + (double)(player.getRandom().nextInt(16) - 8), (double)world.getBottomY(), (double)(world.getBottomY() + ((ServerWorld)world).getLogicalHeight() - 1));
                        double j = player.getZ() + (player.getRandom().nextDouble() - 0.5) * 16.0;
                        if (player.hasVehicle()) {
                            player.stopRiding();
                        }

                        Vec3d vec3d = player.getPos();
                        if (player.teleport(g, h, j, true)) {
                            world.emitGameEvent(GameEvent.TELEPORT, vec3d, GameEvent.Emitter.of(player));
                            SoundEvent soundEvent = SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                            world.playSound((PlayerEntity)null, d, e, f, soundEvent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                            player.playSound(soundEvent, 1.0F, 1.0F);
                            break;
                        }
                    }
                }
            }
        if (this.getPieSliceStack().getItem().isFood() && sliceFood != null) {
                Iterator var7 = sliceFood.getStatusEffects().iterator();

                while(var7.hasNext()) {
                    Pair<StatusEffectInstance, Float> pair = (Pair)var7.next();
                    if (!world.isClient() && pair.getFirst() != null && world.getRandom().nextFloat() < (Float)pair.getSecond()) {
                        player.addStatusEffect(new StatusEffectInstance((StatusEffectInstance)pair.getFirst()));
                    }
                }
            }

            int bites = (Integer)state.get(BITES);
            if (bites < 3) {
                world.setBlockState(pos, (BlockState)state.with(BITES, bites + 1), 3);
            } else {
                world.removeBlock(pos, false);
            }

            world.playSound((PlayerEntity)null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.PLAYERS, 0.8F, 0.8F);
            return ActionResult.SUCCESS;
        }
    }
}
