/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import net.quarkcraft.hub.AbstractPacket;
import org.bukkit.Location;
import org.bukkit.World;

public class WrapperPlayServerNamedSoundEffect extends AbstractPacket {
	public static final PacketType TYPE;

	static {
		TYPE = Server.NAMED_SOUND_EFFECT;
	}

	public WrapperPlayServerNamedSoundEffect() {
		super(new PacketContainer(TYPE), TYPE);
		this.handle.getModifier().writeDefaults();
	}

	public WrapperPlayServerNamedSoundEffect(PacketContainer packet) {
		super(packet, TYPE);
	}

	public String getSoundName() {
		return (String) this.handle.getStrings().read(0);
	}

	public void setSoundName(String value) {
		this.handle.getStrings().write(0, value);
	}

	public Location getEffectPosition(PacketEvent event) {
		return this.getEffectPosition(event.getPlayer().getWorld());
	}

	public Location getEffectPosition(World world) {
		return new Location(world, this.getEffectPositionX(), this.getEffectPositionY(), this.getEffectPositionZ());
	}

	public double getEffectPositionX() {
		return (double) ((Integer) this.handle.getIntegers().read(0)).intValue() / 8.0D;
	}

	public void setEffectPositionX(double value) {
		this.handle.getIntegers().write(0, Integer.valueOf((int) (value * 8.0D)));
	}

	public double getEffectPositionY() {
		return (double) ((Integer) this.handle.getIntegers().read(1)).intValue() / 8.0D;
	}

	public void setEffectPositionY(double value) {
		this.handle.getIntegers().write(1, Integer.valueOf((int) (value * 8.0D)));
	}

	public double getEffectPositionZ() {
		return (double) ((Integer) this.handle.getIntegers().read(2)).intValue() / 8.0D;
	}

	public void setEffectPositionZ(double value) {
		this.handle.getIntegers().write(2, Integer.valueOf((int) (value * 8.0D)));
	}

	public float getVolume() {
		return ((Float) this.handle.getFloat().read(0)).floatValue();
	}

	public void setVolume(float value) {
		this.handle.getFloat().write(0, Float.valueOf(value));
	}

	public float getPitch() {
		return (float) ((Integer) this.handle.getIntegers().read(3)).intValue() / 63.0F;
	}

	public void setPitch(float value) {
		this.handle.getIntegers().write(3, Integer.valueOf((int) (value * 63.0F)));
	}
}