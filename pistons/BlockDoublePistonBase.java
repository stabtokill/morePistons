package morePistons.morePistons.pistons;



import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockPistonMoving;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDoublePistonBase extends BlockPistonBase
{

	public BlockDoublePistonBase(int par1, boolean par2) {
		super(par1, par2);
		setUnlocalizedName("morePistons:piston_double_bottom");
	}
    @SideOnly(Side.CLIENT)
    public static Icon func_94496_b(String par0Str)
    {
        return par0Str == "piston_side" ? morePistons.morePistons.MorePistons.doublePiston : (par0Str == "piston_top_normal" ? Block.pistonBase.topIcon : (par0Str == "piston_top_sticky" ? Block.pistonStickyBase.topIcon : (par0Str == "piston_inner" ? Block.pistonBase.innerTopIcon : null)));
    }

}

