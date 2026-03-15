package me.pixelgames.pixelcrack3r.particleeffects.context;

import me.pixelgames.pixelcrack3r.particleeffects.math.Transform;
import me.pixelgames.pixelcrack3r.particleeffects.math.Vec3;
import org.bukkit.entity.Player;

public final class PlayerContextProvider implements AnimationContextProvider {

    private final Player player;

    public PlayerContextProvider(Player player) {
        this.player = player;
    }

    @Override
    public AnimationContext create(long tick) {
        var loc = player.getLocation();
        var vel = player.getVelocity();

        Transform transform = new Transform(
            new Vec3(loc.getX(), loc.getY(), loc.getZ())
        );

        EntitySnapshot entity = new EntitySnapshot(
            new Vec3(loc.getX(), loc.getY(), loc.getZ()),
            new Vec3(vel.getX(), vel.getY(), vel.getZ()),
            new Vec3(loc.getDirection().getX(), loc.getDirection().getY(), loc.getDirection().getZ()),
            player.getFallDistance() > 0,
            player.isSprinting(),
            player.isSneaking()
        );

        return new AnimationContext(
            tick,
            tick / 20.0,
            transform,
            entity
        );
    }
}