package me.pixelgames.pixelcrack3r.particleeffects.math;

public final class AnimMath {
    private AnimMath() {}

    public static double tau() {
        return Math.PI * 2.0;
    }

    public static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

    public static double lerp(double a, double b, double t) {
        return a + (b - a) * t;
    }

    public static Vec3 lerp(Vec3 a, Vec3 b, double t) {
        return new Vec3(
            lerp(a.x(), b.x(), t),
            lerp(a.y(), b.y(), t),
            lerp(a.z(), b.z(), t)
        );
    }
}