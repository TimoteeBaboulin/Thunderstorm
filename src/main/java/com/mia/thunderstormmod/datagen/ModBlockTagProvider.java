package com.mia.thunderstormmod.datagen;

import com.mia.thunderstormmod.Thunderstorm;
import com.mia.thunderstormmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Thunderstorm.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ENERGY_BLOCK.get());

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.PLASMA_LOG.get())
                .add(ModBlocks.PLASMA_WOOD.get())
                .add(ModBlocks.STRIPPED_PLASMA_LOG.get())
                .add(ModBlocks.STRIPPED_PLASMA_WOOD.get())
                .add(ModBlocks.PLASMA_PLANKS.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ENERGY_BLOCK.get());
    }
}
