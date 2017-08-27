/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.cofredeltesoro;

import java.util.Iterator;
import java.util.LinkedHashSet;
import net.quarkcraft.hub.cofredeltesoro.CofreDelTesoro;
import org.bukkit.plugin.Plugin;

public class CofreDelTesoroHandler {
	private LinkedHashSet<CofreDelTesoro> cofres = new LinkedHashSet();
	private static CofreDelTesoroHandler instance;
	private Plugin plugin;

	public CofreDelTesoroHandler(Plugin plugin) {
		instance = this;
		this.plugin = plugin;
	}

	public void AddCofre(CofreDelTesoro cofre) {
		this.cofres.add(cofre);
	}

	public CofreDelTesoro getCofre(int id) {
		Iterator cofres = this.cofres.iterator();

		while (cofres.hasNext()) {
			CofreDelTesoro match = (CofreDelTesoro) cofres.next();
			if (match.getId() == id) {
				return match;
			}
		}

		return null;
	}

	public static CofreDelTesoroHandler getInstance() {
		return instance;
	}
}