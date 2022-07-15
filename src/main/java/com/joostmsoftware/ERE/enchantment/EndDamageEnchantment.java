package com.joostmsoftware.ERE.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.DamageEnchantment;

public class EndDamageEnchantment extends DamageEnchantment {
    public EndDamageEnchantment() {
        super(Rarity.VERY_RARE, 4, EquipmentSlot.MAINHAND);
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
