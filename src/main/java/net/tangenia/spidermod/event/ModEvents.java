package net.tangenia.spidermod.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tangenia.spidermod.SpiderMod;
import net.tangenia.spidermod.effect.ModEffects;
import net.tangenia.spidermod.entity.ModEntities;
import net.tangenia.spidermod.entity.custom.FunnelWepEntity;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import static net.minecraft.world.damagesource.DamageTypes.IN_WALL;

@Mod.EventBusSubscriber(modid = SpiderMod.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onEntitySuffocationDamage(LivingDamageEvent event) {
        if (event.getEntity() instanceof FunnelWepEntity) {
            if (event.getSource().is(IN_WALL)) {
                event.setAmount(0.0F);
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void inffestedBlockCheck(BlockEvent.BreakEvent event) {
        if(!event.getPlayer().hasEffect(ModEffects.BLACK_WIDOW_AFFINITY_EFFECT.get())) {
            if(isCorrectBiome(getCurrentBiome((ServerPlayer) event.getPlayer()))) {
                if(isCorrectBlock(event.getState().getBlock())) {
                    summonWidow((ServerLevel) event.getLevel(), event);
                }
            }
        }
    }

    private static void summonWidow(ServerLevel level, BlockEvent.BreakEvent event) {
        Random rand = new Random();
        int r = rand.nextInt(100);
        if(r <= 20) {
            ModEntities.BLACKWIDOW.get().spawn(level, event.getPos(), MobSpawnType.EVENT);
        }
    }

    private static ResourceKey<Biome> getCurrentBiome(ServerPlayer player) {
        ServerLevel level = (ServerLevel) player.serverLevel();
        Holder<Biome> holderBiome = level.getBiome(player.getOnPos());
        ResourceLocation location = getBiomeResource(level, holderBiome.get());
        return convertToResourceKey(location);
    }

    private static ResourceLocation getBiomeResource(Level level, Biome biome) {
        return level.registryAccess().registryOrThrow(Registries.BIOME).getKey(biome);
    }

    private static ResourceKey<Biome> convertToResourceKey(ResourceLocation location) {
        return ResourceKey.create(Registries.BIOME, location);
    }

    private static boolean isCorrectBlock(Block block) {
        if (block.equals(Blocks.OAK_PLANKS)) {
            return true;
        } else if (block.equals(Blocks.BIRCH_PLANKS)) {
            return true;
        } else if (block.equals(Blocks.DARK_OAK_PLANKS)) {
            return true;
        } else if (block.equals(Blocks.JUNGLE_PLANKS)) {
            return true;
        } else if (block.equals(Blocks.SPRUCE_PLANKS)) {
            return true;
        } else if (block.equals(Blocks.ACACIA_PLANKS)) {
            return true;
        } else if (block.equals(Blocks.BAMBOO_PLANKS)) {
            return true;
        } else if (block.equals(Blocks.CHERRY_PLANKS)) {
            return true;
        } else if (block.equals(Blocks.MANGROVE_PLANKS)) {
            return true;
        } else if (block.equals(Blocks.WARPED_PLANKS)) {
            return true;
        } else if (block.equals(Blocks.CRIMSON_PLANKS)) {
            return true;
        } else if (block.equals(Blocks.COBBLESTONE)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isCorrectBiome(ResourceKey<Biome> biome) {
        if (biome.equals(Biomes.DESERT)) {
            return true;
        } else if (biome.equals(Biomes.JUNGLE)) {
            return true;
        } else if (biome.equals(Biomes.BADLANDS)) {
            return true;
        } else if (biome.equals(Biomes.SAVANNA)) {
            return true;
        } else if (biome.equals(Biomes.BAMBOO_JUNGLE)) {
            return true;
        } else if (biome.equals(Biomes.JAGGED_PEAKS)) {
            return true;
        } else if (biome.equals(Biomes.SPARSE_JUNGLE)) {
            return true;
        } else if (biome.equals(Biomes.ERODED_BADLANDS)) {
            return true;
        } else if (biome.equals(Biomes.WOODED_BADLANDS)) {
            return true;
        } else if (biome.equals(Biomes.SAVANNA_PLATEAU)) {
            return true;
        } else if (biome.equals(Biomes.WINDSWEPT_SAVANNA)) {
            return true;
        } else {
            return false;
        }
    }
}
