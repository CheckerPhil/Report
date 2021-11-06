package eu.wolfsucht.reportwolfsucht;

import eu.wolfsucht.reportwolfsucht.commands.ReportCommand;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public final class ReportWolfsucht extends Plugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("[REPORT] Plugin enabled!");

        ProxyServer.getInstance().getPluginManager().registerCommand(this, new ReportCommand("report"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[REPORT] Plugin disabled!");
    }
}
