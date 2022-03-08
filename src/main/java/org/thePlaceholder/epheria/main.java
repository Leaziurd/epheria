package org.thePlaceholder.epheria;

import java.util.List;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.OfflinePlayer;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.thePlaceholder.epheria.commands.b0tCommands;
import org.thePlaceholder.epheria.events.interactsEvents;
import org.thePlaceholder.epheria.events.inventoriesEvents;
import org.thePlaceholder.epheria.events.messagesEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;
import org.thePlaceholder.epheria.events.playerJoinAndQuitEvent;
import org.bukkit.ChatColor;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin
{
    private static main instance;
    public static ItemStack menu_star;
    ItemMeta menu_starMeta;
    public static Economy economy;

    public main() {
        this.menu_starMeta = main.menu_star.getItemMeta();
    }

    public void onEnable() {
        main.instance = this;
        this.menu_starMeta.setDisplayName(invokedynamic(makeConcatWithConstants:(Lorg/bukkit/ChatColor;)Ljava/lang/String;, ChatColor.YELLOW));
        main.menu_star.setItemMeta(this.menu_starMeta);
        this.getServer().getPluginManager().registerEvents((Listener)new playerJoinAndQuitEvent(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new messagesEvent(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new inventoriesEvents(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new interactsEvents(), (Plugin)this);
        this.getCommand("b0t").setExecutor((CommandExecutor)new b0tCommands());
    }

    public static main getPlugin() {
        return main.instance;
    }

    static {
        main.menu_star = new ItemStack(Material.NETHER_STAR);
        main.economy = (Economy)new Economy() {
            public boolean isEnabled() {
                return false;
            }

            public String getName() {
                return null;
            }

            public boolean hasBankSupport() {
                return false;
            }

            public int fractionalDigits() {
                return 0;
            }

            public String format(final double v) {
                return null;
            }

            public String currencyNamePlural() {
                return null;
            }

            public String currencyNameSingular() {
                return null;
            }

            public boolean hasAccount(final String s) {
                return false;
            }

            public boolean hasAccount(final OfflinePlayer offlinePlayer) {
                return false;
            }

            public boolean hasAccount(final String s, final String s1) {
                return false;
            }

            public boolean hasAccount(final OfflinePlayer offlinePlayer, final String s) {
                return false;
            }

            public double getBalance(final String s) {
                return 0.0;
            }

            public double getBalance(final OfflinePlayer offlinePlayer) {
                return 0.0;
            }

            public double getBalance(final String s, final String s1) {
                return 0.0;
            }

            public double getBalance(final OfflinePlayer offlinePlayer, final String s) {
                return 0.0;
            }

            public boolean has(final String s, final double v) {
                return false;
            }

            public boolean has(final OfflinePlayer offlinePlayer, final double v) {
                return false;
            }

            public boolean has(final String s, final String s1, final double v) {
                return false;
            }

            public boolean has(final OfflinePlayer offlinePlayer, final String s, final double v) {
                return false;
            }

            public EconomyResponse withdrawPlayer(final String s, final double v) {
                return null;
            }

            public EconomyResponse withdrawPlayer(final OfflinePlayer offlinePlayer, final double v) {
                return null;
            }

            public EconomyResponse withdrawPlayer(final String s, final String s1, final double v) {
                return null;
            }

            public EconomyResponse withdrawPlayer(final OfflinePlayer offlinePlayer, final String s, final double v) {
                return null;
            }

            public EconomyResponse depositPlayer(final String s, final double v) {
                return null;
            }

            public EconomyResponse depositPlayer(final OfflinePlayer offlinePlayer, final double v) {
                return null;
            }

            public EconomyResponse depositPlayer(final String s, final String s1, final double v) {
                return null;
            }

            public EconomyResponse depositPlayer(final OfflinePlayer offlinePlayer, final String s, final double v) {
                return null;
            }

            public EconomyResponse createBank(final String s, final String s1) {
                return null;
            }

            public EconomyResponse createBank(final String s, final OfflinePlayer offlinePlayer) {
                return null;
            }

            public EconomyResponse deleteBank(final String s) {
                return null;
            }

            public EconomyResponse bankBalance(final String s) {
                return null;
            }

            public EconomyResponse bankHas(final String s, final double v) {
                return null;
            }

            public EconomyResponse bankWithdraw(final String s, final double v) {
                return null;
            }

            public EconomyResponse bankDeposit(final String s, final double v) {
                return null;
            }

            public EconomyResponse isBankOwner(final String s, final String s1) {
                return null;
            }

            public EconomyResponse isBankOwner(final String s, final OfflinePlayer offlinePlayer) {
                return null;
            }

            public EconomyResponse isBankMember(final String s, final String s1) {
                return null;
            }

            public EconomyResponse isBankMember(final String s, final OfflinePlayer offlinePlayer) {
                return null;
            }

            public List<String> getBanks() {
                return null;
            }

            public boolean createPlayerAccount(final String s) {
                return false;
            }

            public boolean createPlayerAccount(final OfflinePlayer offlinePlayer) {
                return false;
            }

            public boolean createPlayerAccount(final String s, final String s1) {
                return false;
            }

            public boolean createPlayerAccount(final OfflinePlayer offlinePlayer, final String s) {
                return false;
            }
        };
    }
}
