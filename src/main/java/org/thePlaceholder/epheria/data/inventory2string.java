package org.thePlaceholder.epheria.data;

import java.io.IOException;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Bukkit;
import org.bukkit.util.io.BukkitObjectInputStream;
import java.io.ByteArrayInputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
import org.bukkit.util.io.BukkitObjectOutputStream;
import java.io.ByteArrayOutputStream;
import org.bukkit.inventory.Inventory;

public class inventory2string
{
    public static String toBase64(Inventory inventory) throws IllegalStateException, IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);

        dataOutput.writeInt(inventory.getSize());

        for (int i = 0; i < inventory.getSize(); i++) {
            dataOutput.writeObject(inventory.getItem(i));
        }

        dataOutput.close();
        return Base64Coder.encodeLines(outputStream.toByteArray());
    }

    public static Inventory fromBase64(String data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
        BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
        Inventory inventory = Bukkit.getServer().createInventory(null, dataInput.readInt());

        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, (ItemStack) dataInput.readObject());
        }

        dataInput.close();
        return inventory;
    }
}
