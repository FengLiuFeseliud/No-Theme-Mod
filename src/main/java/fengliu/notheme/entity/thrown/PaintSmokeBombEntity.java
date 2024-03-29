package fengliu.notheme.entity.thrown;

import fengliu.notheme.entity.ModEntitys;
import fengliu.notheme.item.ModItems;
import fengliu.notheme.util.ShapeUtil;
import fengliu.notheme.util.entity.ColorItemPersistentThrownEntity;
import fengliu.notheme.util.item.BaseItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.joml.Vector3f;

import java.util.List;

public class PaintSmokeBombEntity extends ColorItemPersistentThrownEntity {
    public static final int CHANGE_TICK = 10;
    public static final int MAX_DURATION = 320;

    public PaintSmokeBombEntity(EntityType<ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public int getMaxDurationTick() {
        return MAX_DURATION;
    }

    public PaintSmokeBombEntity(PlayerEntity player, World world) {
        super(ModEntitys.PAINT_SMOKE_BOMB_ENTITY_TYPE, player, world);
    }

    @Override
    public List<BaseItem> getColorItems() {
        return ModItems.PAINT_SMOKE_BOMBS;
    }

    public void addParticle(int size, BlockPos fallPos, Vector3f color){
        ShapeUtil.fallQuadrilateral(size, size, fallPos, this.getMovementDirection(), pos -> {
            world.addParticle(new DustParticleEffect(color, 4F),
                    pos.getX() - 0.8, pos.getY() , pos.getZ() - 0.8, 1, 10, 1);
        });
    }

    @Override
    public void tick() {
        super.tick();
        int smokeTick = this.getDurationTick();
        if (smokeTick % 6 != 0){
            return;
        }

        BlockPos fallPos = this.getBlockPos().up();
        Vector3f color = Vec3d.unpackRgb(this.getColor().getFireworkColor()).toVector3f();
        this.addParticle(7, fallPos, color);

        if (CHANGE_TICK < smokeTick && smokeTick < MAX_DURATION - CHANGE_TICK){
            fallPos = fallPos.up();
            this.addParticle(7, fallPos, color);
        }

        if (2 * CHANGE_TICK < smokeTick && smokeTick < MAX_DURATION - CHANGE_TICK * 2){
            fallPos = fallPos.up();
            this.addParticle(7, fallPos, color);
        }

        if (3 * CHANGE_TICK < smokeTick && smokeTick < MAX_DURATION - CHANGE_TICK * 3){
            fallPos = fallPos.up();
            this.addParticle(5, fallPos, color);
        }

        if (4 * CHANGE_TICK < smokeTick && smokeTick < MAX_DURATION - CHANGE_TICK * 4){
            fallPos = fallPos.up();
            this.addParticle(3, fallPos, color);
        }
    }
}
