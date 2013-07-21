package morePistons.morePistons;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import morePistons.morePistons.pistons.BlockDoublePistonBase;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Item;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit; 
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="MorePistons", name="MorePistons", version="0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class MorePistons {

		public static final BlockDoublePistonBase doublePiston = new BlockDoublePistonBase(700, false);
		
		
		
		  public static CreativeTabs tabPistons = new CreativeTabs("tabPistons") {
              public ItemStack getIconItemStack() {
                      return new ItemStack(net.minecraft.item.Item.appleRed, 1, 0);
              }
      };
	
        // The instance of your mod that Forge uses.
        @Instance("MorePistons")
        public static MorePistons instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="morePistons.morePistons.ClientProxy", serverSide="morePistons.morePistons.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) {
                
        	
        	
        	
        	doublePiston.setCreativeTab(tabPistons);
        	LanguageRegistry.addName(doublePiston, "Double Piston");
        	
        	LanguageRegistry.instance().addStringLocalization("itemGroup.tabPistons", "en_US", "Pistons");
        	
        	
        	proxy.registerRenderers();
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}