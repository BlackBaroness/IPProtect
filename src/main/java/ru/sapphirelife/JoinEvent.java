package ru.sapphirelife;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class JoinEvent implements Listener {

    /**
     * Listener for the player's login to the server
     */

    private final JavaPlugin core;

    public JoinEvent(JavaPlugin core) {
        this.core = core;
    }

    @EventHandler
    private void onJoin(PlayerJoinEvent e) {
        JoinThread thread = new JoinThread(core, e.getPlayer());
    }
}
