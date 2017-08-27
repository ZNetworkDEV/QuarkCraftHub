/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import net.quarkcraft.api.CoreAPI;
import net.quarkcraft.api.enums.Rangos;
import net.quarkcraft.api.mysql.MySQL;
import net.quarkcraft.hub.Core1;
import net.quarkcraft.hub.enums.Particulas;
import net.quarkcraft.hub.scoreboard.ScoreboardHelper;
import net.quarkcraft.hub.scoreboard.ScoreboardListener;
import org.apache.commons.codec.binary.Base64;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.Vector;

public class Utilidades
{
  public static HashMap<String, Integer> particles = new HashMap();
  private static final int CENTER_PX = 154;
  
  public static String Color(String color)
  {
    return ChatColor.translateAlternateColorCodes('&', color);
  }
  
  public static ItemStack InventoryNormal2(Inventory inv, int slot, int durability, Material url, String name, String... lore)
  {
    ItemStack skull = createItem2(url, durability, name, lore);
    inv.setItem(slot, skull);
    return skull;
  }
  
  public static ItemStack inventorySkull(Inventory inv, int slot, String url, String name, String... lore)
  {
    ItemStack skull = SkullTextura(url, name, lore);
    inv.setItem(slot, skull);
    return skull;
  }
  
  public static ItemStack createItem2(Material material, int durability, String displayname, String... lore)
  {
    ItemStack item = new ItemStack(material);
    ItemMeta meta = item.getItemMeta();
    meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayname));
    ArrayList<String> Lore = new ArrayList();
    String[] arrayOfString;
    int j = (arrayOfString = lore).length;
    for (int i = 0; i < j; i++)
    {
      String loreString = arrayOfString[i];
      Lore.add(ChatColor.translateAlternateColorCodes('&', loreString));
    }
    meta.setLore(Lore);
    item.setDurability((short)durability);
    
    item.setItemMeta(meta);
    return item;
  }
  
  public static ItemStack PonerInv(Inventory inv, int slot, ItemStack test, String name, String... lore)
  {
    ItemStack test2 = test;
    ItemMeta test3 = test2.getItemMeta();
    test3.setDisplayName(Color(name));
    ArrayList<String> Lore = new ArrayList();
    String[] arrayOfString;
    int j = (arrayOfString = lore).length;
    for (int i = 0; i < j; i++)
    {
      String loreString = arrayOfString[i];
      Lore.add(ChatColor.translateAlternateColorCodes('&', loreString));
    }
    test3.setLore(Lore);
    test2.setItemMeta(test3);
    inv.setItem(slot, test2);
    return test2;
  }
  
  public static ItemStack disfraces(Material material, String displayname, int test, int test2, int test3)
  {
    ItemStack item = new ItemStack(material);
    LeatherArmorMeta meta = (LeatherArmorMeta)item.getItemMeta();
    meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayname));
    
    meta.setColor(Color.fromRGB(test, test2, test3));
    
    item.setItemMeta(meta);
    return item;
  }
  
  public static ItemStack SkullTextura(String url, String displayname, String... lore)
  {
    url = "http://textures.minecraft.net/texture/" + url;
    ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
    if (url.isEmpty()) {
      return head;
    }
    SkullMeta headMeta = (SkullMeta)head.getItemMeta();
    headMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayname));
    ArrayList<String> Lore = new ArrayList();
    String[] arrayOfString;
    int j = (arrayOfString = lore).length;
    for (int i = 0; i < j; i++)
    {
      String loreString = arrayOfString[i];
      Lore.add(ChatColor.translateAlternateColorCodes('&', loreString));
    }
    headMeta.setLore(Lore);
    GameProfile profile = new GameProfile(UUID.randomUUID(), null);
    byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", new Object[] { url }).getBytes());
    profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
    Field profileField = null;
    try
    {
      profileField = headMeta.getClass().getDeclaredField("profile");
      profileField.setAccessible(true);
      profileField.set(headMeta, profile);
    }
    catch (NoSuchFieldException|IllegalArgumentException|IllegalAccessException e1)
    {
      e1.printStackTrace();
    }
    head.setItemMeta(headMeta);
    return head;
  }
  
  public static void DarKit(Player player)
  {
    player.getInventory().clear();
    
    ItemStack juegos = createItem(Material.WATCH, "&bJuegos &7(Click derecho)", new String[] { "&e�Haz click!" });
    ItemStack perfil = createItem(Material.SKULL_ITEM, "&bPerfil &7(Click derecho)", new String[] { "&e�Haz click!" });
    perfil.setDurability((short)3);
    SkullMeta test = (SkullMeta)perfil.getItemMeta();
    test.setOwner(player.getName());
    perfil.setItemMeta(test);
    ItemStack vanidad = createItem(Material.ENDER_CHEST, "&bCosmeticos &7(Click derecho)", new String[] { "&e�Haz click!" });
    ItemStack jugadores = createItem(Material.INK_SACK, "&bOcultar Jugadores &7(Click derecho)", new String[] { "&e�Haz click!" });
    ItemStack lobby = createItem(Material.BED, "&bSeleccionar Lobby &7(Click derecho)", new String[] { "&e�Haz click!" });
    if (CoreAPI.getMySQL().Jugadores(player.getUniqueId().toString()).equals("Si")) {
      jugadores.setDurability((short)10);
    } else {
      jugadores.setDurability((short)8);
    }
    player.getInventory().setItem(0, juegos);
    player.getInventory().setItem(1, perfil);
    player.getInventory().setItem(4, vanidad);
    player.getInventory().setItem(7, jugadores);
    player.getInventory().setItem(8, lobby);
  }
  
  public static void UpdatearScoreBoard2(Player player)
  {
    ScoreboardListener scoreboard = Core1.getInstance().getScoreboardListener();
    
    Scoreboard test = scoreboard.getScoreboardFor(player).getScoreBoard();
    if (test.getTeam(player.getName()) != null) {
      if (CoreAPI.getMySQL().obtenerRango(player).esRango()) {
        test.getTeam(player.getName()).setPrefix("" + CoreAPI.getMySQL().obtenerRango(player).getColor() + ChatColor.BOLD + CoreAPI.getMySQL().obtenerRango(player).getNombre() + " " + ChatColor.WHITE);
      } else {
        test.getTeam(player.getName()).setPrefix("" + ChatColor.GRAY);
      }
    }
  }
  
  public static void UpdatearScoreBoard(Player player)
  {
    ScoreboardListener scoreboard = Core1.getInstance().getScoreboardListener();
    
    Scoreboard test = scoreboard.getScoreboardFor(player).getScoreBoard();
    if (test.getTeam(player.getName()) != null) {
      test.getTeam(player.getName()).unregister();
    }
    test.registerNewTeam(player.getName());
    test.getTeam(player.getName()).setPrefix("");
    test.getTeam(player.getName()).setPrefix("");
    if (CoreAPI.getMySQL().obtenerRango(player).esRango()) {
      test.getTeam(player.getName()).setPrefix("" + CoreAPI.getMySQL().obtenerRango(player).getColor() + ChatColor.BOLD + CoreAPI.getMySQL().obtenerRango(player).getNombre() + " " + ChatColor.WHITE);
    } else {
      test.getTeam(player.getName()).setPrefix("" +ChatColor.GRAY);
    }
    test.getTeam(player.getName()).addEntry(player.getName());
    for (Player a : Bukkit.getServer().getOnlinePlayers()) {
      if (!a.equals(player))
      {
        Scoreboard test2 = scoreboard.getScoreboardFor(a).getScoreBoard();
        if (test2 != null)
        {
          if (test2.getTeam(player.getName()) == null) {
            test2.registerNewTeam(player.getName());
          }
          if (CoreAPI.getMySQL().obtenerRango(player).esRango()) {
            test2.getTeam(player.getName()).setPrefix("" + CoreAPI.getMySQL().obtenerRango(player).getColor() + ChatColor.BOLD + CoreAPI.getMySQL().obtenerRango(player).getNombre() + " " + ChatColor.WHITE);
          } else {
            test2.getTeam(player.getName()).setPrefix("" + ChatColor.GRAY);
          }
          test2.getTeam(player.getName()).addEntry(player.getName());
        }
        if (test.getTeam(a.getName()) == null)
        {
          test.registerNewTeam(a.getName());
          if (CoreAPI.getMySQL().obtenerRango(player).esRango()) {
            test.getTeam(a.getName()).setPrefix("" + CoreAPI.getMySQL().obtenerRango(player).getColor() + ChatColor.BOLD + CoreAPI.getMySQL().obtenerRango(player).getNombre() + " " + ChatColor.WHITE);
          } else {
            test.getTeam(a.getName()).setPrefix("" +ChatColor.GRAY);
          }
          test.getTeam(a.getName()).addEntry(a.getName());
        }
      }
    }
  }
  
  public static void SendTabList(Player player)
  {
    PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();
    IChatBaseComponent header = IChatBaseComponent.ChatSerializer.a("{text:\"" + 
      ChatColor.DARK_PURPLE + "Quark" + ChatColor.LIGHT_PURPLE + "Craft" + "\n" + ChatColor.GRAY + "¡Hub!" + 
      "\"}");
    IChatBaseComponent footer = IChatBaseComponent.ChatSerializer.a("{text:\"" + 
      ChatColor.AQUA + "IP: " + ChatColor.YELLOW + "mc.quarkcraft.net" + "\n" + ChatColor.AQUA + "Tienda: " + 
      ChatColor.YELLOW + "tienda.mc.quarkcraft.net" + "\"}");
    try
    {
      Field a = packet.getClass().getDeclaredField("a");
      a.setAccessible(true);
      a.set(packet, header);
      Field b = packet.getClass().getDeclaredField("b");
      b.setAccessible(true);
      b.set(packet, footer);
    }
    catch (Exception e1)
    {
      e1.printStackTrace();
    }
    ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
  }
  
  public static void sendCenteredMessage(Player player, String message)
  {
    if ((message == null) || (message.equals(""))) {
      player.sendMessage("");
    }
    message = ChatColor.translateAlternateColorCodes('&', message);
    
    int messagePxSize = 0;
    boolean previousCode = false;
    boolean isBold = false;
    char[] arrayOfChar;
    int j = (arrayOfChar = message.toCharArray()).length;
    for (int i = 0; i < j; i++)
    {
      char c = arrayOfChar[i];
      if (c == '�')
      {
        previousCode = true;
      }
      else if (previousCode)
      {
        previousCode = false;
        if ((c == 'l') || (c == 'L')) {
          isBold = true;
        } else {
          isBold = false;
        }
      }
      else
      {
        DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
        messagePxSize += (isBold ? dFI.getBoldLength() : dFI.getLength());
        messagePxSize++;
      }
    }
    int halvedMessageSize = messagePxSize / 2;
    int toCompensate = 154 - halvedMessageSize;
    int spaceLength = DefaultFontInfo.SPACE.getLength() + 1;
    int compensated = 0;
    StringBuilder sb = new StringBuilder();
    while (compensated < toCompensate)
    {
      sb.append(" ");
      compensated += spaceLength;
    }
    player.sendMessage(sb.toString() + message);
  }
  
  public static void Corona(Player p, Particulas test, final ParticleEffect hola)
  {
    int halo = Bukkit.getScheduler()
      .runTaskTimer(Core1.getInstance(), new Runnable()
      {
        float step = 0.0F;
        
        public void run()
        {
          Location loc = p.getLocation();
          double x = Math.cos(0.1D * this.step) * 0.8D;
          double y = 2.5D;
          double z = Math.sin(0.1D * this.step) * 0.8D;
          Vector v = new Vector(x, y, z);
          loc.add(v);
          hola.display(0.0F, 0.0F, 0.0F, 10.0F, 0, loc, 60.0D);
          this.step += 6.0F;
        }
      }, 0L, 0L).getTaskId();
    particles.put(p.getName(), Integer.valueOf(halo));
  }
  
  public static void RemoverCorona(Player player)
  {
    if (particles.containsKey(player.getName()))
    {
      Bukkit.getScheduler().cancelTask(((Integer)particles.get(player.getName())).intValue());
      particles.remove(player.getName());
    }
  }
  
  public static ItemStack createItem(Material material, String displayname, String... lore)
  {
    ItemStack item = new ItemStack(material);
    ItemMeta meta = item.getItemMeta();
    meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayname));
    ArrayList<String> Lore = new ArrayList();
    String[] arrayOfString;
    int j = (arrayOfString = lore).length;
    for (int i = 0; i < j; i++)
    {
      String loreString = arrayOfString[i];
      Lore.add(ChatColor.translateAlternateColorCodes('&', loreString));
    }
    meta.setLore(Lore);
    
    item.setItemMeta(meta);
    return item;
  }
  
  public static ItemStack InventoryNormal(Inventory inv, int slot, Material url, String name, String... lore)
  {
    ItemStack skull = createItem(url, name, lore);
    inv.setItem(slot, skull);
    return skull;
  }
}
