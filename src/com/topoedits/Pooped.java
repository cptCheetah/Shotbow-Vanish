package com.topoedits;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Pooped implements Listener { 
    PluginManager pm = Bukkit.getPluginManager();

  @EventHandler
  public void onAttemptPop(EntityDamageByEntityEvent event) {
    Entity attacker = event.getDamager();
    Entity entity = event.getEntity();
    if (((entity instanceof Player)) && ((attacker instanceof Player))) {
      final Player target = (Player)entity;
      final Player popper = (Player)attacker;
      try {
          
        ((ParticleEffect)ParticleEffect.LAVA).sendToPlayer(popper, target.getLocation(), 0.0F, 2.0F, 1.0F, 20.0F, 100);
        ((ParticleEffect)ParticleEffect.HEART).sendToPlayer(popper, target.getLocation(), 0.0F, 1.0F, 1.0F, 20.0F, 10);
        ((ParticleEffect)ParticleEffect.WITCH_MAGIC).sendToPlayer(popper, target.getLocation(), 0.0F, 0.0F, 1.0F, 20.0F, 25);
      }
      catch (Exception e) {
          
        e.printStackTrace();
      }
      popper.hidePlayer(target);
      popper.sendMessage(ChatColor.LIGHT_PURPLE + "You just popped " + target.getName() + "!");
      event.setCancelled(true);
      popper.getWorld().playSound(target.getLocation(), Sound.CHICKEN_EGG_POP, 0.75F, 0.75F);
      popper.sendMessage(ChatColor.LIGHT_PURPLE + "You just popped " + target.getName() + "!");
      target.sendMessage(ChatColor.LIGHT_PURPLE + "You have been popped by " + popper.getName() + "!");
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this, new Runnable() {
        public void run() {
          popper.showPlayer(target);
        }
      }, 60L);
    }
  }
  
}
