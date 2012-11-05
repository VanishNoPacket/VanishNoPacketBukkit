package org.kitteh.vanish.bukkit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.kitteh.vanish.bukkit.commands.SubCommand;
import org.kitteh.vanish.bukkit.commands.SubCommandHandler;
import org.kitteh.vanish.bukkit.commands.ToggleCommand;

public class BaseVanishCommand implements CommandExecutor {
    
    private VanishPlugin plugin;
    private Map<Collection<String>, Method> subCommandMap;
    private Map<Collection<String>, SubCommandHandler> commandInstanceMap;
    
    private Collection<SubCommandHandler> subCommands;
    
    public BaseVanishCommand (VanishPlugin vPlugin) {
        this.plugin = vPlugin;
        this.subCommandMap = new HashMap<Collection<String>, Method>();
        
        this.initializeCommands();
    }
    
    public void initializeCommands() {
        this.subCommands = new ArrayList<SubCommandHandler>();
        subCommands.add(new ToggleCommand(this.plugin));
        
        for (SubCommandHandler handler : subCommands) {
            
            Class<? extends SubCommandHandler> clazz = handler.getClass();
            
            for (Method method : clazz.getDeclaredMethods()) {
                
                if (method.isAnnotationPresent(SubCommand.class)) {
                    SubCommand annotation = method.getAnnotation(SubCommand.class);
                    
                    Set<String> names = new HashSet<String>();
                    names.add(annotation.commandName());
                    for (String alias : annotation.aliases()) {
                        names.add(alias);
                    }
                    
                    this.subCommandMap.put(names, method);
                    this.commandInstanceMap.put(names, handler);
                }
                
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 1) {
            for (Entry<Collection<String>, Method> entry : subCommandMap.entrySet()) {
                for (String alias : entry.getKey()) {
                    if (args[0].equalsIgnoreCase(alias)) {
                        try {
                            entry.getValue().invoke(commandInstanceMap.get(entry.getKey()), sender, command, label, args);
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return true;
    }

}
