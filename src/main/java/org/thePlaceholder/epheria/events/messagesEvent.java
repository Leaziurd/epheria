package org.thePlaceholder.epheria.events;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import org.thePlaceholder.epheria.data.moneyManager;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.ChatColor;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.event.Listener;

import java.io.IOException;

public class messagesEvent implements Listener
{
    @EventHandler
    public void playerMessage(AsyncChatEvent event)
    {
        event.message(Component.text(PlaceholderAPI.setPlaceholders(event.getPlayer(), "%luckperms_prefix%") + " " + event.getPlayer().getName() + " : " + ChatColor.WHITE + event.originalMessage()));
    }
    
    @EventHandler
    public void playerDeath(final PlayerDeathEvent event) throws IOException {
        Integer account = moneyManager.get(event.getPlayer());
        double lostMoney = - account - account % 20.0;
        moneyManager.add(event.getEntity(), (int) lostMoney);
        event.deathMessage(Component.text(PlaceholderAPI.setPlaceholders(event.getEntity(), "%luckperms_prefix% " + event.getEntity().getName() + ChatColor.WHITE + " died and lost " + ChatColor.DARK_PURPLE + lostMoney + " EPH")));
    }
}
