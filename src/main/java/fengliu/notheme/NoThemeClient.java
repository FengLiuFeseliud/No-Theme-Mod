package fengliu.notheme;

import fengliu.notheme.block.ModBlocks;
import fengliu.notheme.client.block.entity.renderer.ModBlockEntityRenderers;
import fengliu.notheme.entity.ModEntitys;
import fengliu.notheme.networking.packets.server.ModServerMessage;
import fengliu.notheme.screen.ModScreens;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class NoThemeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModBlocks.registerAllBlock();
        ModBlocks.setAllBlockRenderLayerMap();
        ModScreens.registerAllScreen();
        ModServerMessage.registerS2CPackets();
        ModBlockEntityRenderers.registerBlockEntityRenderers();

        ModEntitys.registerAllEntityRenderer();
    }
}
