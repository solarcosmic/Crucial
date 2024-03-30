/*
* Copyright (C) 2024 solarcosmic.

* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package me.solarcosmic.crucial.commands;

import me.solarcosmic.crucial.util.CoreCommons;
import me.solarcosmic.crucial.util.SmartLog;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class CmdSpeed implements CommandExecutor, TabCompleter {
    SmartLog logger = new SmartLog();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length > 0) {
            Player player = null;
            if (args.length >= 2) {
                player = Bukkit.getPlayer(args[1]);
            }
            try {
                float parsedSpeed = parseSpeed(sender, args[0]);
                if (player != null) {
                    player.setWalkSpeed(parsedSpeed);
                    logger.log(sender, "Speed has been successfully set to " + parsedSpeed + " for " + player.getName() + ".");
                } else {
                    setDefaultWalkSpeed(sender, parsedSpeed);
                }
            } catch (IllegalArgumentException e) {
                logger.log(sender,"You must specify a valid number from 1 - 9.");
            }
        } else {
            setDefaultWalkSpeed(sender, 0.2f); // Default walking speed.
        }
        return true;
    }

    public float parseSpeed(CommandSender sender, String input){
        int speedValue = Integer.parseInt(input);
        if (speedValue < 0 || speedValue > 9) {
            logger.log(sender, "Value has to be between 0 - 9.");
        }
        return (float) speedValue / 10;
    }

    private void setDefaultWalkSpeed(CommandSender sender, float speed) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.setWalkSpeed(speed);
            logger.log(sender, "Speed has been successfully set to " + speed + ".");
        } else {
            logger.log(sender, "A player is required! Please specify a player.");
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String s, String[] args) {
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        if (args.length == 1) {
            return Arrays.asList(numbers); // Use Java 8 method
        } else if (args.length == 2) {
            return CoreCommons.getPlayerList();
        }

        return null;
    }
}
