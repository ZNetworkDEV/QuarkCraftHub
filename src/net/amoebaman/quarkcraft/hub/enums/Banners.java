/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.enums;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.quarkcraft.api.enums.Rangos;
import net.quarkcraft.hub.utils.BannersItems;
import net.quarkcraft.hub.utils.Utilidades;
import org.bukkit.inventory.ItemStack;

public class Banners {
	private String name;
	private String displayName;
	private List<String> lore;
	private ItemStack headTexture;
	private Rangos rango;
	private boolean cofre;
	private String permiso;
	private static final List<Banners> VALUES = new ArrayList();
	public static final Banners Pokemon;

	static {
      Pokemon = new Banners("Pokemon", Utilidades.Color("&bBanner de Pokemon"), (List)null, BannersItems.pokeballBanner(), Rangos.Dueño, true, "BannerPokemon");
   }

	private Banners(String name, String displayName, List<String> lore, ItemStack tet, Rangos rango, boolean cofre,
			String permiso) {
		this.name = name;
		this.displayName = displayName;
		this.lore = lore;
		this.headTexture = tet;
		this.rango = rango;
		this.cofre = cofre;
		this.permiso = permiso;
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

	public ItemStack getMaterial() {
		return this.headTexture;
	}

	public Rangos getRango() {
		return this.rango;
	}

	public static List<Banners> values() {
		return VALUES;
	}

	public static Banners valueOf(String name) throws NullPointerException {
		Iterator arg1 = values().iterator();

		while (arg1.hasNext()) {
			Banners type = (Banners) arg1.next();
			if (type.getName().equalsIgnoreCase(name)) {
				return type;
			}
		}

		return null;
	}
}