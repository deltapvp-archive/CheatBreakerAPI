package com.cheatbreaker.impl;

import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class CheckCheatBreakerBanned implements CommandExecutor {
    @SneakyThrows
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Usage: /ischeatbreakerbanned <target>");
            return true;
        }

            sender.sendMessage(ChatColor.YELLOW + "Reading banlist, this may take a while.");
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {

                OfflinePlayer offlinetarget = Bukkit.getServer().getOfflinePlayer(args[0]);

                URL link = new URL("https://raw.githubusercontent.com/CheatBreaker2017/Website/master/cheating_bans_temp.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(link.openStream()));

                String line;
                while ((line = reader.lines().collect(Collectors.joining())) != null)
                    if (!line.contains(offlinetarget.getUniqueId().toString().replace("-", ""))) {
                        sender.sendMessage(ChatColor.GREEN + args[0] + " is not currently CheatBreaker banned.");
                        return true;
                    } else {
                        sender.sendMessage(ChatColor.RED + args[0] + " is currently CheatBreaker banned.");
                        return true;
                    }
                reader.close();

            } else {

                URL link = new URL("https://raw.githubusercontent.com/CheatBreaker2017/Website/master/cheating_bans_temp.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(link.openStream()));

                String line;
                while ((line = reader.lines().collect(Collectors.joining())) != null)
                    if (!line.contains(target.getUniqueId().toString().replace("-", ""))) {
                        sender.sendMessage(ChatColor.GREEN + args[0] + " is not currently CheatBreaker banned.");
                        return true;
                    } else {
                        sender.sendMessage(ChatColor.RED + args[0] + " is currently CheatBreaker banned.");
                        return true;
                    }
                reader.close();

            }
        return false;

    }

}
