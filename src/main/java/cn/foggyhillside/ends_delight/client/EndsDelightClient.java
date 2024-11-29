package cn.foggyhillside.ends_delight.client;

import cn.foggyhillside.ends_delight.client.render.EndStoveRenderer;
import cn.foggyhillside.ends_delight.registry.ModBlockEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class EndsDelightClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockEntityRenderers.register(ModBlockEntityTypes.END_STOVE.get(), EndStoveRenderer::new);
	}
}