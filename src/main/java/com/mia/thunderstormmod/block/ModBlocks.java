package com.mia.thunderstormmod.block;

import com.mia.thunderstormmod.Thunderstorm;
import com.mia.thunderstormmod.block.custom.ModLogRotatedPillarBlock;
import com.mia.thunderstormmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Thunderstorm.MOD_ID);

    public static final DeferredBlock<Block> ENERGY_BLOCK = ModBlocks.registerBlock("energy_block",
            (properties) -> new Block(properties
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> PLASMA_LOG = ModBlocks.registerBlock("plasma_log",
            (properties) -> new ModLogRotatedPillarBlock(properties.strength(3f)));

    public static final DeferredBlock<Block> PLASMA_WOOD = ModBlocks.registerBlock("plasma_wood",
            (properties) -> new ModLogRotatedPillarBlock(properties.strength(3f)));

    public static final DeferredBlock<Block> STRIPPED_PLASMA_LOG = ModBlocks.registerBlock("stripped_plasma_log",
            (properties) -> new ModLogRotatedPillarBlock(properties.strength(3f)));

    public static final DeferredBlock<Block> STRIPPED_PLASMA_WOOD = ModBlocks.registerBlock("stripped_plasma_wood",
            (properties) -> new ModLogRotatedPillarBlock(properties.strength(3f)));

    public static final DeferredBlock<Block> PLASMA_PLANKS = ModBlocks.registerBlock("plasma_planks",
            (properties) -> new Block(properties.strength(2f)));

    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, (properties) -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
