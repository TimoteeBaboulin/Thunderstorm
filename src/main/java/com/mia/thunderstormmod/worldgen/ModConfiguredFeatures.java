package com.mia.thunderstormmod.worldgen;

import com.mia.thunderstormmod.Thunderstorm;
import com.mia.thunderstormmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PLASMA_OVERWORLD_KEY = registerKey("plasma_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PLASMA_NETHER_KEY = registerKey("plasma_nether");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PLASMA_END_KEY = registerKey("plasma_end");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        register(context, PLASMA_OVERWORLD_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
           BlockStateProvider.simple(ModBlocks.PLASMA_LOG.get()),
           new ForkingTrunkPlacer(8, 8, 6),

           BlockStateProvider.simple(Blocks.AIR),
           new BushFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0),

           new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, PLASMA_NETHER_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.PLASMA_LOG.get()),
                new ForkingTrunkPlacer(4, 4, 2),

                BlockStateProvider.simple(Blocks.AIR),
                new BushFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, PLASMA_END_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.PLASMA_LOG.get()),
                new ForkingTrunkPlacer(12, 12, 8),

                BlockStateProvider.simple(Blocks.AIR),
                new BushFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0),

                new TwoLayersFeatureSize(1, 0, 2)).build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Thunderstorm.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key,
                                                                                          F feature, FC configuration) {
            context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
