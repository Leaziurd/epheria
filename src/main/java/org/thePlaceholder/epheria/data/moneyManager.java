package org.thePlaceholder.epheria.data;

import org.bukkit.entity.Player;

import java.io.IOException;

public class moneyManager
{
    public static void add(Player player, Integer integer) throws IOException {
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

    public static Integer get(Player player){
        Integer amount = (Integer) dataManager.getData(player, "money");
        return amount;
    }
}
