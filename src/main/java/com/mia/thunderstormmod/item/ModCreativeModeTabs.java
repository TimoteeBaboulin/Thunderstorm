package com.mia.thunderstormmod.item;

import com.mia.thunderstormmod.Thunderstorm;
import com.mia.thunderstormmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Thunderstorm.MOD_ID);

    public static final Supplier<CreativeModeTab> THUNDERSTORM_TAB = CREATIVE_MODE_TAB.register("thunderstorm_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.THUNDER_STRIKE_DEV_ITEM.get()))
                    .title(Component.translatable("item_group." + Thunderstorm.MOD_ID + ".thunderstorm_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BATTERY);
                        output.accept(ModItems.THUNDER_STRIKE_DEV_ITEM);
                        output.accept(ModBlocks.ENERGY_BLOCK);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
