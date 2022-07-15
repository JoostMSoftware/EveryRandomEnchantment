package com.joostmsoftware.ERE.mixin.server.level;

import com.joostmsoftware.ERE.ERE;
import com.joostmsoftware.ERE.enchantment.EREEnchantments;
import com.mojang.authlib.GameProfile;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.ProfilePublicKey;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin extends Player {
    public ServerPlayerMixin(Level level, BlockPos blockPos, float f, GameProfile gameProfile, @Nullable ProfilePublicKey profilePublicKey) {
        super(level, blockPos, f, gameProfile, profilePublicKey);
    }

    @Unique
    private boolean hasBoots = false;

    @Inject(method = "tick", at = @At(value = "TAIL"))
    public void inject(CallbackInfo ci) {
        var enchants = EnchantmentHelper.getEnchantments(this.getItemBySlot(EquipmentSlot.FEET));
        if (enchants.containsKey(EREEnchantments.BUNNYHOP)) {
            if (!this.hasBoots) {
                this.hasBoots = true;
                this.addEffect(
                        new MobEffectInstance(MobEffects.JUMP, Integer.MAX_VALUE, enchants.get(EREEnchantments.BUNNYHOP)-1)
                );
            }
        } else if (enchants.containsKey(EREEnchantments.RUN)){
            if (!this.hasBoots) {
                this.hasBoots = true;
                this.addEffect(
                        new MobEffectInstance(MobEffects.MOVEMENT_SPEED, Integer.MAX_VALUE, enchants.get(EREEnchantments.RUN)-1)
                );
            }
        } else if (this.hasBoots) {
            this.hasBoots = false;
            this.removeEffect(MobEffects.JUMP);
            this.removeEffect(MobEffects.MOVEMENT_SPEED);
        }
    }
}