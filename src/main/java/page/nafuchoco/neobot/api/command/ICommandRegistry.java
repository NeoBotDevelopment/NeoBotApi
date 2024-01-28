package page.nafuchoco.neobot.api.command;

import net.dv8tion.jda.api.entities.Guild;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import page.nafuchoco.neobot.api.module.NeoModule;

import java.util.List;

public interface ICommandRegistry {
    default void registerCommand(@NotNull CommandExecutor executor, @Nullable NeoModule module) {
        registerCommand(executor, module, null, null);
    }

    default void registerCommand(@NotNull CommandExecutor executor, @Nullable NeoModule module, @Nullable String groupName) {
        registerCommand(executor, module, groupName, null);
    }

    void registerCommand(@NotNull CommandExecutor executor, @Nullable NeoModule module, @Nullable String groupName, @Nullable Guild guild);

    void removeCommand(@NotNull String name, @Nullable NeoModule module, @Nullable Guild guild);

    void removeCommand(@NotNull CommandExecutor executor, @Nullable NeoModule module, @Nullable Guild guild);

    void removeCommands(@Nullable NeoModule module, @Nullable Guild guild);

    void removeCommands(@Nullable NeoModule module);

    void deleteCommandGroup(@Nullable String groupName);

    void deleteCommandGroup(@NotNull CommandGroup commandGroup);

    @NotNull List<CommandGroup> getCommandGroups();

    @NotNull List<String> getCommandGroupsNames();

    @Nullable CommandGroup getCommandGroup(String groupName);

    @NotNull List<CommandExecutor> getCommands();

    @NotNull List<CommandExecutor> getCommands(@Nullable NeoModule module);

    @NotNull List<CommandExecutor> getCommands(@Nullable Guild guild);

    @Nullable CommandExecutor getExecutor(@Nullable Guild guild, String name);
}
