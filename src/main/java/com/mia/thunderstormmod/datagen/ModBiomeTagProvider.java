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

    }
}
