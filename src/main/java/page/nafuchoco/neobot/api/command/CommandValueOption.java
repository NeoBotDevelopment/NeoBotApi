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

import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

public class CommandValueOption implements CommandOption {
    private final OptionType optionType;
    private final String optionName;
    private final String optionDescription;
    private final Map<String, Object> choices;
    private final boolean required;
    private final boolean autoComplete;

    public CommandValueOption(@NotNull OptionType optionType,
                              @NotNull String optionName, @NotNull String optionDescription, boolean required,
                              boolean autoComplete) {
        this.optionType = optionType;
        this.optionName = optionName;
        this.optionDescription = optionDescription;
        this.required = required;
        this.autoComplete = autoComplete;

        choices = new LinkedHashMap<>();
    }


    public SlashCommandData addCommandOption(SlashCommandData slashCommandData) {
        return slashCommandData.addOption(optionType, optionName, optionDescription, required, autoComplete);
    }

    public CommandValueOption addChoiceAsString(@NotNull String name, @NotNull String value) {
        if (optionType != OptionType.STRING)
            throw new IllegalArgumentException("Cannot add string choice for OptionType." + optionType);
        return addChoice(name, value);
    }

    public CommandValueOption addChoiceAsLong(@NotNull String name, long value) {
        if (optionType != OptionType.INTEGER)
            throw new IllegalArgumentException("Cannot add long choice for OptionType." + optionType);
        return addChoice(name, value);
    }

    public CommandValueOption addChoiceAsDouble(@NotNull String name, double value) {
        if (optionType != OptionType.NUMBER)
            throw new IllegalArgumentException("Cannot add double choice for OptionType." + optionType);
        return addChoice(name, value);
    }

    private CommandValueOption addChoice(@NotNull String name, @NotNull Object value) {
        if (autoComplete)
            throw new IllegalStateException("Cannot add choice for autoComplete options.");
        ObjectUtils.requireNonEmpty(name, "Choice name cannot be empty.");
        ObjectUtils.requireNonEmpty(value, "Choice value cannot be empty.");

        choices.put(name, value);
        return this;
    }


    @Override
    public @NotNull OptionType optionType() {
        return optionType;
    }

    @Override
    public @NotNull String optionName() {
        return optionName;
    }

    @Override
    public @NotNull String optionDescription() {
        return optionDescription;
    }

    public boolean required() {
        return required;
    }

    public boolean autoComplete() {
        return autoComplete;
    }

    public Map<String, Object> getChoices() {
        return choices;
    }
}
