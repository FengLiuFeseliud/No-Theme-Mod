package fengliu.notheme.data.generation;

import fengliu.notheme.util.RegisterUtil;
import fengliu.notheme.util.item.BaseItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

import java.util.ConcurrentModificationException;
import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        RegisterUtil.COLORS_ITEM_LIST.forEach(colorItems -> {
            for(BaseItem item: colorItems){
                try {
                    item.generateRecipe(exporter);
                } catch (IllegalStateException | ConcurrentModificationException ignored){

                }
            }
        });
    }
}
