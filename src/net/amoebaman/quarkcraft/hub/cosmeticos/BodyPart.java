/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.cosmeticos;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

public enum BodyPart {
	HEAD, BODY, LEFT_ARM, RIGHT_ARM, LEFT_LEG, RIGHT_LEG;

	public void setPose(ArmorStand stand, Location target) {
		EulerAngle ea;
		Location origin;
		double initYaw;
		double yaw;
		double pitch;
		Vector tgt;
		if (this == HEAD) {
			origin = stand.getEyeLocation();
			initYaw = (double) origin.getYaw();
			tgt = target.toVector();
			origin.setDirection(tgt.subtract(origin.toVector()));
			yaw = (double) origin.getYaw() - initYaw;
			pitch = (double) origin.getPitch();
			if (yaw < -180.0D) {
				yaw += 360.0D;
			} else if (yaw >= 180.0D) {
				yaw -= 360.0D;
			}

			ea = new EulerAngle(Math.toRadians(pitch), Math.toRadians(yaw), 0.0D);
			this.setPose(stand, ea);
		} else {
			origin = stand.getLocation();
			if (this != LEFT_ARM && this != RIGHT_ARM) {
				if (this == LEFT_LEG || this == RIGHT_LEG) {
					origin = origin.add(0.0D, 0.8D, 0.0D);
				}
			} else {
				origin = origin.add(0.0D, 1.4D, 0.0D);
			}

			initYaw = (double) origin.getYaw();
			tgt = target.toVector();
			origin.setDirection(tgt.subtract(origin.toVector()));
			yaw = (double) origin.getYaw() - initYaw;
			pitch = (double) origin.getPitch();
			pitch -= 90.0D;
			ea = new EulerAngle(Math.toRadians(pitch), Math.toRadians(yaw), 0.0D);
			this.setPose(stand, ea);
		}

	}

	public void setPose(ArmorStand stand, EulerAngle angle)
	  {
	    switch (this)
	    {
	    case BODY: 
	      stand.setHeadPose(angle);
	      break;
	    case HEAD: 
	      stand.setBodyPose(angle);
	      break;
	    case LEFT_ARM: 
	      stand.setLeftArmPose(angle);
	      break;
	    case RIGHT_ARM: 
	      stand.setLeftLegPose(angle);
	      break;
	    case LEFT_LEG: 
	      stand.setRightArmPose(angle);
	      break;
	    case RIGHT_LEG: 
	      stand.setRightLegPose(angle);
	    }
	  }
}