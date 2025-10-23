package be.artex.permafrost.entity;

import be.artex.permafrost.Permafrost;
import be.artex.permafrost.item.advanced.scythe.ScytheProjectileEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModEntityTypes {
    private static final RegistryKey<EntityType<?>> SCYTHE_KEY = RegistryKey.of(
            Registries.ENTITY_TYPE.getKey(),
            Identifier.of(Permafrost.MOD_ID, "scythe")
    );

    public static final EntityType<ScytheProjectileEntity> SCYTHE = register(
            SCYTHE_KEY,
            FabricEntityTypeBuilder.<ScytheProjectileEntity>create(SpawnGroup.MISC, ScytheProjectileEntity::new)
                    .dimensions(EntityType.ARROW.getDimensions())
                    .trackRangeBlocks(64)
                    .trackedUpdateRate(10)
    );

    private static <T extends Entity> EntityType<T> register(RegistryKey<EntityType<?>> key, FabricEntityTypeBuilder<T> builder) {
        return Registry.register(Registries.ENTITY_TYPE, key.getValue(), builder.build(key));
    }

    public static void registerModEntityTypes() {
        Permafrost.LOGGER.info("Registering Entity Types for " + Permafrost.MOD_ID);
    }
}
