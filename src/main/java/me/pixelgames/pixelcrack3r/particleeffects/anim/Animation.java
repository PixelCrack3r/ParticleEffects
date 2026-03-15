package me.pixelgames.pixelcrack3r.particleeffects.anim;

import me.pixelgames.pixelcrack3r.particleeffects.context.AnimationContext;

public interface Animation {
    boolean tick(AnimationContext context, ParticleSink sink);
}