/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.cosmeticos;

import java.util.HashMap;
import java.util.UUID;
import net.quarkcraft.hub.enums.Mascotas;
import org.bukkit.entity.Entity;

public class MascotasAPI {
	private static HashMap<String, Entity> Pet = new HashMap();
	private static HashMap<String, Entity> Pet2 = new HashMap();
	private static HashMap<String, Mascotas> Mascotas = new HashMap();
	private static HashMap<UUID, String> Evolucion = new HashMap();
	public static Integer Task;
	private static HashMap<String, Integer> PetActivado = new HashMap();

	public static HashMap<String, Entity> ObtenerMascota() {
		return Pet;
	}

	public static HashMap<String, Mascotas> ObtenerMascotaPorTipo() {
		return Mascotas;
	}

	public static HashMap<String, Entity> ObtenerCompañero() {
      return Pet2;
   }

	public static HashMap<UUID, String> Evolucionado() {
		return Evolucion;
	}

	public static HashMap<String, Integer> ObtenerMascotaTasks() {
		return PetActivado;
	}

	public static Integer Tasks() {
		return Task;
	}
}