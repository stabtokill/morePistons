package morePistons.morePistons.pistons;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import morePistons.morePistons.MorePistons;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityRendererMorePiston extends TileEntitySpecialRenderer
{
    /** instance of RenderBlocks used to draw the piston base and extension. */
    private RenderBlocks blockRenderer;

    public void renderPiston(TileEntityMorePiston par1TileEntity, double par2, double par4, double par6, float par8)
    {
        Block block = Block.blocksList[par1TileEntity.getStoredBlockID()];

        if (block != null && par1TileEntity.getProgress(par8) < 1.0F)
        {
            Tessellator tessellator = Tessellator.instance;
            this.func_110628_a(TextureMap.field_110575_b);
            RenderHelper.disableStandardItemLighting();
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_CULL_FACE);

            if (Minecraft.isAmbientOcclusionEnabled())
            {
                GL11.glShadeModel(GL11.GL_SMOOTH);
            }
            else
            {
                GL11.glShadeModel(GL11.GL_FLAT);
            }

            tessellator.startDrawingQuads();
            tessellator.setTranslation((double)((float)par2 - (float)par1TileEntity.xCoord + par1TileEntity.getOffsetX(par8)), (double)((float)par4 - (float)par1TileEntity.yCoord + par1TileEntity.getOffsetY(par8)), (double)((float)par6 - (float)par1TileEntity.zCoord + par1TileEntity.getOffsetZ(par8)));
            tessellator.setColorOpaque(1, 1, 1);

            if (block == MorePistons.doublePiston && par1TileEntity.getProgress(par8) < 0.5F)
            {
                this.blockRenderer.renderPistonExtensionAllFaces(block, par1TileEntity.xCoord, par1TileEntity.yCoord, par1TileEntity.zCoord, false);
            }
            else if (par1TileEntity.shouldRenderHead() && !par1TileEntity.isExtending())
            {
                Block.pistonExtension.setHeadTexture(((BlockPistonBase)block).getPistonExtensionTexture());
                this.blockRenderer.renderPistonExtensionAllFaces(Block.pistonExtension, par1TileEntity.xCoord, par1TileEntity.yCoord, par1TileEntity.zCoord, par1TileEntity.getProgress(par8) < 0.5F);
                Block.pistonExtension.clearHeadTexture();
                tessellator.setTranslation((double)((float)par2 - (float)par1TileEntity.xCoord), (double)((float)par4 - (float)par1TileEntity.yCoord), (double)((float)par6 - (float)par1TileEntity.zCoord));
                this.blockRenderer.renderPistonBaseAllFaces(block, par1TileEntity.xCoord, par1TileEntity.yCoord, par1TileEntity.zCoord);
            }
            else
            {
                this.blockRenderer.renderBlockAllFaces(block, par1TileEntity.xCoord, par1TileEntity.yCoord, par1TileEntity.zCoord);
            }

            tessellator.setTranslation(0.0D, 0.0D, 0.0D);
            tessellator.draw();
            RenderHelper.enableStandardItemLighting();
        }
    }

    /**
     * Called when the ingame world being rendered changes (e.g. on world -> nether travel) due to using one renderer
     * per tile entity type, rather than instance
     */
    public void onWorldChange(World par1World)
    {
        this.blockRenderer = new RenderBlocks(par1World);
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderPiston((TileEntityMorePiston)par1TileEntity, par2, par4, par6, par8);
    }
}
