package com.mia.thunderstormmod.worldgen;

import com.mia.thunderstormmod.Thunderstorm;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static ResourceKey<PlacedFeature> PLASMA_OVERWORLD_PLACED_KEY = registerKey("plasma_overworld_placed");
    public static ResourceKey<PlacedFeature> PLASMA_NETHER_PLACED_KEY = registerKey("plasma_nether_placed");
    public static ResourceKey<PlacedFeature> PLASMA_END_PLACED_KEY = registerKey("plasma_end_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, PLASMA_OVERWORLD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PLASMA_OVERWORLD_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        Blocks.OAK_SAPLING));

        register(context, PLASMA_NETHER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PLASMA_NETHER_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 1),
                        Blocks.CRIMSON_FUNGUS));

        register(context, PLASMA_END_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PLASMA_END_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 1),
                        Blocks.CHORUS_PLANT));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Thunderstorm.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
