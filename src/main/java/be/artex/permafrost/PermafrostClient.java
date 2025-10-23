package be.artex.permafrost;

import be.artex.permafrost.entity.ModEntityTypes;
import be.artex.permafrost.particle.ModParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EmptyEntityRenderer;

public class PermafrostClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModParticles.registerModParticlesClient();
        EntityRendererRegistry.register(ModEntityTypes.SCYTHE, EmptyEntityRenderer::new);
    }
}
