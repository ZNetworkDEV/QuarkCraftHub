package net.quarkcraft.hub.scoreboard;

import java.util.Collection;
import java.util.WeakHashMap;
import net.quarkcraft.api.CoreAPI;
import net.quarkcraft.api.enums.Rangos;
import net.quarkcraft.api.mysql.MySQL;
import net.quarkcraft.hub.Core1;
import net.quarkcraft.hub.utils.Utilidades;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class ScoreboardListener
  implements Listener
{
  private final WeakHashMap<Player, ScoreboardHelper> helper = new WeakHashMap();
  
  public ScoreboardHelper getScoreboardFor(Player player)
  {
    return (ScoreboardHelper)this.helper.get(player);
  }
  
  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent event)
  {
    Player player = event.getPlayer();
    this.helper.remove(player);
  }
  
  @EventHandler
  public void onPlayerKick(PlayerKickEvent event)
  {
    Player player = event.getPlayer();
    this.helper.remove(player);
  }
  
  public void unregister(Scoreboard board, String name)
  {
    Team team = board.getTeam(name);
    if (team != null) {
      team.unregister();
    }
  }
  
  public void registerScoreboards(Player player)
  {
    Scoreboard bukkitScoreBoard = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
    player.setScoreboard(bukkitScoreBoard);
    ScoreboardHelper scoreboardHelper = new ScoreboardHelper(bukkitScoreBoard, Utilidades.Color("&6NeroCraft"));
    
    this.helper.put(player, scoreboardHelper);
    
    resendTab(player);
    for (Player online : Bukkit.getOnlinePlayers()) {
      if ((online != player) && 
        (getScoreboardFor(online) != null)) {
        getScoreboardFor(online).getScoreBoard();
      }
    }
  }
  
  public void resendTab(Player player)
  {
    if (getScoreboardFor(player) == null) {
      return;
    }
    getScoreboardFor(player).getScoreBoard();
  }
  
  public void setupScoreboard()
  {
    new BukkitRunnable()
    {
      public void run()
      {
        for (Player player : Bukkit.getOnlinePlayers())
        {
          ScoreboardHelper scoreboardHelper = ScoreboardListener.this.getScoreboardFor(player);
          scoreboardHelper.clear();
          scoreboardHelper.add(Utilidades.Color(""));
          scoreboardHelper.add(Utilidades.Color("&eInformacion:"));
          scoreboardHelper.add(Utilidades.Color("&fRango:&a " + CoreAPI.getMySQL().obtenerRango(player).getColor() + CoreAPI.getMySQL().obtenerRango(player).getNombre()));
          scoreboardHelper.add(Utilidades.Color("&fPuntos:&a " + CoreAPI.getMySQL().getPuntos(player)));
          scoreboardHelper.add(Utilidades.Color("&fNeroCoins:&a " + CoreAPI.getMySQL().getQuarks(player)));
          scoreboardHelper.add(Utilidades.Color(""));
          scoreboardHelper.add(Utilidades.Color("&fLobby:&a #1"));
          scoreboardHelper.add(Utilidades.Color("&fJugadores:&a " + Bukkit.getServer().getOnlinePlayers().size()));
          scoreboardHelper.add(Utilidades.Color(""));
          scoreboardHelper.add(Utilidades.Color("&eplay.nerocraft.es"));
          
          Utilidades.UpdatearScoreBoard2(player);
          
          scoreboardHelper.update(player);
        }
      }
    }.runTaskTimer(Core1.getInstance(), 1L, 1L);
  }
}
