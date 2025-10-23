package be.artex.permafrost.item.advanced.scythe;

import be.artex.permafrost.damageType.ModDamageTypes;
import be.artex.permafrost.item.ModItems;
import be.artex.permafrost.particle.ModParticles;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class ScytheProjectileEntity extends PersistentProjectileEntity {
    private int life;

    public ScytheProjectileEntity(EntityType<? extends ScytheProjectileEntity> type, World world) {
        super(type, world);
        this.life = -20;
    }

    @Override
    public void tick() {
        super.tick();

        World world = getWorld();

        if (world.isClient) {
            world.addParticle(ModParticles.ICE_PARTICLE,
                    this.getX(), this.getY(), this.getZ(),
                    0, 0, 0);
            return;
        }

        if (world.getBlockState(this.getBlockPos()).isSolid()) {
            this.discard();
            return;
        }

        life++;

        if (life > 0)
            this.discard();
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.FROZEN_SCYTHE);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        if (hitResult.getType() == HitResult.Type.BLOCK)
            this.discard();
        else
            onEntityHit((EntityHitResult) hitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        World world = getWorld();

        if (world.isClient)
            return;

        ServerWorld serverWorld = (ServerWorld) world;
        Entity entity = entityHitResult.getEntity();

        entity.damage(serverWorld, new DamageSource(ModDamageTypes.createDamageType(ModDamageTypes.SCYTHE, world), this, null), 3f);
    }

    @Override
    public boolean hasNoGravity() {
        return true;
    }
}
