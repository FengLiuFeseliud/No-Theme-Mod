package fengliu.notheme.item;

import fengliu.notheme.item.armor.HeartArmor;
import fengliu.notheme.item.food.ice.cream.*;
import fengliu.notheme.item.heart.*;
import fengliu.notheme.item.heart.drop.HeartAbsorptionDevice;
import fengliu.notheme.item.heart.drop.HeartDrop;
import fengliu.notheme.item.heart.drop.HeartDropDevice;
import fengliu.notheme.item.heart.drop.HeartHalfDrop;
import fengliu.notheme.item.heart.fake.FakeHeart;
import fengliu.notheme.item.tool.*;
import fengliu.notheme.util.RegisterUtil;
import fengliu.notheme.util.item.BaseItem;
import fengliu.notheme.util.item.armor.BaseArmorItem;
import fengliu.notheme.util.level.ILevelItem;
import fengliu.notheme.util.level.LevelsUtil;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.DyeColor;

import java.util.List;
import java.util.Map;

import static fengliu.notheme.item.ModItemGroups.*;

public class ModItems {
    public static final BaseItem STABILIZER = register("stabilizer", HEART_GROUP);
    public static final BaseItem CUING_AGENT = register("curing_agent", HEART_GROUP);
    public static final EmptyBloodNeedle EMPTY_BLOOD_NEEDLE = register(new EmptyBloodNeedle(new FabricItemSettings().maxCount(1), "empty_blood_needle"), HEART_GROUP);
    public static final BloodNeedle BLOOD_NEEDLE = register(new BloodNeedle(new FabricItemSettings().maxCount(1), "blood_needle"), HEART_GROUP);
    public static final GoldBloodNeedle GOLD_BLOOD_NEEDLE = register(new GoldBloodNeedle(new FabricItemSettings().maxCount(1), "gold_blood_needle"), HEART_GROUP);
    public static final FrostBloodNeedle FROST_BLOOD_NEEDLE = register(new FrostBloodNeedle(new FabricItemSettings().maxCount(1), "frost_blood_needle"), HEART_GROUP);
    public static final PoisonBloodNeedle POISON_BLOOD_NEEDLE = register(new PoisonBloodNeedle(new FabricItemSettings().maxCount(1), "poison_blood_needle"), HEART_GROUP);
    public static final WitherBloodNeedle WITHER_BLOOD_NEEDLE = register(new WitherBloodNeedle(new FabricItemSettings().maxCount(1), "wither_blood_needle"), HEART_GROUP);
    public static final WaterBloodNeedle WATER_BLOOD_NEEDLE = register(new WaterBloodNeedle(new FabricItemSettings().recipeRemainder(EMPTY_BLOOD_NEEDLE).maxCount(1), "water_blood_needle"), HEART_GROUP);
    public static final EmptyHeart EMPTY_HEART = register(new EmptyHeart( "empty_heart"), HEART_GROUP);
    public static final Heart HEART = register(new Heart("heart"), HEART_GROUP);
    public static final FakeHeart FAKE_HEART = register(new FakeHeart(HEART), HEART_GROUP);
    public static final GoldHeart GOLD_HEART = register(new GoldHeart("gold_heart"), HEART_GROUP);
    public static final FakeHeart FAKE_GOLD_HEART = register(new FakeHeart(GOLD_HEART), HEART_GROUP);
    public static final FrostHeart FROST_HEART = register(new FrostHeart("frost_heart"), HEART_GROUP);
    public static final FakeHeart FAKE_FROST_HEART = register(new FakeHeart(FROST_HEART), HEART_GROUP);
    public static final PoisonHeart POISON_HEART = register(new PoisonHeart("poison_heart"), HEART_GROUP);
    public static final FakeHeart FAKE_POISON_HEART = register(new FakeHeart(POISON_HEART), HEART_GROUP);
    public static final WitherHeart WITHER_HEART = register(new WitherHeart("wither_heart"), HEART_GROUP);
    public static final FakeHeart FAKE_WITHER_HEART = register(new FakeHeart(WITHER_HEART), HEART_GROUP);
    public static final AnimalHeart ANIMAL_HEART = register(new AnimalHeart("animal_heart"), HEART_GROUP);
    public static final FakeHeart FAKE_ANIMAL_HEART = register(new FakeHeart(ANIMAL_HEART), HEART_GROUP);
    public static final HeartDrop HEART_DROP = register(new HeartDrop(new FabricItemSettings().maxCount(64), "heart_drop"), HEART_GROUP);
    public static final HeartHalfDrop HEART_HALF_DROP = register(new HeartHalfDrop(new FabricItemSettings().maxCount(64), "heart_half_drop"), HEART_GROUP);
    public static final Map<Item, ILevelItem> HEART_DROP_DEVICE = LevelsUtil.registerItems(HeartDropDevice.HeartDropDeviceLevels.values(), HEART_GROUP);
    public static final Map<Item, ILevelItem> HEART_ABSORPTION_DEVICE = LevelsUtil.registerItems(HeartAbsorptionDevice.HeartAbsorptionDeviceLevels.values(), HEART_GROUP);
    public static final HeartArmor HEART_HELMET = register(new HeartArmor(ArmorItem.Type.HELMET), HEART_GROUP);
    public static final HeartArmor HEART_CHESTPLATE = register(new HeartArmor(ArmorItem.Type.CHESTPLATE), HEART_GROUP);
    public static final HeartArmor HEART_LEGGINGS = register(new HeartArmor(ArmorItem.Type.LEGGINGS), HEART_GROUP);
    public static final HeartArmor HEART_BOOTS = register(new HeartArmor(ArmorItem.Type.BOOTS), HEART_GROUP);

    public static final BaseItem BAR = register("bar", FOOD_GROUP);
    public static final List<BaseItem> ICE_CREAM_BAR_PACKS = RegisterUtil.registerColorItems(DyeColor.values(), dyeColor -> new IceCreamBarPack(new FabricItemSettings().maxCount(16), dyeColor,"ice_cream_bar_pack"), FOOD_GROUP);
    public static final List<BaseItem> PACK_ICE_CREAM_BARS = RegisterUtil.registerColorItems(DyeColor.values(), dyeColor -> new PackIceCream(new FabricItemSettings().maxCount(1), dyeColor,"pack_ice_cream_bar"), FOOD_GROUP);
    public static final Map<Item, ILevelItem> ICE_CREAM_BARS = LevelsUtil.registerItems(IceCreamBar.IceCreamLevels.values(), FOOD_GROUP);
    public static final Map<Item, ILevelItem> CHOCOLATE_CRUST_ICE_CREAM_BARS = LevelsUtil.registerItems(ChocolateCrustIceCreamBar.IceCreamLevels.values(), FOOD_GROUP);
    public static final Map<Item, ILevelItem> COOKIE_ICE_CREAM_BARS = LevelsUtil.registerItems(CookieIceCreamBar.IceCreamLevels.values(), FOOD_GROUP);
    public static final Map<Item, ILevelItem> CHOCOLATE_CRUST_COOKIE_ICE_CREAM_BARS = LevelsUtil.registerItems(ChocolateCrustCookieIceCreamBar.IceCreamLevels.values(), FOOD_GROUP);
    public static final Map<Item, ILevelItem> SALT_WATER_POPSICLE = LevelsUtil.registerItems(SaltWaterPopsicle.IceCreamLevels.values(), FOOD_GROUP);
    public static final Map<Item, ILevelItem> GOLDEN_APPLE_ICE_CREAM_BARS = LevelsUtil.registerItems(GoldenAppleIceCreamBar.IceCreamLevels.values(), FOOD_GROUP);
    public static final Map<Item, ILevelItem> CHOCOLATE_CRUST_GOLDEN_APPLE_ICE_CREAM_BARS = LevelsUtil.registerItems(ChocolateCrustGoldenAppleIceCreamBar.IceCreamLevels.values(), FOOD_GROUP);
    public static final Map<Item, ILevelItem> CHORUS_FRUIT_ICE_CREAM_BARS = LevelsUtil.registerItems(ChorusFruitIceCreamBar.IceCreamLevels.values(), FOOD_GROUP);
    public static final Map<Item, ILevelItem> CHOCOLATE_CRUST_CHORUS_FRUIT_ICE_CREAM_BARS = LevelsUtil.registerItems(ChocolateCrustChorusFruitIceCreamBar.IceCreamLevels.values(), FOOD_GROUP);
    public static final Map<Item, ILevelItem> GLOW_BERRIES_ICE_CREAM_BARS = LevelsUtil.registerItems(GlowBerriesIceCreamBar.IceCreamLevels.values(), FOOD_GROUP);
    public static final Map<Item, ILevelItem> CHOCOLATE_CRUST_GLOW_BERRIES_ICE_CREAM_BARS = LevelsUtil.registerItems(ChocolateCrustGlowBerriesIceCreamBar.IceCreamLevels.values(), FOOD_GROUP);

    public static final BaseItem EMPTY_COLOR_PICKER = register(new EmptyColorPicker(new FabricItemSettings().maxCount(1), "empty_color_picker"), TOOL_GROUP);
    public static final List<BaseItem> COLOR_PICKERS = RegisterUtil.registerColorItems(DyeColor.values(), dyeColor -> new ColorPicker(new FabricItemSettings().maxCount(1).maxDamage(64), dyeColor,"color_picker"), TOOL_GROUP);
    public static final BaseItem EMPTY_SPRAY_GUN = register(new BaseItem(new FabricItemSettings().maxCount(1), "empty_spray_gun"), TOOL_GROUP);
    public static final List<BaseItem> SPRAY_GUNS = RegisterUtil.registerColorItems(DyeColor.values(), dyeColor -> new SprayGun(new FabricItemSettings().maxCount(1).maxDamage(64), dyeColor,"spray_gun"), TOOL_GROUP);
    public static final BaseItem EMPTY_BRUSH = register(new BaseItem(new FabricItemSettings().maxCount(1), "empty_brush"), TOOL_GROUP);
    public static final List<BaseItem> BRUSHS = RegisterUtil.registerColorItems(DyeColor.values(), dyeColor -> new Brush(new FabricItemSettings().maxCount(1).maxDamage(128), dyeColor,"brush"), TOOL_GROUP);
    public static final BaseItem EMPTY_WATER_BALLOON = register(new EmptyWaterBalloon(new FabricItemSettings().maxCount(64), "empty_water_balloon"), TOOL_GROUP);
    public static final BaseItem WATER_BALLOON = register(new WaterBalloon(new FabricItemSettings().maxCount(64), "water_balloon"), TOOL_GROUP);
    public static final List<BaseItem> COLOR_WATER_BALLOONS = RegisterUtil.registerColorItems(DyeColor.values(), dyeColor -> new ColorWaterBalloon(new FabricItemSettings().maxCount(64), dyeColor,"color_water_balloon"), TOOL_GROUP);
    public static final BaseItem EMPTY_WALL_GUN = register(new EmptyWallGun(new FabricItemSettings().maxCount(1), "empty_wall_gun"), TOOL_GROUP);
    public static final List<BaseItem> WALL_GUNS = RegisterUtil.registerColorItems(DyeColor.values(), dyeColor -> new WallGun(new FabricItemSettings().maxCount(1).maxDamage(9), dyeColor,"wall_gun"), TOOL_GROUP);
    public static final List<BaseItem> WALL_SHELLS = RegisterUtil.registerColorItems(DyeColor.values(), dyeColor -> new WallShell(new FabricItemSettings().maxCount(64), dyeColor,"wall_shell"), TOOL_GROUP);
    public static final BaseItem SCATTER_COLOR_GUN = register(new ScatterColorGun(new FabricItemSettings().maxCount(1), "scatter_color_gun"), TOOL_GROUP);
    public static final List<BaseItem> COLOR_SCATTER_COLOR_GUNS = RegisterUtil.registerColorItems(DyeColor.values(), dyeColor -> new ColorScatterColorGun(new FabricItemSettings().maxCount(1), dyeColor,"color_scatter_color_gun"), TOOL_GROUP);
    public static final List<BaseItem> PAINT_SMOKE_BOMBS = RegisterUtil.registerColorItems(DyeColor.values(), dyeColor -> new PaintSmokeBomb(new FabricItemSettings().maxCount(8), dyeColor,"paint_smoke_bomb"), TOOL_GROUP);
    public static final BaseItem SIGNAL_GUN = register(new SignalGun(new FabricItemSettings().maxCount(1), "signal_gun"), TOOL_GROUP);
    public static final List<BaseItem> SIGNAL_SHELLS = RegisterUtil.registerColorItems(DyeColor.values(), dyeColor -> new SignalShell(new FabricItemSettings().maxCount(16), dyeColor,"signal_shell"), TOOL_GROUP);

    public static <BI extends BaseItem> BI register(BI item, ItemGroup group){
        return RegisterUtil.registerItem(item.name, item, group, RegisterUtil.Model.GENERATED);
    }

    public static <BAI extends BaseArmorItem> BAI register(BAI item, ItemGroup group){
        return RegisterUtil.registerItem(item.name, item, group, RegisterUtil.Model.GENERATED);
    }

    public static BaseItem register(String id, ItemGroup group){
        return RegisterUtil.registerItem(id, new BaseItem(id), group, RegisterUtil.Model.GENERATED);
    }
}
