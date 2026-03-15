package me.pixelgames.pixelcrack3r.particleeffects.context;

import me.pixelgames.pixelcrack3r.particleeffects.math.Vec3;

public record EntitySnapshot(
    Vec3 position,
    Vec3 velocity,
    Vec3 lookDirection,
    boolean onGround,
    boolean sprinting,
    boolean sneaking
) {
    public static final EntitySnapshot NONE = new EntitySnapshot(
            Vec3.ZERO,
            Vec3.ZERO,
            Vec3.ZERO,
            false,
            false,
            false
    );
}