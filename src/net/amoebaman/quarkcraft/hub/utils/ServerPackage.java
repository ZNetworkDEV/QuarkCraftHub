/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.utils;

import org.bukkit.Bukkit;

enum ServerPackage {
	MINECRAFT("net.minecraft.server." + getServerVersion()), CRAFTBUKKIT(
			"org.bukkit.craftbukkit." + getServerVersion());

	private final String path;

	private ServerPackage(String path) {
		this.path = path;
	}

	public String toString() {
		return this.path;
	}

	public Class<?> getClass(String className) throws ClassNotFoundException {
		return Class.forName(this.toString() + "." + className);
	}

	public static String getServerVersion() {
		return Bukkit.getServer().getClass().getPackage().getName().substring(23);
	}
}