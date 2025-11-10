package com.mia.thunderstormmod.item;

import com.mia.thunderstormmod.Thunderstorm;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.Nullable;

public class ThunderArrow extends Arrow {

    public ThunderArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(level, owner, pickupItemStack, firedFromWeapon);
    }

    public ThunderArrow(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack weapon)
    {
        super(level, x, y, z, pickupItemStack, weapon);
    }

    public ThunderArrow(EntityType<ThunderArrow> thunderArrowEntityType, Level level) {
        super(thunderArrowEntityType, level);
    }

    static Item.Properties GetProperties(Item.Properties _properties) {
        return _properties
                .stacksTo(16)
                .durability(100);
    }

    @Override
    public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
        super.shoot(x, y, z, velocity, inaccuracy);
        // Additional behavior for ThunderArrow can be added here
    }

    private Boolean SpawnLightningAt(Level level, Vec3 pos)
    {
        if (!(level instanceof ServerLevel server))
            return false;

        EntitySpawnReason reason = EntitySpawnReason.TRIGGERED;
        LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(server, reason);
        if (bolt == null)
            return false;

        bolt.moveOrInterpolateTo(pos);
        server.addFreshEntity(bolt);
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        Thunderstorm.LOGGER.info("Thunder Arrow Tick");
        if (this.isInGround())
        {
            SpawnLightningAt(this.level(), this.position());
        }

        // Additional behavior for ThunderArrow can be added here
    }
}
