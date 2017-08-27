/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.nms;

import net.quarkcraft.hub.nms.PetsNms;
import net.quarkcraft.hub.nms.PlayerFollower;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class PetsManager implements PetsNms {
	public void followPlayer(Player player, Entity entity, double speed) {
		PlayerFollower.followPlayer(player, entity, speed);
	}
}