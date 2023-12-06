package net.tangenia.spidermod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.tangenia.spidermod.effect.ModEffects;
import net.tangenia.spidermod.entity.ai.FunnelWebBurrowGoal;
import net.tangenia.spidermod.entity.ai.FunnelWebSurpriceAttackGoal;
import net.tangenia.spidermod.entity.ai.FunnelWebUnBurrowGoal;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

import static net.minecraft.world.damagesource.DamageTypes.IN_WALL;

public class FunnelWepEntity extends Monster {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(FunnelWepEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID =
            SynchedEntityData.defineId(FunnelWepEntity.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Boolean> BURROWED =
            SynchedEntityData.defineId(FunnelWepEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> BURROWING =
            SynchedEntityData.defineId(FunnelWepEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> UNBURROWING =
            SynchedEntityData.defineId(FunnelWepEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> UNBURROWINGANIMATION =
            SynchedEntityData.defineId(FunnelWepEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SURPRICE_ATTACKING =
            SynchedEntityData.defineId(FunnelWepEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SURPRICE_ATTACKED =
            SynchedEntityData.defineId(FunnelWepEntity.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    private  int attackAnimationTimeout = 0;

    public final AnimationState burrowAnimationState = new AnimationState();
    private int burrowAnimationTimeout = 0;

    public final AnimationState unBurrowAnimationState = new AnimationState();
    private int unBurrowAnimationTimeout = 0;

    public final AnimationState surpriceAttackAnimationState = new AnimationState();
    private int surpriceAttackAnimationTimeout = 0;
    private LevelReader level;

    public FunnelWepEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    @Override
    protected void registerGoals()
    {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(3, new FunnelAttackGoal(this));
        this.goalSelector.addGoal(5, new FunnelWaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new FunnelWebBurrowGoal(this));
        this.goalSelector.addGoal(4, new FunnelWebUnBurrowGoal(this));
        this.goalSelector.addGoal(4, new FunnelWebSurpriceAttackGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new FunnelTargetFreeGoal<>(this, Player.class));
        this.targetSelector.addGoal(3, new FunnelTargetSurpriceGoal<>(this, Player.class));
        this.targetSelector.addGoal(3, new FunnelTargetFreeGoal<>(this, IronGolem.class));
    }
    public static AttributeSupplier.Builder createAttributes()
    {
        return Monster.createMobAttributes().add(Attributes.MAX_HEALTH, 50D)
                .add(Attributes.ATTACK_DAMAGE, 6f)
                .add(Attributes.FOLLOW_RANGE, 34D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.MOVEMENT_SPEED, 0.20D)
                .add(Attributes.ATTACK_KNOCKBACK, 1f);
    }


    protected PathNavigation createNavigation(Level pLevel) {
        return new WallClimberNavigation(this, pLevel);
    }

    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        if(this.isBurrowed()) {
            pCompound.putBoolean("isBurrowed", this.isBurrowed());
        }

        if(this.isSurpriceAttacked()) {
            pCompound.putBoolean("surpriceAttacked", this.isSurpriceAttacked());
        }
    }

    public void readAdditionalSaveData( CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.contains("isBurrowed", 99)) {
            this.setBurrowed(true);
        }

        if (pCompound.contains("surpriceAttacked", 99)) {
            this.setSupriceAttacked(true);
        }
    }


    public MobType getMobType() {
        return MobType.ARTHROPOD;
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
                    ((LivingEntity)pEntity).addEffect(new MobEffectInstance(ModEffects.FUNNEL_WEB_EFFECT.get(), 40 * i, i - 6), this);
                }
            }

            return true;
        } else {
            return false;
        }
    }
    static class FunnelAttackGoal extends MeleeAttackGoal{
        private final FunnelWepEntity entity;
        private int attackDelay = 13;
        private int ticksUntilNextAttack = 13;
        private boolean shouldCountTilNextAttack = false;
        public FunnelAttackGoal(FunnelWepEntity pFunnelWep)
        {
            super(pFunnelWep, 1.5D, true);
            entity = ((FunnelWepEntity) pFunnelWep);
        }
        public boolean canUse()
        {
            if(this.mob.isVehicle()) {
                return false;
            }
            else if(this.entity.isBurrowed()) {
                return false;
            }
            else return super.canUse();
        }
        public boolean canContinueToUse()
        {
            float f = this.mob.getLightLevelDependentMagicValue();
            if (f >= 0.5F && this.mob.getRandom().nextInt(100) == 0) {
                this.mob.setTarget((LivingEntity)null);
                return false;
            } else {
                return super.canContinueToUse();
            }
        }
        protected double getAttackReachSqr(LivingEntity pAttackTarget) {
            return (double)(16.0F + pAttackTarget.getBbWidth());
        }

        @Override
        protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
            if(isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {
                shouldCountTilNextAttack = true;
                if(isTimeToStartAttackAnimation()) {
                    entity.setAttacking(true);
                }

                if(isTimeToAttack()) {
                    this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getY(), pEnemy.getZ());
                    performAttack(pEnemy);
                }

            } else {
                resetAttackCooldown();
                shouldCountTilNextAttack = false;
                entity.setAttacking(false);
                entity.attackAnimationTimeout = 0;
            }
        }

        private boolean isTimeToStartAttackAnimation() {
            return this.ticksUntilNextAttack <= attackDelay;
        }

        private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
            return pDistToEnemySqr <= this.getAttackReachSqr(pEnemy);
        }

        protected void resetAttackCooldown() {
            this.ticksUntilNextAttack = this.adjustedTickDelay(attackDelay * 2);
        }

        @Override
        protected boolean isTimeToAttack()
        {
            return this.ticksUntilNextAttack <= 0;
        }

        @Override
        public int getTicksUntilNextAttack()
        {
            return ticksUntilNextAttack;
        }

        protected void performAttack(LivingEntity pEnemy)
        {
            this.resetAttackCooldown();
            this.mob.swing(InteractionHand.MAIN_HAND);
            this.mob.doHurtTarget(pEnemy);
        }

        @Override
        public void start() {
            super.start();
            this.attackDelay = 13;
            this.ticksUntilNextAttack = 13;
        }
        @Override
        public void tick() {
            super.tick();
            if(shouldCountTilNextAttack)
            {
                this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
            }
        }
        @Override
        public void stop() {
            entity.setAttacking(false);
            super.stop();
        }
    }

    static class FunnelRandomStrollGoal extends RandomStrollGoal {

        private final FunnelWepEntity entity;
        public FunnelRandomStrollGoal(FunnelWepEntity pFunnelWep, double pSpeedModifier) {
            super(pFunnelWep, pSpeedModifier);
            this.entity = pFunnelWep;
        }

        @Override
        public boolean canUse() {
            if (this.entity.isBurrowed()) {
                return false;
            }
            else return super.canUse();
        }

        @Override
        public boolean canContinueToUse() {
            if (this.entity.isBurrowed()) {
                return false;
            }
            else return super.canUse();
        }

        @Override
        public void tick() {
            if (this.entity.isBurrowed()) {
                this.entity.getNavigation().stop();
                super.stop();
            }
        }
    }

    static class FunnelWaterAvoidingRandomStrollGoal extends FunnelRandomStrollGoal
    {
        public static final float PROBABILITY = 0.001F;
        protected final float probability;
        private final FunnelWepEntity entity;

        public FunnelWaterAvoidingRandomStrollGoal(FunnelWepEntity pFunnelWep, double pSpeedModifier) {
            this(pFunnelWep, pSpeedModifier, 0.001F);
        }
        public FunnelWaterAvoidingRandomStrollGoal(FunnelWepEntity pFunnelWep, double pSpeedModifier, float pProbability) {
            super(pFunnelWep, pSpeedModifier);
            this.entity = pFunnelWep;
            this.probability = pProbability;
        }

        @Nullable
        protected Vec3 getPosition() {
            if (this.entity.isInWaterOrBubble()) {
                Vec3 vec3 = LandRandomPos.getPos(this.entity, 15, 7);
                return vec3 == null ? super.getPosition() : vec3;
            } else {
                return this.entity.getRandom().nextFloat() >= this.probability ? LandRandomPos.getPos(this.entity, 10, 7) : super.getPosition();
            }
        }
    }
    static class FunnelTargetFreeGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T>
    {
        private final FunnelWepEntity entity;

        public FunnelTargetFreeGoal(FunnelWepEntity pFunnelWep, Class<T> pEntityTypeToTarget) {
            super(pFunnelWep, pEntityTypeToTarget, true);
            this.entity = pFunnelWep;
        }

        public boolean canUse() {
            float f = this.mob.getLightLevelDependentMagicValue();
            if(f >= 0.5F) {
                return false;
            }
            else if (this.entity.isBurrowed()) {
                return false;
            }
            else return super.canUse();
        }
    }

    static class FunnelTargetSurpriceGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T>
    {
        private final FunnelWepEntity entity;

        public FunnelTargetSurpriceGoal(FunnelWepEntity pFunnelWep, Class<T> pEntityTypeToTarget) {
            super(pFunnelWep, pEntityTypeToTarget, true);
            this.entity = pFunnelWep;
        }

        public boolean canUse() {
            if(!this.entity.isSurpriceAttacked()) {
                return false;
            }
            else if(this.entity.isBurrowed()) {
                return false;
            }
            else return super.canUse();
        }
    }

    private void setupAnimationStates()
    {
        if(!this.isBurrowed()) {
            if (this.idleAnimationTimeout <= 0)
            {
                this.idleAnimationTimeout = 40; //this.random.nextInt(50) + 90;
                this.idleAnimationState.start(this.tickCount);
            } else {
                --this.idleAnimationTimeout;
            }
            if(this.walkAnimation.isMoving()) {
                this.idleAnimationState.stop();
            }

            if(this.isAttacking() && attackAnimationTimeout <= 0)
            {
                attackAnimationTimeout = 25;
                this.idleAnimationState.stop();
                attackAnimationState.start(this.tickCount);
            } else {
                --this.attackAnimationTimeout;
            }
            if(!this.isAttacking())
            {
                this.attackAnimationState.stop();
            }
        }
        else {
            if(this.burrowAnimationTimeout <= 0 && this.isBurrowing())
            {
                burrowAnimationTimeout = 40;
                this.idleAnimationState.stop();
                burrowAnimationState.start(this.tickCount);
            }
            else {
                --this.burrowAnimationTimeout;
            }

            if(this.unBurrowAnimationTimeout <= 0 && this.isAnimationUnBurrowing())
            {
                unBurrowAnimationTimeout = 40;
                this.idleAnimationState.stop();
                unBurrowAnimationState.start(this.tickCount);
            }
            else {
                --this.unBurrowAnimationTimeout;
            }

            if(this.surpriceAttackAnimationTimeout <= 0 && this.isSurpriceAttacking()) {
                surpriceAttackAnimationTimeout = 40;
                this.burrowAnimationState.stop();
                surpriceAttackAnimationState.start(this.tickCount);
            }
            else {
                --this.surpriceAttackAnimationTimeout;
            }
        }
    }

    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.STANDING && !this.isAttacking()) {
            f = Math.min(pPartialTick * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }
        if (this.isAttacking())
        {
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
    public void tick()
    {
        super.tick();
        if(this.level().isClientSide())
        {
            this.setupAnimationStates();
        }
        if(!this.level().isClientSide())
        {
            this.setClimbing(this.horizontalCollision);
        }
        if(this.level().isClientSide() && this.isBurrowed())
        {
            Level level = this.level();
            Player nearestPlayer = level.getNearestPlayer(this, 7);
            if(nearestPlayer != null) {
                BlockPos pos = new BlockPos(nearestPlayer.getBlockX(), nearestPlayer.getBlockY() - 1, nearestPlayer.getBlockZ());
                spawnSandParticles(level, pos);
            }
        }
    }

    public static void spawnSandParticles(Level level, BlockPos pos) {
        level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, level.getBlockState(pos)),
                pos.getX() + 0.5, pos.getY() + 1.1, pos.getZ() + 0.5, 0.0, 0.0, 0.0);
    }

    public void makeStuckInBlock(BlockState pState, Vec3 pMotionMultiplier) {
        if (!pState.is(Blocks.COBWEB)) {
            super.makeStuckInBlock(pState, pMotionMultiplier);
        }

    }

    public void setAttacking(boolean attacking)
    {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking()
    {
        return this.entityData.get(ATTACKING);
    }

    public void setBurrowed(boolean burroweing)
    {
        this.entityData.set(BURROWED, burroweing);
    }

    public boolean isBurrowed()
    {
        return this.entityData.get(BURROWED);
    }

    public boolean isBurrowing()
    {
        return this.entityData.get(BURROWING);
    }

    public void setBurrowing(boolean set)
    {
        this.entityData.set(BURROWING, set);
    }

    public boolean isUnBurrowing()
    {
        return this.entityData.get(UNBURROWING);
    }

    public void setUnBurrowing(boolean set) { this.entityData.set(UNBURROWING, set);}

    public boolean isAnimationUnBurrowing() {return this.entityData.get(UNBURROWINGANIMATION);}

    public void setUnburrowinganimation(boolean set) {this.entityData.set(UNBURROWINGANIMATION, set);}

    public boolean isSurpriceAttacking() { return this.entityData.get(SURPRICE_ATTACKING);}

    public void setSurpriceAttacking(boolean set) {this.entityData.set(SURPRICE_ATTACKING, set);}

    public boolean isSurpriceAttacked() { return this.entityData.get(SURPRICE_ATTACKED);}

    public void setSupriceAttacked(boolean set) {this.entityData.set(SURPRICE_ATTACKED, set);}

    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return 0.65F;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        if (damageSource.is(IN_WALL)) {
            return null;
        }
        return SoundEvents.SPIDER_HURT;
    }

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
    protected void defineSynchedData()
    {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
        this.entityData.define(BURROWED, false);
        this.entityData.define(SURPRICE_ATTACKING, false);
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
        this.entityData.define(BURROWING, false);
        this.entityData.define(UNBURROWING, false);
        this.entityData.define(UNBURROWINGANIMATION, false);
        this.entityData.define(SURPRICE_ATTACKED, false);
    }
}
