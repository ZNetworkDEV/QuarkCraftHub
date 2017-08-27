/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.enums;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.quarkcraft.api.enums.Rangos;
import net.quarkcraft.hub.utils.Utilidades;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class ColorDeChat {
	private String name;
	private String displayName;
	private List<String> lore;
	private Material getMaterial;
	private Rangos rango;
	private int test;
	private ChatColor color;
	private boolean cofre;
	private String permiso;
	private static final List<ColorDeChat> VALUES = new ArrayList();
	public static final ColorDeChat Blanco;
	public static final ColorDeChat Naranja;
	public static final ColorDeChat Magenta;
	public static final ColorDeChat AzulClaro;
	public static final ColorDeChat Amarillo;
	public static final ColorDeChat VerdeClaro;
	public static final ColorDeChat Rosado;
	public static final ColorDeChat GrisOscuro;
	public static final ColorDeChat GrisClaro;
	public static final ColorDeChat Cyan;
	public static final ColorDeChat Morado;
	public static final ColorDeChat Azul;
	public static final ColorDeChat VerdeOscuro;
	public static final ColorDeChat Rojo;

	static {
      Blanco = new ColorDeChat("Blanco", Utilidades.Color("&fBlanco"), (List)null, Material.STAINED_GLASS, 0, ChatColor.WHITE, Rangos.Dueño, true, "ColorChatBlanco");
      Naranja = new ColorDeChat("Naranja", Utilidades.Color("&6Naranja"), (List)null, Material.STAINED_GLASS, 4, ChatColor.GOLD, Rangos.Dueño, true, "ColorChatNaranja");
      Magenta = new ColorDeChat("Magenta", Utilidades.Color("&dMagenta"), (List)null, Material.STAINED_GLASS, 2, ChatColor.LIGHT_PURPLE, Rangos.Dueño, false, "ColorChatMagenta");
      AzulClaro = new ColorDeChat("AzulClaro", Utilidades.Color("&3Azul Claro"), (List)null, Material.STAINED_GLASS, 3, ChatColor.BLUE, Rangos.Dueño, true, "ColorChatAzulClaro");
      Amarillo = new ColorDeChat("Amarillo", Utilidades.Color("&eAmarillo"), (List)null, Material.STAINED_GLASS, 1, ChatColor.YELLOW, Rangos.Dueño, false, "ColorChatAmarillo");
      VerdeClaro = new ColorDeChat("VerdeClaro", Utilidades.Color("&aVerde Claro"), (List)null, Material.STAINED_GLASS, 5, ChatColor.GREEN, Rangos.Dueño, false, "ColorChatVerdeClaro");
      Rosado = new ColorDeChat("RojoClaro", Utilidades.Color("&cRojo Claro"), (List)null, Material.STAINED_GLASS, 6, ChatColor.RED, Rangos.Dueño, false, "ColorChatRojoClaro");
      GrisOscuro = new ColorDeChat("GrisOscuro", Utilidades.Color("&8Gris Oscuro"), (List)null, Material.STAINED_GLASS, 7, ChatColor.DARK_GRAY, Rangos.Dueño, false, "ColorChatGrisOscuro");
      GrisClaro = new ColorDeChat("GrisClaro", Utilidades.Color("&7Gris Claro"), (List)null, Material.STAINED_GLASS, 8, ChatColor.GRAY, Rangos.Dueño, false, "ColorChatGrisClaro");
      Cyan = new ColorDeChat("Cyan", Utilidades.Color("&bCyan"), (List)null, Material.STAINED_GLASS, 9, ChatColor.AQUA, Rangos.Dueño, false, "ColorChatCyan");
      Morado = new ColorDeChat("Morado", Utilidades.Color("&5Morado"), (List)null, Material.STAINED_GLASS, 10, ChatColor.DARK_PURPLE, Rangos.Dueño, false, "ColorChatMorado");
      Azul = new ColorDeChat("AzulOscuro", Utilidades.Color("&9Azul Oscuro"), (List)null, Material.STAINED_GLASS, 11, ChatColor.DARK_BLUE, Rangos.Dueño, false, "ColorChatAzulOscuro");
      VerdeOscuro = new ColorDeChat("VerdeOscuro", Utilidades.Color("&2Verde Oscuro"), (List)null, Material.STAINED_GLASS, 13, ChatColor.DARK_GREEN, Rangos.Dueño, false, "ColorChatVerdeOscuro");
      Rojo = new ColorDeChat("RojoOscuro", Utilidades.Color("&4Rojo Oscuro"), (List)null, Material.STAINED_GLASS, 14, ChatColor.DARK_RED, Rangos.Dueño, false, "ColorChatRojoOscuro");
   }

	private ColorDeChat(String name, String displayName, List<String> lore, Material test, int durability,
			ChatColor color, Rangos rango, boolean cofre, String permiso) {
		this.name = name;
		this.displayName = displayName;
		this.lore = lore;
		this.getMaterial = test;
		this.rango = rango;
		this.test = durability;
		this.color = color;
		this.cofre = cofre;
		this.permiso = permiso;
		if (!VALUES.contains(this)) {
			VALUES.add(this);
		}

	}

	public String getName() {
		return this.name;
	}

	public String ObtenerPermiso() {
		return this.permiso;
	}

	public int getDurability() {
		return this.test;
	}

	public ChatColor getColor() {
		return this.color;
	}

	public boolean SePuedeObtener() {
		return this.cofre;
	}

	public String ObtenerCofreDelTesoro() {
		return this.cofre ? "Si" : "No";
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public List<String> getLore() {
		return this.lore;
	}

	public Material getMaterial() {
		return this.getMaterial;
	}

	public Rangos getRango() {
		return this.rango;
	}

	public static List<ColorDeChat> values() {
		return VALUES;
	}

	public static ColorDeChat valueOf(String name) throws NullPointerException {
		Iterator arg1 = values().iterator();

		while (arg1.hasNext()) {
			ColorDeChat type = (ColorDeChat) arg1.next();
			if (type.getName().equalsIgnoreCase(name)) {
				return type;
			}
		}

		return null;
	}
}