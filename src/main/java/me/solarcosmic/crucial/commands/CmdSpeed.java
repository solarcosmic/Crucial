package me.solarcosmic.crucial.commands;

import me.solarcosmic.crucial.util.CoreCommons;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class CmdSpeed implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {

        float parsed = 0.1f; //provide the default walking speed, either 1 or 2
        if (args.length > 0){
            Player player = null;
            if (args.length >= 2)
            {
                player = Bukkit.getPlayer(args[1]);
            }
            try {
                parsed = ((float) Integer.parseInt(args[0]))/10;
            } catch (IllegalArgumentException exception) {
                sender.sendMessage("You must specify a valid number from 1 - 9.");
            }
            if (player != null) // execute
            {
                player.setWalkSpeed(parsed);
                sender.sendMessage("Speed has been successfully set to " + parsed + ".");
            } else {
                setDefault(sender, parsed);
            }
        } else {
            setDefault(sender, parsed);
        }

        return true;
    }

    public void setDefault(CommandSender sender, float parsed)
    {
        if (sender instanceof Player){
            ((Player) sender).setWalkSpeed(parsed);
            sender.sendMessage("Speed has been successfully set to " + parsed + ".");
        } else {
            sender.sendMessage("A player is required! Please specify a player.");
        }
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        if (args.length == 1)
        {
            return Arrays.asList(numbers); // use java 8 method
        } else if (args.length == 2) {
            return CoreCommons.getPlayerList();
        }

        return null;
    }
}
