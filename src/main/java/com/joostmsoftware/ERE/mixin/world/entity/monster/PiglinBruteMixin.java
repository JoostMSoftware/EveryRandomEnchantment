package com.joostmsoftware.ERE.mixin.world.entity.monster;

import com.joostmsoftware.ERE.world.entity.EREMobType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PiglinBrute.class)
public abstract class PiglinBruteMixin extends AbstractPiglin {
    public PiglinBruteMixin(EntityType<? extends AbstractPiglin> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public MobType getMobType() {
        return EREMobType.NETHER;
    }

}
