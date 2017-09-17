package fr.discowzombie.xpmanager;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import fr.discowzombie.xpmanager.events.XPGetter;
import fr.discowzombie.xpmanager.manager.LevelAbstract;

public class XPManager extends JavaPlugin {
	
	private static XPManager instance;
	
	@Override
	public void onEnable() {
		instance = this;
				
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		LevelAbstract.levels.clear();
		for(String st : getConfig().getConfigurationSection("lvls").getValues(false).keySet()){
			Integer lvl = Integer.parseInt(st);
			Integer xp = getConfig().getInt("lvls."+lvl);
			LevelAbstract.levels.put(lvl, xp);
		}
		
		System.out.println("Levels :");
		System.out.println(LevelAbstract.levels);
		
		Bukkit.getServer().getPluginManager().registerEvents(new XPGetter(), this);
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	
	public static XPManager get(){
		return instance;
	}

}
