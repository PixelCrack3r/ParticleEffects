package me.pixelgames.pixelcrack3r.particleeffects.context;

import me.pixelgames.pixelcrack3r.particleeffects.math.Transform;

public final class StaticContextProvider implements AnimationContextProvider {

    private final Transform transform;

    public StaticContextProvider(Transform transform) {
        this.transform = transform;
    }

    @Override
    public AnimationContext create(long tick) {
        return new AnimationContext(
                tick,
                tick / 20.0,
                transform,
                EntitySnapshot.NONE
        );
    }
}