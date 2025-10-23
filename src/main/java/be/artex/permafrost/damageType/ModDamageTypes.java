package be.artex.permafrost.damageType;

import be.artex.permafrost.Permafrost;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDamageTypes {
    public static final RegistryKey<DamageType> SCYTHE = damageTypeKey("scythe");

    private static RegistryKey<DamageType> damageTypeKey(String name) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(Permafrost.MOD_ID, name));
    }

    public static RegistryEntry<DamageType> createDamageType(RegistryKey<DamageType> key, World world) {
        return world.getRegistryManager()
                .getOrThrow(RegistryKeys.DAMAGE_TYPE)
                .getEntry(key.getValue()).get();
    }
}
