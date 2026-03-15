package me.pixelgames.pixelcrack3r.particleeffects.anim;

import org.bukkit.Particle;

public record ParticleSpec(
    Particle type,
    int count,
    double offsetX,
    double offsetY,
    double offsetZ,
    double extra,
    Object data
) {}