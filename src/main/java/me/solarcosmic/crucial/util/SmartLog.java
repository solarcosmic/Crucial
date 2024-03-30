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
package me.solarcosmic.crucial.util;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SmartLog {
    public String prefix = "#3d3d3d[#de7a00Crucial#3d3d3d]#7d7d7d";
    public void log(CommandSender sender, String str){
        sender.sendMessage(CoreCommons.translateHexColorCodes(prefix + " " + str));
    }

    public void log(Player sender, String str){
        sender.sendMessage(CoreCommons.translateHexColorCodes(prefix + " " + str));
    }

    public void log(String str){
        Bukkit.getConsoleSender().sendMessage(CoreCommons.translateHexColorCodes(prefix + " " + str));
    }
}
