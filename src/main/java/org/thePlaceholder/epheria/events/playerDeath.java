package org.thePlaceholder.epheria.events;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.thePlaceholder.epheria.data.moneyManager;
import org.thePlaceholder.epheria.data.prefix;
import org.thePlaceholder.epheria.menus.mainMenu;

public class playerDeath implements Listener
{
    @EventHandler
    public void playerDeathEvent(PlayerDeathEvent event)
    {
        event.getDrops().remove(mainMenu.generateMenuStar());

        double account = moneyManager.get(event.getPlayer());
        double lostMoney = - account - (account % 20.0);
        if(account < lostMoney)
        {
            moneyManager.add(event.getEntity(), (int) lostMoney);
            event.deathMessage(Component.text(prefix.get(event.getPlayer()) + " " + event.getEntity().getName() + ChatColor.WHITE + " died and lost " + ChatColor.DARK_PURPLE + lostMoney + " EPH"));
        }
        else
        {
            event.deathMessage(Component.text(prefix.get(event.getPlayer()) + " " + event.getEntity().getName() + ChatColor.WHITE + " died"));
        }
    }
}
