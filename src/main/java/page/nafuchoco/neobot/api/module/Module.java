/*
 * Copyright 2022 NAFU_at
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package page.nafuchoco.neobot.api.module;

import net.dv8tion.jda.api.entities.Guild;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import page.nafuchoco.neobot.api.Launcher;
import page.nafuchoco.neobot.api.command.CommandExecutor;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public interface Module {

    /**
     * This is called when the module is loaded.
     * At this point, most of the features of the bot are not available, but you can change the behavior of the bot.
     */
    void onLoad();

    /**
     * Called when this module is enabled.
     */
    void onEnable();

    /**
     * Called when this module is disabled.
     */
    void onDisable();

    /**
     * Returns the enabled status of the module.
     *
     * @return enabled status of the module
     */
    boolean isEnable();

    /**
     * Register the CommandExecutor.
     *
     * @param executor CommandExecutor class to be registered
     */
    default void registerCommand(@NotNull CommandExecutor executor) {
        registerCommand(null, null, executor);
    }

    /**
     * Register the CommandExecutor.
     *
     * @param groupName       Name of the command group to which the command executor belongs.
     * @param commandExecutor CommandExecutor class to be registered
     */
    default void registerCommand(@Nullable String groupName, @NotNull CommandExecutor commandExecutor) {
        registerCommand(null, groupName, commandExecutor);
    }

    /**
     * Register the CommandExecutor.
     *
     * @param guild           Guild to which the command executor belongs.
     * @param commandExecutor CommandExecutor class to be registered
     */
    void registerCommand(@Nullable Guild guild, @Nullable String groupName, @NotNull CommandExecutor commandExecutor);

    /**
     * Register all CommandExecutors.
     *
     * @param executors List containing the CommandExecutor
     */
    default void registerCommands(@NotNull List<CommandExecutor> executors) {
        registerCommand(null, executors);
    }

    /**
     * Register all CommandExecutors.
     *
     * @param groupName Name of the command group to which the command executor belongs.
     * @param executors List containing the CommandExecutor
     */
    default void registerCommand(@Nullable String groupName, @NotNull List<CommandExecutor> executors) {
        executors.forEach(e -> registerCommand(groupName, e));
    }

    /**
     * Sends registered commands to discord.
     *
     * @deprecated It is no longer necessary to explicitly queue command list updates.
     * This method will therefore be removed in v2.
     */
    @Deprecated(forRemoval = true, since = "v1.1")
    void queueCommandRegister();

    /**
     * Unregisters all commands related to the specified CommandExecutor class.
     *
     * @param executor CommandExecutor class that wants to be unregistered
     */
    void removeCommand(@NotNull CommandExecutor executor);

    /**
     * Unregisters all CommandExecutor classes registered from this module.
     */
    void removeCommands();

    /**
     * Returns a description of this module.
     *
     * @return module description
     */
    ModuleDescription getDescription();

    /**
     * Returns the Bot's controller class.
     *
     * @return Bot's controller class
     */
    Launcher getLauncher();

    /**
     * Get the embedded resources for this module.
     *
     * @param filename Resource file name
     * @return InputStream of the file, or null if the file is not found
     */
    InputStream getResources(String filename);

    /**
     * Returns a folder to store the plugin data files.
     *
     * @return Folder for storing plugin data files.
     */
    File getDataFolder();

    /**
     * Returns the module logger associated with this Bot's logger.
     *
     * @return Module logger associated with this bot's logger
     */
    NeoModuleLogger getModuleLogger();

    /**
     * Returns the class loader that loaded the module.
     *
     * @return The class loader that loaded the module
     */
    ClassLoader getClassLoader();
}
