package cn.foggyhillside.ends_delight.mixin;

import cn.foggyhillside.ends_delight.event.DragonToothKnifeEvent;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow
    public abstract float getHealth();

    @ModifyArg(
            method = "actuallyHurt",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/LivingEntity;setHealth(F)V"
            ),
            index = 0
    )
    protected float setHealthMixin(float amount, @Local(argsOnly = true) DamageSource source) {
        return this.getHealth() - DragonToothKnifeEvent.KnifeEvents.onAttackEndMobs((LivingEntity) (Object) this, source, this.getHealth() - amount);
    }

    @ModifyArg(
            method = "actuallyHurt",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/damagesource/CombatTracker;recordDamage(Lnet/minecraft/world/damagesource/DamageSource;F)V"
            ),
            index = 1
    )
    protected float onDamageMixin(float amount, @Local(argsOnly = true) DamageSource source) {
        return this.getHealth() - DragonToothKnifeEvent.KnifeEvents.onAttackEndMobs((LivingEntity) (Object) this, source, this.getHealth() - amount);
    }

    @ModifyArg(
            method = "actuallyHurt",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/LivingEntity;setAbsorptionAmount(F)V"
            ),
            index = 0
    )
    protected float setAbsorptionAmountMixin(float amount, @Local(argsOnly = true) DamageSource source) {
        return this.getHealth() - DragonToothKnifeEvent.KnifeEvents.onAttackEndMobs((LivingEntity) (Object) this, source, this.getHealth() - amount);
    }

}