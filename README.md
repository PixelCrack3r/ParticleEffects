# ParticleEffects

A lightweight particle animation library for **Paper** designed for clean, reusable, tick-based effects.

Instead of hardcoding particle rendering logic everywhere, this library lets you define **animations** that emit particle frames every tick and hand the rendering over to a `ParticleSink`.

## Features

- Built for **Paper**
- Tick-based animation system
- Clean separation between:
  - animation logic
  - context/state
  - rendering
- Static and dynamic context providers
- Composable animations
- Reusable particle specs
- Easy to extend with custom animations
