package net.tangenia.spidermod.entity.ai;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.tangenia.spidermod.entity.custom.WanderingSpiderEntity;

public class StalkingGoal extends Goal {
    private final PathNavigation navigation;
    private Player target;
    private int timeToRecalcPath;
    private int timeToStrike = 100;

    private final WanderingSpiderEntity entity;
    public StalkingGoal(PathNavigation navigation, WanderingSpiderEntity pMob) {
        this.navigation = navigation;
        entity = pMob;
    }

    private boolean isPlayNearBy(double range) {
        Level level = this.entity.level();
        Player nearestPlayer = level.getNearestPlayer(this.entity, 200);
        if(nearestPlayer != null) {
            if(nearestPlayer.distanceTo(this.entity) <= range) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean canUse() {
        if(!isPlayNearBy(30)) {
            return false;
        }
        if(this.entity.isAggro()) {
            return false;
        }
        Level level = this.entity.level();
        target = level.getNearestPlayer(this.entity, 40);
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
            if(!(this.timeToStrike >= 100)) {
                this.timeToStrike++;
        }}
    }

    @Override
    public void stop() {
        this.target = null;
        this.entity.setFollowing(false);
        this.navigation.stop();
        super.stop();
    }
}
