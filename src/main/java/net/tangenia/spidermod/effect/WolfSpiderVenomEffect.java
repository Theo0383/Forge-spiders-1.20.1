package net.tangenia.spidermod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class WolfSpiderVenomEffect extends MobEffect {
    private float lastHealth;

    protected WolfSpiderVenomEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

        float currentHealth = pLivingEntity.getHealth();
        float healthChange = currentHealth - lastHealth;

        if(healthChange > 0.0f) {
            pLivingEntity.hurt(pLivingEntity.damageSources().generic(), 1.5F * (float) (pAmplifier + 1));
        }

        lastHealth = currentHealth;

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier)
    {
        return true;
    }
}
