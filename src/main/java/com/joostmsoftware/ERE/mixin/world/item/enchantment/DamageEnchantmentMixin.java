package com.joostmsoftware.ERE.mixin.world.item.enchantment;

import com.joostmsoftware.ERE.world.entity.EREMobType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DamageEnchantment.class)
public class DamageEnchantmentMixin {
    private static final int NETHER = 3;
    private static final int END = 4;
    @Final
    @Shadow
    public int type;

    @Inject(method = "getDamageBonus", at = @At(value = "HEAD"), cancellable = true)
    public void invokeGetDamageBonus(int i, MobType mobType, CallbackInfoReturnable<Float> cir) {
        if (this.type == 0) {
            cir.setReturnValue(1.0F + (float)Math.max(0, i - 1) * 0.5F);
        } else if (this.type == 1 && mobType == MobType.UNDEAD) {
            cir.setReturnValue((float)i * 2.5F);
        } else if (this.type == 2 && mobType == MobType.ARTHROPOD){
            cir.setReturnValue((float)i * 2.5F);
        } else if (this.type == 3 && mobType == EREMobType.NETHER) {
            cir.setReturnValue((float) i * 1.5f);
        } else {
            cir.setReturnValue(this.type == 4 && mobType == EREMobType.END ? (float)i * 1.5F : 0.0F);
        }
    }
}
