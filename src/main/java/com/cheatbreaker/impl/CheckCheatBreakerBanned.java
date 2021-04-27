package com.cheatbreaker.impl;

import com.cheatbreaker.api.CheatBreakerAPI;
import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
        }

        sender.sendMessage(ChatColor.YELLOW + "Reading banlist, this may take a while.");

        URL link = new URL("https://raw.githubusercontent.com/CheatBreaker2017/Website/master/cheating_bans_temp.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(link.openStream()));

        String listLine;
        Player target = Bukkit.getServer().getPlayer(args[0]);

        while ((listLine = reader.lines().collect(Collectors.joining())) != null)
            if (!listLine.contains(target.getName())){
                sender.sendMessage(ChatColor.GREEN + target.getName() + " is not currently CheatBreaker banned.");
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + target.getName() + " is currently CheatBreaker banned.");
                return true;
            }
        reader.close();

        return false;
    }
}
