package com.joostmsoftware.ERE.mixin.world.entity.monster;

import com.joostmsoftware.ERE.world.entity.EREMobType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Ghast.class)
public class GhastMixin extends FlyingMob {
    protected GhastMixin(EntityType<? extends FlyingMob> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public MobType getMobType() {
        return EREMobType.NETHER;
    }
}
