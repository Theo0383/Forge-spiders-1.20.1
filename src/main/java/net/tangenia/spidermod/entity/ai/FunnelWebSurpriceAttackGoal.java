package net.tangenia.spidermod.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.tangenia.spidermod.effect.FunnelWebAffinityEffect;
import net.tangenia.spidermod.effect.ModEffects;
import net.tangenia.spidermod.entity.custom.FunnelWepEntity;

public class FunnelWebSurpriceAttackGoal extends Goal {
    private final FunnelWepEntity entity;
    private boolean isTimeToStartAttacking;
    public FunnelWebSurpriceAttackGoal(FunnelWepEntity pMob) {
        this.entity = pMob;
    }

    @Override
    public boolean canUse() {
        if(!this.entity.isBurrowed()) {
            return false;
        }
        else if(!isPlayNearBy(4)) {
            return false;
        }
        else if(affinityNearBy()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean canContinueToUse() {
        return true;
    }

    private boolean isPlayNearBy(double range) {
        Level level = this.entity.level();
        Player nearestPlayer = level.getNearestPlayer(this.entity, 20);
        if(nearestPlayer != null) {
            if(nearestPlayer.distanceTo(this.entity) <= range) {
                return true;
            }
            return false;
        }
        return false;
    }
    private boolean affinityNearBy() {
        Level level = this.entity.level();
        Player nearestPlayer = level.getNearestPlayer(this.entity, 10);
        if(nearestPlayer != null) {
            if(nearestPlayer.hasEffect(ModEffects.FUNNEL_WEB_AFFINITY_EFFECT.get())) {
                return true;
            }
            return false;
        }
        return false;
    }

    protected void cheackAndPreformAttack() {
        if(isPlayNearBy(6) && isTimeToStartAttacking) {
            Level level = this.entity.level();
            Player pEnemy = level.getNearestPlayer(this.entity, 3);
            if(pEnemy != null) {
                this.entity.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getY(), pEnemy.getZ());
                this.entity.doHurtTarget(pEnemy);
            }
        }
    }

    @Override
    public void start() {
        this.entity.setSupriceAttacked(true);
        this.entity.setSurpriceAttacking(true);
        this.isTimeToStartAttacking = true;
    }

    @Override
    public void tick() {
        Level level = this.entity.level();
        BlockPos entityPos0 = new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ());
        Block block = level.getBlockState(entityPos0).getBlock();

        if(!(block instanceof AirBlock)) {
            if(this.entity.isBurrowed()) {
                this.entity.setPos(this.entity.getX(), this.entity.getY() +1, this.entity.getZ());
            }
        }
        else {
            this.entity.setBurrowed(false);
            cheackAndPreformAttack();
            stop();
        }
    }

    @Override
    public void stop() {
        this.entity.setSurpriceAttacking(false);
        this.isTimeToStartAttacking = false;
        super.stop();
    }
}
