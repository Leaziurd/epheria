package org.thePlaceholder.epheria.data;

import org.bukkit.entity.Player;

import java.io.IOException;

public class moneyManager
{
    public static void add(Player player, Integer integer) throws IOException
    {
        Integer money = (Integer) dataManager.getData(player, "money");

        if(money == null)
        {
            dataManager.setData(player, "money", integer);
        }
        else
        {
            dataManager.setData(player, "money", money + integer);
        }
    }

    public static double get(Player player)
    {
        Integer amount = (Integer) dataManager.getData(player, "money");
        if(amount == null) return 0.00;
        return amount;
    }
}
