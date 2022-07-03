package com.joostmsoftware.ERE.enchantment;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class RandomnessCurse extends Enchantment {
    protected RandomnessCurse() {
        super(Rarity.COMMON, EnchantmentCategory.ARMOR, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    private MobEffect RandomEffect() {
        int i = (int)(Math.random()*(33-1+1)+1);
        return MobEffect.byId(i);
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    @Override
    public void doPostHurt(@NotNull LivingEntity user, @NotNull Entity target, int level){
        user.addEffect(new MobEffectInstance(RandomEffect(), 20 * 5 * level, level -1));
        super.doPostHurt(user, target, level);
    }


}
