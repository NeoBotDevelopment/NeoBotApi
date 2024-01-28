package page.nafuchoco.neobot.api.command;

import net.dv8tion.jda.api.entities.Guild;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import page.nafuchoco.neobot.api.module.NeoModule;

import java.util.List;

public interface ICommandRegistry {
    default void registerCommand(@NotNull CommandExecutor executor, @Nullable NeoModule module) {
        registerCommand(executor, null, null, module);
    }

    default void registerCommand(@NotNull CommandExecutor executor, @Nullable String groupName, @Nullable NeoModule module) {
        registerCommand(executor, null, groupName, module);
    }

    void registerCommand(@NotNull CommandExecutor executor, @Nullable Guild guild, @Nullable String groupName, @Nullable NeoModule module);

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
