package net.tangenia.spidermod.entity.ai;

import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.tangenia.spidermod.effect.ModEffects;
import net.tangenia.spidermod.effect.WanderingSpiderAffinityEffect;
import net.tangenia.spidermod.entity.custom.WanderingSpiderEntity;

public class StalkingGoal extends Goal {
    private final PathNavigation navigation;
    private Player target;
    private int timeToRecalcPath;
    private int timeToStrike = 200;

    private final WanderingSpiderEntity entity;
    public StalkingGoal(PathNavigation navigation, WanderingSpiderEntity pMob) {
        this.navigation = navigation;
        entity = pMob;
    }

    private Player noAffinityNearBy(double range) {
        Level level = this.entity.level();

        for (Player player : level.players()) {
            if (EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(player) && EntitySelector.LIVING_ENTITY_STILL_ALIVE.test(player)) {
                if(!player.hasEffect(ModEffects.WANDERING_SPIDER_AFFINITY_EFFECT.get())) {
                    double d0 = player.distanceToSqr(this.entity.getX(), this.entity.getY(), this.entity.getZ());
                    if (range < 0.0D || d0 < range * range) {
                        return player;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean canUse() {
        if(noAffinityNearBy(80) == null) {
            return false;
        }
        if(this.entity.isAggro()) {
            return false;
        }
        target = noAffinityNearBy(80);
        return true;
    }

    @Override
    public boolean canContinueToUse() {
        if(this.entity.isAggro()) {
            stop();
            return false;
        }
        if(target.isSpectator()) {
            stop();
            return false;
        }
        if(target.isCreative()) {
            stop();
            return false;
        }
        if(target.hasEffect(ModEffects.WANDERING_SPIDER_AFFINITY_EFFECT.get())) {
            stop();
            return false;
        }
        if(target.getHealth() <= 0.0) {
            stop();
            return false;
        }
        return super.canContinueToUse();
    }

    @Override
    public void start() {
        if(!this.entity.isFollowing()) {
            this.entity.setFollowing(true);
        }
    }

    @Override
    public void tick() {
        this.entity.getLookControl().setLookAt(target);
        if (--this.timeToRecalcPath <= 0) {
            this.timeToRecalcPath = this.adjustedTickDelay(10);
            this.navigation.moveTo(this.target, 1);
        }
        if(target.distanceTo(this.entity) <= 30) {
            if (--this.timeToStrike <= 0) {
                this.entity.setAggro(true);
            }
        }
        else {
            if(!(this.timeToStrike >= 200)) {
                this.timeToStrike++;
        }}
        this.entity.setPersistenceRequired();
    }

    @Override
    public void stop() {
        this.target = null;
        this.entity.setFollowing(false);
        this.navigation.stop();
        super.stop();
    }
}
