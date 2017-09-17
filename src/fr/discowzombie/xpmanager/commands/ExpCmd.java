package fr.discowzombie.xpmanager.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.discowzombie.xpmanager.manager.LevelAbstract;
import fr.discowzombie.xpmanager.manager.PlayerManager;

public class ExpCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			PlayerManager pm = new PlayerManager(p);
			p.sendMessage("§7Niveau: §f"+pm.getPlayerLvl()+"§7.");
			p.sendMessage("§7Exp: §f"+pm.getPlayerXp()+"§7/§f"+pm.getXpNeedToReach(pm.getPlayerLvl()+1)+"§7.");
			LevelAbstract.updateBar(p);
		}
		return true;
	}

}
