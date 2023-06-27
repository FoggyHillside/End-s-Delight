package cn.foggyhillside.endsdelight.renderer;

import cn.foggyhillside.endsdelight.tile.EndStoveTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.items.ItemStackHandler;
import vectorwing.farmersdelight.blocks.StoveBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class EndStoveTileEntityRenderer extends TileEntityRenderer<EndStoveTileEntity> {
    private static final Minecraft MC = Minecraft.getInstance();

    public EndStoveTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcher) {
        super(rendererDispatcher);
    }

    public void render(EndStoveTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        Direction direction = ((Direction)tileEntityIn.getBlockState().get(StoveBlock.HORIZONTAL_FACING)).getOpposite();
        ItemStackHandler inventory = tileEntityIn.getInventory();

        for(int i = 0; i < inventory.getSlots(); ++i) {
            ItemStack stoveStack = inventory.getStackInSlot(i);
            if (!stoveStack.isEmpty()) {
                matrixStackIn.push();
                matrixStackIn.translate(0.5, 1.02, 0.5);
                float f = -direction.getHorizontalAngle();
                matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f));
                matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90.0F));
                Vector2f itemOffset = tileEntityIn.getStoveItemOffset(i);
                matrixStackIn.translate((double)itemOffset.x, (double)itemOffset.y, 0.0);
                matrixStackIn.scale(0.375F, 0.375F, 0.375F);
                if (tileEntityIn.getWorld() != null) {
                    MC.getItemRenderer().renderItem(stoveStack, ItemCameraTransforms.TransformType.FIXED, WorldRenderer.getCombinedLight(tileEntityIn.getWorld(), tileEntityIn.getPos().up()), combinedOverlayIn, matrixStackIn, bufferIn);
                }

                matrixStackIn.pop();
            }
        }

    }
}
