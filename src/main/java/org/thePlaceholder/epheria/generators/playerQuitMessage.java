package org.thePlaceholder.epheria.generators;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;
import org.thePlaceholder.epheria.data.prefix;

public class playerQuitMessage
{
    public static void quitMessage(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        String playerName = player.getName();
        String minus = ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]";
        String playerPrefix = prefix.get(event.getPlayer());
        event.quitMessage(Component.text(minus + " " + playerPrefix + " " + playerName));
    }
}
