package fr.discowzombie.xpmanager;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import fr.discowzombie.xpmanager.events.XPGetter;

public class XPManager extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		Bukkit.getServer().getPluginManager().registerEvents(new XPGetter(), this);
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}

}
