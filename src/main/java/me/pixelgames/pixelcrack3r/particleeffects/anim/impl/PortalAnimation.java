package me.pixelgames.pixelcrack3r.particleeffects.anim.impl;

import me.pixelgames.pixelcrack3r.particleeffects.anim.Animation;
import me.pixelgames.pixelcrack3r.particleeffects.anim.ParticleFrame;
import me.pixelgames.pixelcrack3r.particleeffects.anim.ParticleSink;
import me.pixelgames.pixelcrack3r.particleeffects.anim.ParticleSpec;
import me.pixelgames.pixelcrack3r.particleeffects.context.AnimationContext;
import me.pixelgames.pixelcrack3r.particleeffects.math.AnimMath;
import me.pixelgames.pixelcrack3r.particleeffects.math.Vec3;

public class PortalAnimation implements Animation {

    private final double width;
    private final double height;

    private final int framePoints;
    private final int swirlPoints;

    private final double frameRotationSpeed;
    private final double swirlSpeed;
    private final double depth;

    private final ParticleSpec frameParticle;
    private final ParticleSpec swirlParticle;

    public PortalAnimation(
            double width,
            double height,
            int framePoints,
            int swirlPoints,
            double frameRotationSpeed,
            double swirlSpeed,
            double depth,
            ParticleSpec frameParticle,
            ParticleSpec swirlParticle
    ) {
        this.width = width;
        this.height = height;
        this.framePoints = framePoints;
        this.swirlPoints = swirlPoints;
        this.frameRotationSpeed = frameRotationSpeed;
        this.swirlSpeed = swirlSpeed;
        this.depth = depth;
        this.frameParticle = frameParticle;
        this.swirlParticle = swirlParticle;
    }

    @Override
    public boolean tick(AnimationContext context, ParticleSink sink) {
        long tick = context.tick();
        renderFrame(context, sink, tick);
        renderSwirl(context, sink, tick);
        return true;
    }

    private void renderFrame(AnimationContext context, ParticleSink sink, long tick) {
        double rotation = tick * this.frameRotationSpeed;
        for(int i = 0; i < this.framePoints; ++i) {
            double t = i / (double)this.framePoints;
            double angle = t * AnimMath.tau() + rotation;

            double x = Math.cos(angle) * this.width;
            double y = Math.sin(angle) * this.height;

            double z = Math.sin(angle * 3.0 + tick * 0.12) * depth;
            emit(context, sink, new Vec3(x, y, z), frameParticle);
        }
    }

    private void renderSwirl(AnimationContext context, ParticleSink sink, long tick) {
        double rotation = tick * this.swirlSpeed;

        for(int i = 0; i < this.swirlPoints; ++i) {
            double t = i / (double)this.swirlPoints;

            double radiusX = AnimMath.lerp(this.width * 0.85, width * 0.08, t);
            double radiusY = AnimMath.lerp(this.height * 0.85, height * 0.08, t);

            double angle = rotation + t * AnimMath.tau() * 3.5;

            double x = Math.cos(angle) * radiusX;
            double y = Math.sin(angle) * radiusY;

            double z = Math.cos((angle * 2 - tick * 0.08) * (depth * (1 - t)));

            emit(context, sink, new Vec3(x, y, z), swirlParticle);
        }
    }


    private void emit(AnimationContext context, ParticleSink sink, Vec3 local, ParticleSpec spec) {
        Vec3 pos = context.transform().apply(local);
        sink.emit(new ParticleFrame(pos, spec));
    }

}
