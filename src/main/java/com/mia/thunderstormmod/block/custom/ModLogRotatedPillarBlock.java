package com.mia.thunderstormmod.block.custom;

import com.mia.thunderstormmod.block.ModBlocks;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

public class ModLogRotatedPillarBlock extends RotatedPillarBlock {
    public ModLogRotatedPillarBlock(Properties properties) {
        super(properties.sound(SoundType.WOOD));
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is(ModBlocks.PLASMA_LOG)) {
                return ModBlocks.STRIPPED_PLASMA_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            } else if (state.is(ModBlocks.PLASMA_WOOD)) {
                return ModBlocks.STRIPPED_PLASMA_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }
        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
