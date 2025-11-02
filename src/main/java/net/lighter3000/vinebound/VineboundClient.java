package net.lighter3000.vinebound;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.client.rendering.EntityRendererRegistryImpl;
import net.lighter3000.vinebound.entity.ModEntities;
import net.lighter3000.vinebound.entity.client.MossGolemModel;
import net.lighter3000.vinebound.entity.client.MossGolemRenderer;
import net.minecraft.client.render.entity.model.EntityModel;

public class VineboundClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(MossGolemModel.MOSS_GOLEM, MossGolemModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MOSS_GOLEM, MossGolemRenderer::new);

    }
}
