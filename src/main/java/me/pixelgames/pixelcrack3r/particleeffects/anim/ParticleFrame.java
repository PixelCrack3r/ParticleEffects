package me.pixelgames.pixelcrack3r.particleeffects.anim;

import me.pixelgames.pixelcrack3r.particleeffects.math.Vec3;

public record ParticleFrame(
    Vec3 position,
    ParticleSpec particle
) {}