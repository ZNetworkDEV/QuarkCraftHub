/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.nms;

import net.minecraft.server.v1_8_R3.AttributeInstance;
import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.GenericAttributes;
import net.minecraft.server.v1_8_R3.PathEntity;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class PlayerFollower {
	public static void followPlayer(Player player, Entity entity, double speed) {
		net.minecraft.server.v1_8_R3.Entity petEntity = ((CraftEntity) entity).getHandle();
		((EntityInsentient) petEntity).getNavigation().a(2.0F);
		net.minecraft.server.v1_8_R3.Entity petf = ((CraftEntity) entity).getHandle();
		Location targetLocation = player.getLocation();
		PathEntity path = ((EntityInsentient) petf).getNavigation().a(targetLocation.getX() + 1.0D,
				targetLocation.getY(), targetLocation.getZ() + 1.0D);

		try {
			int exception = (int) Bukkit.getPlayer(player.getName()).getLocation().distance(entity.getLocation());
			if (exception > 15 && entity.isValid() && player.isOnGround()) {
				entity.teleport(player.getLocation());
			}

			if (path != null) {
				AttributeInstance attributes;
				if (exception > 2) {
					if (!player.isFlying()) {
						((EntityInsentient) petf).getNavigation().a(path, speed);
						((EntityInsentient) petf).getNavigation().a(speed);
						attributes = ((EntityInsentient) ((CraftEntity) entity).getHandle())
								.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED);
						attributes.setValue(speed);
					} else {
						attributes = ((EntityInsentient) ((CraftEntity) entity).getHandle())
								.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED);
						attributes.setValue(0.0D);
					}
				} else {
					attributes = ((EntityInsentient) ((CraftEntity) entity).getHandle())
							.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED);
					attributes.setValue(0.0D);
				}
			}
		} catch (IllegalArgumentException arg9) {
			entity.teleport(player.getLocation());
		}

	}
}