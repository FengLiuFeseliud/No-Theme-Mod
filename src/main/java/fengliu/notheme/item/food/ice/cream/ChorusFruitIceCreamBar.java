package fengliu.notheme.item.food.ice.cream;

import fengliu.notheme.item.ModItems;
import fengliu.notheme.util.level.ILevelItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

import java.util.Map;

public class ChorusFruitIceCreamBar extends IceCreamBar {
    public ChorusFruitIceCreamBar(Settings settings, String name) {
        super(settings, name);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        Items.CHORUS_FRUIT.finishUsing(Items.CHORUS_FRUIT.getDefaultStack(), world, user);
        if (user instanceof PlayerEntity player) {
            this.getIceCreams().forEach(((item, iLevelItem) -> {
                player.getItemCooldownManager().set(item, 20);
            }));
        }

        return super.finishUsing(stack, world, user);
    }

    @Override
    public Map<Item, ILevelItem> getIceCreams() {
        return ModItems.CHORUS_FRUIT_ICE_CREAM_BARS;
    }

    public enum IceCreamLevels implements IIceCreamLevel {
        NOT_THAW(1, 600, 3, "not_thaw"),
        THAW_HALF(2, 300, 2, "thaw_half"),
        THAW_MOST(3, 150, 1, "thaw_most");

        private final int level;
        private final int thawTime;
        private final int gain;
        private final String thawName;

        IceCreamLevels(int level, int thawTime, int gain, String thawName) {
            this.thawTime = thawTime * 20;
            this.level = level;
            this.gain = gain;
            this.thawName = thawName;
        }

        @Override
        public FoodComponent getFoodComponent() {
            return new FoodComponent.Builder()
                .hunger((int) (2.5f * this.gain)).saturationModifier((float) (this.gain))
                .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 100 * this.gain), 1.0f)
                .alwaysEdible().build();
        }

        @Override
        public int getThawTime() {
            return this.thawTime;
        }

        @Override
        public String getThawName() {
            return this.thawName;
        }

        @Override
        public int getLevel() {
            return this.level;
        }

        @Override
        public int getMaxLevel() {
            return IceCreamLevels.values().length;
        }

        @Override
        public int getGain() {
            return this.gain;
        }

        @Override
        public String getIdName() {
            return "chorus_fruit_ice_cream_bar";
        }

        @Override
        public Item getItem() {
            return new ChorusFruitIceCreamBar(new FabricItemSettings().maxCount(1).maxDamage(this.getMaxLevel()).food(this.getFoodComponent()), this.getIdName());
        }
    }
}
