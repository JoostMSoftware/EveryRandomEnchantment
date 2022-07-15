package com.joostmsoftware.ERE.enchantment;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantment;

public class EREEnchantments {
    private static final Enchantment FROST = new FrostEnchantment();
    private static final Enchantment RANDOMNESS = new RandomnessCurse();
    public static final Enchantment ENDDAMAGE = new EndDamageEnchantment();
    public static final Enchantment NETHERDAMAGE = new NetherDamageEnchantment();
    public static final Enchantment BUNNYHOP = new BunnyHopEnchantment();
    public static final Enchantment SOAP = new SoapEnchantment();
    public static final Enchantment RUN = new RunningEnchantment();
    public static final Enchantment POISON = new PoisonBladeEnchantment();
    public static final Enchantment HUNGERCURSE = new HungerCurse();

    private static void RegisterEnchantment(String ItemPath, Enchantment enchantment) {
        Registry.register(Registry.ENCHANTMENT, new ResourceLocation("ere", ItemPath), enchantment);
    }

    public static void Init() {
        RegisterEnchantment("frost", FROST);
        RegisterEnchantment("randomness", RANDOMNESS);
        RegisterEnchantment("enddamage", ENDDAMAGE);
        RegisterEnchantment("netherdamage", NETHERDAMAGE);
        RegisterEnchantment("bunnyhop", BUNNYHOP);
        RegisterEnchantment("soap", SOAP);
        RegisterEnchantment("run", RUN);
        RegisterEnchantment("poisonblade", POISON);
        RegisterEnchantment("hungercurse", HUNGERCURSE);
    }
}
