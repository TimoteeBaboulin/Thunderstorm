package com.mia.thunderstormmod.datagen;

import com.mia.thunderstormmod.Thunderstorm;
import com.mia.thunderstormmod.block.ModBlocks;
import com.mia.thunderstormmod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.stream.Stream;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, Thunderstorm.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        // -------------------- ITEMS --------------------
        itemModels.generateFlatItem(ModItems.BATTERY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.THUNDER_STRIKE_DEV_ITEM.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        // -------------------- BLOCKS --------------------
        blockModels.createTrivialCube(ModBlocks.ENERGY_BLOCK.get());

        blockModels.woodProvider(ModBlocks.PLASMA_LOG.get()).logWithHorizontal(ModBlocks.PLASMA_LOG.get()).wood(ModBlocks.PLASMA_WOOD.get());
        blockModels.woodProvider(ModBlocks.STRIPPED_PLASMA_LOG.get()).logWithHorizontal(ModBlocks.STRIPPED_PLASMA_LOG.get()).wood(ModBlocks.STRIPPED_PLASMA_WOOD.get());

        blockModels.createTrivialCube(ModBlocks.PLASMA_PLANKS.get());
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream();
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return ModItems.ITEMS.getEntries().stream();
    }
}
