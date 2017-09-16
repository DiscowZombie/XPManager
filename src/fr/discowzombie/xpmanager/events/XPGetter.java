package fr.discowzombie.xpmanager.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

import fr.discowzombie.xpmanager.manager.PlayerManager;

public class XPGetter implements Listener {
	
	@EventHandler (priority = EventPriority.LOWEST)
	public void onXPGain(PlayerExpChangeEvent e){
		Player p = e.getPlayer();
		int amount = e.getAmount();
		
		int lvl = new PlayerManager(p).getPlayerLvl();
		int xp = new PlayerManager(p).getPlayerXp();
	}

}
