package org.thePlaceholder.epheria.commands;

import org.bukkit.ChatColor;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class b0tCommands implements CommandExecutor
{
    boolean isDoingSomething;
    
    public b0tCommands() {
        this.isDoingSomething = false;
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String alias, final String[] args) {
        final Player player = (Player) sender;

        if (!this.isDoingSomething) {

            if (args[0] == "kill") {
                if (Bukkit.getPlayer(args[1]) != null && Bukkit.getPlayer(args[1]).isOnline()) {

                    Bukkit.broadcast("kill " + args[1], "prefix.0.§7[b0t]");
                    Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "Leaziurd" + ChatColor.RESET + ChatColor.WHITE + "was sent to kill " + ChatColor.DARK_PURPLE + Bukkit.getPlayer(args[1]).getName());
                    isDoingSomething = true;
                }
                player.sendMessage("The player that you are trying to kill doesn't exist or is disconnected");
            }
        }
        else {
            player.sendMessage("The b0t is doing an action please use \"/b0t stop\" to stop it.");
        }

        if (args[1] == "stop") {
            Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "Leaziurd" + ChatColor.RESET + ChatColor.WHITE + "was stopped.");
            Bukkit.broadcast("stop", "prefix.0.§7[b0t]");
            this.isDoingSomething = false;
        }
        return true;
    }
}
