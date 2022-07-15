package com.joostmsoftware.ERE.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.DamageEnchantment;

public class NetherDamageEnchantment extends DamageEnchantment {
    public NetherDamageEnchantment() {
        super(Rarity.VERY_RARE, 3, EquipmentSlot.MAINHAND);
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }
}
