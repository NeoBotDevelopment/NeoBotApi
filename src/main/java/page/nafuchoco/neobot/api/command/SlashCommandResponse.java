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

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.callbacks.IMessageEditCallback;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;
import net.dv8tion.jda.api.interactions.components.LayoutComponent;
import net.dv8tion.jda.api.requests.ErrorResponse;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.WebhookMessageCreateAction;
import net.dv8tion.jda.api.requests.restaction.WebhookMessageEditAction;
import net.dv8tion.jda.api.utils.AttachedFile;
import net.dv8tion.jda.api.utils.AttachmentUpdate;
import net.dv8tion.jda.api.utils.FileUpload;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;
import net.dv8tion.jda.api.utils.messages.MessageEditBuilder;
import net.dv8tion.jda.api.utils.messages.MessageEditData;
import org.jetbrains.annotations.NotNull;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;

public class SlashCommandResponse {
    private final InteractionHook hook;

    private boolean executorResponded = false;

    public SlashCommandResponse(InteractionHook hook) {
        this.hook = hook;
    }

    /**
     * Retrieves the original reply to this interaction.
     * <br>This doesn't work for ephemeral messages and will always cause an unknown message error response.
     *
     * @return {@link RestAction} - Type: {@link Message}
     */
    @CheckReturnValue
    @Nonnull
    public RestAction<Message> retrieveOriginal() {
        return hook.retrieveOriginal();
    }

    /**
     * Edit the source message sent by this interaction.
     * <br>For {@link IMessageEditCallback#editComponents(Collection)} and {@link IMessageEditCallback#deferEdit()} this will be the message the components are attached to.
     * For {@link IReplyCallback#deferReply()} and {@link IReplyCallback#reply(String)} this will be the reply message instead.
     *
     * <p>This method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param content The new message content to use
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException If the provided content is null, empty, or longer than {@link Message#MAX_CONTENT_LENGTH}
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editOriginal(@NotNull String content) {
        return hook.editOriginal(content);
    }

    /**
     * Edit the source message sent by this interaction.
     * <br>For {@link IMessageEditCallback#editComponents(Collection)} and {@link IMessageEditCallback#deferEdit()} this will be the message the components are attached to.
     * For {@link IReplyCallback#deferReply()} and {@link IReplyCallback#reply(String)} this will be the reply message instead.
     *
     * <p>This method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param components The new component layouts for this message, such as {@link ActionRow ActionRows}
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException If the provided components are null, or more than 5 layouts are provided
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editOriginalComponents(@NotNull Collection<? extends LayoutComponent> components) {
        return hook.editOriginalComponents(components);
    }

    /**
     * Edit the source message sent by this interaction.
     * <br>For {@link IMessageEditCallback#editComponents(Collection)} and {@link IMessageEditCallback#deferEdit()} this will be the message the components are attached to.
     * For {@link IReplyCallback#deferReply()} and {@link IReplyCallback#reply(String)} this will be the reply message instead.
     *
     * <p>This method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param components The new component layouts for this message, such as {@link ActionRow ActionRows}
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException If the provided components are null, or more than 5 layouts are provided
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editOriginalComponents(@NotNull LayoutComponent... components) {
        return hook.editOriginalComponents(components);
    }

    /**
     * Edit the source message sent by this interaction.
     * <br>For {@link IMessageEditCallback#editComponents(Collection)} and {@link IMessageEditCallback#deferEdit()} this will be the message the components are attached to.
     * For {@link IReplyCallback#deferReply()} and {@link IReplyCallback#reply(String)} this will be the reply message instead.
     *
     * <p>This method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param embeds {@link MessageEmbed MessageEmbeds} to use (up to {@value Message#MAX_EMBED_COUNT} in total)
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException If the provided embeds are null, or more than {@value Message#MAX_EMBED_COUNT}
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editOriginalEmbeds(@NotNull Collection<? extends MessageEmbed> embeds) {
        return hook.editOriginalEmbeds(embeds);
    }

    /**
     * Edit the source message sent by this interaction.
     * <br>For {@link IMessageEditCallback#editComponents(Collection)} and {@link IMessageEditCallback#deferEdit()} this will be the message the components are attached to.
     * For {@link IReplyCallback#deferReply()} and {@link IReplyCallback#reply(String)} this will be the reply message instead.
     *
     * <p>This method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param embeds The new {@link MessageEmbed MessageEmbeds} to use
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException If the provided embeds are null, or more than 10
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editOriginalEmbeds(@NotNull MessageEmbed... embeds) {
        return hook.editOriginalEmbeds(embeds);
    }

    /**
     * Edit the source message sent by this interaction.
     * <br>For {@link IMessageEditCallback#editComponents(Collection)} and {@link IMessageEditCallback#deferEdit()} this will be the message the components are attached to.
     * For {@link IReplyCallback#deferReply()} and {@link IReplyCallback#reply(String)} this will be the reply message instead.
     *
     * <p>This method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param message The new message to replace the existing message with
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException If the provided message is null
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editOriginal(@NotNull MessageEditData message) {
        return hook.editOriginal(message);
    }

    /**
     * Edit the source message sent by this interaction.
     * <br>For {@link IMessageEditCallback#editComponents(Collection)} and {@link IMessageEditCallback#deferEdit()} this will be the message the components are attached to.
     * For {@link IReplyCallback#deferReply()} and {@link IReplyCallback#reply(String)} this will be the reply message instead.
     *
     * <p>This method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param format Format string for the message content
     * @param args   Format arguments for the content
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException If the formatted string is null, empty, or longer than {@link Message#MAX_CONTENT_LENGTH}
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editOriginalFormat(@NotNull String format, @NotNull Object... args) {
        return hook.editOriginalFormat(format, args);
    }

    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editOriginalAttachments(@NotNull Collection<? extends AttachedFile> attachments) {
        return hook.editOriginalAttachments(attachments);
    }

    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editOriginalAttachments(@NotNull AttachedFile... attachments) {
        return hook.editOriginalAttachments(attachments);
    }

    /**
     * Delete the original reply.
     *
     * @return {@link RestAction}
     */
    @CheckReturnValue
    @Nonnull
    public RestAction<Void> deleteOriginal() {
        return hook.deleteOriginal();
    }

    /**
     * Send a message to this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     * </ul>
     *
     * @param content The message content
     * @return {@link WebhookMessageCreateAction}
     * @throws IllegalArgumentException If the content is null or longer than {@link Message#MAX_CONTENT_LENGTH} characters
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageCreateAction<Message> sendMessage(@NotNull String content) {
        
        return hook.sendMessage(content);
    }

    /**
     * Send a message to this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     * </ul>
     *
     * @param message The {@link MessageCreateData} to send
     * @return {@link WebhookMessageCreateAction}
     * @throws IllegalArgumentException If null is provided
     * @see MessageCreateBuilder MessageCreateBuilder
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageCreateAction<Message> sendMessage(@NotNull MessageCreateData message) {
        return hook.sendMessage(message);
    }

    /**
     * Send a message to this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     * </ul>
     *
     * @param format Format string for the message content
     * @param args   Format arguments for the content
     * @return {@link WebhookMessageCreateAction}
     * @throws IllegalArgumentException If the format string is null or the resulting content is longer than {@link Message#MAX_CONTENT_LENGTH} characters
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageCreateAction<Message> sendMessageFormat(@NotNull String format, @NotNull Object... args) {
        return hook.sendMessageFormat(format, args);
    }

    /**
     * Send a message to this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     * </ul>
     *
     * <p><b>Example: Attachment Images</b>
     * <pre>{@code
     * // Make a file upload instance which refers to a local file called "myFile.png"
     * // The second parameter "image.png" is the filename we tell discord to use for the attachment
     * FileUpload file = FileUpload.fromData(new File("myFile.png"), "image.png");
     *
     * // Build a message embed which refers to this attachment by the given name.
     * // Note that this must be the same name as configured for the attachment, not your local filename.
     * MessageEmbed embed = new EmbedBuilder()
     *   .setDescription("This is my cute cat :)")
     *   .setImage("attachment://image.png") // refer to the file by using the "attachment://" schema with the filename we gave it above
     *   .build();
     *
     * webhook.sendMessageEmbeds(Collections.singleton(embed)) // send the embeds
     *        .addFiles(file) // add the file as attachment
     *        .queue();
     * }</pre>
     *
     * @param embeds {@link MessageEmbed MessageEmbeds} to use (up to {@value Message#MAX_EMBED_COUNT})
     * @return {@link WebhookMessageCreateAction}
     * @throws IllegalArgumentException If any of the embeds are null, more than {@value Message#MAX_EMBED_COUNT}, or longer than {@link MessageEmbed#EMBED_MAX_LENGTH_BOT}.
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageCreateAction<Message> sendMessageEmbeds(@NotNull Collection<? extends MessageEmbed> embeds) {
        return hook.sendMessageEmbeds(embeds);
    }

    /**
     * Send a message to this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     * </ul>
     *
     * <p><b>Example: Attachment Images</b>
     * <pre>{@code
     * // Make a file upload instance which refers to a local file called "myFile.png"
     * // The second parameter "image.png" is the filename we tell discord to use for the attachment
     * FileUpload file = FileUpload.fromData(new File("myFile.png"), "image.png");
     *
     * // Build a message embed which refers to this attachment by the given name.
     * // Note that this must be the same name as configured for the attachment, not your local filename.
     * MessageEmbed embed = new EmbedBuilder()
     *   .setDescription("This is my cute cat :)")
     *   .setImage("attachment://image.png") // refer to the file by using the "attachment://" schema with the filename we gave it above
     *   .build();
     *
     * webhook.sendMessageEmbeds(embed) // send the embed
     *        .addFiles(file) // add the file as attachment
     *        .queue();
     * }</pre>
     *
     * @param embed  {@link MessageEmbed} to use
     * @param embeds Additional {@link MessageEmbed MessageEmbeds} to use (up to {@value Message#MAX_EMBED_COUNT} in total)
     * @return {@link WebhookMessageCreateAction}
     * @throws IllegalArgumentException If any of the embeds are null, more than {@value Message#MAX_EMBED_COUNT}, or longer than {@link MessageEmbed#EMBED_MAX_LENGTH_BOT}.
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageCreateAction<Message> sendMessageEmbeds(@NotNull MessageEmbed embed, @NotNull MessageEmbed... embeds) {
        return hook.sendMessageEmbeds(embed, embeds);
    }

    /**
     * Send a message to this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     * </ul>
     *
     * @param components {@link LayoutComponent LayoutComponents} to use (up to {@value Message#MAX_COMPONENT_COUNT})
     * @return {@link WebhookMessageCreateAction}
     * @throws IllegalArgumentException If any of the components are null or more than {@value Message#MAX_COMPONENT_COUNT} component layouts are provided
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageCreateAction<Message> sendMessageComponents(@NotNull Collection<? extends LayoutComponent> components) {
        return hook.sendMessageComponents(components);
    }

    /**
     * Send a message to this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     * </ul>
     *
     * @param component {@link LayoutComponent} to use
     * @param other     Additional {@link LayoutComponent LayoutComponents} to use (up to {@value Message#MAX_COMPONENT_COUNT} in total)
     * @return {@link WebhookMessageCreateAction}
     * @throws IllegalArgumentException If any of the components are null or more than {@value Message#MAX_COMPONENT_COUNT} component layouts are provided
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageCreateAction<Message> sendMessageComponents(@NotNull LayoutComponent component, @NotNull LayoutComponent... other) {
        return hook.sendMessageComponents(component, other);
    }

    /**
     * Send a message to this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p><b>Resource Handling Note:</b> Once the request is handed off to the requester, for example when you call {@link RestAction#queue()},
     * the requester will automatically clean up all opened files by itself. You are only responsible to close them yourself if it is never handed off properly.
     * For instance, if an exception occurs after using {@link FileUpload#fromData(File)}, before calling {@link RestAction#queue()}.
     * You can safely use a try-with-resources to handle this, since {@link FileUpload#close()} becomes ineffective once the request is handed off.
     *
     * <p><b>Example: Attachment Images</b>
     * <pre>{@code
     * // Make a file upload instance which refers to a local file called "myFile.png"
     * // The second parameter "image.png" is the filename we tell discord to use for the attachment
     * FileUpload file = FileUpload.fromData(new File("myFile.png"), "image.png");
     *
     * // Build a message embed which refers to this attachment by the given name.
     * // Note that this must be the same name as configured for the attachment, not your local filename.
     * MessageEmbed embed = new EmbedBuilder()
     *   .setDescription("This is my cute cat :)")
     *   .setImage("attachment://image.png") // refer to the file by using the "attachment://" schema with the filename we gave it above
     *   .build();
     *
     * webhook.sendFiles(Collections.singleton(file)) // send the file upload
     *        .addEmbeds(embed) // add the embed you want to reference the file with
     *        .queue();
     * }</pre>
     *
     * @param files The {@link FileUpload FileUploads} to attach to the message
     * @return {@link WebhookMessageCreateAction}
     * @throws IllegalArgumentException If null is provided
     * @see FileUpload#fromData(InputStream, String)
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageCreateAction<Message> sendFiles(@NotNull Collection<? extends FileUpload> files) {
        return hook.sendFiles(files);
    }

    /**
     * Send a message to this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p><b>Resource Handling Note:</b> Once the request is handed off to the requester, for example when you call {@link RestAction#queue()},
     * the requester will automatically clean up all opened files by itself. You are only responsible to close them yourself if it is never handed off properly.
     * For instance, if an exception occurs after using {@link FileUpload#fromData(File)}, before calling {@link RestAction#queue()}.
     * You can safely use a try-with-resources to handle this, since {@link FileUpload#close()} becomes ineffective once the request is handed off.
     *
     * <p><b>Example: Attachment Images</b>
     * <pre>{@code
     * // Make a file upload instance which refers to a local file called "myFile.png"
     * // The second parameter "image.png" is the filename we tell discord to use for the attachment
     * FileUpload file = FileUpload.fromData(new File("myFile.png"), "image.png");
     *
     * // Build a message embed which refers to this attachment by the given name.
     * // Note that this must be the same name as configured for the attachment, not your local filename.
     * MessageEmbed embed = new EmbedBuilder()
     *   .setDescription("This is my cute cat :)")
     *   .setImage("attachment://image.png") // refer to the file by using the "attachment://" schema with the filename we gave it above
     *   .build();
     *
     * webhook.sendFiles(file) // send the file upload
     *        .addEmbeds(embed) // add the embed you want to reference the file with
     *        .queue();
     * }</pre>
     *
     * @param files The {@link FileUpload FileUploads} to attach to the message
     * @return {@link WebhookMessageCreateAction}
     * @throws IllegalArgumentException If null is provided
     * @see FileUpload#fromData(InputStream, String)
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageCreateAction<Message> sendFiles(@NotNull FileUpload... files) {
        return hook.sendFiles(files);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit the source message of the interaction.
     * @param content   The new message content to use
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException If the provided content is null or longer than {@link Message#MAX_CONTENT_LENGTH} characters
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editMessageById(@NotNull String messageId, @NotNull String content) {
        return hook.editMessageById(messageId, content);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit the source message of the interaction.
     * @param content   The new message content to use
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException If the provided content is null or longer than {@link Message#MAX_CONTENT_LENGTH} characters
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editMessageById(long messageId, @NotNull String content) {
        return hook.editMessageById(messageId, content);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit the source message of the interaction.
     * @param message   The {@link MessageEditData} containing the update information
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException If the provided message is null
     * @see MessageEditBuilder MessageEditBuilder
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editMessageById(@NotNull String messageId, @NotNull MessageEditData message) {
        return hook.editMessageById(messageId, message);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit the source message of the interaction.
     * @param message   The {@link MessageEditData} containing the update information
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException If the provided message is null
     * @see MessageEditBuilder MessageEditBuilder
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editMessageById(long messageId, MessageEditData message) {
        return hook.editMessageById(messageId, message);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit the source message of the interaction.
     * @param format    Format string for the message content
     * @param args      Format arguments for the content
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException If the formatted string is null or longer than {@link Message#MAX_CONTENT_LENGTH} characters
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editMessageFormatById(@NotNull String messageId, @NotNull String format, @NotNull Object... args) {
        return hook.editMessageFormatById(messageId, format, args);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit the source message of the interaction.
     * @param format    Format string for the message content
     * @param args      Format arguments for the content
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException If the formatted string is null or longer than {@link Message#MAX_CONTENT_LENGTH} characters
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editMessageFormatById(long messageId, @NotNull String format, @NotNull Object... args) {
        return hook.editMessageFormatById(messageId, format, args);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit the source message of the interaction.
     * @param embeds    {@link MessageEmbed MessageEmbeds} to use (up to {@value Message#MAX_EMBED_COUNT} in total)
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException If null or more than {@value Message#MAX_EMBED_COUNT} embeds are provided
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editMessageEmbedsById(@NotNull String messageId, @NotNull Collection<? extends MessageEmbed> embeds) {
        return hook.editMessageEmbedsById(messageId, embeds);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit the source message of the interaction.
     * @param embeds    {@link MessageEmbed MessageEmbeds} to use (up to {@value Message#MAX_EMBED_COUNT} in total)
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException If null or more than {@value Message#MAX_EMBED_COUNT} embeds are provided
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editMessageEmbedsById(long messageId, @NotNull Collection<? extends MessageEmbed> embeds) {
        return hook.editMessageEmbedsById(messageId, embeds);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit the source message of the interaction.
     * @param embeds    The new {@link MessageEmbed MessageEmbeds} to use
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException If null or more than {@value Message#MAX_EMBED_COUNT} embeds are provided
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editMessageEmbedsById(@NotNull String messageId, @NotNull MessageEmbed... embeds) {
        return hook.editMessageEmbedsById(messageId, embeds);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The message id. For interactions this supports {@code "@original"} to edit the source message of the interaction.
     * @param embeds    The new {@link MessageEmbed MessageEmbeds} to use
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException If null or more than {@value Message#MAX_EMBED_COUNT} embeds are provided
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editMessageEmbedsById(long messageId, @NotNull MessageEmbed... embeds) {
        return hook.editMessageEmbedsById(messageId, embeds);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId  The message id. For interactions this supports {@code "@original"} to edit the source message of the interaction.
     * @param components The new component layouts for this message, such as {@link ActionRow ActionRows}
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException <ul>
     *                                                                                                                                                 <li>If {@code null} is provided</li>
     *                                                                                                                                                 <li>If any of the components is not {@link LayoutComponent#isMessageCompatible() message compatible}</li>
     *                                                                                                                                                 <li>If more than {@value Message#MAX_COMPONENT_COUNT} component layouts are provided</li>
     *                                                                                                                                             </ul>
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editMessageComponentsById(@NotNull String messageId, @NotNull Collection<? extends LayoutComponent> components) {
        return hook.editMessageComponentsById(messageId, components);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId  The message id. For interactions this supports {@code "@original"} to edit the source message of the interaction.
     * @param components The new component layouts for this message, such as {@link ActionRow ActionRows}
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException <ul>
     *                                                                                                                                                 <li>If {@code null} is provided</li>
     *                                                                                                                                                 <li>If any of the components is not {@link LayoutComponent#isMessageCompatible() message compatible}</li>
     *                                                                                                                                                 <li>If more than {@value Message#MAX_COMPONENT_COUNT} component layouts are provided</li>
     *                                                                                                                                             </ul>
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editMessageComponentsById(long messageId, @NotNull Collection<? extends LayoutComponent> components) {
        return hook.editMessageComponentsById(messageId, components);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId  The message id. For interactions this supports {@code "@original"} to edit the source message of the interaction.
     * @param components The new component layouts for this message, such as {@link ActionRow ActionRows}
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException <ul>
     *                                                                                                                                                 <li>If {@code null} is provided</li>
     *                                                                                                                                                 <li>If any of the components is not {@link LayoutComponent#isMessageCompatible() message compatible}</li>
     *                                                                                                                                                 <li>If more than {@value Message#MAX_COMPONENT_COUNT} component layouts are provided</li>
     *                                                                                                                                             </ul>
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editMessageComponentsById(@NotNull String messageId, @NotNull LayoutComponent... components) {
        return hook.editMessageComponentsById(messageId, components);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId  The message id. For interactions this supports {@code "@original"} to edit the source message of the interaction.
     * @param components The new component layouts for this message, such as {@link ActionRow ActionRows}
     * @return {@link WebhookMessageEditAction}
     * @throws IllegalArgumentException <ul>
     *                                                                                                                                                 <li>If {@code null} is provided</li>
     *                                                                                                                                                 <li>If any of the components is not {@link LayoutComponent#isMessageCompatible() message compatible}</li>
     *                                                                                                                                                 <li>If more than {@value Message#MAX_COMPONENT_COUNT} component layouts are provided</li>
     *                                                                                                                                             </ul>
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editMessageComponentsById(long messageId, @NotNull LayoutComponent... components) {
        return hook.editMessageComponentsById(messageId, components);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p><b>Resource Handling Note:</b> Once the request is handed off to the requester, for example when you call {@link RestAction#queue()},
     * the requester will automatically clean up all opened files by itself. You are only responsible to close them yourself if it is never handed off properly.
     * For instance, if an exception occurs after using {@link FileUpload#fromData(File)}, before calling {@link RestAction#queue()}.
     * You can safely use a try-with-resources to handle this, since {@link FileUpload#close()} becomes ineffective once the request is handed off.
     *
     * @param messageId   The message id. For interactions this supports {@code "@original"} to edit the source message of the interaction.
     * @param attachments The new attachments of the message (Can be {@link FileUpload FileUploads} or {@link AttachmentUpdate AttachmentUpdates})
     * @return {@link MessageEditCallbackAction} that can be used to further update the message
     * @throws IllegalArgumentException If null is provided
     * @see AttachedFile#fromAttachment(Message.Attachment)
     * @see FileUpload#fromData(InputStream, String)
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editMessageAttachmentsById(@NotNull String messageId, @NotNull Collection<? extends AttachedFile> attachments) {
        return hook.editMessageAttachmentsById(messageId, attachments);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p><b>Resource Handling Note:</b> Once the request is handed off to the requester, for example when you call {@link RestAction#queue()},
     * the requester will automatically clean up all opened files by itself. You are only responsible to close them yourself if it is never handed off properly.
     * For instance, if an exception occurs after using {@link FileUpload#fromData(File)}, before calling {@link RestAction#queue()}.
     * You can safely use a try-with-resources to handle this, since {@link FileUpload#close()} becomes ineffective once the request is handed off.
     *
     * @param messageId   The message id. For interactions this supports {@code "@original"} to edit the source message of the interaction.
     * @param attachments The new attachments of the message (Can be {@link FileUpload FileUploads} or {@link AttachmentUpdate AttachmentUpdates})
     * @return {@link MessageEditCallbackAction} that can be used to further update the message
     * @throws IllegalArgumentException If null is provided
     * @see AttachedFile#fromAttachment(Message.Attachment)
     * @see FileUpload#fromData(InputStream, String)
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editMessageAttachmentsById(@NotNull String messageId, @NotNull AttachedFile... attachments) {
        return hook.editMessageAttachmentsById(messageId, attachments);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p><b>Resource Handling Note:</b> Once the request is handed off to the requester, for example when you call {@link RestAction#queue()},
     * the requester will automatically clean up all opened files by itself. You are only responsible to close them yourself if it is never handed off properly.
     * For instance, if an exception occurs after using {@link FileUpload#fromData(File)}, before calling {@link RestAction#queue()}.
     * You can safely use a try-with-resources to handle this, since {@link FileUpload#close()} becomes ineffective once the request is handed off.
     *
     * @param messageId   The message id. For interactions this supports {@code "@original"} to edit the source message of the interaction.
     * @param attachments The new attachments of the message (Can be {@link FileUpload FileUploads} or {@link AttachmentUpdate AttachmentUpdates})
     * @return {@link MessageEditCallbackAction} that can be used to further update the message
     * @throws IllegalArgumentException If null is provided
     * @see AttachedFile#fromAttachment(Message.Attachment)
     * @see FileUpload#fromData(InputStream, String)
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editMessageAttachmentsById(long messageId, @NotNull Collection<? extends AttachedFile> attachments) {
        return hook.editMessageAttachmentsById(messageId, attachments);
    }

    /**
     * Edit an existing message sent by this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p><b>Resource Handling Note:</b> Once the request is handed off to the requester, for example when you call {@link RestAction#queue()},
     * the requester will automatically clean up all opened files by itself. You are only responsible to close them yourself if it is never handed off properly.
     * For instance, if an exception occurs after using {@link FileUpload#fromData(File)}, before calling {@link RestAction#queue()}.
     * You can safely use a try-with-resources to handle this, since {@link FileUpload#close()} becomes ineffective once the request is handed off.
     *
     * @param messageId   The message id. For interactions this supports {@code "@original"} to edit the source message of the interaction.
     * @param attachments The new attachments of the message (Can be {@link FileUpload FileUploads} or {@link AttachmentUpdate AttachmentUpdates})
     * @return {@link MessageEditCallbackAction} that can be used to further update the message
     * @throws IllegalArgumentException If null is provided
     * @see AttachedFile#fromAttachment(Message.Attachment)
     * @see FileUpload#fromData(InputStream, String)
     */
    @CheckReturnValue
    @Nonnull
    public WebhookMessageEditAction<Message> editMessageAttachmentsById(long messageId, @NotNull AttachedFile... attachments) {
        return hook.editMessageAttachmentsById(messageId, attachments);
    }

    /**
     * Delete a message from this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The id for the message to delete
     * @return {@link RestAction}
     * @throws IllegalArgumentException If the provided message id is null or not a valid snowflake
     */
    @CheckReturnValue
    @Nonnull
    public RestAction<Void> deleteMessageById(@NotNull String messageId) {
        return hook.deleteMessageById(messageId);
    }

    /**
     * Delete a message from this webhook.
     *
     * <p>If this is an {@link InteractionHook InteractionHook} this method will be delayed until the interaction is acknowledged.
     *
     * <p>Possible {@link ErrorResponse ErrorResponses} include:
     * <ul>
     *     <li>{@link ErrorResponse#UNKNOWN_WEBHOOK UNKNOWN_WEBHOOK}
     *     <br>The webhook is no longer available, either it was deleted or in case of interactions it expired.</li>
     *     <li>{@link ErrorResponse#UNKNOWN_MESSAGE UNKNOWN_MESSAGE}
     *     <br>The message for that id does not exist</li>
     * </ul>
     *
     * @param messageId The id for the message to delete
     * @return {@link RestAction}
     */
    @CheckReturnValue
    @Nonnull
    public RestAction<Void> deleteMessageById(long messageId) {
        return hook.deleteMessageById(messageId);
    }

    public boolean isExecutorResponded() {
        return executorResponded;
    }
}
