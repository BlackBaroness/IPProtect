package ru.sapphirelife;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class IPProtect extends JavaPlugin {

    /**
     * Plugin to the IP whitelist.
     * Allows you to log in for a player only from certain addresses.
     * VERY useful for players with a large number of permissions (admins).
     *
     * @author Black_Baroness
     */

    @Override
    public void onEnable() {
        File file = new File(getDataFolder() + File.separator + "config.yml");
        if (!file.exists()) saveDefaultConfig();

        JoinEvent event = new JoinEvent(this);
        Bukkit.getPluginManager().registerEvents(event, this);

        System.out.println(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "[IPProtect] " + ChatColor.RESET + "Protection activated. Would you like some tea, captain?");
        System.out.println(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "[IPProtect] " + ChatColor.RESET + "Don't worry, you'll never find more reliable than me.");
    }
}
