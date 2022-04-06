package org.thePlaceholder.epheria.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.thePlaceholder.epheria.items.sugarDiamond;

public class giveCustomItem implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(sender instanceof Player)
        {
            if(args[0] == null) return false;
            else
            {
                Player player = (Player) sender;

                if(args[0] == "sugar_diamond") player.getInventory().addItem(sugarDiamond.item());
            }
            return true;
        }
        else
        {
            return false;
        }
    }
}
