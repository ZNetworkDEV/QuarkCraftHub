/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.events;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import net.md_5.bungee.api.ChatColor;
import net.quarkcraft.api.CoreAPI;
import net.quarkcraft.api.enums.Rangos;
import net.quarkcraft.api.mysql.MySQL;
import net.quarkcraft.hub.Core1;
import net.quarkcraft.hub.anvil.AnvilGUI;
import net.quarkcraft.hub.anvil.AnvilGUI.AnvilClickEvent;
import net.quarkcraft.hub.anvil.AnvilGUI.AnvilClickEventHandler;
import net.quarkcraft.hub.anvil.AnvilGUI.AnvilSlot;
import net.quarkcraft.hub.cofredeltesoro.CofreDelTesoro;
import net.quarkcraft.hub.cofredeltesoro.CofreDelTesoroHandler;
import net.quarkcraft.hub.cosmeticos.Cosmeticos;
import net.quarkcraft.hub.cosmeticos.MascotasAPI;
import net.quarkcraft.hub.cosmeticos.MascotasUtils;
import net.quarkcraft.hub.enums.Banners;
import net.quarkcraft.hub.enums.ColorDeChat;
import net.quarkcraft.hub.enums.Disfraces;
import net.quarkcraft.hub.enums.Mascotas;
import net.quarkcraft.hub.enums.MascotasTip;
import net.quarkcraft.hub.enums.Particulas;
import net.quarkcraft.hub.enums.Sombreros;
import net.quarkcraft.hub.menu.Menu;
import net.quarkcraft.hub.scoreboard.ScoreboardListener;
import net.quarkcraft.hub.utils.BungeeUtils;
import net.quarkcraft.hub.utils.Title;
import net.quarkcraft.hub.utils.Utilidades;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class Events
  implements Listener
{
  public HashMap<String, Integer> cooldown = new HashMap();
  
  @EventHandler
  public void PChat(AsyncPlayerChatEvent event)
  {
    Player player = event.getPlayer();
    String msg = event.getMessage();
    if (CoreAPI.getMySQL().obtenerRango(player).esRango())
    {
      if (!CoreAPI.getMySQL().TieneColorChat(player.getUniqueId().toString()).equals("No"))
      {
        ChatColor test = ChatColor.valueOf(CoreAPI.getMySQL().ObtenerColorDeChatEquipado(player));
        event.setFormat("" + CoreAPI.getMySQL().obtenerRango(player).getColor() + ChatColor.BOLD + CoreAPI.getMySQL().obtenerRango(player).getNombre() + " " + ChatColor.GRAY + player.getName() + ": " + test + event.getMessage());
      }
      else
      {
        event.setFormat("" + CoreAPI.getMySQL().obtenerRango(player).getColor() + ChatColor.BOLD + CoreAPI.getMySQL().obtenerRango(player).getNombre() + " " + ChatColor.GRAY + player.getName() + ": " + CoreAPI.getMySQL().obtenerRango(player).getChatColor() + event.getMessage());
      }
    }
    else {
      event.setFormat(CoreAPI.getMySQL().obtenerRango(player).getColor() + CoreAPI.getMySQL().obtenerRango(player).getNombre() + " " + ChatColor.GRAY + player.getName() + ": " + CoreAPI.getMySQL().obtenerRango(player).getChatColor() + event.getMessage());
    }
    if (msg.equalsIgnoreCase(Core1.getInstance().palabra))
    {
    	if (Core1.getInstance().palabra == "") {
    		 
    	} else {
	      for (Player players : Bukkit.getServer().getOnlinePlayers())
	    	  players.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eChat &6» &e¡El jugador&a " + player.getName() + " &egano en " + Math.round(100.0D * ((new Date().getTime() - Core1.getInstance().tiempo) / 1000.0D)) / 100.0D) + " segundos!");	      {
	        }
	        Core1.getInstance().palabra = "";
	        Core1.getInstance().ganador = true;
	       player.sendMessage("&eChat &6» &e¡Has ganado felicidades!");
    	}
    }
    }
  
  @EventHandler
  public void feed(FoodLevelChangeEvent event)
  {
    event.setCancelled(true);
  }
  
  @EventHandler
  public void PDamage(EntityDamageEvent event)
  {
    event.setCancelled(true);
  }
  
  @EventHandler
  public void Breka2(BlockBreakEvent event)
  {
    if (!event.getPlayer().isOp()) {
      event.setCancelled(true);
    }
  }
  
  @EventHandler
  public void Breakk(BlockPlaceEvent event)
  {
    if (!event.getPlayer().isOp()) {
      event.setCancelled(true);
    }
  }
  
  @EventHandler
  public void Mascota(PlayerInteractAtEntityEvent event)
  {
    Player player = event.getPlayer();
    
    event.setCancelled(true);
    if ((!CoreAPI.getMySQL().TieneMascota(player.getUniqueId().toString()).equals("No")) && (event.getRightClicked().hasMetadata(player.getName()))) {
      if (((Mascotas)MascotasAPI.ObtenerMascotaPorTipo().get(player.getName())).getTipo().equals(MascotasTip.Compañero)) {
        Menu.Ajustes(player, true);
      } else {
        Menu.Ajustes(player, false);
      }
    }
  }
  
  @EventHandler
  public void onInventoryOpenEvent(InventoryOpenEvent e)
  {
    if (((e.getInventory().getHolder() instanceof Chest)) || ((e.getInventory().getHolder() instanceof DoubleChest))) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void PCLick(InventoryClickEvent event)
  {
    final Player player = (Player)event.getWhoClicked();
    
    event.setCancelled(true);
    if ((event.getCurrentItem() == null) || (event.getCurrentItem().getType() == Material.AIR)) {
      return;
    }
    if (event.getInventory().getName().equals("Cofre del Tesoro"))
    {
      if (event.getCurrentItem().getType() == Material.STAINED_GLASS_PANE)
      {
        player.sendMessage(Utilidades.Color("&c¡Sin quarks!"));
        player.closeInventory();
        return;
      }
      if (event.getCurrentItem().getType() == Material.CHEST)
      {
        CofreDelTesoro tesoro = CofreDelTesoroHandler.getInstance().getCofre(0);
        if (tesoro.abriendo().get())
        {
          player.sendMessage(Utilidades.Color("&c¡Oops , alguien ya esta abriendo este cofre del tesoro!"));
          event.setCancelled(true);
          player.closeInventory();
          return;
        }
        tesoro.Abrir(player);
        //CoreAPI.getMySQL().REMOVEQUARKS(player, 1);
        player.closeInventory();
      }
    }
    if (event.getInventory().getName().equals("Mi Perfil")) {
      if (event.getCurrentItem().getType() == Material.PAPER) {
        Menu.Estadisticass(player);
      }
    }
    if (event.getInventory().getName().equals("Ajustes de Mascota"))
    {
      if (event.getRawSlot() == 10)
      {
        Entity test = (Entity)MascotasAPI.ObtenerMascota().get(player.getName());
        
        test.setPassenger(player);
        
        player.closeInventory();
        
        player.sendMessage(Utilidades.Color("&e¡Has montado a tu mascota!"));
        
        player.closeInventory();
      }
      if (event.getRawSlot() == 13)
      {
        player.closeInventory();
        
        final Player player3 = (Player)event.getWhoClicked();
        
        AnvilGUI gui = new AnvilGUI(player3, new AnvilGUI.AnvilClickEventHandler()
        {
          public void onAnvilClick(AnvilGUI.AnvilClickEvent event)
          {
            if (event.getSlot() == AnvilGUI.AnvilSlot.OUTPUT)
            {
              event.setWillClose(true);
              event.setWillDestroy(true);
              CoreAPI.getMySQL().PonerNombreMascota(player3, event.getName());
              player3.sendMessage(Utilidades.Color("&e¡Nombre cambiado satisfactoriamente a " + event.getName() + "&e!"));
              Entity test = (Entity)MascotasAPI.ObtenerMascota().get(player.getName());
              test.setCustomName(Utilidades.Color(event.getName()));
            }
            else
            {
              event.setWillClose(false);
              event.setWillDestroy(false);
            }
          }
        });
        gui.setSlot(AnvilGUI.AnvilSlot.INPUT_LEFT, Utilidades.createItem(Material.NAME_TAG, "Pon el nombre aqui", new String[] { "&e¡Haz click!" }));
        
        gui.open();
      }
      if (event.getRawSlot() == 16)
      {
        player.sendMessage(Utilidades.Color("&c¡Solo puedes evolucionar a compa¡eros!"));
        player.closeInventory();
      }
    }
    ItemStack involucion;
    if (event.getInventory().getName().equals("Ajustes de Compañero"))
    {
      if (event.getRawSlot() == 10)
      {
        Entity test = ((Entity)MascotasAPI.ObtenerMascota().get(player.getName())).getPassenger();
        
        test.setPassenger(player);
        
        player.closeInventory();
        
        player.sendMessage(Utilidades.Color("&e¡Has montado a tu compa¡ero!"));
        
        player.closeInventory();
      }
      if (event.getRawSlot() == 13)
      {
        player.closeInventory();
        
        final Player player3 = (Player)event.getWhoClicked();
        
        AnvilGUI gui = new AnvilGUI(player3, new AnvilGUI.AnvilClickEventHandler()
        {
          public void onAnvilClick(AnvilGUI.AnvilClickEvent event)
          {
            if (event.getSlot() == AnvilGUI.AnvilSlot.OUTPUT)
            {
              event.setWillClose(true);
              event.setWillDestroy(true);
              CoreAPI.getMySQL().PonerNombreMascota(player3, event.getName());
              player3.sendMessage(Utilidades.Color("&e¡Nombre cambiado satisfactoriamente a " + event.getName() + "&e!"));
              Entity test = ((Entity)MascotasAPI.ObtenerMascota().get(player.getName())).getPassenger();
              test.setCustomName(Utilidades.Color(event.getName()));
            }
            else
            {
              event.setWillClose(false);
              event.setWillDestroy(false);
            }
          }
        });
        gui.setSlot(AnvilGUI.AnvilSlot.INPUT_LEFT, Utilidades.createItem(Material.NAME_TAG, "Pon el nombre aqui", new String[] { "&e¡Haz click!" }));
        
        gui.open();
      }
      if (event.getRawSlot() == 16)
      {
        if (!((Mascotas)MascotasAPI.ObtenerMascotaPorTipo().get(player.getName())).EvolucionarSePuede().booleanValue())
        {
          player.sendMessage(Utilidades.Color("&c¡Este compa¡ero no se puede evolucionar!"));
          player.closeInventory();
          return;
        }
        ItemStack evolucion = MascotasUtils.skull(((Mascotas)MascotasAPI.ObtenerMascotaPorTipo().get(player.getName())).getEvolucionUrl());
        involucion = MascotasUtils.skull(((Mascotas)MascotasAPI.ObtenerMascotaPorTipo().get(player.getName())).getUrl());
        if (((String)MascotasAPI.Evolucionado().get(player.getUniqueId())).equals("No"))
        {
          player.sendMessage(Utilidades.Color("&e¡Has evolucionado a tu compa¡ero!"));
          
          Entity test = ((Entity)MascotasAPI.ObtenerMascota().get(player.getName())).getPassenger();
          EntityEquipment equipment = ((LivingEntity)test).getEquipment();
          equipment.setHelmet(evolucion);
          
          player.getWorld().playEffect(test.getLocation(), Effect.EXPLOSION, 3);
          
          MascotasAPI.Evolucionado().put(player.getUniqueId(), "Si");
          
          player.closeInventory();
        }
        else
        {
          player.sendMessage(Utilidades.Color("&e¡Has involucionado a tu compa¡ero!"));
          
          Entity test = ((Entity)MascotasAPI.ObtenerMascota().get(player.getName())).getPassenger();
          EntityEquipment equipment = ((LivingEntity)test).getEquipment();
          equipment.setHelmet(involucion);
          
          MascotasAPI.Evolucionado().put(player.getUniqueId(), "No");
          
          player.getWorld().playEffect(test.getLocation(), Effect.EXPLOSION, 3);
          
          player.closeInventory();
        }
      }
    }
    if (event.getInventory().getName().contains("Color de"))
    {
      if (event.getCurrentItem().getType() == Material.BARRIER)
      {
        player.sendMessage(Utilidades.Color("&e¡Has removido tu color de chat!"));
        CoreAPI.getMySQL().PonerTieneColorChat(player, "No");
        player.closeInventory();
      }
      for (ColorDeChat hat : ColorDeChat.values()) {
        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Utilidades.Color(hat.getDisplayName())))
        {
          if (CoreAPI.getMySQL().obtenerRango(player).equals(hat.getRango())) {
            Cosmeticos.EquiparColorDeChat(player, hat);
          } else {
            player.sendMessage(Utilidades.Color("&c¡No requieres el rango necesario para este cosmetico!"));
          }
          player.closeInventory();
        }
      }
    }
    if (event.getInventory().getName().contains("Disfraces"))
    {
      if (event.getCurrentItem().getType() == Material.BARRIER)
      {
        player.sendMessage(Utilidades.Color("&e¡Has removido tu disfras!"));
        CoreAPI.getMySQL().PonerTieneDisfras(player, "No");
        player.getInventory().setHelmet(null);
        player.getInventory().setChestplate(null);
        player.getInventory().setLeggings(null);
        player.getInventory().setBoots(null);
        player.closeInventory();
      }
      for (Disfraces hat : Disfraces.values()) {
        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Utilidades.Color(hat.getDisplayName())))
        {
          if (CoreAPI.getMySQL().obtenerRango(player).equals(hat.getRango())) {
            Cosmeticos.EquiparDisfras(player, hat);
          } else {
            player.sendMessage(Utilidades.Color("&c¡No requieres el rango necesario para este cosmetico!"));
          }
          player.closeInventory();
        }
      }
    }
    if (event.getInventory().getName().contains("Particulas"))
    {
      if (event.getCurrentItem().getType() == Material.BARRIER)
      {
        player.sendMessage(Utilidades.Color("&e¡Has removido tu particula!"));
        CoreAPI.getMySQL().PonerTieneParticula(player, "No");
        Utilidades.RemoverCorona(player);
        player.closeInventory();
      }
      for (Particulas hat : Particulas.values()) {
        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Utilidades.Color(hat.getDisplayName())))
        {
          if (CoreAPI.getMySQL().obtenerRango(player).equals(hat.getRango())) {
            Cosmeticos.EquiparParticula(player, hat);
          } else {
            player.sendMessage(Utilidades.Color("&c¡No requieres el rango necesario para este cosmetico!"));
          }
          player.closeInventory();
        }
      }
    }
    if (event.getInventory().getName().contains("Banners"))
    {
      if (event.getCurrentItem().getType() == Material.BARRIER)
      {
        player.sendMessage(Utilidades.Color("&e¡Has removido tu banner!"));
        CoreAPI.getMySQL().PonerTieneBanner(player, "No");
        player.getInventory().setHelmet(null);
        player.closeInventory();
      }
      for (Banners hat : Banners.values()) {
        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Utilidades.Color(hat.getDisplayName())))
        {
          if (CoreAPI.getMySQL().obtenerRango(player).equals(hat.getRango())) {
            Cosmeticos.EquiparBanner(player, hat);
          } else {
            player.sendMessage(Utilidades.Color("&c¡No requieres el rango necesario para este cosmetico!"));
          }
          player.closeInventory();
        }
      }
    }
    if (event.getInventory().getName().contains("Compañeros y"))
    {
      if (event.getCurrentItem().getType() == Material.BARRIER)
      {
        player.sendMessage(Utilidades.Color("&e¡Has removido tu mascota/compa¡ero!"));
        Cosmeticos.RemoverMascota(player);
        CoreAPI.getMySQL().PonerTieneMascota(player, "No");
        player.closeInventory();
      }
      for (Mascotas hat : Mascotas.values()) {
        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Utilidades.Color(hat.getDisplayName())))
        {
          if (CoreAPI.getMySQL().obtenerRango(player).equals(hat.getRango())) {
            Cosmeticos.EquiparMascota(player, hat);
          } else {
            player.sendMessage(Utilidades.Color("&c¡No requieres el rango necesario para este cosmetico!"));
          }
          player.closeInventory();
        }
      }
    }
    if (event.getInventory().getName().contains("Sombreros"))
    {
      if (event.getCurrentItem().getType() == Material.BARRIER)
      {
        player.sendMessage(Utilidades.Color("&e¡Has removido tu sombrero!"));
        player.getInventory().setHelmet(null);
        CoreAPI.getMySQL().PonerTieneSombrero(player, "No");
        player.closeInventory();
      }
      for (Sombreros hat : Sombreros.values()) {
        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Utilidades.Color(hat.getDisplayName())))
        {
          if (CoreAPI.getMySQL().obtenerRango(player).equals(hat.getRango())) {
            Cosmeticos.EquiparSombrero(player, hat);
          } else {
            player.sendMessage(Utilidades.Color("&c¡No requieres el rango necesario para este cosmetico!"));
          }
          player.closeInventory();
        }
      }
    }
    if (event.getInventory().getName().equalsIgnoreCase("Cosmeticos"))
    {
      if (event.getCurrentItem().getType() == Material.SKULL_ITEM) {
        Menu.Sombreros(player);
      }
      if (event.getCurrentItem().getType() == Material.BONE) {
        Menu.Mascotas(player, 1);
      }
      if (event.getCurrentItem().getType() == Material.WATER_BUCKET) {
        Menu.Particulas(player);
      }
      if (event.getCurrentItem().getType() == Material.STAINED_CLAY) {
        Menu.ColorDeChat(player);
      }
      if (event.getCurrentItem().getType() == Material.DRAGON_EGG) {
        Menu.Disfraces(player);
      }
      if (event.getCurrentItem().getType() == Material.BANNER) {
        Menu.Banners(player);
      }
    }
    event.getInventory().getName().equalsIgnoreCase("Mi Perfil");
    if (event.getInventory().getName().equalsIgnoreCase("Lobbys Disponibles"))
    {
      player.sendMessage(Utilidades.Color("&aYa estas conectado a este lobby!"));
      player.closeInventory();
    }
    if (event.getInventory().getName().equalsIgnoreCase("Juegos")) {
      if (event.getRawSlot() == 10)
      {
        player.closeInventory();
        
        BungeeUtils.sendToServer(player, "ArenaPvP");
      }
    }
  }
  
  @EventHandler
  public void PInteract(PlayerInteractEvent event)
  {
    final Player player = event.getPlayer();
    if ((event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && 
      ((event.getClickedBlock().getState() instanceof Chest)))
    {
      event.setCancelled(true);
      CofreDelTesoro tesoro = CofreDelTesoroHandler.getInstance().getCofre(0);
      if (tesoro.abriendo().get())
      {
        player.sendMessage(Utilidades.Color("&c¡Oops , alguien ya esta abriendo este cofre del tesoro!"));
        return;
      }
      Menu.CofreDelTesoro(player);
      return;
    }
    if ((player.getItemInHand() != null) && (player.getItemInHand().hasItemMeta()) && (player.getItemInHand().getItemMeta().hasDisplayName()))
    {
      if ((player.getItemInHand() == null) || (!player.getItemInHand().hasItemMeta())) {
        return;
      }
      if (player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&bPerfil &7(Click derecho)"))) {
        Menu.MiPerfil(player);
      }
      if (player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&bCosmeticos &7(Click derecho)"))) {
        Menu.Cosmeticos(player);
      }
      if (player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&bJuegos &7(Click derecho)"))) {
        Menu.Juegos(player);
      }
      if (player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&bSeleccionar Lobby &7(Click derecho)"))) {
        Menu.Lobbys(player);
      }
      if (player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&bOcultar Jugadores &7(Click derecho)")))
      {
        if (this.cooldown.containsKey(player.getName()))
        {
          player.sendMessage(Utilidades.Color("&c¡Espera un lapso de 5 segundos antes de volver a usar esto!"));
          return;
        }
        this.cooldown.put(player.getName(), Integer.valueOf(5));
        
        new BukkitRunnable()
        {
          int segundos = 5;
          
          public void run()
          {
            this.segundos -= 1;
            if (this.segundos == 0)
            {
              cancel();
              Events.this.cooldown.remove(player.getName());
            }
          }
        }.runTaskTimer(Core1.getInstance(), 0L, 20L);
        if (CoreAPI.getMySQL().Jugadores(player.getUniqueId().toString()).equals("Si"))
        {
          for (Player test : Bukkit.getOnlinePlayers()) {
            player.hidePlayer(test);
          }
          player.sendMessage(Utilidades.Color("&aHas ocultado los jugadores!"));
          CoreAPI.getMySQL().PonerJugadores(player, false);
          player.getItemInHand().setDurability((short)8);
        }
        else
        {
          for (Player test : Bukkit.getOnlinePlayers()) {
            player.showPlayer(test);
          }
          player.sendMessage(Utilidades.Color("&aAhora ves a los jugadores!"));
          CoreAPI.getMySQL().PonerJugadores(player, true);
          player.getItemInHand().setDurability((short)10);
        }
      }
    }
  }
  
  @EventHandler
  public void PQuit(PlayerQuitEvent event)
  {
    Player player = event.getPlayer();
    if (!CoreAPI.getMySQL().TieneSombrero(player.getUniqueId().toString()).equals("No"))
    {
      Sombreros mascota = Sombreros.valueOf(CoreAPI.getMySQL().ObtenerSombrero(player));
      
      player.getInventory().setHelmet(null);
    }
    if (!CoreAPI.getMySQL().TieneBanner(player.getUniqueId().toString()).equals("No")) {
      player.getInventory().setHelmet(null);
    }
    if (!CoreAPI.getMySQL().TieneParticula(player.getUniqueId().toString()).equals("No"))
    {
      Particulas mascota = Particulas.valueOf(CoreAPI.getMySQL().ObtenerParticula(player));
      
      Utilidades.RemoverCorona(player);
    }
    if (!CoreAPI.getMySQL().TieneMascota(player.getUniqueId().toString()).equals("No"))
    {
      Mascotas mascota = Mascotas.valueOf(CoreAPI.getMySQL().ObtenermASCOTA(player));
      
      Cosmeticos.RemoverMascota(player);
    }
    if (!CoreAPI.getMySQL().TieneDisfras(player.getUniqueId().toString()).equals("No"))
    {
      player.getInventory().setHelmet(null);
      player.getInventory().setChestplate(null);
      player.getInventory().setLeggings(null);
      player.getInventory().setBoots(null);
    }
  }
  
  @EventHandler
  public void PJoin(PlayerJoinEvent event)
  {
    Player player = event.getPlayer();
    
    Location spawn = new Location(Bukkit.getWorld("Lobby"), 20.647D, 38.0D, -9.42D);
    
    player.teleport(spawn);
    for (Player test : Bukkit.getOnlinePlayers()) {
      if (CoreAPI.getMySQL().Jugadores(player.getUniqueId().toString()).equals("Si")) {
        test.hidePlayer(player);
      }
    }
    Title title = new Title(Utilidades.Color("&5Quark&dCraft"), "", 25, 25, 25);
    title.send(player);
    Utilidades.SendTabList(player);
    player.setMaxHealth(2.0D);
    player.setHealth(2.0D);
    player.setFoodLevel(20);
    
    player.sendMessage("");
    player.sendMessage("");
    player.sendMessage("");
    player.sendMessage("");
    player.sendMessage("");
    player.sendMessage("");
    player.sendMessage("");
    player.sendMessage("");
    player.sendMessage("");
    player.sendMessage("");
    player.sendMessage("");
    player.sendMessage("");
    player.sendMessage("");
    player.sendMessage("");
    player.sendMessage("");
    player.sendMessage("");
    player.sendMessage("");
    player.sendMessage("");
    player.sendMessage("");
    player.sendMessage("");
    player.sendMessage("");
    if (CoreAPI.getMySQL().EsPremium(player.getUniqueId().toString()).equals("Si")) {
      player.sendMessage(ChatColor.GREEN + "Logeado como premium!");
    }
    player.sendMessage("");
    Utilidades.sendCenteredMessage(player, "&7&m----------------------------------------------");
    Utilidades.sendCenteredMessage(player, "");
    Utilidades.sendCenteredMessage(player, "&5Quark&dCraft");
    Utilidades.sendCenteredMessage(player, "&fBienvenid@ a la comunidad");
    Utilidades.sendCenteredMessage(player, "&fActiva el modo premium con &b/premium");
    Utilidades.sendCenteredMessage(player, "&bTienda: &etienda.mc.quarkcraft.net");
    Utilidades.sendCenteredMessage(player, "&bTwitter: &e@QuarkCraft");
    Utilidades.sendCenteredMessage(player, "");
    Utilidades.sendCenteredMessage(player, "&7&m----------------------------------------------");
    
    Core1.getInstance().getScoreboardListener().registerScoreboards(player);
    
    Utilidades.UpdatearScoreBoard(player);
    Utilidades.DarKit(player);
    if (!CoreAPI.getMySQL().TieneSombrero(player.getUniqueId().toString()).equals("No"))
    {
      Sombreros mascota = Sombreros.valueOf(CoreAPI.getMySQL().ObtenerSombrero(player));
      
      Cosmeticos.EquiparSombrero1(player, mascota);
    }
    if (!CoreAPI.getMySQL().TieneBanner(player.getUniqueId().toString()).equals("No"))
    {
      Banners mascota = Banners.valueOf(CoreAPI.getMySQL().ObtenerBanner(player));
      
      Cosmeticos.EquiparBanner1(player, mascota);
    }
    if (!CoreAPI.getMySQL().TieneParticula(player.getUniqueId().toString()).equals("No"))
    {
      Particulas mascota = Particulas.valueOf(CoreAPI.getMySQL().ObtenerParticula(player));
      
      Cosmeticos.EquiparParticula1(player, mascota);
    }
    if (!CoreAPI.getMySQL().TieneMascota(player.getUniqueId().toString()).equals("No"))
    {
      Mascotas mascota = Mascotas.valueOf(CoreAPI.getMySQL().ObtenermASCOTA(player));
      
      Cosmeticos.EquiparMascota1(player, mascota);
    }
    if (!CoreAPI.getMySQL().TieneDisfras(player.getUniqueId().toString()).equals("No"))
    {
      Disfraces mascota = Disfraces.valueOf(CoreAPI.getMySQL().ObtenerDIsfras(player));
      
      Cosmeticos.EquiparDisfras1(player, mascota);
    }
  }
}
