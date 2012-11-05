package org.kitteh.vanish.bukkit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.kitteh.vanish.bukkit.VanishPlugin;

public class ToggleCommand extends SubCommandHandler {
    
    public ToggleCommand(VanishPlugin vPlugin) {
        super(vPlugin);
    }

    @SubCommand(commandName = "toggle", aliases = { "t", "tog" })
    public void toggleCommand(CommandSender sender, Command command, String label, String[] args) {
        
    }

}
