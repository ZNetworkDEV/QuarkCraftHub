/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.cosmeticos;

import net.quarkcraft.api.CoreAPI;
import net.quarkcraft.hub.cosmeticos.MascotasAPI;
import net.quarkcraft.hub.cosmeticos.MascotasUtils;
import net.quarkcraft.hub.enums.Banners;
import net.quarkcraft.hub.enums.ColorDeChat;
import net.quarkcraft.hub.enums.Disfraces;
import net.quarkcraft.hub.enums.Mascotas;
import net.quarkcraft.hub.enums.MascotasTip;
import net.quarkcraft.hub.enums.Particulas;
import net.quarkcraft.hub.enums.Sombreros;
import net.quarkcraft.hub.utils.Utilidades;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

public class Cosmeticos {
	public static void EquiparDisfras(Player player, Disfraces sombrero) {
		if (!CoreAPI.getMySQL().TieneSombrero(player.getUniqueId().toString()).equals("No")) {
			player.sendMessage(Utilidades.Color("&c°Tienes un sombrero equipado!"));
		} else if (!CoreAPI.getMySQL().TieneBanner(player.getUniqueId().toString()).equals("No")) {
			player.sendMessage(Utilidades.Color("&c°Tienes un banner equipado!"));
		} else if (!CoreAPI.getMySQL().TieneDisfras(player.getUniqueId().toString()).equals("No")) {
			player.sendMessage(Utilidades.Color("&c°Ya tienes un disfras equipado!"));
		} else {
			ItemStack sombreroe = Utilidades.SkullTextura(sombrero.getHeadTexture(), "&b" + sombrero.getDisplayName(),
					new String[]{""});
			ItemStack chestplate = sombrero.getChestplate();
			ItemStack leggings = sombrero.getLeggings();
			ItemStack boots = sombrero.getBoots();
			player.getInventory().setHelmet(sombreroe);
			player.getInventory().setChestplate(chestplate);
			player.getInventory().setLeggings(leggings);
			player.getInventory().setBoots(boots);
			player.sendMessage(
					Utilidades.Color("&e°Te has equipado el disfras &b" + sombrero.getDisplayName() + "&e!"));
			FireworkEffect effect = FireworkEffect.builder().trail(false).flicker(false).withColor(Color.RED)
					.withFade(Color.ORANGE).with(Type.BALL).build();
			Firework fw = (Firework) player.getWorld().spawn(player.getLocation(), Firework.class);
			FireworkMeta meta = fw.getFireworkMeta();
			meta.clearEffects();
			meta.addEffect(effect);
			meta.setPower(0);
			fw.setFireworkMeta(meta);
			CoreAPI.getMySQL().PonerTieneDisfras(player, sombrero.getName());
		}
	}

	public static void EquiparBanner(Player player, Banners sombrero) {
		if (!CoreAPI.getMySQL().TieneSombrero(player.getUniqueId().toString()).equals("No")) {
			player.sendMessage(Utilidades.Color("&c°Tienes un sombrero equipado!"));
		} else if (!CoreAPI.getMySQL().TieneDisfras(player.getUniqueId().toString()).equals("No")) {
			player.sendMessage(Utilidades.Color("&c°Tienes un disfras equipado!"));
		} else if (!CoreAPI.getMySQL().TieneBanner(player.getUniqueId().toString()).equals("No")) {
			player.sendMessage(Utilidades.Color("&c°Ya tienes un banner equipado!"));
		} else {
			player.sendMessage(Utilidades.Color("&e°Te has equipado el banner &b" + sombrero.getDisplayName() + "&e!"));
			CoreAPI.getMySQL().PonerTieneBanner(player, sombrero.getName());
			player.getInventory().setHelmet(sombrero.getMaterial());
		}
	}

	public static void EquiparBanner1(Player player, Banners sombrero) {
		player.sendMessage(Utilidades.Color("&e°Te has equipado el banner &b" + sombrero.getDisplayName() + "&e!"));
		CoreAPI.getMySQL().PonerTieneBanner(player, sombrero.getName());
		player.getInventory().setHelmet(sombrero.getMaterial());
	}

	public static void EquiparDisfras1(Player player, Disfraces sombrero) {
		ItemStack sombreroe = Utilidades.SkullTextura(sombrero.getHeadTexture(), "&b" + sombrero.getDisplayName(),
				new String[]{""});
		ItemStack chestplate = sombrero.getChestplate();
		ItemStack leggings = sombrero.getLeggings();
		ItemStack boots = sombrero.getBoots();
		player.getInventory().setHelmet(sombreroe);
		player.getInventory().setChestplate(chestplate);
		player.getInventory().setLeggings(leggings);
		player.getInventory().setBoots(boots);
		player.sendMessage(Utilidades.Color("&e°Te has equipado el disfras &b" + sombrero.getDisplayName() + "&e!"));
		FireworkEffect effect = FireworkEffect.builder().trail(false).flicker(false).withColor(Color.RED)
				.withFade(Color.ORANGE).with(Type.BALL).build();
		Firework fw = (Firework) player.getWorld().spawn(player.getLocation(), Firework.class);
		FireworkMeta meta = fw.getFireworkMeta();
		meta.clearEffects();
		meta.addEffect(effect);
		meta.setPower(0);
		fw.setFireworkMeta(meta);
		CoreAPI.getMySQL().PonerTieneDisfras(player, sombrero.getName());
	}

	public static void EquiparSombrero(Player player, Sombreros sombrero) {
		if (!CoreAPI.getMySQL().TieneDisfras(player.getUniqueId().toString()).equals("No")) {
			player.sendMessage(Utilidades.Color("&c°Tienes un disfras equipado!"));
		} else if (!CoreAPI.getMySQL().TieneBanner(player.getUniqueId().toString()).equals("No")) {
			player.sendMessage(Utilidades.Color("&c°Tienes un banner equipado!"));
		} else if (!CoreAPI.getMySQL().TieneSombrero(player.getUniqueId().toString()).equals("No")) {
			player.sendMessage(Utilidades.Color("&c°Ya tienes un sombrero equipado!"));
		} else {
			ItemStack sombreroe = Utilidades.SkullTextura(sombrero.getHeadTexture(), "&b" + sombrero.getDisplayName(),
					new String[]{""});
			player.getInventory().setHelmet(sombreroe);
			player.sendMessage(
					Utilidades.Color("&e°Te has equipado el sombrero &b" + sombrero.getDisplayName() + "&e!"));
			CoreAPI.getMySQL().PonerTieneSombrero(player, sombrero.getName());
		}
	}

	public static void RemoverMascota(Player player) {
		if (((Entity) MascotasAPI.ObtenerMascota().get(player.getName())).getPassenger() != null) {
			((Entity) MascotasAPI.ObtenerMascota().get(player.getName())).getPassenger().remove();
		}

		((Entity) MascotasAPI.ObtenerMascota().get(player.getName())).remove();
		MascotasAPI.ObtenerMascota().remove(player.getName());
		Bukkit.getScheduler()
				.cancelTask(((Integer) MascotasAPI.ObtenerMascotaTasks().get(player.getName())).intValue());
	}

	public static void EquiparParticula(Player player, Particulas disfras) {
		if (!CoreAPI.getMySQL().TieneParticula(player.getUniqueId().toString()).equals("No")) {
			player.sendMessage(Utilidades.Color("&c°Ya tienes una particula remuevela para equiparte otra!"));
		} else {
			CoreAPI.getMySQL().PonerTieneParticula(player, disfras.getName());
			player.sendMessage(
					Utilidades.Color("&e°Te has equipado la particula &b" + disfras.getDisplayName() + "&e!"));
			Utilidades.Corona(player, disfras, disfras.getEfecto());
		}
	}

	public static void EquiparColorDeChat(Player player, ColorDeChat color) {
		if (!CoreAPI.getMySQL().TieneColorChat(player.getUniqueId().toString()).equals("No")) {
			player.sendMessage(Utilidades.Color("&c°Ya tienes un color de chat equipado!"));
		} else {
			CoreAPI.getMySQL().PonerTieneColorChat(player, color.getColor().name());
			player.sendMessage(
					Utilidades.Color("&e°Te has equipado el color de chat &b" + color.getDisplayName() + "&e!"));
		}
	}

	public static void EquiparMascota(Player player, Mascotas mascota) {
		if (!CoreAPI.getMySQL().TieneMascota(player.getUniqueId().toString()).equals("No")) {
			player.sendMessage(Utilidades.Color("&c°Ya tienes una mascota remuevela para equiparte otra!"));
		} else {
			if (mascota.getTipo().equals(MascotasTip.Mascota)) {
				player.sendMessage(Utilidades.Color("&e°Te has equipado la mascota &b" + mascota.getName() + "&e!"));
			} else {
				player.sendMessage(Utilidades.Color("&e°Te has equipado el compa√±ero &b" + mascota.getName() + "&e!"));
			}

			MascotasUtils.SpawnearMascota(player, mascota);
			CoreAPI.getMySQL().PonerTieneMascota(player, mascota.getName());
		}
	}

	public static void EquiparSombrero1(Player player, Sombreros sombrero) {
		ItemStack sombreroe = Utilidades.SkullTextura(sombrero.getHeadTexture(), "&b" + sombrero.getDisplayName(),
				new String[]{""});
		player.getInventory().setHelmet(sombreroe);
		player.sendMessage(Utilidades.Color("&e°Te has equipado el sombrero &b" + sombrero.getDisplayName() + "&e!"));
		CoreAPI.getMySQL().PonerTieneSombrero(player, sombrero.getName());
	}

	public static void RemoverMascota1(Player player) {
		if (((Entity) MascotasAPI.ObtenerMascota().get(player.getName())).getPassenger() != null) {
			((Entity) MascotasAPI.ObtenerMascota().get(player.getName())).getPassenger().remove();
		}

		((Entity) MascotasAPI.ObtenerMascota().get(player.getName())).remove();
		MascotasAPI.ObtenerMascota().remove(player.getName());
		Bukkit.getScheduler()
				.cancelTask(((Integer) MascotasAPI.ObtenerMascotaTasks().get(player.getName())).intValue());
	}

	public static void EquiparParticula1(Player player, Particulas disfras) {
		CoreAPI.getMySQL().PonerTieneParticula(player, disfras.getName());
		player.sendMessage(Utilidades.Color("&e°Te has equipado la particula &b" + disfras.getDisplayName() + "&e!"));
		Utilidades.Corona(player, disfras, disfras.getEfecto());
	}

	public static void EquiparColorDeChat1(Player player, ColorDeChat color) {
		CoreAPI.getMySQL().PonerTieneColorChat(player, color.getColor().name());
		player.sendMessage(Utilidades.Color("&e°Te has equipado el color de chat &b" + color.getDisplayName() + "&e!"));
	}

	public static void EquiparMascota1(Player player, Mascotas mascota) {
		if (mascota.getTipo().equals(MascotasTip.Mascota)) {
			player.sendMessage(Utilidades.Color("&e°Te has equipado la mascota &b" + mascota.getName() + "&e!"));
		} else {
			player.sendMessage(Utilidades.Color("&e°Te has equipado el compa√±ero &b" + mascota.getName() + "&e!"));
		}

		MascotasUtils.SpawnearMascota(player, mascota);
		CoreAPI.getMySQL().PonerTieneMascota(player, mascota.getName());
	}
}