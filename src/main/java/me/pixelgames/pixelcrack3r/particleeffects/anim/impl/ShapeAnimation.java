package me.pixelgames.pixelcrack3r.particleeffects.anim.impl;

import me.pixelgames.pixelcrack3r.particleeffects.anim.*;
import me.pixelgames.pixelcrack3r.particleeffects.context.AnimationContext;
import me.pixelgames.pixelcrack3r.particleeffects.math.Vec3;
import me.pixelgames.pixelcrack3r.particleeffects.shape.Shape;

public final class ShapeAnimation implements Animation {
    private final Shape shape;
    private final int points;
    private final ParticleSpec spec;
    private final long durationTicks;

    public ShapeAnimation(Shape shape, int points, ParticleSpec spec, long durationTicks) {
        this.shape = shape;
        this.points = points;
        this.spec = spec;
        this.durationTicks = durationTicks;
    }

    @Override
    public boolean tick(AnimationContext context, ParticleSink sink) {
        if (context.tick() >= durationTicks) {
            return false;
        }

        for (int i = 0; i < points; i++) {
            double t = i / (double) points;
            Vec3 point = context.transform().apply(shape.sample(t));
            sink.emit(new ParticleFrame(point, spec));
        }

        return true;
    }
}