package net.tangenia.spidermod.effect;

import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexBuffer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.logging.Level;

public class WanderingSpiderVenomEffect extends MobEffect {

    int heartBeatPause = 20;
    protected WanderingSpiderVenomEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

        float hurt = pLivingEntity.getMaxHealth() - pLivingEntity.getHealth();
        if(hurt >= (10 * (pAmplifier + 1)))
            hurt = 10 * (pAmplifier + 1);

        if(heartBeatPause == 0) {
            if(pLivingEntity instanceof Player)
            {
                pLivingEntity.level().playSound((Player) pLivingEntity, new BlockPos(pLivingEntity.getBlockX(), pLivingEntity.getBlockY(), pLivingEntity.getBlockZ()), SoundEvents.WARDEN_HEARTBEAT, SoundSource.PLAYERS, 1f, 1f);
            }
            pLivingEntity.hurt(pLivingEntity.damageSources().generic(), hurt);
            heartBeatPause = 20;
        }
        else {
            heartBeatPause --;
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier)
    {
        return true;
    }
}
