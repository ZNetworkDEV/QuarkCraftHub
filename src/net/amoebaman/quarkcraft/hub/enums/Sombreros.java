/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.enums;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.quarkcraft.api.enums.Rangos;
import net.quarkcraft.hub.utils.Utilidades;

public class Sombreros {
	private String name;
	private String displayName;
	private List<String> lore;
	private String headTexture;
	private Rangos rango;
	private String permiso;
	private boolean cofre;
	private static final List<Sombreros> VALUES = new ArrayList();
	public static final Sombreros Hamburgesa;
	public static final Sombreros Pan;

	static {
		Hamburgesa = new Sombreros("Hamburgesa", Utilidades.Color("&bSombrero de Hamburgesa"), (List) null,
				"a6ef1c25f516f2e7d6f7667420e33adcf3cdf938cb37f9a41a8b35869f569b", Rangos.USUARIO, true,
				"SombreroHamburgesa");
		Pan = new Sombreros("Pan", Utilidades.Color("&bSombrero de Pan"), (List) null,
				"f3487d457f9062d787a3e6ce1c4664bf7402ec67dd111256f19b38ce4f670", Rangos.USUARIO, true, "SombreroPan");
	}

	private Sombreros(String name, String displayName, List<String> lore, String headTexture, Rangos rango,
			boolean cofre, String permiso) {
		this.name = name;
		this.displayName = displayName;
		this.lore = lore;
		this.headTexture = headTexture;
		this.rango = rango;
		this.permiso = permiso;
		this.cofre = cofre;
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

	public static List<Sombreros> values() {
		return VALUES;
	}

	public static Sombreros valueOf(String name) throws NullPointerException {
		Iterator arg1 = values().iterator();

		while (arg1.hasNext()) {
			Sombreros type = (Sombreros) arg1.next();
			if (type.getName().equalsIgnoreCase(name)) {
				return type;
			}
		}

		return null;
	}
}