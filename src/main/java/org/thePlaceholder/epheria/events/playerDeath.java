package org.thePlaceholder.epheria.events;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.thePlaceholder.epheria.data.moneyManager;
import org.thePlaceholder.epheria.data.prefix;

import java.io.IOException;

public class playerDeath implements Listener
{
    @EventHandler
    public void playerDeathEvent(final PlayerDeathEvent event) throws IOException
    {
        double account = moneyManager.get(event.getPlayer());
        double lostMoney = - account - account % 20.0;
        moneyManager.add(event.getEntity(), (int) lostMoney);

        event.deathMessage(Component.text(prefix.get(event.getPlayer()) + " " + event.getEntity().getName() + ChatColor.WHITE + " died and lost " + ChatColor.DARK_PURPLE + lostMoney + " EPH"));
    }
}
