package me.solarcosmic.crucial;

import me.solarcosmic.crucial.commands.CmdSpeed;
import org.bukkit.plugin.java.JavaPlugin;

public final class Crucial extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("speed").setExecutor(new CmdSpeed());
        getCommand("speed").setTabCompleter(new CmdSpeed());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
