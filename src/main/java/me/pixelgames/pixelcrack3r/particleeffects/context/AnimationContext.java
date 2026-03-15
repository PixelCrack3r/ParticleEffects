package me.pixelgames.pixelcrack3r.particleeffects.context;

import me.pixelgames.pixelcrack3r.particleeffects.math.Transform;

public record AnimationContext(
        long tick,
        double timeSeconds,
        Transform transform,
        EntitySnapshot entity
) {}