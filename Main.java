package de.cryt4x.clearchat.main;


import org.bukkit.plugin.java.JavaPlugin;

import de.cryt4x.clearchat.commands.ClearChat;
import de.cryt4x.clearchat.commands.ClearChatInfo;

public class Main extends JavaPlugin
{
	private static Main plugin;
	public void onEnable ()
	{
		plugin = this;
		
		//Server-Console Output
		System.out.println("[PresetPlugin] XXX Plugin of <Author> (<*Shortcut* ctplX>) loaded!");
		
		//Plugin-Info
		getCommand("ccinfo").setExecutor(new ClearChatInfo());
		
		//Commands
		getCommand("cc").setExecutor(new ClearChat());
		
		//Listeners
		//PluginManager pluginManager = Bukkit.getPluginManager();
		//pluginManager.registerEvents(new <AListenerClass()>, this);
		//pluginManager.registerEvents(new BlockPlaced(), this);
	}
	public static Main getPlugin() {
		return plugin;
	}
}
