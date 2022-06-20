package page.nafuchoco.neobot.api.command;

import page.nafuchoco.neobot.api.module.NeoModule;

import java.util.List;

public interface ICommandRegistry {
    void registerCommand(CommandExecutor executor, NeoModule module);

    void registerCommand(CommandExecutor executor, String groupName, NeoModule module);

    void removeCommand(String name, NeoModule module);

    void removeCommand(CommandExecutor executor, NeoModule module);

    void removeCommands(NeoModule module);

    void deleteCommandGroup(String groupName);

    void deleteCommandGroup(CommandGroup commandGroup);

    List<CommandGroup> getCommandGroups();

    List<String> getCommandGroupsNames();

    List<CommandExecutor> getCommands();

    CommandGroup getCommandGroup(String groupName);

    CommandExecutor getExecutor(String name);
}
