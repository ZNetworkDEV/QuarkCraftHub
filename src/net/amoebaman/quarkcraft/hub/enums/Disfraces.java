/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.enums;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.quarkcraft.api.enums.Rangos;
import net.quarkcraft.hub.utils.Utilidades;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Disfraces {
	private String name;
	private String displayName;
	private List<String> lore;
	private String headTexture;
	private Rangos rango;
	private String permiso;
	private boolean cofre;
	private ItemStack helmet;
	private ItemStack chestplate;
	private ItemStack leggings;
	private ItemStack boots;
	private static final List<Disfraces> VALUES = new ArrayList();
	public static final Disfraces Hamburgesa;

	static {
      Hamburgesa = new Disfraces("Mario", Utilidades.Color("&bDisfras Mario"), (List)null, "6f7eb75e5542cc4937aaad5bb8657393eaf0265006eac1dc96691f32e16437", Rangos.Dueño, true, "DisfrasMario", Utilidades.disfraces(Material.LEATHER_HELMET, "", 255, 255, 255), Utilidades.disfraces(Material.LEATHER_CHESTPLATE, "", 255, 255, 255), Utilidades.disfraces(Material.LEATHER_LEGGINGS, "", 255, 255, 255), Utilidades.disfraces(Material.LEATHER_BOOTS, "", 255, 255, 255));
   }

	private Disfraces(String name, String displayName, List<String> lore, String headTexture, Rangos rango,
			boolean cofre, String permiso, ItemStack helmet, ItemStack chestplate, ItemStack leggings,
			ItemStack boots) {
		this.name = name;
		this.displayName = displayName;
		this.lore = lore;
		this.headTexture = headTexture;
		this.rango = rango;
		this.permiso = permiso;
		this.helmet = helmet;
		this.chestplate = chestplate;
		this.leggings = leggings;
		this.boots = boots;
		if (!VALUES.contains(this)) {
			VALUES.add(this);
		}

	}

	public String ObtenerPermiso() {
		return this.permiso;
	}

	public String getName() {
		return this.name;
	}

	public ItemStack getHelmet() {
		return this.helmet;
	}

	public ItemStack getChestplate() {
		return this.chestplate;
	}

	public ItemStack getLeggings() {
		return this.leggings;
	}

	public ItemStack getBoots() {
		return this.boots;
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

	public String getHeadTexture() {
		return this.headTexture;
	}

	public Rangos getRango() {
		return this.rango;
	}

	public static List<Disfraces> values() {
		return VALUES;
	}

	public static Disfraces valueOf(String name) throws NullPointerException {
		Iterator arg1 = values().iterator();

		while (arg1.hasNext()) {
			Disfraces type = (Disfraces) arg1.next();
			if (type.getName().equalsIgnoreCase(name)) {
				return type;
			}
		}

		return null;
	}
}