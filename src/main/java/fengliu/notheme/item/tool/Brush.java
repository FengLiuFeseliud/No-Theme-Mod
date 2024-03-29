package fengliu.notheme.item.tool;

import fengliu.notheme.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class Brush extends ColorPicker {
    public final DyeColor dyeColor;

    public Brush(Settings settings, DyeColor dyeColor, String textureName) {
        super(settings, dyeColor, textureName);
        this.dyeColor = dyeColor;
    }

    @Override
    public DyeColor getColor() {
        return this.dyeColor;
    }

    public Item getEmptyItem() {
        return ModItems.EMPTY_BRUSH;
    }

    public static BlockState sprayBlock(BlockState blockState, @Nullable DyeColor color) {
        if (color == null){
            return blockState;
        }

        String blockPath = Registries.BLOCK.getId(blockState.getBlock()).getPath();
        for (DyeColor oldColor : DyeColor.values()) {
            if (!blockPath.startsWith(oldColor.getName())) {
                continue;
            }

            return Registries.BLOCK.get(new Identifier(blockPath.replace(oldColor.getName(), color.getName()))).getDefaultState();
        }
        return blockState;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        context.getWorld().setBlockState(context.getBlockPos(), Brush.sprayBlock(context.getWorld().getBlockState(context.getBlockPos()), this.getColor()));
        if (context.getWorld().isClient()) {
            return ActionResult.SUCCESS;
        }

        if (context.getStack().damage(1, context.getWorld().random, (ServerPlayerEntity) context.getPlayer())) {
            context.getPlayer().setStackInHand(context.getHand(), ModItems.EMPTY_BRUSH.getDefaultStack());
        }
        return ActionResult.SUCCESS;
    }
}
