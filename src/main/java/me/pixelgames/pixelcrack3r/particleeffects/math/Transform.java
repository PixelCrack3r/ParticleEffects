package me.pixelgames.pixelcrack3r.particleeffects.math;

public final class Transform {
    private final Vec3 translation;

    public Transform(Vec3 translation) {
        this.translation = translation;
    }

    public Vec3 apply(Vec3 point) {
        return point.add(translation);
    }

    public static Transform identity() {
        return new Transform(new Vec3(0, 0, 0));
    }
}