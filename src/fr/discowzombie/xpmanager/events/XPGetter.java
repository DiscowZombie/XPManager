package fr.discowzombie.xpmanager.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.discowzombie.xpmanager.manager.LevelAbstract;
import fr.discowzombie.xpmanager.manager.PlayerManager;

public class XPGetter implements Listener {
	
	@EventHandler
	public void updateXpBar(PlayerJoinEvent e){
		Player p = e.getPlayer();
		LevelAbstract.updateBar(p);
	}
	
	@EventHandler (priority = EventPriority.MONITOR)
	public void onXPGain(PlayerExpChangeEvent e){
		Player p = e.getPlayer();
		int amount = e.getAmount();
		
		new PlayerManager(p).addXp(amount);
		LevelAbstract.updateBar(p);
	}
	
}
