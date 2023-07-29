package cn.foggyhillside.ends_delight;

import cn.foggyhillside.ends_delight.client.render.EndStoveBlockEntityRenderer;
import cn.foggyhillside.ends_delight.registry.ModBlockEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;

public class EndsDelightClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockEntityRendererRegistry.register(ModBlockEntity.EndStove, EndStoveBlockEntityRenderer::new);
	}
}