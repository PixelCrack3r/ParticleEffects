package me.pixelgames.pixelcrack3r.particleeffects.anim.impl;

import me.pixelgames.pixelcrack3r.particleeffects.anim.*;
import me.pixelgames.pixelcrack3r.particleeffects.context.AnimationContext;
import me.pixelgames.pixelcrack3r.particleeffects.math.Vec3;

public final class PlayerTrailAnimation implements Animation {

    private final ParticleSpec spec;

    public PlayerTrailAnimation(ParticleSpec spec) {
        this.spec = spec;
    }

    @Override
    public boolean tick(AnimationContext context, ParticleSink sink) {
        Vec3 velocity = context.entity().velocity();
        if (velocity == null) {
            return true;
        }

        double speed = Math.sqrt(
            velocity.x() * velocity.x() +
            velocity.y() * velocity.y() +
            velocity.z() * velocity.z()
        );

        int points = Math.max(3, (int) Math.round(speed * 10));

        for (int i = 0; i < points; i++) {
            double t = i / (double) points;
            Vec3 offset = new Vec3(0, t * 0.5, 0);
            Vec3 pos = context.transform().apply(offset);
            sink.emit(new ParticleFrame(pos, spec));
        }

        return true;
    }
}