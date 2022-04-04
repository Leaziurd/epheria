package org.thePlaceholder.epheria.generators;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.thePlaceholder.epheria.data.moneyManager;
import org.thePlaceholder.epheria.data.prefix;
import org.thePlaceholder.epheria.menus.mainMenu;

import java.io.IOException;

public class playerJoinMessage
{
    public static void joinMessage(PlayerJoinEvent event) throws IOException
    {
        Player player = event.getPlayer();
        String playerName = player.getName();
        String plus = ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]";

        if (!player.hasPlayedBefore())
        {
            event.joinMessage(Component.text(plus + " It's " + prefix.get(player) + " " + playerName + " first time on the server."));
            moneyManager.add(player,25);
            player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "Leaziurd" + ChatColor.RESET + ChatColor.WHITE + " sent you " + ChatColor.RESET + ChatColor.DARK_PURPLE + " 25.0EPH");
        }
        else
        {
            event.joinMessage(Component.text(plus + " " + prefix.get(player) + " " + playerName));
        }
        player.getInventory().setItem(17, mainMenu.generateMenuStar());
    }
}