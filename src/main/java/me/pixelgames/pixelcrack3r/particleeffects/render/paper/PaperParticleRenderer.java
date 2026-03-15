package me.pixelgames.pixelcrack3r.particleeffects.render.paper;

import me.pixelgames.pixelcrack3r.particleeffects.anim.ParticleFrame;
import me.pixelgames.pixelcrack3r.particleeffects.anim.ParticleSink;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;

public final class PaperParticleRenderer implements ParticleSink {

    private final World world;
    private final int radius;

    public PaperParticleRenderer(World world, int radius) {
        this.world = world;
        this.radius = radius;
    }

    @Override
    public void emit(ParticleFrame frame) {
        Location loc = new Location(
            world,
            frame.position().x(),
            frame.position().y(),
            frame.position().z()
        );

        Particle particle = frame.particle().type();

        particle.builder()
            .location(loc)
            .count(frame.particle().count())
            .offset(
                frame.particle().offsetX(),
                frame.particle().offsetY(),
                frame.particle().offsetZ()
            )
            .extra(frame.particle().extra())
            .data(frame.particle().data())
            .receivers(radius, true)
            .spawn();
    }
}