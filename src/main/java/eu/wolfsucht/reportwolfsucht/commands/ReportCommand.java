package eu.wolfsucht.reportwolfsucht.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ReportCommand extends Command {

    String prefix = ChatColor.RED + "Report " + ChatColor.GRAY + "| " + ChatColor.RESET;

    public ReportCommand(String name){
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer) sender;
        if (args.length == 0) {
            p.sendMessage(new TextComponent(prefix + ChatColor.RED + "Bitte nutze /report <Spieler> <Grund>."));
        }else if (args.length == 1){
            p.sendMessage(new TextComponent(prefix + ChatColor.RED + "Bitte wähle aus einem der folgenden Gründen:"));
            p.sendMessage(new TextComponent(ChatColor.RED + "- HACKING"));
            p.sendMessage(new TextComponent(ChatColor.RED + "- BUGUSING"));
            p.sendMessage(new TextComponent(ChatColor.RED + "- TROLLING"));
            p.sendMessage(new TextComponent(ChatColor.RED + "- SPAWNTRAPPING"));
            p.sendMessage(new TextComponent(ChatColor.RED + "- VERHALTEN"));
        }else if (args.length > 1){
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
            if(target == null){
                p.sendMessage(new TextComponent(prefix + ChatColor.RED + "Dieser Spieler ist offline."));
            }else  if (target.getName() == p.getName()){
                p.sendMessage(new TextComponent(prefix + ChatColor.RED + "Du kannst dich nicht selber reporten."));
            }else if (args[1].equalsIgnoreCase("HACKING") && args[1].equalsIgnoreCase("BUGUSING") && args[1].equalsIgnoreCase("TROLLING") && args[1].equalsIgnoreCase("SPAWNTRAPPING") && args[1].equalsIgnoreCase("VERHALTEN")){
                p.sendMessage(new TextComponent(prefix + ChatColor.RED + "Bitte wähle aus einem der folgenden Gründen:"));
                p.sendMessage(new TextComponent(ChatColor.RED + "- HACKING"));
                p.sendMessage(new TextComponent(ChatColor.RED + "- BUGUSING"));
                p.sendMessage(new TextComponent(ChatColor.RED + "- TROLLING"));
                p.sendMessage(new TextComponent(ChatColor.RED + "- SPAWNTRAPPING"));
                p.sendMessage(new TextComponent(ChatColor.RED + "- VERHALTEN"));
            }else {
                for (ProxiedPlayer all : ProxyServer.getInstance().getPlayers()){
                    if(all.hasPermission("Report.see")){
                        p.sendMessage(new TextComponent(prefix + "Der Spieler " + ChatColor.YELLOW + target.getName() + ChatColor.RESET + " wurde von " + ChatColor.YELLOW + p.getName() + ChatColor.RESET + " für " + ChatColor.YELLOW + args[1] + ChatColor.RESET + " reportet."));
                        TextComponent c = new TextComponent(ChatColor.GREEN + "[ANNEHMEN]");
                        c.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tp " + target);
                    }
                }

                p.sendMessage(new TextComponent(prefix + ChatColor.GREEN + "Vielen Dank für dein Report! Bitte habe ein wenig gedult ein Teammitglied wird sich sofort um diesen kümmern."));
                p.sendMessage(new TextComponent(prefix + ChatColor.DARK_RED + "Der Missbrauch und das Spammen des Report Befehls sind strafbar."));
            }
        }
    }


}
