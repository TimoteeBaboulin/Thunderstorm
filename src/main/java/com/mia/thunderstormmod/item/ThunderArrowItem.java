package com.mia.thunderstormmod.item;

import com.mia.thunderstormmod.Thunderstorm;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class ThunderArrowItem extends ArrowItem {
    public ThunderArrowItem(Properties p_40512_) {
        super(p_40512_);
    }

    public static final Properties GetProperties(Properties _properties) {
        _properties.stacksTo(64);
        return _properties
                .durability(100);
    }

    public static final DeferredItem<ThunderArrowItem> register(String name) {
        return ModItems.ITEMS.registerItem(
                name,
                ThunderArrowItem::new,
                ThunderArrowItem::GetProperties);
    }

    @Override
    public AbstractArrow createArrow(Level level, ItemStack ammo, LivingEntity shooter, @Nullable ItemStack weapon)
    {
        Thunderstorm.LOGGER.info("Create Arrow");
        return new ThunderArrow(level, shooter, ammo.copyWithCount(1), weapon);
    }

    @Override
    public int getMaxStackSize(ItemStack stack)
    {
        return 64;
    }

    @Override
    public @NotNull Projectile asProjectile(Level level, Position position, ItemStack stack, Direction direction)
    {
        ThunderArrow arrow = new ThunderArrow(level, position.x(), position.y(), position.z(), stack.copyWithCount(1), null);
        arrow.pickup = AbstractArrow.Pickup.ALLOWED;
        return arrow;
    }
}
