/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.menu;

import net.quarkcraft.api.CoreAPI;
import net.quarkcraft.hub.enums.Banners;
import net.quarkcraft.hub.enums.ColorDeChat;
import net.quarkcraft.hub.enums.Disfraces;
import net.quarkcraft.hub.enums.Mascotas;
import net.quarkcraft.hub.enums.MascotasTip;
import net.quarkcraft.hub.enums.Particulas;
import net.quarkcraft.hub.enums.Sombreros;
import net.quarkcraft.hub.utils.BungeeUtils;
import net.quarkcraft.hub.utils.Utilidades;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class Menu {
	private static int[] SLOTS = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
			22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35};

	public static void Juegos(Player player) {
		Inventory juegos = Bukkit.createInventory((InventoryHolder) null, 54, "Juegos");
		BungeeUtils.getPlayerCount("ArenaPvP");
	Integer arenapvpconectados = (Integer) BungeeUtils.playerCounts.get("ArenaPvP");
		ItemStack ArenaPvP = Utilidades.createItem(Material.LAVA_BUCKET, "&bArenaPvP",
				new String[]{"&7¡Si te gusta el pvp esta es tu modalidad ,", "&7conviertete en el mejor!", "",
						"&f" + arenapvpconectados + " &7Jugadores conectados ", "", "&e¡Haz click!"});
		juegos.setItem(10, ArenaPvP);
		player.openInventory(juegos);
	}

	public static void Sombreros(Player player) {
		Inventory opciones = Bukkit.createInventory((InventoryHolder) null, 54, "Sombreros - Pagina 1");
		byte from = 1;
		byte to = 27;
		int i = 0;
		int size = Sombreros.values().size();

		for (int h = from; h <= to; ++h) {
			try {
				if (h > size) {
					break;
				}

				Sombreros sombreros = (Sombreros) Sombreros.values().get(h - 1);
				if (CoreAPI.getMySQL().obtenerRango(player).equals(sombreros.getRango())) {
					Utilidades
							.inventorySkull(opciones, SLOTS[i], sombreros.getHeadTexture(), sombreros.getDisplayName(),
									new String[]{"&7Lucete con este asombroso sombrero",
											"&7de&b " + sombreros.getName(), "",
											"&7Requiere: " + sombreros.getRango().getColor()
													+ sombreros.getRango().getNombre() + " &7O Superior",
											"", "&e¡Haz click!"});
				} else {
					Utilidades
							.inventorySkull(opciones, SLOTS[i], sombreros.getHeadTexture(), sombreros.getDisplayName(),
									new String[]{"&7Lucete con este asombroso sombrero",
											"&7de&b " + sombreros.getName(), "",
											"&7Requiere: " + sombreros.getRango().getColor()
													+ sombreros.getRango().getNombre() + " &7O Superior",
											"", "&e¡No requieres el rango!"});
				}

				++i;
			} catch (Exception arg8) {
				arg8.printStackTrace();
			}

			ItemStack arg9 = Utilidades.SkullTextura("e31867a69880dc124cf1735bdeed2788bec4f26b52b7d31aef9601c80f0888e",
					"&bSombreros", new String[]{"&7Lucete con los magnificos sombreros!"});
			opciones.setItem(49, arg9);
			if (!CoreAPI.getMySQL().TieneSombrero(player.getUniqueId().toString()).equals("No")) {
				ItemStack test = Utilidades.createItem(Material.BARRIER, "&bRemover Sombrero",
						new String[]{"&e¡Haz click!"});
				opciones.setItem(45, test);
			}

			player.openInventory(opciones);
		}

	}

	public static void ColorDeChat(Player player) {
		Inventory opciones = Bukkit.createInventory((InventoryHolder) null, 54, "Color de Chat - Pagina 1");
		byte from = 1;
		byte to = 27;
		int i = 0;
		int size = ColorDeChat.values().size();

		for (int h = from; h <= to; ++h) {
			try {
				if (h > size) {
					break;
				}

				ColorDeChat colorchat = (ColorDeChat) ColorDeChat.values().get(h - 1);
				if (CoreAPI.getMySQL().obtenerRango(player).equals(colorchat.getRango())) {
					Utilidades.InventoryNormal2(opciones, SLOTS[i], colorchat.getDurability(), Material.STAINED_GLASS,
							colorchat.getDisplayName(),
							new String[]{"&7Lucete con este asombroso color de chat",
									"&7de color&b " + colorchat.getDisplayName(), "",
									"&7Requiere: " + colorchat.getRango().getNombre() + " O Superior", "",
									"&e¡Haz click!"});
				} else {
					Utilidades.InventoryNormal2(opciones, SLOTS[i], colorchat.getDurability(), Material.STAINED_GLASS,
							colorchat.getDisplayName(),
							new String[]{"&7Lucete con este asombroso color de chat",
									"&7de color&b " + colorchat.getDisplayName(), "",
									"&7Requiere: " + colorchat.getRango().getNombre() + " O Superior", "",
									"&e¡No requieres el rango!"});
				}

				++i;
			} catch (Exception arg7) {
				arg7.printStackTrace();
			}

			ItemStack arg8;
			if (!CoreAPI.getMySQL().TieneColorChat(player.getUniqueId().toString()).equals("No")) {
				arg8 = Utilidades.createItem(Material.BARRIER, "&bRemover Color de Chat",
						new String[]{"&e¡Haz click!"});
				opciones.setItem(45, arg8);
			}

			arg8 = Utilidades.createItem2(Material.STAINED_CLAY, 5, "&bColor del Chat",
					new String[]{"&7Haz resaltar tu nombre en el chat"});
			opciones.setItem(49, arg8);
			player.openInventory(opciones);
		}

	}

	public static void Disfraces(Player player) {
		Inventory opciones = Bukkit.createInventory((InventoryHolder) null, 54, "Disfraces - Pagina 1");
		byte from = 1;
		byte to = 27;
		int i = 0;
		int size = Disfraces.values().size();

		for (int h = from; h <= to; ++h) {
			try {
				if (h > size) {
					break;
				}

				Disfraces disfras = (Disfraces) Disfraces.values().get(h - 1);
				if (CoreAPI.getMySQL().obtenerRango(player).equals(disfras.getRango())) {
					Utilidades
							.inventorySkull(opciones, SLOTS[i], disfras.getHeadTexture(), disfras.getDisplayName(),
									new String[]{"&7Lucete con este asombroso disfras", "&7de&b " + disfras.getName(),
											"",
											"&7Requiere: " + disfras.getRango().getColor()
													+ disfras.getRango().getNombre() + " &7O Superior",
											"", "&e¡Haz click!"});
				} else {
					Utilidades
							.inventorySkull(opciones, SLOTS[i], disfras.getHeadTexture(), disfras.getDisplayName(),
									new String[]{"&7Lucete con este asombroso disfras", "&7de&b " + disfras.getName(),
											"",
											"&7Requiere: " + disfras.getRango().getColor()
													+ disfras.getRango().getNombre() + " &7O Superior",
											"", "&e¡No requieres el rango!"});
				}

				++i;
			} catch (Exception arg7) {
				arg7.printStackTrace();
			}

			ItemStack arg8;
			if (!CoreAPI.getMySQL().TieneDisfras(player.getUniqueId().toString()).equals("No")) {
				arg8 = Utilidades.createItem(Material.BARRIER, "&bRemover Disfras", new String[]{"&e¡Haz click!"});
				opciones.setItem(45, arg8);
			}

			arg8 = Utilidades.createItem2(Material.DRAGON_EGG, 0, "&bDisfraces",
					new String[]{"&7Lucete con los increibles disfrases"});
			opciones.setItem(49, arg8);
			player.openInventory(opciones);
		}

	}

	public static void Ajustes(Player player, boolean test) {
      Inventory mascota = Bukkit.createInventory((InventoryHolder)null, 27, "Ajustes de Mascota");
      Inventory Compañero = Bukkit.createInventory((InventoryHolder)null, 27, "Ajustes de Compañero");
      ItemStack Montar = Utilidades.createItem(Material.SADDLE, "&bMontar", new String[]{"&7Por si quieres montar a tu mascota!", "", "&e¡Haz click!"});
      ItemStack Renombrar = Utilidades.createItem(Material.EMPTY_MAP, "&bRenombrar", new String[]{"&7Por si quieres renombrar a tu mascota!", "", "&e¡Haz click!"});
      ItemStack Evolucionar = Utilidades.createItem(Material.SLIME_BALL, "&bEvolucionar", new String[]{"&7Por si quieres evolucionar a tu compañero!", "", "&e¡Haz click!"});
      if(test) {
    	  Compañero.setItem(10, Montar);
    	  Compañero.setItem(13, Renombrar);
    	  Compañero.setItem(16, Evolucionar);
         player.openInventory(Compañero);
      } else {
         mascota.setItem(10, Montar);
         mascota.setItem(13, Renombrar);
         mascota.setItem(16, Evolucionar);
         player.openInventory(mascota);
      }

   }

	public static void Particulas(Player player) {
		Inventory opciones = Bukkit.createInventory((InventoryHolder) null, 54, "Particulas - Pagina 1");
		byte from = 1;
		byte to = 27;
		int i = 0;
		int size = Particulas.values().size();

		for (int h = from; h <= to; ++h) {
			try {
				if (h > size) {
					break;
				}

				Particulas particulas = (Particulas) Particulas.values().get(h - 1);
				if (CoreAPI.getMySQL().obtenerRango(player).equals(particulas.getRango())) {
					Utilidades.InventoryNormal(opciones, SLOTS[i], particulas.getMaterial(),
							particulas.getDisplayName(),
							new String[]{"&7Lucete con esta asombrosa particula", "&7de&b " + particulas.getName(), "",
									"&7Requiere: " + particulas.getRango().getColor()
											+ particulas.getRango().getNombre() + " &7O Superior",
									"", "&e¡Haz click!"});
				} else {
					Utilidades.InventoryNormal(opciones, SLOTS[i], particulas.getMaterial(),
							particulas.getDisplayName(),
							new String[]{"&7Lucete con esta asombrosa particula", "&7de&b " + particulas.getName(), "",
									"&7Requiere: " + particulas.getRango().getColor()
											+ particulas.getRango().getNombre() + " &7O Superior",
									"", "&e¡No requieres el rango!"});
				}

				++i;
			} catch (Exception arg7) {
				arg7.printStackTrace();
			}

			ItemStack arg8;
			if (!CoreAPI.getMySQL().TieneParticula(player.getUniqueId().toString()).equals("No")) {
				arg8 = Utilidades.createItem(Material.BARRIER, "&bRemover Particula", new String[]{"&e¡Haz click!"});
				opciones.setItem(45, arg8);
			}

			arg8 = Utilidades.createItem2(Material.WATER_BUCKET, 0, "&bParticulas",
					new String[]{"&7Lucete con las increibles particulas"});
			opciones.setItem(49, arg8);
			player.openInventory(opciones);
		}

	}

	public static void Banners(Player player) {
		Inventory opciones = Bukkit.createInventory((InventoryHolder) null, 54, "Banners - Pagina 1");
		byte from = 1;
		byte to = 27;
		int i = 0;
		int size = Banners.values().size();

		for (int h = from; h <= to; ++h) {
			try {
				if (h > size) {
					break;
				}

				Banners banners = (Banners) Banners.values().get(h - 1);
				if (CoreAPI.getMySQL().obtenerRango(player).equals(banners.getRango())) {
					Utilidades
							.PonerInv(opciones, SLOTS[i], banners.getMaterial(), banners.getDisplayName(),
									new String[]{"&7Lucete con esta asombroso banner", "&7de&b " + banners.getName(),
											"",
											"&7Requiere: " + banners.getRango().getColor()
													+ banners.getRango().getNombre() + " &7O Superior",
											"", "&e¡Haz click!"});
				} else {
					Utilidades
							.PonerInv(opciones, SLOTS[i], banners.getMaterial(), banners.getDisplayName(),
									new String[]{"&7Lucete con esta asombroso banner", "&7de&b " + banners.getName(),
											"",
											"&7Requiere: " + banners.getRango().getColor()
													+ banners.getRango().getNombre() + " &7O Superior",
											"", "&e¡No requieres el rango!"});
				}

				++i;
			} catch (Exception arg7) {
				arg7.printStackTrace();
			}

			ItemStack arg8;
			if (!CoreAPI.getMySQL().TieneBanner(player.getUniqueId().toString()).equals("No")) {
				arg8 = Utilidades.createItem(Material.BARRIER, "&bRemover Banner", new String[]{"&e¡Haz click!"});
				opciones.setItem(45, arg8);
			}

			arg8 = Utilidades.createItem2(Material.BANNER, 0, "&bBanners",
					new String[]{"&7Lucete con los increibles banners en tu cabeza"});
			opciones.setItem(49, arg8);
			player.openInventory(opciones);
		}

	}

	public static void Mascotas(Player player, int page) {
      Inventory opciones = Bukkit.createInventory((InventoryHolder)null, 54, "Compañeros y Mascotas - Pagina " + page);
      byte from = 1;
      byte to = 36;
      int i = 0;
      int size = Mascotas.values().size();

      for(int h = from; h <= to; ++h) {
         try {
            if(h > size) {
               break;
            }

            Mascotas mascotas = (Mascotas)Mascotas.values().get(h - 1);
            if(mascotas.getTipo().equals(MascotasTip.Mascota)) {
               if(CoreAPI.getMySQL().obtenerRango(player).equals(mascotas.getRango())) {
                  Utilidades.InventoryNormal(opciones, SLOTS[i], mascotas.getMaterial(), mascotas.getDisplayName(), new String[]{"&7Lucete con esta asombrosa Mascota &b" + mascotas.getName(), "", "&7Requiere: " + mascotas.getRango().getColor() + mascotas.getRango().getNombre() + " &7O Superior", "", "&e¡Haz click!"});
               } else {
                  Utilidades.InventoryNormal(opciones, SLOTS[i], mascotas.getMaterial(), mascotas.getDisplayName(), new String[]{"&7Lucete con esta asombrosa Mascota &b" + mascotas.getName(), "", "&7Requiere: " + mascotas.getRango().getColor() + mascotas.getRango().getNombre() + " &7O Superior", "", "&e¡No requieres el rango!"});
               }
            }

            if(mascotas.getTipo().equals(MascotasTip.Compañero)) {
               if(CoreAPI.getMySQL().obtenerRango(player).equals(mascotas.getRango())) {
                  Utilidades.inventorySkull(opciones, SLOTS[i], mascotas.getUrl(), mascotas.getDisplayName(), new String[]{"&7Lucete con este asombroso Compañero &b" + mascotas.getName(), "", "&7Requiere: " + mascotas.getRango().getColor() + mascotas.getRango().getNombre() + " &7O Superior", "", "&e¡Haz click!"});
               } else {
                  Utilidades.inventorySkull(opciones, SLOTS[i], mascotas.getUrl(), mascotas.getDisplayName(), new String[]{"&7Lucete con este asombroso Compañero &b" + mascotas.getName(), "", "&7Requiere: " + mascotas.getRango().getColor() + mascotas.getRango().getNombre() + " &7O Superior", "", "&e¡No requieres el rango!"});
               }
            }

            ++i;
         } catch (Exception arg8) {
            arg8.printStackTrace();
         }

         ItemStack arg9;
         if(!CoreAPI.getMySQL().TieneMascota(player.getUniqueId().toString()).equals("No")) {
            arg9 = Utilidades.createItem(Material.BARRIER, "&bRemover Mascota", new String[]{"&e¡Haz click!"});
            opciones.setItem(45, arg9);
         }

         arg9 = Utilidades.createItem2(Material.BONE, 0, "&bMascotas y Compañeros", new String[]{"&7Por si te sientes aburrido y ", "&7quieres una mascota o compañero"});
         opciones.setItem(49, arg9);
         player.openInventory(opciones);
      }

   }

	public static void Cosmeticos(Player player) {
		Inventory cosmeticos = Bukkit.createInventory((InventoryHolder) null, 54, "Cosmeticos");
		ItemStack sombreros = Utilidades.SkullTextura("e31867a69880dc124cf1735bdeed2788bec4f26b52b7d31aef9601c80f0888e",
				"&bSombreros", new String[]{"&7Lucete con los magnificos sombreros!", "", "&e¡Haz click!"});
		cosmeticos.setItem(13, sombreros);
		ItemStack mascotas = Utilidades.createItem2(Material.BONE, 0, "&bMascotas y Compañeros", new String[]{
				"&7Por si te sientes aburrido y ", "&7quieres una mascota o compañero", "", "&e¡Haz click!"});
		cosmeticos.setItem(10, mascotas);
		ItemStack particulas = Utilidades.createItem2(Material.WATER_BUCKET, 0, "&bParticulas",
				new String[]{"&7Lucete con las increibles particulas", "", "&e¡Haz click!"});
		cosmeticos.setItem(16, particulas);
		ItemStack banners = Utilidades.createItem2(Material.BANNER, 0, "&bBanners",
				new String[]{"&7Lucete con los increibles banners en tu cabeza", "", "&e¡Haz click!"});
		cosmeticos.setItem(28, banners);
		ItemStack disfras = Utilidades.createItem2(Material.DRAGON_EGG, 0, "&bDisfraces",
				new String[]{"&7Lucete con los increibles disfrases", "", "&e¡Haz click!"});
		cosmeticos.setItem(31, disfras);
		ItemStack colorchat = Utilidades.createItem2(Material.STAINED_CLAY, 5, "&bColor del Chat",
				new String[]{"&7Haz resaltar tu nombre en el chat", "", "&e¡Haz click!"});
		cosmeticos.setItem(34, colorchat);
		player.openInventory(cosmeticos);
	}

	public static void MiPerfil(Player player) {
		Inventory perfil = Bukkit.createInventory((InventoryHolder) null, 27, "Mi Perfil");
		ItemStack estadisticas = Utilidades.createItem2(Material.PAPER, 0, "&bEstadisticas",
				new String[]{"&7Mira tus estadisticas de cada ", "&7juego y ten una vision general", "&7de ellas", "",
						"&e¡Haz click!"});
		perfil.setItem(10, estadisticas);
		player.openInventory(perfil);
	}

	public static void CofreDelTesoro(Player player) {
		Inventory cofre = Bukkit.createInventory((InventoryHolder) null, 45, "Cofre del Tesoro");
		ItemStack sin = Utilidades.createItem2(Material.STAINED_GLASS_PANE, 14, "&bSin Quarks",
				new String[]{"&7No tienes quarks!"});
		ItemStack con = Utilidades.createItem2(Material.CHEST, 0, "&bCofre del Tesoro",
				new String[]{"&7Click para abrirlo!", "", "&e¡Haz click!"});
		if (CoreAPI.getMySQL().getQuarks(player) == 0) {
			cofre.setItem(22, sin);
			player.openInventory(cofre);
		} else {
			for (int i = 0; i < CoreAPI.getMySQL().getQuarks(player); ++i) {
				cofre.setItem(i, con);
			}

			player.openInventory(cofre);
		}
	}

	public static void Estadisticass(Player player) {
		Inventory perfil = Bukkit.createInventory((InventoryHolder) null, 54, "Estadisticas");
		ItemStack estadisticas;
		if (CoreAPI.getArenaPvPMySQL().hasAccount(player)) {
			estadisticas = Utilidades.createItem2(Material.LAVA_BUCKET, 0, "&bArenaPvP",
					new String[]{"&fMatanzas:&7 " + CoreAPI.getArenaPvPMySQL().getKills(player),
							"&fMuertes:&7 " + CoreAPI.getArenaPvPMySQL().getMuertes(player),
							"&fGanadas:&7 " + CoreAPI.getArenaPvPMySQL().getGanadas(player),
							"&fRankeds:&7 " + CoreAPI.getArenaPvPMySQL().getRankeds(player),
							"&fPuntos:&7 " + CoreAPI.getArenaPvPMySQL().getELO(player),
							"&fDivision:&7 " + CoreAPI.getArenaPvPMySQL().getDivision(player).getDivisionColor()
									+ CoreAPI.getArenaPvPMySQL().getDivision(player).getNombre()});
			perfil.setItem(10, estadisticas);
		} else {
			estadisticas = Utilidades.createItem2(Material.LAVA_BUCKET, 0, "&bArenaPvP",
					new String[]{"&fMatanzas:&7 Vacio", "&fMuertes:&7 Vacio", "&fGanadas:&7 Vacio",
							"&fPuntos: &7 Vacio", "&fRankeds:&7 Vacio", "&fDivision:&7 Vacio"});
			perfil.setItem(10, estadisticas);
		}

		player.openInventory(perfil);
	}

	public static void Lobbys(Player player) {
		Inventory juegos = Bukkit.createInventory((InventoryHolder) null, 27, "Lobbys Disponibles");
		ItemStack lobby1 = Utilidades.createItem(Material.STAINED_CLAY, "&bLobby 1",
				new String[]{"&7¡Ya te encuentras en este lobby!", "",
						"&f" + Bukkit.getOnlinePlayers().size() + " &7Jugadores conectados ", "", "&e¡Haz click!"});
		lobby1.setDurability((short) 14);
		juegos.setItem(13, lobby1);
		player.openInventory(juegos);
	}
}