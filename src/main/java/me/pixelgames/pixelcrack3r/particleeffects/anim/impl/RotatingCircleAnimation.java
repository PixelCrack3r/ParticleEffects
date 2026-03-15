package me.pixelgames.pixelcrack3r.particleeffects.anim.impl;

import me.pixelgames.pixelcrack3r.particleeffects.anim.*;
import me.pixelgames.pixelcrack3r.particleeffects.context.AnimationContext;
import me.pixelgames.pixelcrack3r.particleeffects.math.AnimMath;
import me.pixelgames.pixelcrack3r.particleeffects.math.Vec3;

public class RotatingCircleAnimation implements Animation {

    private final double radius;
    private final int points;
    private final double angularSpeed;
    private final ParticleSpec spec;

    public RotatingCircleAnimation(double radius, double angularSpeed, ParticleSpec spec) {
        this.radius = radius;
        this.angularSpeed = angularSpeed;
        this.points = Math.max(8, (int) Math.round(radius * Math.PI * 2));
        this.spec = spec;
    }

    @Override
    public boolean tick(AnimationContext context, ParticleSink sink) {
        long tick = context.tick();
        double rotation = tick * angularSpeed;
        for(int i = 0; i < points; i++) {
            double t = i / ((double)points);
            double angle = t * AnimMath.tau() + rotation;

            double x = Math.cos(angle) * radius;
            double z = Math.sin(angle) * radius;

            Vec3 pos = context.transform().apply(new Vec3(x, 0, z));

            sink.emit(new ParticleFrame(
                    pos,
                    spec
            ));
        }
        return true;
    }
}
