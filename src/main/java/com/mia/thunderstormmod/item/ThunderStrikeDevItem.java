package com.mia.thunderstormmod.item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class ThunderStrikeDevItem extends Item {
    public ThunderStrikeDevItem(Properties properties) {
        super(properties);
    }

    public static Properties GetProperties(Properties _properties) {
        return _properties
                .stacksTo(1)
                .fireResistant();
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
    public InteractionResult useOn(UseOnContext context)
    {
        Level level = context.getLevel();
        Vec3 position = context.getClickedPos().above().getCenter();
        Boolean success = SpawnLightningAt(level, position);

        InteractionResult result;
        if (!success)
            result = InteractionResult.FAIL;
        else
            result = InteractionResult.SUCCESS;
        return result;
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        Level level = target.level();
        SpawnLightningAt(level, target.position());
    }
}
