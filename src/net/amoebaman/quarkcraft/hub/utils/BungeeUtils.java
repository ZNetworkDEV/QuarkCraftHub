/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package net.quarkcraft.hub.utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class BungeeUtils
{
  public static HashMap<String, Integer> playerCounts = new HashMap();
  private static Plugin test;
  
  public static void setup(Plugin plugin)
  {
	  test = plugin;
	
    Bukkit.getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");
    Bukkit.getMessenger().registerIncomingPluginChannel(plugin, "BungeeCord", new IncommingListener());
    
    
    playerCounts.put("ArenaPvP", Integer.valueOf(0));
  }
  
  public static void sendToServer(Player player, String server)
  {
    send(toByte(
    
      new String[] {"Connect", server }), player);
  }
  
  public static byte[] toByte(String... string)
  {
    ByteArrayDataOutput out = ByteStreams.newDataOutput();
    String[] arrayOfString = string;int j = string.length;
    for (int i = 0; i < j; i++)
    {
      String str = arrayOfString[i];
      out.writeUTF(str);
    }
    return out.toByteArray();
  }
  
  public static void send(byte[] data, Player player)
  {
    player.sendPluginMessage(test, "BungeeCord", data);
  }
  
  public static void getPlayerCount(String Server)
  {
    try
    {
      ByteArrayOutputStream b = new ByteArrayOutputStream();
      DataOutputStream out = new DataOutputStream(b);
      out.writeUTF("PlayerCount");
      out.writeUTF(Server);
      Bukkit.getServer().sendPluginMessage(test, "BungeeCord", b.toByteArray());
    }
    catch (IOException e2)
    {
      e2.printStackTrace();
    }
  }
  
  static class IncommingListener
    implements PluginMessageListener
  {
    public void onPluginMessageReceived(String channel, Player player, byte[] message)
    {
      if (!channel.equals("BungeeCord")) {
        return;
      }
      try
      {
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
        String command = in.readUTF();
        if (command.equals("PlayerCount"))
        {
          String server = in.readUTF();
          int playerCount = in.readInt();
          BungeeUtils.playerCounts.put(server, Integer.valueOf(playerCount));
        }
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }
}
