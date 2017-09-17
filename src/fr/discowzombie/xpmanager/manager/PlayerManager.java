package fr.discowzombie.xpmanager.manager;

import org.bukkit.entity.Player;

import fr.discowzombie.xpmanager.XPManager;

public class PlayerManager {
	
	private Player player;
	
	public PlayerManager(Player player){
		this.player = player;
	}

	public int getPlayerLvl() {
		createDataIfHasnt();
		int lvl = XPManager.get().getConfig().getInt("lvl."+player.getUniqueId().toString());
		return lvl;
	}

	public int getPlayerXp() {
		createDataIfHasnt();
		int xp = XPManager.get().getConfig().getInt("xp."+player.getUniqueId().toString());
		return xp;
	}
	
	public boolean hasDataLvl(){
		if(XPManager.get().getConfig().getString("lvl."+player.getUniqueId().toString()) != null){
			return true;
		}
		return false;
	}
	
	public boolean hasDataXp(){
		if(XPManager.get().getConfig().getString("xp."+player.getUniqueId().toString()) != null){
			return true;
		}
		return false;
	}
	
	public void createDataIfHasnt(){
		if(!hasDataLvl()){
			XPManager.get().getConfig().set("lvl."+player.getUniqueId().toString(), 0);
			XPManager.get().saveConfig();
		}
		if(!hasDataXp()){
			XPManager.get().getConfig().set("xp."+player.getUniqueId().toString(), 0);
			XPManager.get().saveConfig();
		}
	}

	public int getXpNeedToReach(int level) {
		return LevelAbstract.levels.get(level);
	}
	
	public void addXp(int quantity){
		createDataIfHasnt();
		
		int actualLvl = getPlayerLvl();
		int actualXp = getPlayerXp();
		
		int lvlup = 0;

		//Tant que l'xp necessaire pour lvl up est <= xp gain
		while((getXpNeedToReach(actualLvl+1+lvlup)-actualXp) <= quantity){
			quantity -= (LevelAbstract.levels.get(actualLvl+1+lvlup)-actualXp);
			lvlup++;
			actualXp = 0;
			LevelAbstract.callLvLUp(player, actualLvl+lvlup);
		}
		//L'xp qu'il lui reste est strictement < l'xp need to lvl up
		int newlvl = actualLvl + lvlup;
		int newxp = actualXp + quantity;
		XPManager.get().getConfig().set("lvl."+player.getUniqueId().toString(), newlvl);
		XPManager.get().saveConfig();
		XPManager.get().getConfig().set("xp."+player.getUniqueId().toString(), newxp);
		XPManager.get().saveConfig();
		
		LevelAbstract.updateBar(player);
	}

}
