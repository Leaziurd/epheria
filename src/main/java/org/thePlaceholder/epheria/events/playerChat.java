package org.thePlaceholder.epheria.events;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.thePlaceholder.epheria.data.prefix;

public class playerChat implements Listener
{
    @EventHandler
    public void playerMessage(AsyncChatEvent event)
    {
        String baseMessage = PlainTextComponentSerializer.plainText().serialize(event.originalMessage());
        Component finalMessage = Component.text(prefix.get(event.getPlayer()) + " " + event.getPlayer().getName() + " : " + ChatColor.WHITE + baseMessage);

        event.message(finalMessage);
    }
}
