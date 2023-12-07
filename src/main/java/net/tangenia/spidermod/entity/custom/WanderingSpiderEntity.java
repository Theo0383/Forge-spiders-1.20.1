package net.tangenia.spidermod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.tangenia.spidermod.effect.ModEffects;
import net.tangenia.spidermod.entity.ai.AggroHurtByTargetGoal;
import net.tangenia.spidermod.entity.ai.StalkingGoal;
import net.tangenia.spidermod.entity.ai.WanderingSpiderAttackGoal;

public class WanderingSpiderEntity extends Monster {

    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID =
            SynchedEntityData.defineId(WanderingSpiderEntity.class, EntityDataSerializers.BYTE);

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(WanderingSpiderEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Boolean> FOLLOWING =
            SynchedEntityData.defineId(WanderingSpiderEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Boolean> AGGRO =
            SynchedEntityData.defineId(WanderingSpiderEntity.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new WanderingSpiderAttackGoal(this, 2.3D, true));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 4f));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new AggroHurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new WanderTargetGoal<>(this, Player.class));

        this.goalSelector.addGoal(2, new StalkingGoal(navigation, this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMobAttributes().add(Attributes.MAX_HEALTH, 88D)
                .add(Attributes.ATTACK_DAMAGE, 8f)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.MOVEMENT_SPEED, 0.20D)
                .add(Attributes.ATTACK_KNOCKBACK, 1f);
    }

    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    protected PathNavigation createNavigation(Level pLevel) {
        return new WallClimberNavigation(this, pLevel);
    }

    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        if(this.isAggro()) {
            pCompound.putBoolean("isAggro", this.isAggro());
        }
    }

    public void readAdditionalSaveData( CompoundTag pCompound) {
        if (pCompound.contains("isBAggro", 99)) {
            this.setAggro(true);
        }
    }

    public boolean doHurtTarget(Entity pEntity) {
        if (super.doHurtTarget(pEntity)) {
            if (pEntity instanceof LivingEntity) {
                int i = 0;
                if (this.level().getDifficulty() == Difficulty.EASY) {
                    i = 6;
                } else if (this.level().getDifficulty() == Difficulty.NORMAL) {
                    i = 7;
                } else if (this.level().getDifficulty() == Difficulty.HARD) {
                    i = 15;
                }

                if (i > 0) {
                    ((LivingEntity)pEntity).addEffect(new MobEffectInstance(ModEffects.WANDERING_SPIDER_EFFECT.get(), 120 * i, i - 6), this);
                }
                this.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 1), this);
            }

            return true;
        } else {
            return false;
        }
    }

    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
        if(this.walkAnimation.isMoving()) {
            this.idleAnimationState.stop();
        }

        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 40;
            attackAnimationState.start(this.tickCount);
        } else {
            --this.attackAnimationTimeout;
        }
        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    protected void updateWalkAnimation(float v) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(v * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.walkAnimation.update(f, 0.2F);
    }

    public boolean isClimbing() {
        return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
    }

    public boolean onClimbable() {
        return this.isClimbing();
    }

    public void setClimbing(boolean pClimbing) {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        if (pClimbing) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }

        this.entityData.set(DATA_FLAGS_ID, b0);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide) {
            this.setupAnimationStates();
        }
        if(!this.level().isClientSide())
        {
            this.setClimbing(this.horizontalCollision);
        }
    }

    public void makeStuckInBlock(BlockState pState, Vec3 pMotionMultiplier) {
        if (!pState.is(Blocks.COBWEB)) {
            super.makeStuckInBlock(pState, pMotionMultiplier);
        }

    }

    static class WanderTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T>
    {
        private final WanderingSpiderEntity entity;

        public WanderTargetGoal(WanderingSpiderEntity pWander, Class<T> pEntityTypeToTarget) {
            super(pWander, pEntityTypeToTarget, true);
            this.entity = pWander;
        }

        public boolean canUse() {
            if(!this.entity.isAggro()) {
                return false;
            }
            return super.canUse();
        }
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }
    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }
    public void setFollowing(boolean following) {
        this.entityData.set(FOLLOWING, following);
    }
    public boolean isFollowing() { return this.entityData.get(FOLLOWING); }
    public void setAggro(boolean aggro) {
        this.entityData.set(AGGRO, aggro);
    }
    public boolean isAggro() { return this.entityData.get(AGGRO); }

    protected SoundEvent getHurtSound(DamageSource damageSource) { return SoundEvents.SPIDER_HURT; }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.SPIDER_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SPIDER_DEATH;
    }

    protected void playStepSound(BlockPos pPos, BlockState pBlock) {
        this.playSound(SoundEvents.SPIDER_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
        this.entityData.define(ATTACKING, false);
        this.entityData.define(FOLLOWING, false);
        this.entityData.define(AGGRO, false);
    }
    public WanderingSpiderEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
}
