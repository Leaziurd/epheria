package org.thePlaceholder.epheria.data;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class prefix
{
    public static String get(Player player)
    {
        if(player.hasPermission("epheria.op")) return ChatColor.RED + "[OP]";
        else return ChatColor.WHITE + "[MEMBER]";
    }
}