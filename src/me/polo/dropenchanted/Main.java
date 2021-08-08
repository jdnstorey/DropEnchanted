package me.polo.dropenchanted;

import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public class Main extends JavaPlugin implements Listener {

    ArrayList<UUID> droppers = new ArrayList<>();

    public void onEnable() {

    }

    public void onDisable(){}

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        Item item = e.getItemDrop();
        ItemStack is = item.getItemStack();
        Player p = e.getPlayer();

        if(is.getItemMeta().hasEnchants()){
            if(droppers.contains(p.getUniqueId())){
                droppers.remove(p.getUniqueId());
                return;
                //drop the item
            }
            if(!droppers.contains(p.getUniqueId())){
                droppers.add(p.getUniqueId());
                p.sendMessage(ChatColor.RED + "Are you sure you would like to drop this item?");
                e.setCancelled(true);
            }
        }
    }

}
