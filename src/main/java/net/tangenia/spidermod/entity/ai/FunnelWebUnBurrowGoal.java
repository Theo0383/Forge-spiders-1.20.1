package net.tangenia.spidermod.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.tangenia.spidermod.entity.custom.FunnelWepEntity;

public class FunnelWebUnBurrowGoal extends Goal {
    private final FunnelWepEntity entity;
    public FunnelWebUnBurrowGoal(FunnelWepEntity pMob) {
        this.entity = pMob;
    }

    public boolean canUse() {
        Level level = this.entity.level();
        if(!this.entity.isBurrowed()) {
            return false;
        }
        else if(level.isDay()) {
            return false;
        }
        return true;
    }

    public boolean canContinueToUse() {
        Level level = this.entity.level();
        if(this.entity.isBurrowed()) {
            return false;
        }
        else if(level.isDay()) {
            return false;
        }
        return true;
    }

    @Override
    public void start() {
        this.entity.getNavigation().stop();
        if(!this.entity.isUnBurrowing()) {
            this.entity.setUnBurrowing(true);
            this.entity.setUnburrowinganimation(true);
        }
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
            this.entity.setUnBurrowing(false);
            this.entity.setBurrowed(false);
            this.entity.setUnburrowinganimation(false);
            stop();
        }
    }
}
