package page.nafuchoco.neobot.api.command;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import page.nafuchoco.neobot.api.module.NeoModule;

import java.util.List;

public interface ICommandRegistry {
    void registerCommand(@NotNull CommandExecutor executor, @Nullable NeoModule module);

    void registerCommand(@NotNull CommandExecutor executor, @Nullable String groupName, @Nullable NeoModule module);

    void removeCommand(@NotNull String name, @Nullable NeoModule module);

    void removeCommand(@NotNull CommandExecutor executor, @Nullable NeoModule module);

    void removeCommands(@Nullable NeoModule module);

    void deleteCommandGroup(@Nullable String groupName);

    void deleteCommandGroup(@NotNull CommandGroup commandGroup);

    @NotNull List<CommandGroup> getCommandGroups();

    @NotNull List<String> getCommandGroupsNames();

    @NotNull List<CommandExecutor> getCommands();

    @Nullable CommandGroup getCommandGroup(String groupName);

    @Nullable CommandExecutor getExecutor(String name);
}
