package com.joostmsoftware.ERE.enchantment;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantment;

public class EREEnchants {
    private static final Enchantment FROST = new FrostEnchantment();
    private static final Enchantment RANDOMNESS = new RandomnessCurse();

    private static void RegisterEnchantment(String ItemPath, Enchantment enchantment) {
        Registry.register(Registry.ENCHANTMENT, new ResourceLocation("ere", ItemPath), enchantment);
    }

    public static void Init() {
        RegisterEnchantment("frost", FROST);
        RegisterEnchantment("randomness", RANDOMNESS);
    }
}
