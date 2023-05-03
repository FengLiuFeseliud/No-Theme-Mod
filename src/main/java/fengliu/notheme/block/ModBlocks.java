package fengliu.notheme.block;

import fengliu.notheme.block.heart.*;
import fengliu.notheme.util.RegisterUtil;
import fengliu.notheme.util.block.BaseBlock;
import fengliu.notheme.util.block.IBaseBlock;
import fengliu.notheme.util.level.ILevelBlock;
import fengliu.notheme.util.level.LevelsUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;

import java.util.Map;

public class ModBlocks {
    public static final Map<Block, ILevelBlock> CUSTOMERS_BLOCKS = LevelsUtil.getBlocks(CustomersBlock.CustomersBlockLevels.values());
    public static final Block BLOOD_POOL_BLOCK = new BloodPoolBlock(FabricBlockSettings.of(Material.STONE).strength(5.0f).requiresTool().nonOpaque());
    public static final BaseBlock WITHER_BLOCK = new WitherBlock(FabricBlockSettings.of(Material.SOIL).strength(0.5f, 0.5f).requiresTool().nonOpaque(), "wither_block");
    public static final BaseBlock LIFE_BLOCK = new LifeBlock(FabricBlockSettings.of(Material.SOIL).strength(0.5f, 0.5f).requiresTool().nonOpaque(), "life_block");
    public static final BaseBlock ABSORPTION_BLOCK = new AbsorptionBlock(FabricBlockSettings.of(Material.SOIL).strength(0.5f, 0.5f).requiresTool().nonOpaque(), "absorption_block");
    public static final BaseBlock FROST_BLOCK = new BaseBlock(FabricBlockSettings.of(Material.SOIL).strength(0.5f, 0.5f).requiresTool().nonOpaque(), "frost_block");
    public static final BaseBlock POISON_BLOCK = new BaseBlock(FabricBlockSettings.of(Material.SOIL).strength(0.5f, 0.5f).requiresTool().nonOpaque(), "poison_block");
    public static final BaseBlock ANIMAL_BLOCK = new BaseBlock(FabricBlockSettings.of(Material.SOIL).strength(0.5f, 0.5f).requiresTool().nonOpaque(), "animal_block");
    public static final BaseBlock LONG_FOR_LIFE_BLOCK = new LongForLifeBlock(FabricBlockSettings.of(Material.SOIL).strength(0.5f, 0.5f).requiresTool().nonOpaque(), "long_for_life_block");

    @Environment(EnvType.CLIENT)
    public static void setAllBlockRenderLayerMap(){
        BlockRenderLayerMap.INSTANCE.putBlock(BLOOD_POOL_BLOCK, RenderLayer.getTranslucent());
    };

    public static final BaseBlock[] HEART_GROUP_BLOCK = new BaseBlock[]{
        WITHER_BLOCK,
        LIFE_BLOCK,
        ABSORPTION_BLOCK,
        FROST_BLOCK,
        ANIMAL_BLOCK,
        POISON_BLOCK,
        LONG_FOR_LIFE_BLOCK
    };

    public static void registerAllBlock(){
        LevelsUtil.registerAllBlock(CUSTOMERS_BLOCKS);

        RegisterUtil.registerBlock((IBaseBlock) BLOOD_POOL_BLOCK);
        RegisterUtil.registerBlocks(HEART_GROUP_BLOCK);
    }
}