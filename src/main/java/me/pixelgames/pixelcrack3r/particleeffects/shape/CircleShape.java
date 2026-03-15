package me.pixelgames.pixelcrack3r.particleeffects.shape;

import me.pixelgames.pixelcrack3r.particleeffects.math.Vec3;

public final class CircleShape implements Shape {
    private final double radius;

    public CircleShape(double radius) {
        this.radius = radius;
    }

    @Override
    public Vec3 sample(double t) {
        double angle = t * Math.PI * 2.0;
        return new Vec3(
            Math.cos(angle) * radius,
            0,
            Math.sin(angle) * radius
        );
    }
}