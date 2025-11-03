package com.mia.thunderstormmod.item;

import com.mia.thunderstormmod.Thunderstorm;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems extends Item{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Thunderstorm.MOD_ID);

    public static final DeferredItem<Item> BATTERY = ITEMS.registerItem(
            "battery",
            ModItems::new,
            ModItems::SetProperties
    );

    public ModItems(Properties properties) {
        super(properties);
    }

    public static Item.Properties SetProperties(Item.Properties properties) {
        return properties;
    }

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
