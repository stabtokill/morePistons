package morePistons.morePistons;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.src.ModLoader;
import net.minecraftforge.client.MinecraftForgeClient;
import morePistons.morePistons.CommonProxy;
import morePistons.morePistons.pistons.TileEntityMorePiston;
import morePistons.morePistons.pistons.TileEntityRendererMorePiston;

public class ClientProxy extends CommonProxy {
        
        @Override
        public void registerRenderers() {
                // This is for rendering entities and so forth later on
        	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMorePiston.class, new TileEntityRendererMorePiston());
           // MinecraftForgeClient.preloadTexture("/morePistons/blocks/block_textures");
        }
        
}