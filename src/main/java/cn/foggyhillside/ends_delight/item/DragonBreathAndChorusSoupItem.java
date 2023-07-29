package cn.foggyhillside.ends_delight.item;

import com.nhoryzon.mc.farmersdelight.item.ConsumableItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Set;
import java.util.stream.Collectors;

public class DragonBreathAndChorusSoupItem extends ConsumableItem {


    public DragonBreathAndChorusSoupItem(Settings settings) {
        super(settings);
    }

    public DragonBreathAndChorusSoupItem(Settings settings, boolean hasFoodEffectTooltip) {
        super(settings, hasFoodEffectTooltip);
    }

    public DragonBreathAndChorusSoupItem(Settings settings, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(settings, hasFoodEffectTooltip, hasCustomTooltip);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient()) {
            this.affectConsumer(stack, world, user);
        }
        if (stack.isFood()) {
            super.finishUsing(stack, world, user);
            if (user.isSneaking()) {
                if (!world.isClient) {
                    double d = user.getX();
                    double e = user.getY();
                    double f = user.getZ();

                    for(int i = 0; i < 16; ++i) {
                        double g = user.getX() + (user.getRandom().nextDouble() - 0.5) * 16.0;
                        double h = MathHelper.clamp(user.getY() + (double)(user.getRandom().nextInt(16) - 8), (double)world.getBottomY(), (double)(world.getBottomY() + ((ServerWorld)world).getLogicalHeight() - 1));
                        double j = user.getZ() + (user.getRandom().nextDouble() - 0.5) * 16.0;
                        if (user.hasVehicle()) {
                            user.stopRiding();
                        }

                        Vec3d vec3d = user.getPos();
                        if (user.teleport(g, h, j, true)) {
                            world.emitGameEvent(GameEvent.TELEPORT, vec3d, GameEvent.Emitter.of(user));
                            SoundEvent soundEvent = user instanceof FoxEntity ? SoundEvents.ENTITY_FOX_TELEPORT : SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                            world.playSound((PlayerEntity)null, d, e, f, soundEvent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                            user.playSound(soundEvent, 1.0F, 1.0F);
                            break;
                        }
                    }

                    if (user instanceof PlayerEntity) {
                        ((PlayerEntity)user).getItemCooldownManager().set(this, 20);
                    }
                }
            }
        }
            return stack;
    }

    @Override
    public void affectConsumer(ItemStack stack, World world, LivingEntity user) {
        Set<StatusEffect> compatibleEffectList = user.getStatusEffects().stream().filter(this::canEffectInstanceBeRemovedByMilk).map(
                StatusEffectInstance::getEffectType).collect(Collectors.toSet());

        if (!compatibleEffectList.isEmpty()) {
            compatibleEffectList.stream().skip(world.getRandom().nextInt(compatibleEffectList.size())).findFirst().ifPresent(
                    user::removeStatusEffect);
        }
    }

    private boolean canEffectInstanceBeRemovedByMilk(StatusEffectInstance effectInstance) {
        return effectInstance.getEffectType().getCategory() == StatusEffectCategory.HARMFUL;
    }
}