package be.artex.permafrost.particles;

import be.artex.permafrost.Permafrost;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.*;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final SimpleParticleType ICE_PARTICLE = FabricParticleTypes.simple();

    private static void registerParticule(String name, ParticleType particle) {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Permafrost.MOD_ID, name), particle);
    }

    public static void registerModParticles() {
        registerParticule("ice_particle", ICE_PARTICLE);
    }

    public static void registerModParticlesClient() {
        ParticleFactoryRegistry instance =  ParticleFactoryRegistry.getInstance();

        instance.register(ICE_PARTICLE, FireSmokeParticle.Factory::new);
    }
}
