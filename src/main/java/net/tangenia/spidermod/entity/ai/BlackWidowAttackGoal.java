package net.tangenia.spidermod.entity.ai;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.tangenia.spidermod.entity.custom.BlackWidowEntity;

public class BlackWidowAttackGoal extends MeleeAttackGoal {
    private final BlackWidowEntity entity;
    private int attackDelay = 15;
    private int ticksUntilNextAttack = 15;
    private boolean shouldCountTilNextAttack = false;
    public BlackWidowAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        entity = ((BlackWidowEntity) pMob);
    }

    protected double getAttackReachSqr(LivingEntity pAttackTarget) {
        return (double)(15.0F + pAttackTarget.getBbWidth());
    }
    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistTtoEnemySqr) {
        return pDistTtoEnemySqr <= this.getAttackReachSqr(pEnemy);
    }

    protected  void resetAttackCoolDown() {
        this.ticksUntilNextAttack = this.adjustedTickDelay(attackDelay * 2);
    }
    @Override
    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    @Override
    public int getTicksUntilNextAttack() {
        return ticksUntilNextAttack;
    }

    protected void performeAttack(LivingEntity pEnemy) {
        this.resetAttackCoolDown();
        this.mob.swing(InteractionHand.MAIN_HAND);
        this.mob.doHurtTarget(pEnemy);
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if(isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {
            shouldCountTilNextAttack = true;

            if(isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if(isTimeToAttack()) {
                this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performeAttack(pEnemy);
            }
        } else {
            resetAttackCoolDown();
            shouldCountTilNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }

    private boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    @Override
    public void start() {
        super.start();

        this.attackDelay = 15;
        this.ticksUntilNextAttack = 15;
    }

    @Override
    public void tick() {
        super.tick();
        if(shouldCountTilNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack -1, 0);
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}
