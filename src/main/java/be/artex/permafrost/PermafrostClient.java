package be.artex.permafrost;

import be.artex.permafrost.particles.ModParticles;
import net.fabricmc.api.ClientModInitializer;

public class PermafrostClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModParticles.registerModParticlesClient();
    }
}
