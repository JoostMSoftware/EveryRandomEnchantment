package com.joostmsoftware.ERE;

import com.joostmsoftware.ERE.enchantment.EREEnchantments;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableSource;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class LootTableInjector {
    public static void Init() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (id.equals(BuiltInLootTables.BASTION_TREASURE)) {
                if (source.equals(LootTableSource.VANILLA)) {
                    LootPool poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1.0F))
                            .add(LootItem.lootTableItem(Items.BOOK).setWeight(1).apply(new EnchantRandomlyFunction.Builder().withEnchantment(EREEnchantments.NETHERDAMAGE)))
                            .build();

                    tableBuilder
                            .pool(poolBuilder)
                            .build();
                }
            }

            if (id.equals(BuiltInLootTables.END_CITY_TREASURE)) {
                if (source.equals(LootTableSource.VANILLA)) {
                    LootPool poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1.0F))
                            .add(LootItem.lootTableItem(Items.BOOK).setWeight(1).apply(new EnchantRandomlyFunction.Builder().withEnchantment(EREEnchantments.ENDDAMAGE)))
                            .build();

                    tableBuilder
                            .pool(poolBuilder)
                            .build();
                }
            }
        });
    }
}
