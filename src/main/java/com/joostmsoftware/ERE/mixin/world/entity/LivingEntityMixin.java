package com.joostmsoftware.ERE.mixin.world.entity;

import com.joostmsoftware.ERE.enchantment.EREEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Shadow public abstract ItemStack getItemBySlot(EquipmentSlot equipmentSlot);

    @Redirect(method = "travel", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Block;getFriction()F"))
    public float onModifyExpressionValue(Block instance){
        var enchants = EnchantmentHelper.getEnchantments(this.getItemBySlot(EquipmentSlot.FEET));
        if (enchants.containsKey(EREEnchantments.SOAP)) {
            return 1.02f;
        } else {
            return instance.getFriction();
        }
    }
}
