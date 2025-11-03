package com.mia.thunderstormmod.item;

import com.mia.thunderstormmod.Thunderstorm;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Thunderstorm.MOD_ID);

    public static final DeferredItem<Item> BATTERY = ITEMS.registerSimpleItem("battery");
    public static final DeferredItem<ThunderStrikeDevItem> THUNDER_STRIKE_DEV_ITEM = ThunderStrikeDevItem.register("thunder_strike_dev_item");

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
