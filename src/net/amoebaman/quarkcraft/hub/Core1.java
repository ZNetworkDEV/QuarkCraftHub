/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.HoverEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;
import net.quarkcraft.hub.cofredeltesoro.CofreDelTesoro;
import net.quarkcraft.hub.cofredeltesoro.CofreDelTesoroHandler;
import net.quarkcraft.hub.events.Events;
import net.quarkcraft.hub.nms.PetsManager;
import net.quarkcraft.hub.scoreboard.ScoreboardListener;
import net.quarkcraft.hub.utils.BungeeUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Player.Spigot;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Core1
  extends JavaPlugin
{
  private static Core1 instance;
  private ScoreboardListener scoreboardListener;
  private PetsManager nmsmanager;
  public ProtocolManager protocolManager;
  public List<String> palabras;
  public String recompensa;
  public boolean ganador;
  public static long tiempo;
  public static Random random;
  public String palabra;
  
  public void onEnable()
  {
    instance = this;
    
    this.nmsmanager = new PetsManager();
    
    this.protocolManager = ProtocolLibrary.getProtocolManager();
    
    this.palabras = new ArrayList();
    this.palabras.add("jkADSKqw");
    this.palabras.add("KSDAAAIWQ");
    this.palabras.add("OEQWOEPAS");
    this.palabras.add("kASDJae");
    this.palabras.add("msdaKDwqie");
    
    random = new Random();
    
    getServer().getPluginManager().registerEvents(new Events(), this);
    
    this.scoreboardListener = new ScoreboardListener();
    
    disableSound();
    
    getServer().getPluginManager().registerEvents(this.scoreboardListener, this);
    
    this.scoreboardListener = new ScoreboardListener();
    
    this.scoreboardListener.setupScoreboard();
    
    BungeeUtils.setup(this);
    
    new CofreDelTesoroHandler(this);
    
    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable()
    {
      public void run()
      {
        Location cofre = new Location(Bukkit.getWorld("Lobby"), 15.505D, 40.875D, 4.441D);
        Location cofre1 = new Location(Bukkit.getWorld("Lobby"), 15.505D, 39.875D, 4.441D);
        new CofreDelTesoro(cofre, cofre1.getBlock(), 0);
      }
    }, 60L);
    
    Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(getInstance(), new Runnable()
    {
      public void run()
      {
        Core1.tiempo = new Date().getTime();
        Core1.getInstance();Core1.getInstance().palabra = ((String)Core1.getInstance().palabras.get(Core1.random().nextInt(Core1.getInstance().palabras.size())));
        for (Player p : Bukkit.getServer().getOnlinePlayers())
        {
          TextComponent textComponent = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&eChat &6» &e¡Pon el cursor aqui para ver la palabra oculta!"));
          textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.GREEN + Core1.getInstance().palabra).create()));
          p.spigot().sendMessage(textComponent);
        }
        Core1.getInstance().ganador = false;
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core1.getInstance(), new Runnable()
        {
          public void run()
          {
            if (!Core1.getInstance().ganador)
            {
              for (Player p : Bukkit.getServer().getOnlinePlayers())
              {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eChat &6» &e¡Nadie adivino la palabra a tiempo!"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eChat &6» &e¡La palabra era&a " + Core1.this.palabra + "&e !"));
              }
              Core1.getInstance().palabra = "";
            }
          }
        }, 500L);
      }
    }, 0L, 1000L);
  }

  
  public static Random random()
  {
    return random;
  }
  
  public void onDisable() {}
  
  public void disableSound()
  {
    this.protocolManager.addPacketListener(
      new PacketAdapter(instance, ListenerPriority.HIGH, new PacketType[] { PacketType.Play.Server.NAMED_SOUND_EFFECT })
      {
        public void onPacketSending(PacketEvent event)
        {
          WrapperPlayServerNamedSoundEffect named = new WrapperPlayServerNamedSoundEffect(event.getPacket());
          if (named.getSoundName().equals("mob.wolf.bark")) {
            event.setCancelled(true);
          } else if (named.getSoundName().equals("mob.wolf.growl")) {
            event.setCancelled(true);
          } else if (named.getSoundName().equals("mob.wolf.howl")) {
            event.setCancelled(true);
          } else if (named.getSoundName().equals("mob.wolf.panting")) {
            event.setCancelled(true);
          } else if (named.getSoundName().equals("mob.wolf.shake")) {
            event.setCancelled(true);
          } else if (named.getSoundName().equals("mob.wolf.whine")) {
            event.setCancelled(true);
          }
        }
      });
  }
  
  public PetsManager getNmsManager()
  {
    return this.nmsmanager;
  }
  
  public ScoreboardListener getScoreboardListener()
  {
    return this.scoreboardListener;
  }
  
  public static Core1 getInstance()
  {
    return instance;
  }
}
