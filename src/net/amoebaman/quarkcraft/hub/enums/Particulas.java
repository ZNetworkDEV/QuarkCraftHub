/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.enums;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.quarkcraft.api.enums.Rangos;
import net.quarkcraft.hub.utils.ParticleEffect;
import net.quarkcraft.hub.utils.Utilidades;
import org.bukkit.Material;

public class Particulas {
	private String name;
	private String displayName;
	private List<String> lore;
	private Material getMaterial;
	private Rangos rango;
	private ParticleEffect effect;
	private boolean cofre;
	private static final List<Particulas> VALUES = new ArrayList();
	public static final Particulas Agua;
	public static final Particulas Lava;
	public static final Particulas Corazones;
	public static final Particulas Sspension;
	public static final Particulas Notas;
	private String permiso;

	static {
		Agua = new Particulas("Agua", Utilidades.Color("&bParticula de Agua"), (List) null, Material.WATER_BUCKET,
				ParticleEffect.DRIP_WATER, Rangos.USUARIO, true, "ParticulaAgua");
		Lava = new Particulas("Lava", Utilidades.Color("&bParticula de Lava"), (List) null, Material.LAVA_BUCKET,
				ParticleEffect.DRIP_LAVA, Rangos.USUARIO, true, "ParticulaLava");
		Corazones = new Particulas("Corazones", Utilidades.Color("&bParticula de Corazones"), (List) null,
				Material.REDSTONE, ParticleEffect.HEART, Rangos.USUARIO, true, "ParticulaCorazones");
		Sspension = new Particulas("Suspension", Utilidades.Color("&bParticula de Suspension"), (List) null,
				Material.ENDER_PEARL, ParticleEffect.SUSPENDED_DEPTH, Rangos.USUARIO, false, "ParticulaSuspension");
		Notas = new Particulas("Notas", Utilidades.Color("&bParticula de Notas"), (List) null, Material.NOTE_BLOCK,
				ParticleEffect.NOTE, Rangos.USUARIO, false, "ParticulaNotas");
	}

	private Particulas(String name, String displayName, List<String> lore, Material headTexture, ParticleEffect efecto,
			Rangos rango, boolean cofre, String permiso) {
		this.name = name;
		this.displayName = displayName;
		this.lore = lore;
		this.getMaterial = headTexture;
		this.rango = rango;
		this.effect = efecto;
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

	public String getDisplayName() {
		return this.displayName;
	}

	public List<String> getLore() {
		return this.lore;
	}

	public ParticleEffect getEfecto() {
		return this.effect;
	}

	public Material getMaterial() {
		return this.getMaterial;
	}

	public Rangos getRango() {
		return this.rango;
	}

	public static List<Particulas> values() {
		return VALUES;
	}

	public boolean SePuedeObtener() {
		return this.cofre;
	}

	public static Particulas valueOf(String name) throws NullPointerException {
		Iterator arg1 = values().iterator();

		while (arg1.hasNext()) {
			Particulas type = (Particulas) arg1.next();
			if (type.getName().equalsIgnoreCase(name)) {
				return type;
			}
		}

		return null;
	}
}