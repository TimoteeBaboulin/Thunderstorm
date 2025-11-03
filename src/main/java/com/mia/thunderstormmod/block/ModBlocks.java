package com.mia.thunderstormmod.block;

import com.mia.thunderstormmod.Thunderstorm;
import com.mia.thunderstormmod.item.ModItems;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Thunderstorm.MOD_ID);

    public static final DeferredBlock<Block> ENERGY_BLOCK = ModBlocks.registerBlock("energy_block");

    public static DeferredBlock<Block> registerBlock(String name)
    {
        DeferredBlock<Block> block = BLOCKS.registerSimpleBlock(name);
        ModItems.registerBlockItem(name, block);
        return block;
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
