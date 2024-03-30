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
package me.solarcosmic.crucial;

import me.solarcosmic.crucial.commands.CmdSpeed;
import me.solarcosmic.crucial.util.SmartLog;
import org.bukkit.plugin.java.JavaPlugin;

public final class Crucial extends JavaPlugin {
    SmartLog logger = new SmartLog();

    @Override
    public void onEnable() {
        // Plugin startup logic
        logger.log("Licensed under the Apache License, Version 2.0 (the \"License\")");
        getCommand("speed").setExecutor(new CmdSpeed());
        getCommand("speed").setTabCompleter(new CmdSpeed());
        logger.log("Registered 1 command(s)");
        logger.log("Crucial loaded. Thank you for using this plugin.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
