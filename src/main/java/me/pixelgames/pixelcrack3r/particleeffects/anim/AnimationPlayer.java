package me.pixelgames.pixelcrack3r.particleeffects.anim;

import me.pixelgames.pixelcrack3r.particleeffects.context.AnimationContext;
import me.pixelgames.pixelcrack3r.particleeffects.context.AnimationContextProvider;
import me.pixelgames.pixelcrack3r.particleeffects.math.Transform;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;

public final class AnimationPlayer {

    private final JavaPlugin plugin;
    private final Map<Integer, BukkitTask> tasks = new HashMap<>();

    public AnimationPlayer(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public BukkitTask play(Animation animation, ParticleSink sink, AnimationContextProvider contextProvider) {
        BukkitRunnable runnable = new BukkitRunnable() {
            private long tick = 0;

            @Override
            public void run() {
                AnimationContext context = contextProvider.create(tick);

                tick++;

                boolean alive = animation.tick(context, sink);
                if (!alive) {
                    this.cancel();
                    tasks.remove(this.getTaskId());
                }
            }
        };

        BukkitTask task = runnable.runTaskTimer(plugin, 0L, 1L);
        tasks.put(task.getTaskId(), task);
        return task;
    }

    public void cancel(int taskId) {
        BukkitTask task = tasks.remove(taskId);
        if (task != null) {
            task.cancel();
        }
    }

    public void cancel(BukkitTask task) {
        if (task != null) {
            tasks.remove(task.getTaskId());
            task.cancel();
        }
    }

    public void cancelAll() {
        for (BukkitTask task : tasks.values()) {
            task.cancel();
        }
        tasks.clear();
    }
}