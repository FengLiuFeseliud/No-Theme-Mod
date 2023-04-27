package fengliu.notheme.util;

import fengliu.notheme.NoThemeMod;
import net.minecraft.util.Identifier;

public class IdUtil {

    public static Identifier get(String name){
        return new Identifier(NoThemeMod.MOD_ID, name);
    }

    public static Identifier getTooltip(String name){
        return new Identifier(NoThemeMod.MOD_ID, name);
    }

    public static String getItemTooltip(String name){
        return "item." + NoThemeMod.MOD_ID + "." + name + ".tooltip";
    }

    public static String getItemTooltip(String name, int index){
        return "item." + NoThemeMod.MOD_ID + "." + name + ".tooltip." + index;
    }

    public static String getBlockItemTooltip(String name){
        return "block.item." + NoThemeMod.MOD_ID + "." + name + ".tooltip";
    }

    public static String getBlockItemTooltip(String name, int index){
        return "block.item." + NoThemeMod.MOD_ID + "." + name + ".tooltip." + index;
    }

    public static String getDisplayName(String name){
        return "block." + NoThemeMod.MOD_ID + "." + name + ".display.name";
    }

    public static String getDeathMessage(String name){
        return NoThemeMod.MOD_ID + ".death." + name;
    }
}
