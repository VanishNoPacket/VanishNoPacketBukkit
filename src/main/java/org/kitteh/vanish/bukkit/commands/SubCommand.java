package org.kitteh.vanish.bukkit.commands;

public @interface SubCommand {
    
    String commandName();
    String[] aliases();

}
