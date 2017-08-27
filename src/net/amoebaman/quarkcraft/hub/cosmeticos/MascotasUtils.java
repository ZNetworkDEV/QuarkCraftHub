/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.cosmeticos;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.UUID;
import net.quarkcraft.api.CoreAPI;
import net.quarkcraft.api.mysql.MySQL;
import net.quarkcraft.hub.Core1;
import net.quarkcraft.hub.enums.Mascotas;
import net.quarkcraft.hub.enums.MascotasTip;
import net.quarkcraft.hub.nms.PetsManager;
import org.apache.commons.codec.binary.Base64;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.SkullType;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

public class MascotasUtils
{
  public static void SpawnearMascota(final Player player, Mascotas tipo)
  {
    EntityType tipos = tipo.getTipoEntity();
    
    final Entity pet = player.getWorld().spawnEntity(player.getLocation().clone().add(0.0D, 0.25D, 0.0D), tipos);
    if (tipo.equals(Mascotas.EsqueletoWhiter))
    {
      Skeleton skeleton = (Skeleton)pet;
      skeleton.setSkeletonType(Skeleton.SkeletonType.WITHER);
    }
    MascotasAPI.ObtenerMascota().put(player.getName(), pet);
    MascotasAPI.ObtenerMascotaPorTipo().put(player.getName(), tipo);
    
    MascotasAPI.Task = Integer.valueOf(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Core1.getInstance(), new Runnable()
    {
      public void run()
      {
        Core1.getInstance().getNmsManager().followPlayer(player, pet, 0.7D);
      }
    }, 5L, 6L));
    MascotasAPI.ObtenerMascotaTasks().put(player.getName(), MascotasAPI.Tasks());
    pet.setMetadata(player.getName(), new FixedMetadataValue(Core1.getInstance(), Boolean.valueOf(true)));
    if (!CoreAPI.getMySQL().TieneNombreMascota(player.getUniqueId().toString()).equals("No"))
    {
      pet.setCustomNameVisible(true);
      pet.setCustomName(CoreAPI.getMySQL().getNombreMascota(player));
    }
    else
    {
      pet.setCustomNameVisible(true);
      pet.setCustomName(" ");
    }
    if (tipo.getTipo().equals(MascotasTip.Compañero))
    {
      LivingEntity lentity = (LivingEntity)pet;
      lentity.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 
        9999999, 9999999));
      
      ArmorStand compa = (ArmorStand)pet.getWorld().spawnEntity(pet.getLocation(), EntityType.ARMOR_STAND);
      compa.setVisible(false);
      compa.setSmall(true);
      if (!CoreAPI.getMySQL().TieneNombreMascota(player.getUniqueId().toString()).equals("No"))
      {
        compa.setCustomNameVisible(true);
        compa.setCustomName(CoreAPI.getMySQL().getNombreMascota(player));
      }
      else
      {
        compa.setCustomNameVisible(true);
        compa.setCustomName(" ");
      }
      pet.setCustomNameVisible(false);
      
      compa.setMetadata(player.getName(), new FixedMetadataValue(Core1.getInstance(), Boolean.valueOf(true)));
      
      compa.getLocation().setDirection(player.getLocation().getDirection());
      
      MascotasAPI.Task = Integer.valueOf(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Core1.getInstance(), new Runnable()
      {
        public void run()
        {
          BodyPart.HEAD.setPose(compa, player.getEyeLocation());
          pet.setPassenger(compa);
        }
      }, 5L, 6L));
      
      MascotasAPI.ObtenerCompañero().put(player.getName(), compa);
      MascotasAPI.Evolucionado().put(player.getUniqueId(), "No");
      
      EntityEquipment equipment = compa.getEquipment();
      
      ItemStack helmet = skull(tipo.getUrl());
      equipment.setHelmet(helmet);
    }
  }
  
  public static ItemStack skull(String url)
  {
    url = "http://textures.minecraft.net/texture/" + url;
    ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
    SkullMeta skullMeta = (SkullMeta)head.getItemMeta();
    if (url.isEmpty()) {
      return head;
    }
    GameProfile profile = new GameProfile(UUID.randomUUID(), null);
    byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", new Object[] { url }).getBytes());
    profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
    try
    {
      Field profileField = skullMeta.getClass().getDeclaredField("profile");
      profileField.setAccessible(true);
      profileField.set(skullMeta, profile);
    }
    catch (NoSuchFieldException|IllegalArgumentException|IllegalAccessException e1)
    {
      e1.printStackTrace();
    }
    head.setItemMeta(skullMeta);
    return head;
  }
}