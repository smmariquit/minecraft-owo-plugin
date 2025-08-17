package com.example.owoplugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class OwoPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new OwoListener(), this);
    }
}

class OwoListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        boolean cowNearby = player.getNearbyEntities(5, 5, 5).stream()
                .anyMatch(entity -> entity instanceof Cow);
        if (cowNearby) {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "OWO");
        }
    }
}
