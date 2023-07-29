package cn.foggyhillside.ends_delight.client.render;

import cn.foggyhillside.ends_delight.block.EndStoveBlock;
import cn.foggyhillside.ends_delight.blockentity.EndStoveBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec2f;

@Environment(EnvType.CLIENT)
public class EndStoveBlockEntityRenderer implements BlockEntityRenderer<EndStoveBlockEntity> {
    public EndStoveBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    public void render(EndStoveBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        Direction direction = ((Direction)entity.getCachedState().get(EndStoveBlock.FACING)).getOpposite();
        DefaultedList<ItemStack> inventory = entity.getInventory();
        int intPos = (int)entity.getPos().asLong();

        for(int i = 0; i < inventory.size(); ++i) {
            ItemStack itemStack = (ItemStack)inventory.get(i);
            if (!itemStack.isEmpty()) {
                matrices.push();
                matrices.translate(0.5, 1.02, 0.5);
                float angle = -direction.asRotation();
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(angle));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
                Vec2f itemOffset = entity.getStoveItemOffset(i);
                matrices.translate((double)itemOffset.x, (double)itemOffset.y, 0.0);
                matrices.scale(0.375F, 0.375F, 0.375F);
                if (entity.getWorld() != null) {
                    int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
                    MinecraftClient.getInstance().getItemRenderer().renderItem(itemStack, ModelTransformationMode.FIXED, lightAbove, overlay, matrices, vertexConsumers, entity.getWorld(), intPos + i);
                }

                matrices.pop();
            }
        }

    }
}

