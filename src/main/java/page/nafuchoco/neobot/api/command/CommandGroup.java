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

package page.nafuchoco.neobot.api.command;

import net.dv8tion.jda.api.entities.Guild;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import page.nafuchoco.neobot.api.module.NeoModule;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CommandGroup {
    private final String groupName;
    private final Map<NeoModule, Map<Long, Map<String, CommandExecutor>>> executors;
    private boolean enabled;

    public CommandGroup(String groupName) {
        this.groupName = groupName;
        executors = new LinkedHashMap<>();
        enabled = true;
    }

    public String getGroupName() {
        return groupName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void registerCommand(@NotNull CommandExecutor executor, @Nullable NeoModule module, @Nullable Guild guild) {
        Map<Long, Map<String, CommandExecutor>> mods = executors.computeIfAbsent(module, key -> new LinkedHashMap<>());
        Map<String, CommandExecutor> reg = mods.computeIfAbsent(guild != null ? guild.getIdLong() : null, key -> new LinkedHashMap<>());
        String name = executor.getName();
        reg.put(name, executor);
    }

    @Nullable
    public CommandExecutor removeCommand(@NotNull String name, @Nullable NeoModule module, @Nullable Guild guild) {
        CommandExecutor executor = null;
        if (executors.containsKey(module) && (executors.get(module).containsKey(guild != null ? guild.getIdLong() : null))) {
            executor = executors.get(module).get(guild != null ? guild.getIdLong() : null).get(name);
            executors.get(module).get(guild != null ? guild.getIdLong() : null).remove(name);
        }

        return executor;
    }

    public boolean removeCommand(@NotNull CommandExecutor executor, @Nullable NeoModule module, @Nullable Guild guild) {
        if (executors.containsKey(module) && (executors.get(module).containsKey(guild != null ? guild.getIdLong() : null))) {
            String name = executor.getName();
            if (executors.get(module).get(guild != null ? guild.getIdLong() : null).containsKey(name)) {
                executors.get(module).get(guild != null ? guild.getIdLong() : null).remove(name);
                return true;
            }
        }

        return false; // If the command executor is not registered, return false.
    }

    public List<CommandExecutor> removeCommands(@NotNull NeoModule module, @Nullable Guild guild) {
        return executors.get(module).remove(guild != null ? guild.getIdLong() : null).values().stream().toList();
    }

    public Map<Long, List<CommandExecutor>> removeCommands(@NotNull NeoModule module) {
        Map<Long, List<CommandExecutor>> removed = new LinkedHashMap<>();
        executors.get(module).forEach((key, value) -> removed.put(key, value.values().stream().toList()));
        executors.remove(module);
        return removed;
    }

    public @NotNull List<CommandExecutor> getCommands(@Nullable NeoModule module) {
        return executors.get(module).values().stream().map(Map::values).flatMap(Collection::stream).toList();
    }

    public @NotNull List<CommandExecutor> getCommands(Guild guild) {
        return executors.values().stream().filter(v -> v.containsKey(guild.getIdLong())).map(v -> v.get(guild.getIdLong()).values()).flatMap(Collection::stream).toList();
    }

    public @NotNull List<CommandExecutor> getCommands() {
        return executors.values().stream().map(Map::values).flatMap(Collection::stream).map(Map::values).flatMap(Collection::stream).toList();
    }

    /**
     * Returns a CommandExecutor matching the specified name.
     *
     * @param guild If this argument is specified,
     *              the search is performed from both those registered with the specified and those registered with null.
     *              If the argument is null, only those registered with null are returned.
     * @param name  The name of the CommandExecutor to search for.
     * @return CommandExecutor matching the specified name.
     */
    public CommandExecutor getExecutor(@Nullable Guild guild, @NotNull String name) {
        CommandExecutor executor = null;

        for (Map<Long, Map<String, CommandExecutor>> mods : executors.values()) {
            Map<String, CommandExecutor> defaultRegs = mods.computeIfAbsent(null, key -> new LinkedHashMap<>());
            if (guild != null) {
                if (mods.containsKey(guild.getIdLong()))
                    executor = mods.get(guild.getIdLong()).get(name);
                executor = executor == null ? defaultRegs.get(name) : executor; // If the executor is registered with the specified guild, it will be prioritized.
            } else {
                executor = defaultRegs.get(name);
            }

            if (executor != null)
                break;
        }

        return executor;
    }
}
