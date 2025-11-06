package com.mia.thunderstormmod.item;

import com.mia.thunderstormmod.Thunderstorm;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Thunderstorm.MOD_ID);

    public static final DeferredItem<Item> BATTERY = ITEMS.registerItem("battery", Item::new);

    public static final DeferredItem<Item> THUNDER_STRIKE_DEV_ITEM = ITEMS.registerItem("thunder_strike_dev_item", ThunderStrikeDevItem::new);

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
