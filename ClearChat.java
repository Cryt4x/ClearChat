package de.cryt4x.clearchat.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChat implements CommandExecutor 
{
	private Player p;
	private int j;
	private void playerFailMessage ()
	{
		p.sendMessage("§cPls use §6/cc\n§cor       §6/cc [Number of Lines]\n§cor       §6/cc [Number of Lines] [Player]");
	}
	
	@Override
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args)
	{
		if (sender instanceof Player)
		{
			p = (Player) sender;
			
			
			if (p.hasPermission("cc.spam"))
			{
				if (args.length == 2)
				{
					try {
						j = Integer.parseInt(args[0]);
					} catch (Exception e) {
						// TODO: handle exception
						playerFailMessage(); //message
						return false;
					}
					Player p2 = Bukkit.getPlayer(args[1]);
					j = Integer.parseInt(args[0]);
					for (int i=0;i<j;i++)
					{
						p2.sendMessage("\n");
					}
				}
				else if (args.length == 1)
				{
					try {
						j = Integer.parseInt(args[0]);
					} catch (Exception e) {
						// TODO: handle exception
						playerFailMessage(); //message
						return false;
					}
					j = Integer.parseInt(args[0]);
					for (int i=0;i<j;i++)
					{
						Bukkit.broadcastMessage("\n");
					}
				}
				else if (args.length == 0)
				{
					j = 100;
					for (int i=0;i<j;i++)
					{
						Bukkit.broadcastMessage("\n");
					}
				}
				else
				{
					p.sendMessage("§cPls use §6/cc [Number of Lines] §cor §6/cc§c!");
				}
			}
			else if (args.length == 1)
			{
				try {
					j = Integer.parseInt(args[0]);
				} catch (Exception e) {
					// TODO: handle exception
					playerFailMessage(); //message
					return false;
				}
				j = Integer.parseInt(args[0]);
				for (int i=0;i<j;i++)
				{
					p.sendMessage("\n");
				}
			}
			else if (args.length == 0)
			{
				j = 100;
				for (int i=0;i<j;i++)
				{
					p.sendMessage("\n");
				}
			}
			else
			{
				p.sendMessage("§cPls use §6/cc [Number of Lines] §cor §6/cc§c!");
			}
		}
		else
		{
			sender.sendMessage("This command can only be executed by a player!");
		}
		
		return false;
	}
	
}
