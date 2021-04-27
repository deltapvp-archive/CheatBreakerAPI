package com.cheatbreaker.impl;

import com.cheatbreaker.api.CheatBreakerAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CheckRunningCheatBreaker implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (args.length == 0) {
            if (!CheatBreakerAPI.getInstance().isRunningCheatBreaker((Player) sender)) {
                sender.sendMessage(ChatColor.RED + sender.getName() + " is not running CheatBreaker 2017.");
            } else {
                sender.sendMessage(ChatColor.GREEN + sender.getName() + " is running CheatBreaker 2017.");
            }
        } else {
            Player target = Bukkit.getServer().getPlayer(args[0]);

            if (target == null) {
                sender.sendMessage(ChatColor.RED + "That player is not online.");
                return true;
            }

            if (!CheatBreakerAPI.getInstance().isRunningCheatBreaker(target)) {
                sender.sendMessage(ChatColor.RED + args[0] + " is not running CheatBreaker 2017.");
            } else {
                sender.sendMessage(ChatColor.GREEN + args[0] + " is running CheatBreaker 2017.");
            }

        }

        return false;
    }
}
