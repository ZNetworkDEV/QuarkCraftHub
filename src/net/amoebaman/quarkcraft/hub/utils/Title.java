/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.utils;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import net.quarkcraft.hub.utils.ServerPackage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.json.simple.JSONObject;

public class Title {
	private JSONObject title;
	private JSONObject subtitle;
	private int fadeIn;
	private int fadeOut;
	private int stay;

	@Deprecated
	public static boolean DEBUG;

	public Title(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
		this.title = convert(title);
		this.subtitle = convert(subtitle);
		this.fadeIn = fadeIn;
		this.fadeOut = fadeOut;
		this.stay = stay;
	}

	public Title(JSONObject title, JSONObject subtitle, int fadeIn, int fadeOut, int stay) {
		this.title = title;
		this.subtitle = subtitle;
		this.fadeIn = fadeIn;
		this.fadeOut = fadeOut;
		this.stay = stay;
	}

	public void send(Player player) {
		Preconditions.checkNotNull(player);

		try {
			Object e = player.getClass().getMethod("getHandle", new Class[0]).invoke(player, new Object[0]);
			Object connection = e.getClass().getField("playerConnection").get(e);
			Class playPacket = ServerPackage.MINECRAFT.getClass("PacketPlayOutTitle");
			Class genericPacket = ServerPackage.MINECRAFT.getClass("Packet");
			Class chatComponent = ServerPackage.MINECRAFT.getClass("IChatBaseComponent");
			Class serializer = ServerPackage.MINECRAFT.getClass("IChatBaseComponent$ChatSerializer");
			Class action = ServerPackage.MINECRAFT.getClass("PacketPlayOutTitle$EnumTitleAction");
			Object timesPacket = playPacket.getConstructor(new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE})
					.newInstance(new Object[]{Integer.valueOf(this.fadeIn), Integer.valueOf(this.stay),
							Integer.valueOf(this.fadeOut)});
			connection.getClass().getMethod("sendPacket", new Class[]{genericPacket}).invoke(connection,
					new Object[]{timesPacket});
			Object subtitleComponent;
			Object subtitlePacket;
			if (this.title != null && !this.title.isEmpty()) {
				subtitleComponent = serializer.getMethod("a", new Class[]{String.class}).invoke((Object) null,
						new Object[]{this.title.toString()});
				subtitlePacket = playPacket.getConstructor(new Class[]{action, chatComponent})
						.newInstance(new Object[]{action.getField("TITLE").get((Object) null), subtitleComponent});
				connection.getClass().getMethod("sendPacket", new Class[]{genericPacket}).invoke(connection,
						new Object[]{subtitlePacket});
			}

			if (this.subtitle != null && !this.subtitle.isEmpty()) {
				subtitleComponent = serializer.getMethod("a", new Class[]{String.class}).invoke((Object) null,
						new Object[]{this.subtitle.toString()});
				subtitlePacket = playPacket.getConstructor(new Class[]{action, chatComponent})
						.newInstance(new Object[]{action.getField("SUBTITLE").get((Object) null), subtitleComponent});
				connection.getClass().getMethod("sendPacket", new Class[]{genericPacket}).invoke(connection,
						new Object[]{subtitlePacket});
			}

		} catch (Throwable arg11) {
			throw new RuntimeException(arg11);
		}
	}

	public void sendToAll() {
		Iterator arg1 = Bukkit.getOnlinePlayers().iterator();

		while (arg1.hasNext()) {
			Player player = (Player) arg1.next();
			this.send(player);
		}

	}

	public JSONObject getTitle() {
		return this.title;
	}

	public JSONObject getSubtitle() {
		return this.subtitle;
	}

	public int getFadeIn() {
		return this.fadeIn;
	}

	public int getFadeOut() {
		return this.fadeOut;
	}

	public int getStay() {
		return this.stay;
	}

	public void setTitle(String title) {
		this.title = convert(title);
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = convert(subtitle);
	}

	public void setTitle(JSONObject title) {
		this.title = title;
	}

	public void setSubtitle(JSONObject subtitle) {
		this.subtitle = subtitle;
	}

	public void setFadeIn(int fadeIn) {
		this.fadeIn = fadeIn;
	}

	public void setFadeOut(int fadeOut) {
		this.fadeOut = fadeOut;
	}

	public void setStay(int stay) {
		this.stay = stay;
	}

	static JSONObject convert(String text) {
		JSONObject json = new JSONObject();
		json.put("text", text);
		return json;
	}
}