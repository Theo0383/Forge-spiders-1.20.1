package net.tangenia.spidermod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tangenia.spidermod.SpiderMod;
import net.tangenia.spidermod.entity.custom.BlackWidowEntity;
import net.tangenia.spidermod.entity.custom.FunnelWepEntity;
import net.tangenia.spidermod.entity.custom.WanderingSpiderEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SpiderMod.MODID);

    public static final RegistryObject<EntityType<FunnelWepEntity>> FUNNELWEP =
            ENTITY_TYPES.register("funnel_wep", () -> EntityType.Builder.of(FunnelWepEntity::new, MobCategory.MONSTER)
                    .sized(2.0f, 0.8f).build("funnel_wep"));

    public static final RegistryObject<EntityType<BlackWidowEntity>> BLACKWIDOW =
            ENTITY_TYPES.register("black_widow", () -> EntityType.Builder.of(BlackWidowEntity::new, MobCategory.MONSTER)
                    .sized(1.5f, 0.8f).build("black_widow"));

    public static final RegistryObject<EntityType<WanderingSpiderEntity>> WANDERING_SPIDER =
            ENTITY_TYPES.register("wandering_spider", () -> EntityType.Builder.of(WanderingSpiderEntity::new, MobCategory.MONSTER)
                    .sized(2.5f, 1f).build("wandering_spider"));
    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }
}
