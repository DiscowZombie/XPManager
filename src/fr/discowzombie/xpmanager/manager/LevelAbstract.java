package fr.discowzombie.xpmanager.manager;

import java.util.HashMap;

import org.bukkit.entity.Player;

import fr.discowzombie.xpmanager.XPManager;

public abstract class LevelAbstract {
	
	public static HashMap<Integer, Integer> levels = new HashMap<>();
	
	public static void updateBar(Player player){
		PlayerManager pm = new PlayerManager(player);
		
		player.setLevel(0);
		player.setTotalExperience(0);
		player.setExp(0);
		
		player.setLevel(pm.getPlayerLvl());
		player.setExp((float)(pm.getPlayerXp() / (pm.getXpNeedToReach(pm.getPlayerLvl()+1))));
	}
	
	public static void callLvLUp(Player player, int level){
		player.sendMessage(XPManager.get().getConfig().getString("messages.lvlup").replace('&', '§').replace("%player%", player.getName()).replace("%level%", level+""));
	}

}
