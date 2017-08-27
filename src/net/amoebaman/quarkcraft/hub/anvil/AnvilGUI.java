/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.anvil;

import java.util.HashMap;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.ChatMessage;
import net.minecraft.server.v1_8_R3.Container;
import net.minecraft.server.v1_8_R3.ContainerAnvil;
import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayOutOpenWindow;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import net.quarkcraft.hub.Core1;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftInventoryView;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;

public class AnvilGUI
{
  private Player player;
  private AnvilClickEventHandler handler;
  
  private class AnvilContainer
    extends ContainerAnvil
  {
    public AnvilContainer(EntityHuman entity)
    {
    	super(entity.inventory, entity.world,new BlockPosition(0, 0, 0), entity);
    }
    
    public boolean a(EntityHuman entityhuman)
    {
      return true;
    }
  }
  
  public static enum AnvilSlot
  {
    INPUT_LEFT(0),  INPUT_RIGHT(1),  OUTPUT(2);
    
    private int slot;
    
    private AnvilSlot(int slot)
    {
      this.slot = slot;
    }
    
    public int getSlot()
    {
      return this.slot;
    }
    
    public static AnvilSlot bySlot(int slot)
    {
      AnvilSlot[] arrayOfAnvilSlot;
      int j = (arrayOfAnvilSlot = values()).length;
      for (int i = 0; i < j; i++)
      {
        AnvilSlot anvilSlot = arrayOfAnvilSlot[i];
        if (anvilSlot.getSlot() == slot) {
          return anvilSlot;
        }
      }
      return null;
    }
  }
  
  public class AnvilClickEvent
  {
    private AnvilGUI.AnvilSlot slot;
    private String name;
    private boolean close = true;
    private boolean destroy = true;
    
    public AnvilClickEvent(AnvilGUI.AnvilSlot slot, String name)
    {
      this.slot = slot;
      this.name = name;
    }
    
    public AnvilGUI.AnvilSlot getSlot()
    {
      return this.slot;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public boolean getWillClose()
    {
      return this.close;
    }
    
    public void setWillClose(boolean close)
    {
      this.close = close;
    }
    
    public boolean getWillDestroy()
    {
      return this.destroy;
    }
    
    public void setWillDestroy(boolean destroy)
    {
      this.destroy = destroy;
    }
  }
  
  private HashMap<AnvilSlot, ItemStack> items = new HashMap();
  private Inventory inv;
  private Listener listener;
  
  public AnvilGUI(Player player, final AnvilClickEventHandler handler)
  {
    this.player = player;
    this.handler = handler;
    
    this.listener = new Listener()
    {
      @EventHandler
      public void onInventoryClick(InventoryClickEvent event)
      {
        if ((event.getWhoClicked() instanceof Player))
        {
          Player clicker = (Player)event.getWhoClicked();
          if (event.getInventory().equals(AnvilGUI.this.inv))
          {
            event.setCancelled(true);
            
            ItemStack item = event.getCurrentItem();
            int slot = event.getRawSlot();
            String name = "";
            if ((item != null) && 
              (item.hasItemMeta()))
            {
              ItemMeta meta = item.getItemMeta();
              if (meta.hasDisplayName()) {
                name = meta.getDisplayName();
              }
            }
            AnvilGUI.AnvilClickEvent clickEvent = new AnvilGUI.AnvilClickEvent(AnvilGUI.AnvilSlot.bySlot(slot), name);
            
            handler.onAnvilClick(clickEvent);
            if (clickEvent.getWillClose()) {
              event.getWhoClicked().closeInventory();
            }
            if (clickEvent.getWillDestroy()) {
              AnvilGUI.this.destroy();
            }
          }
        }
      }
      
      @EventHandler
      public void onInventoryClose(InventoryCloseEvent event)
      {
        if ((event.getPlayer() instanceof Player))
        {
          Player player = (Player)event.getPlayer();
          Inventory inv = event.getInventory();
          if (inv.equals(AnvilGUI.this.inv))
          {
            inv.clear();
            AnvilGUI.this.destroy();
          }
        }
      }
      
      @EventHandler
      public void onPlayerQuit(PlayerQuitEvent event)
      {
        if (event.getPlayer().equals(AnvilGUI.this.getPlayer())) {
          AnvilGUI.this.destroy();
        }
      }
    };
    Bukkit.getPluginManager().registerEvents(this.listener, Core1.getInstance());
  }
  
  public Player getPlayer()
  {
    return this.player;
  }
  
  public void setSlot(AnvilSlot slot, ItemStack item)
  {
    this.items.put(slot, item);
  }
  
  public void open()
  {
    EntityPlayer p = ((CraftPlayer)this.player).getHandle();
    
    AnvilContainer container = new AnvilContainer(p);
    
    this.inv = container.getBukkitView().getTopInventory();
    for (AnvilSlot slot : this.items.keySet()) {
      this.inv.setItem(slot.getSlot(), (ItemStack)this.items.get(slot));
    }
    int c = p.nextContainerCounter();
    
    p.playerConnection.sendPacket(new PacketPlayOutOpenWindow(c, "minecraft:anvil", new ChatMessage("Repairing", new Object[0]), 0));
    
    p.activeContainer = container;
    
    p.activeContainer.windowId = c;
    
    p.activeContainer.addSlotListener(p);
  }
  
  public void destroy()
  {
    this.player = null;
    this.handler = null;
    this.items = null;
    
    HandlerList.unregisterAll(this.listener);
    
    this.listener = null;
  }
  
  public static abstract interface AnvilClickEventHandler
  {
    public abstract void onAnvilClick(AnvilGUI.AnvilClickEvent paramAnvilClickEvent);
  }
}
