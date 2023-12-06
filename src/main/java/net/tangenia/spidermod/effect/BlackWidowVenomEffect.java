package net.tangenia.spidermod.effect;


import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.state.BlockState;

import static net.minecraft.world.damagesource.DamageTypes.IN_WALL;

public class BlackWidowVenomEffect extends MobEffect {
    private double prevPosX;
    private double prevPosZ;

    protected BlackWidowVenomEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    public boolean didMove(LivingEntity entity) {
        double prevX = prevPosX;
        double prevZ = prevPosZ;

        prevPosX = entity.getX();
        prevPosZ = entity.getZ();

        double deltaX = entity.getX() - prevX;
        double deltaZ = entity.getZ() - prevZ;

        double distanceMoved = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);
        double movementThreshold = 0.01;
        if (distanceMoved > movementThreshold) {
            return true;
        }
        else return false;
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier)
    {
        if(pLivingEntity.getHealth() > 1) {
            if(didMove(pLivingEntity)) {
                pLivingEntity.hurt(pLivingEntity.damageSources().generic(), 0.5F * (float)(pAmplifier + 1));
            }
            super.applyEffectTick(pLivingEntity, pAmplifier);
            pLivingEntity.hurt(pLivingEntity.damageSources().generic(), 0.1F * (float)(pAmplifier + 1));
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier)
    {
        return true;
    }
}
