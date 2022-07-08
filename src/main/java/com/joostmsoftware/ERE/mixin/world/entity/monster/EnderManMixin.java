package com.joostmsoftware.ERE.mixin.world.entity.monster;

import com.joostmsoftware.ERE.world.entity.EREMobType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnderMan.class)
public class EnderManMixin extends Monster {
    protected EnderManMixin(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public MobType getMobType() {
        return EREMobType.END;
    }
}
