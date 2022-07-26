package com.joostmsoftware.ERE.enchantment;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class HungerCurse extends Enchantment {
    public HungerCurse() {
        super(Rarity.UNCOMMON, EnchantmentCategory.ARMOR, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET});
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    @Override
    public void doPostHurt(@NotNull LivingEntity user, @NotNull Entity target, int level){
        user.addEffect(new MobEffectInstance(MobEffects.HUNGER, 20 * 5 * level, level -1));
        super.doPostHurt(user, target, level);
    }
}
