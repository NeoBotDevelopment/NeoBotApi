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

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.interactions.InteractionHook;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import page.nafuchoco.neobot.api.Launcher;

import java.util.Map;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CommandContext {
    private final Launcher launcher;
    private final Guild guild;
    private final MessageChannelUnion channel;
    private final Member invoker;
    private final InteractionHook hook;

    private final String trigger;
    private final Map<String, AssignedCommandValueOption> options;
    private final CommandExecutor command;
    private final CommandExecutor subCommand;

    private final SlashCommandResponse responseSender;


    public @NotNull Launcher getLauncher() {
        return launcher;
    }

    /**
     * @return Command Executed Guild
     */
    public @NotNull Guild getGuild() {
        return guild;
    }

    /**
     * @return Command executed text channel
     */
    public @NotNull TextChannel getChannel() {
        // テキストチャンネルでない場合エラーが発生する可能性があります。実質的にはそのような状況に陥ることはまずありません。
        return channel.asTextChannel();
    }

    /**
     * @return Command executed member
     */
    public @NotNull Member getInvoker() {
        return invoker;
    }

    /**
     * @return
     */
    public @NotNull InteractionHook getHook() {
        return hook;
    }

    /**
     * @return Executed command name
     */
    public @NotNull String getTrigger() {
        return trigger;
    }

    /**
     * @return Specified options
     */
    public @NotNull Map<String, AssignedCommandValueOption> getOptions() {
        return options;
    }

    /**
     * @return Executed command class
     */
    public @NotNull CommandExecutor getCommand() {
        return command;
    }

    /**
     * @return Executed sub command class
     */
    public @Nullable CommandExecutor getSubCommand() {
        return subCommand;
    }

    /**
     * @return
     */
    public @NotNull SlashCommandResponse getResponseSender() {
        return responseSender;
    }
}
