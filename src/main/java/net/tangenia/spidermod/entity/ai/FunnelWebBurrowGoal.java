package net.tangenia.spidermod.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.tangenia.spidermod.entity.custom.FunnelWepEntity;
import org.checkerframework.framework.qual.Covariant;

import java.util.EnumSet;

public class FunnelWebBurrowGoal extends Goal {
    private final FunnelWepEntity entity;
    private int TicksUntilBurrowingDone = 10;
    private boolean IsTimeToStartBurrow = false;

    public FunnelWebBurrowGoal(FunnelWepEntity pMob) {
        this.entity = pMob;
        this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
    }

    public boolean canContinueToUse() {
        if(!this.entity.isBurrowed()) {
            return false;
        }
        else if(this.entity.isSurpriceAttacked()) {
            return false;
        }
        return true;
    }

    public boolean canUse() {
        Level level = this.entity.level();
        BlockPos entityPos = new BlockPos(entity.getBlockX(), entity.getBlockY() - 1, entity.getBlockZ());
        Block block = level.getBlockState(entityPos).getBlock();
        if(this.entity.isInWaterOrBubble()) {
            return false;
        }
        else if (!this.entity.onGround()) {
            return false;
        }
        else if (level.isNight()) {
            return false;
        }
        else if (!(block == Blocks.SAND || block == Blocks.RED_SAND)) {
            return false;
        }
        else if (this.entity.isBurrowed()) {
            return false;
        }
        else if (this.entity.isSurpriceAttacked()) {
            return false;
        }
        else return true;
    }

    protected void BurrowCheck() {
        this.entity.setBurrowing(true);
        Burrow();
    }

    protected void Burrow() {
        if(TicksUntilBurrowingDone > 0) {
            this.entity.setPos(this.entity.getX(), this.entity.getY() - 0.0001, this.entity.getZ());
        }
        else {
            this.entity.setBurrowing(false);
            this.IsTimeToStartBurrow = false;
        }
    }

    @Override
    public void start() {
        if(!this.entity.isBurrowed()) {
            IsTimeToStartBurrow = true;
            this.TicksUntilBurrowingDone = 10;
            this.entity.setBurrowed(true);
        }
        this.entity.getNavigation().stop();
    }

    @Override
    public void tick() {
        if(IsTimeToStartBurrow) {
            this.TicksUntilBurrowingDone = Math.max(this.TicksUntilBurrowingDone - 1, 0);
            BurrowCheck();
        }
        Level level = this.entity.level();
        BlockPos entityPos = new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ());
        Block block = level.getBlockState(entityPos).getBlock();
        if(block == Blocks.AIR && this.entity.isBurrowed() && level.isDay()) {
            this.entity.setPos(this.entity.getX(), this.entity.getY() - 4, this.entity.getZ());
            this.TicksUntilBurrowingDone = 15;
            this.entity.getNavigation().stop();
            IsTimeToStartBurrow = true;
        }
    }
}
