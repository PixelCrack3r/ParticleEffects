package me.pixelgames.pixelcrack3r.particleeffects.shape;

import me.pixelgames.pixelcrack3r.particleeffects.math.Vec3;

public interface Shape {
    Vec3 sample(double t); // t in [0, 1]
}