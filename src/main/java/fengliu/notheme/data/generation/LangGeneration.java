package fengliu.notheme.data.generation;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fengliu.notheme.util.RegisterUtil;
import fengliu.notheme.util.color.IColor;
import fengliu.notheme.util.item.BaseItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class LangGeneration extends FabricLanguageProvider {
    private final FabricDataOutput dataGenerator;
    private final Map<String, String> colorTranslations = new HashMap<>();

    public LangGeneration(FabricDataOutput dataGenerator) {
        super(dataGenerator, "zh_cn");
        this.dataGenerator = dataGenerator;
        this.getColorTranslations();
    }

    public void getColorTranslations(){
        this.colorTranslations.put("white", "白色");
        this.colorTranslations.put("orange", "橙色");
        this.colorTranslations.put("magenta", "品红色");
        this.colorTranslations.put("light_blue", "淡蓝色");
        this.colorTranslations.put("yellow", "黄色");
        this.colorTranslations.put("lime", "黄绿色");
        this.colorTranslations.put("pink", "粉红色");
        this.colorTranslations.put("gray", "灰色");
        this.colorTranslations.put("light_gray", "淡灰色");
        this.colorTranslations.put("cyan", "青色");
        this.colorTranslations.put("purple", "紫色");
        this.colorTranslations.put("blue", "蓝色");
        this.colorTranslations.put("brown", "棕色");
        this.colorTranslations.put("green", "绿色");
        this.colorTranslations.put("red", "红色");
        this.colorTranslations.put("black", "黑色");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        JsonObject translations;
        try {
            Path existingFilePath = this.dataGenerator.getModContainer().findPath("assets/notheme/lang/zh_cn.existing.json").get();
            translationBuilder.add(existingFilePath);

            try (Reader reader = Files.newBufferedReader(existingFilePath)) {
                translations = JsonParser.parseReader(reader).getAsJsonObject();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to add existing language file!", e);
        }

        RegisterUtil.COLORS_ITEM_LIST.forEach(colorItemList -> {
            for(BaseItem item: colorItemList){
                if (!(item instanceof IColor color)){
                    continue;
                }

                String translationKey = "item.notheme."+item.getTextureName();
                try {
                    translationBuilder.add(item, this.colorTranslations.get(color.getColor().getName())+translations.get(translationKey).getAsString());
                } catch (Exception e) {
                    throw new RuntimeException("未添加键 "+ translationKey + " ?", e);
                }
            }
        });
    }
}
