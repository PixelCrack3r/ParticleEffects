package me.pixelgames.pixelcrack3r.particleeffects.anim.impl;

import me.pixelgames.pixelcrack3r.particleeffects.anim.Animation;
import me.pixelgames.pixelcrack3r.particleeffects.context.AnimationContext;
import me.pixelgames.pixelcrack3r.particleeffects.anim.ParticleSink;

import java.util.ArrayList;
import java.util.List;

public class CompositeAnimation implements Animation {

    private final List<Animation> animations;

    public CompositeAnimation(Animation... animations) {
        this.animations = new ArrayList<>(List.of(animations));
    }

    @Override
    public boolean tick(AnimationContext context, ParticleSink sink) {
        this.animations.removeIf(animation -> !animation.tick(context, sink));
        return !this.animations.isEmpty();
    }
}
