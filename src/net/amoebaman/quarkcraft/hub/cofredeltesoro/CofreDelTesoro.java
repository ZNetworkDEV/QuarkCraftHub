/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.cofredeltesoro;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayOutBlockAction;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import net.quarkcraft.hub.Core1;
import net.quarkcraft.hub.enums.Banners;
import net.quarkcraft.hub.enums.ColorDeChat;
import net.quarkcraft.hub.enums.Disfraces;
import net.quarkcraft.hub.enums.Mascotas;
import net.quarkcraft.hub.enums.Particulas;
import net.quarkcraft.hub.enums.Sombreros;
import net.quarkcraft.hub.utils.Utilidades;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Builder;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class CofreDelTesoro
{
  private Location loc;
  private org.bukkit.block.Block block;
  private int id;
  private AtomicBoolean abriendo;
  private HashMap<String, Hologram> holograms;
  private HashMap<String, ItemStack> material1 = new HashMap();
  
  public CofreDelTesoro(Location loc, org.bukkit.block.Block block, int id)
  {
    this.loc = loc;
    this.block = block;
    this.id = id;
    this.abriendo = new AtomicBoolean(false);
    this.holograms = new HashMap();
    Hologram test = SpawnearHolo("&eCofre del Tesoro", "&b&lHAZ CLICK");
    this.holograms.put("1", test);
    CofreDelTesoroHandler.getInstance().AddCofre(this);
  }
  
  public Location getLocation()
  {
    return this.loc;
  }
  
  public org.bukkit.block.Block getBlock()
  {
    return this.block;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public AtomicBoolean abriendo()
  {
    return this.abriendo;
  }
  
  public String Recompensa2()
  {
    String recompensa = Recompensa();
    Iterator localIterator;
    if (recompensa.equals("Banners"))
    {
      List<Banners> COSMETICOSS = new ArrayList();
      localIterator = Banners.values().iterator();
      if (localIterator.hasNext())
      {
        Banners cosmetico = (Banners)localIterator.next();
        if ((cosmetico.SePuedeObtener()) && (recompensa.equals("Banners"))) {
          COSMETICOSS.add(cosmetico);
        }
        Core1.getInstance();int random = Core1.random.nextInt(COSMETICOSS.size());
        String test = ((Banners)COSMETICOSS.get(random)).getDisplayName();
        this.material1.put(test, ((Banners)COSMETICOSS.get(random)).getMaterial());
        return ((Banners)COSMETICOSS.get(random)).getDisplayName();
      }
    }
    if (recompensa.equals("ColorDeChat"))
    {
      List<ColorDeChat> COSMETICOSS = new ArrayList();
      localIterator = ColorDeChat.values().iterator();
      if (localIterator.hasNext())
      {
        ColorDeChat cosmetico = (ColorDeChat)localIterator.next();
        if ((cosmetico.SePuedeObtener()) && (recompensa.equals("ColorDeChat"))) {
          COSMETICOSS.add(cosmetico);
        }
        Core1.getInstance();int random = Core1.random.nextInt(COSMETICOSS.size());
        String test = ((ColorDeChat)COSMETICOSS.get(random)).getDisplayName();
        this.material1.put(test, new ItemStack(((ColorDeChat)COSMETICOSS.get(random)).getMaterial()));
        return ((ColorDeChat)COSMETICOSS.get(random)).getDisplayName();
      }
    }
    if (recompensa.equals("Disfraces"))
    {
      List<Disfraces> COSMETICOSS = new ArrayList();
      localIterator = Disfraces.values().iterator();
      if (localIterator.hasNext())
      {
        Disfraces cosmetico = (Disfraces)localIterator.next();
        if ((cosmetico.ObtenerCofreDelTesoro().equals("Si")) && (recompensa.equals("Disfraces"))) {
          COSMETICOSS.add(cosmetico);
        }
        Core1.getInstance();int random = Core1.random.nextInt(COSMETICOSS.size());
        String test = ((Disfraces)COSMETICOSS.get(random)).getDisplayName();
        this.material1.put(test, ((Disfraces)COSMETICOSS.get(random)).getChestplate());
        return ((Disfraces)COSMETICOSS.get(random)).getDisplayName();
      }
    }
    if (recompensa.equals("Mascotas"))
    {
      List<Mascotas> COSMETICOSS = new ArrayList();
      localIterator = Mascotas.values().iterator();
      if (localIterator.hasNext())
      {
        Mascotas cosmetico = (Mascotas)localIterator.next();
        if ((cosmetico.SePuedeObtener()) && (recompensa.equals("Mascotas"))) {
          COSMETICOSS.add(cosmetico);
        }
        Core1.getInstance();int random = Core1.random.nextInt(COSMETICOSS.size());
        String test = ((Mascotas)COSMETICOSS.get(random)).getDisplayName();
        this.material1.put(test, new ItemStack(((Mascotas)COSMETICOSS.get(random)).getMaterial()));
        return ((Mascotas)COSMETICOSS.get(random)).getDisplayName();
      }
    }
    if (recompensa.equals("Particulas"))
    {
      List<Particulas> COSMETICOSS = new ArrayList();
      localIterator = Particulas.values().iterator();
      if (localIterator.hasNext())
      {
        Particulas cosmetico = (Particulas)localIterator.next();
        if ((cosmetico.SePuedeObtener()) && (recompensa.equals("Particulas"))) {
          COSMETICOSS.add(cosmetico);
        }
        Core1.getInstance();int random = Core1.random.nextInt(COSMETICOSS.size());
        String test = ((Particulas)COSMETICOSS.get(random)).getDisplayName();
        this.material1.put(test, new ItemStack(((Particulas)COSMETICOSS.get(random)).getMaterial()));
        return ((Particulas)COSMETICOSS.get(random)).getDisplayName();
      }
    }
    if (recompensa.equals("Sombreros"))
    {
      List<Sombreros> COSMETICOSS = new ArrayList();
      localIterator = Sombreros.values().iterator();
      if (localIterator.hasNext())
      {
        Sombreros cosmetico = (Sombreros)localIterator.next();
        if ((cosmetico.ObtenerCofreDelTesoro().equals("Si")) && (recompensa.equals("Sombreros"))) {
          COSMETICOSS.add(cosmetico);
        }
        Core1.getInstance();int random = Core1.random.nextInt(COSMETICOSS.size());
        
        ItemStack test = Utilidades.SkullTextura(((Sombreros)COSMETICOSS.get(random)).getHeadTexture(), "", new String[] { "" });
        String test2 = ((Sombreros)COSMETICOSS.get(random)).getDisplayName();
        this.material1.put(test2, test);
        return ((Sombreros)COSMETICOSS.get(random)).getDisplayName();
      }
    }
    return null;
  }
  
  public String Recompensa()
  {
    List<String> cosmeticos = new ArrayList();
    cosmeticos.add("Banners");
    cosmeticos.add("ColorDeChat");
    cosmeticos.add("Disfraces");
    cosmeticos.add("Mascotas");
    cosmeticos.add("Particulas");
    cosmeticos.add("Sombreros");
    
    Core1.getInstance();String recompensa = (String)cosmeticos.get(Core1.random().nextInt(cosmeticos.size()));
    for (Banners cosmetico : Banners.values()) {
      if ((cosmetico.SePuedeObtener()) && (recompensa.equals("Banners"))) {
        return recompensa;
      }
    }
    for (ColorDeChat cosmetico : ColorDeChat.values()) {
      if ((cosmetico.SePuedeObtener()) && (recompensa.equals("ColorDeChat"))) {
        return recompensa;
      }
    }
    for (Disfraces cosmetico : Disfraces.values()) {
      if ((cosmetico.ObtenerCofreDelTesoro().equals("Si")) && (recompensa.equals("Disfraces"))) {
        return recompensa;
      }
    }
    for (Mascotas cosmetico : Mascotas.values()) {
      if ((cosmetico.ObtenerCofreDelTesoro().equals("Si")) && (recompensa.equals("Mascotas"))) {
        return recompensa;
      }
    }
    for (Particulas cosmetico : Particulas.values()) {
      if ((cosmetico.SePuedeObtener()) && (recompensa.equals("Particulas"))) {
        return recompensa;
      }
    }
    for (Sombreros cosmetico : Sombreros.values()) {
      if ((cosmetico.ObtenerCofreDelTesoro().equals("Si")) && (recompensa.equals("Sombreros"))) {
        return recompensa;
      }
    }
    return null;
  }
  
  public Hologram SpawnearHolo(String name1, String name2)
  {
    Location cofre1 = new Location(Bukkit.getWorld("Lobby"), 15.505D, 39.875D, 4.441D);
    Hologram hologram = HologramsAPI.createHologram(Core1.getInstance(), cofre1.add(0.0D, 1.0D, 0.0D));
    hologram.appendTextLine(Utilidades.Color(name1));
    hologram.appendTextLine(Utilidades.Color(name2));
    return hologram;
  }
  
  public void Abrir(final Player player)
  {
    if (abriendo().get()) {
      return;
    }
    player.sendMessage(Utilidades.Color("&e�Abriendo Cofre del Tesoro!"));
    
    abriendo().set(true);
    
    Hologram holograma = (Hologram)this.holograms.get("1");
    
    holograma.delete();
    
    new BukkitRunnable()
    {
      int segundos = 12;
      Location cofre1 = new Location(Bukkit.getWorld("Lobby"), 15.505D, 39.875D, 4.441D);
      
      public void run()
      {
        this.segundos -= 1;
        if (this.segundos == 7)
        {
          CofreDelTesoro.this.changeChestState(this.cofre1, true);
          
          String recompensafinal = CofreDelTesoro.this.Recompensa2();
          
          Hologram test = CofreDelTesoro.this.SpawnearHolo("&eRecom&bpensa:", "&b" + recompensafinal);
          
          test.appendItemLine((ItemStack)CofreDelTesoro.this.material1.get(recompensafinal));
          
          CofreDelTesoro.this.holograms.put("2", test);
          
          Firework fw = (Firework)player.getWorld().spawnEntity(this.cofre1, EntityType.FIREWORK);
          FireworkMeta fwm = fw.getFireworkMeta();
          
          Random r = new Random();
          
          int rt = r.nextInt(4) + 1;
          FireworkEffect.Type type = FireworkEffect.Type.BALL;
          if (rt == 1) {
            type = FireworkEffect.Type.BALL;
          }
          if (rt == 2) {
            type = FireworkEffect.Type.BALL_LARGE;
          }
          if (rt == 3) {
            type = FireworkEffect.Type.BURST;
          }
          if (rt == 4) {
            type = FireworkEffect.Type.CREEPER;
          }
          if (rt == 5) {
            type = FireworkEffect.Type.STAR;
          }
          int r1i = r.nextInt(17) + 1;
          int r2i = r.nextInt(17) + 1;
          Color c1 = CofreDelTesoro.this.getColor(r1i);
          Color c2 = CofreDelTesoro.this.getColor(r2i);
          
          FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
          
          fwm.addEffect(effect);
          
          int rp = r.nextInt(2) + 1;
          fwm.setPower(0);
          
          fw.setFireworkMeta(fwm);
        }
        if (this.segundos == 1)
        {
          CofreDelTesoro.this.changeChestState(this.cofre1, false);
          
          Hologram holograma = (Hologram)CofreDelTesoro.this.holograms.get("2");
          
          holograma.delete();
        }
        if (this.segundos == 0)
        {
          Hologram test = CofreDelTesoro.this.SpawnearHolo("&eCofre del Tesoro", "&b&lHAZ CLICK");
          CofreDelTesoro.this.holograms.put("1", test);
          CofreDelTesoro.this.abriendo().set(false);
          cancel();
        }
      }
    }.runTaskTimer(Core1.getInstance(), 0L, 20L);
  }
  
  private Color getColor(int i)
  {
    Color c = null;
    if (i == 1) {
      c = Color.AQUA;
    }
    if (i == 2) {
      c = Color.BLACK;
    }
    if (i == 3) {
      c = Color.BLUE;
    }
    if (i == 4) {
      c = Color.FUCHSIA;
    }
    if (i == 5) {
      c = Color.GRAY;
    }
    if (i == 6) {
      c = Color.GREEN;
    }
    if (i == 7) {
      c = Color.LIME;
    }
    if (i == 8) {
      c = Color.MAROON;
    }
    if (i == 9) {
      c = Color.NAVY;
    }
    if (i == 10) {
      c = Color.OLIVE;
    }
    if (i == 11) {
      c = Color.ORANGE;
    }
    if (i == 12) {
      c = Color.PURPLE;
    }
    if (i == 13) {
      c = Color.RED;
    }
    if (i == 14) {
      c = Color.SILVER;
    }
    if (i == 15) {
      c = Color.TEAL;
    }
    if (i == 16) {
      c = Color.WHITE;
    }
    if (i == 17) {
      c = Color.YELLOW;
    }
    return c;
  }
  
  public void changeChestState(Location loc, boolean open)
  {
    byte dataByte = (byte) (open ? 1 : 0);
    for (Player player : Bukkit.getOnlinePlayers())
    {
      player.playNote(loc, (byte)1, dataByte);
      BlockPosition position = new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
      
      PacketPlayOutBlockAction blockActionPacket = new PacketPlayOutBlockAction(position, net.minecraft.server.v1_8_R3.Block.getById(loc.getBlock().getTypeId()), 1, dataByte);
      ((CraftPlayer)player).getHandle().playerConnection.sendPacket(blockActionPacket);
    }
  }
}