package net.tangenia.spidermod.entity.ai;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.tangenia.spidermod.entity.custom.WanderingSpiderEntity;

public class StalkingGoal extends Goal {

    private final WanderingSpiderEntity entity;
    public StalkingGoal(WanderingSpiderEntity pMob) {
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
        if(!isPlayNearBy(80)) {
            return false;
        }
        if(!this.entity.isAggro()) {
            return false;
        }
        return true;
    }
}
