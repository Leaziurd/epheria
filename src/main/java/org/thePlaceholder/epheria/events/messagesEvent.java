package org.thePlaceholder.epheria.events;

import org.thePlaceholder.epheria.data.moneyManager;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.ChatColor;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.Listener;

import java.io.IOException;

public class messagesEvent implements Listener
{
    @EventHandler
    public void playerMessage(AsyncPlayerChatEvent event)
    {
        event.setFormat(PlaceholderAPI.setPlaceholders(event.getPlayer(), "%luckperms_prefix%") + " " + event.getPlayer().getName() + " : " + ChatColor.WHITE + event.getMessage());
    }
    
    @EventHandler
    public void playerDeath(final PlayerDeathEvent event) throws IOException {
        Integer account = moneyManager.get(event.getPlayer());
        double lostMoney = - account - account % 20.0;
        moneyManager.add(event.getEntity(), (int) lostMoney);
        event.setDeathMessage(PlaceholderAPI.setPlaceholders(event.getEntity(), "%luckperms_prefix% " + event.getEntity().getName() + ChatColor.WHITE + " died and lost " + ChatColor.DARK_PURPLE + lostMoney + " EPH"));
    }
}
