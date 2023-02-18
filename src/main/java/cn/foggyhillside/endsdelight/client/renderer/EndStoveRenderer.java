package cn.foggyhillside.endsdelight.client.renderer;

import cn.foggyhillside.endsdelight.block.EndStoveBlock;
import cn.foggyhillside.endsdelight.blockentitiy.EndStoveBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import net.minecraftforge.items.ItemStackHandler;

public class EndStoveRenderer implements BlockEntityRenderer<EndStoveBlockEntity> {
    public EndStoveRenderer(BlockEntityRendererProvider.Context context) {
    }

    public void render(EndStoveBlockEntity stoveEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int combinedLightIn, int combinedOverlayIn) {
        Direction direction = ((Direction)stoveEntity.getBlockState().getValue(EndStoveBlock.FACING)).getOpposite();
        ItemStackHandler inventory = stoveEntity.getInventory();
        int posLong = (int)stoveEntity.getBlockPos().asLong();

        for(int i = 0; i < inventory.getSlots(); ++i) {
            ItemStack stoveStack = inventory.getStackInSlot(i);
            if (!stoveStack.isEmpty()) {
                poseStack.pushPose();
                poseStack.translate(0.5, 1.02, 0.5);
                float f = -direction.toYRot();
                poseStack.mulPose(Vector3f.YP.rotationDegrees(f));
                poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
                Vec2 itemOffset = stoveEntity.getStoveItemOffset(i);
                poseStack.translate((double)itemOffset.x, (double)itemOffset.y, 0.0);
                poseStack.scale(0.375F, 0.375F, 0.375F);
                if (stoveEntity.getLevel() != null) {
                    Minecraft.getInstance().getItemRenderer().renderStatic(stoveStack, ItemTransforms.TransformType.FIXED, LevelRenderer.getLightColor(stoveEntity.getLevel(), stoveEntity.getBlockPos().above()), combinedOverlayIn, poseStack, buffer, posLong + i);
                }

                poseStack.popPose();
            }
        }

    }
}
