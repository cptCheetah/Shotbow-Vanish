package com.topoedits;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public void onEnable(){
        double version = 1.2;
        System.out.println("Plugin Enabled" + version);
           registerEvents(this, new Pooped());

    }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player player = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("pooped")) && 
      (player.hasPermission("pooped.admin")) && 
      (args.length < 1))
    {
      player.sendMessage("§b§m----------<<§c Pooped§a Commands §b§m>>§b§m----------");
      player.sendMessage("");
      player.sendMessage(" §cThe Commands Only Available From The v1.1 ");
      player.sendMessage("  §e/rlpooped:§7§o Reload Plugin.");
      player.sendMessage("  §b/ebpooped:§7§o Enable Plugin");
      player.sendMessage("  §a/dspooped:§7§o Disable Plugin");
      player.sendMessage("");
      player.sendMessage("§b§m----------------------------------------");
    return true;
    }
    
    //Reload Command
     if (cmd.getName().equalsIgnoreCase("rlpooped")) {
     Player p = (Player)sender;
      if (player.hasPermission("pooped.admin"))
      {
        PluginManager plg = Bukkit.getPluginManager();
        Plugin plgname = plg.getPlugin("Pooped");
        plg.disablePlugin(plgname);
        plg.enablePlugin(plgname);
        player.sendMessage(ChatColor.GREEN + "[Shotbow Vanish]" + ChatColor.RED + "Plugin Reloaded!");
      }
      return true;
     }
     //Disabling Command
  if (cmd.getName().equalsIgnoreCase("ebpooped")) {
     Player p = (Player)sender;
      if (player.hasPermission("pooped.admin"))
      {
        PluginManager plg = Bukkit.getPluginManager();
        Plugin plgname = plg.getPlugin("Pooped");
        plg.disablePlugin(plgname);
        plg.enablePlugin(plgname);
        player.sendMessage(ChatColor.GREEN + "[Shotbow Vanish]" + ChatColor.RED + "Plugin Enabled...");
      }
      return true;   
  }
      //Enable Command
  if (cmd.getName().equalsIgnoreCase("dspooped")) {
     Player p = (Player)sender;
      if (player.hasPermission("poop.disable"))
      {
        PluginManager plg = Bukkit.getPluginManager();
        Plugin plgname = plg.getPlugin("Pooped");
        plg.disablePlugin(plgname);
        player.sendMessage(ChatColor.GREEN + "[Shotbow Vanish]" + ChatColor.RED + "Plugin Disabling...");
      }
      return true;   
  }
      return false;
}
   private void registerEvents(Main main, Pooped pooped) {
      
  }
}
