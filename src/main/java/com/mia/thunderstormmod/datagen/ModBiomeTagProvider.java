package com.mia.thunderstormmod.datagen;

import com.mia.thunderstormmod.Thunderstorm;
import com.mia.thunderstormmod.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends BiomeTagsProvider {
    public ModBiomeTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider, Thunderstorm.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Biomes.ALL_VANILLA_BIOMES)
                .addTag(BiomeTags.IS_OVERWORLD)
                .add(Biomes.BASALT_DELTAS) // Nether biomes (because IS_NETHER doesn't register properly for some reason)
                .add(Biomes.WARPED_FOREST)
                .add(Biomes.CRIMSON_FOREST)
                .add(Biomes.SOUL_SAND_VALLEY)
                .add(Biomes.NETHER_WASTES)
                .add(Biomes.END_BARRENS) // End biomes (because IS_END doesn't register properly for some reason)
                .add(Biomes.END_HIGHLANDS)
                .add(Biomes.END_MIDLANDS)
                .add(Biomes.THE_END);
    }
}
