/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.nms;

import java.lang.reflect.Field;
import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.PathfinderGoalFloat;
import net.minecraft.server.v1_8_R3.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_8_R3.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_8_R3.PathfinderGoalSelector;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_8_R3.util.UnsafeList;
import org.bukkit.entity.Entity;

public class Pathfinder {
	public static void removePathfinders(Entity entity) {
		net.minecraft.server.v1_8_R3.Entity PetEntity = ((CraftEntity) entity).getHandle();

		try {
			Field Ex = PathfinderGoalSelector.class.getDeclaredField("b");
			Ex.setAccessible(true);
			Field cField = PathfinderGoalSelector.class.getDeclaredField("c");
			cField.setAccessible(true);
			Ex.set(((EntityInsentient) PetEntity).goalSelector, new UnsafeList());
			Ex.set(((EntityInsentient) PetEntity).targetSelector, new UnsafeList());
			cField.set(((EntityInsentient) PetEntity).goalSelector, new UnsafeList());
			cField.set(((EntityInsentient) PetEntity).targetSelector, new UnsafeList());
			((EntityInsentient) PetEntity).goalSelector.a(0,
					new PathfinderGoalLookAtPlayer((EntityInsentient) PetEntity, EntityHuman.class, 6.0F));
			((EntityInsentient) PetEntity).goalSelector.a(1,
					new PathfinderGoalRandomLookaround((EntityInsentient) PetEntity));
			((EntityInsentient) PetEntity).goalSelector.a(2, new PathfinderGoalFloat((EntityInsentient) PetEntity));
		} catch (Exception arg3) {
			arg3.printStackTrace();
		}

	}
}