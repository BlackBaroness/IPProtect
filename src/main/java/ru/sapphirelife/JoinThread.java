package ru.sapphirelife;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class JoinThread extends Thread {

    /**
     * IP processing thread
     */

    private final JavaPlugin core;
    private final Player p;

    public JoinThread(JavaPlugin core, Player p) {
        this.core = core;
        this.p = p;
        start();
    }

    @Override
    public synchronized void start() {
        core.reloadConfig();
        FileConfiguration cfg = core.getConfig();
        String reason = cfg.getString("reason");
        String nick = p.getName();
        String ip = p.getAddress().getAddress().toString().replace("/", "");
        List<String> list = cfg.getStringList(nick);
        System.out.println(ip);

        // checking for a player in the list
        if (list.toString().equals("[]")) return;

        if (!list.contains(ip)) {
            p.kickPlayer(reason);
        }
    }
}
