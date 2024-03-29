package fengliu.notheme.item.tool;

import fengliu.notheme.item.ModItems;
import fengliu.notheme.util.color.IColor;
import fengliu.notheme.util.item.BaseItem;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class ScatterColorGun extends BaseItem {
    public static final String COOL_COUNT_KEY = "coolCount";
    public static final int COOL_TIME = 80;
    public static final int SCATTER_QUANTITY = 3;
    public static final int YAW_OFFSET = 10;
    private boolean sendWallShell = false;
    private int spawnCount = 0;

    public ScatterColorGun(Settings settings, String name) {
        super(settings, name);
    }

    public ScatterColorGun(Settings settings, DyeColor color, String name) {
        super(settings, color, name);
    }

    private interface ShellEntitySpawn{
        void spawn(ThrownItemEntity shell);
    }

    public DyeColor getColor(){
        return null;
    }

    public static int getScatterQuantity(ItemStack stack){
        return SCATTER_QUANTITY + EnchantmentHelper.getLevel(Enchantments.MULTISHOT, stack) * 2;
    }

    private ThrownItemEntity getWaterBalloonShell(WaterBalloon waterBalloon, World world, PlayerEntity player){
        ThrownItemEntity shell = waterBalloon.getEntity(world, player);
        if (this.getColor() == null){
            shell.setItem(ModItems.COLOR_WATER_BALLOONS.get(0).getDefaultStack());
            return shell;
        }

        for (BaseItem item: ModItems.COLOR_WATER_BALLOONS){
            if (!this.getColor().equals(((IColor) item).getColor())){
                continue;
            }
            shell.setItem(item.getDefaultStack());
        }
        return shell;
    }

    private void stackSpawnShells(int scatterQuantity, ItemStack stack, PlayerEntity player, World world, ShellEntitySpawn spawn){
        ThrownItemEntity shell;
        for (int count = 0; count < stack.getCount(); count++){
            if (this.spawnCount >= scatterQuantity){
                break;
            }

            if (stack.getItem() instanceof WaterBalloon waterBalloon){
                shell = this.getWaterBalloonShell(waterBalloon, world, player);
                stack.decrement(1);
            } else {
                if (!player.isSneaking()){
                    break;
                }
                List<Block> blocks = EmptyWallGun.getWallBlocks(player, this.getColor());
                if (blocks.isEmpty()){
                    break;
                }

                shell = WallGun.getColorShellEntity(world, player, blocks, this.getColor());
                this.sendWallShell = true;
            }

            spawn.spawn(shell);
            this.spawnCount ++;
        }
    }

    public boolean spawnShells(World world, PlayerEntity player, ItemStack handStack, ShellEntitySpawn spawn){
        this.spawnCount = 0;
        this.sendWallShell = false;
        int scatterQuantity = ScatterColorGun.getScatterQuantity(handStack);
        for (int index = 0; index < PlayerInventory.MAIN_SIZE + 9; index++){
            ItemStack stack = player.getInventory().getStack(index);
            if (!(stack.getItem() instanceof WaterBalloon) && !(stack.getItem() instanceof BlockItem)){
                continue;
            }

            this.stackSpawnShells(scatterQuantity, stack, player, world, spawn);
            if (this.spawnCount >= scatterQuantity){
                break;
            }
        }
        return sendWallShell;
    }

    public void gunNbtCool(PlayerEntity player, Hand hand){
        ItemStack stack = player.getStackInHand(hand);
        NbtCompound nbt = stack.getOrCreateNbt();
        if (!nbt.contains(COOL_COUNT_KEY, NbtElement.INT_TYPE)){
            nbt.putInt(COOL_COUNT_KEY, 1);
            return;
        }

        int coolCount = nbt.getInt(COOL_COUNT_KEY);
        if (coolCount >= 5){
            nbt.putInt(COOL_COUNT_KEY, 0);
            player.getItemCooldownManager().set(this, COOL_TIME);
            return;
        }

        nbt.putInt(COOL_COUNT_KEY, nbt.getInt(COOL_COUNT_KEY) + 1);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient){
            return super.use(world, user, hand);
        }

        ItemStack stack = user.getStackInHand(hand);
        float pitch = user.getPitch();
        float[] yaw = new float[]{user.getYaw() - (float) (YAW_OFFSET * ScatterColorGun.getScatterQuantity(stack)) / 2};
        if (this.spawnShells(world, user, stack, shell -> {
            shell.setVelocity(user, pitch, yaw[0], 0.0F, 1.5F, 0F);
            world.spawnEntity(shell);
            yaw[0] = yaw[0] + YAW_OFFSET;
        })){
            user.getItemCooldownManager().set(this, COOL_TIME);
            for (BaseItem item: ModItems.COLOR_SCATTER_COLOR_GUNS){
                user.getItemCooldownManager().set(item, COOL_TIME);
            }
            EmptyWallGun.coolWallGun(user);
        } else {
            this.gunNbtCool(user, hand);
        }

        return super.use(world, user, hand);
    }
}
