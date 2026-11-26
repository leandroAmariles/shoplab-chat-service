package com.shoplab.chat.infrastructure.in.rest.util.mapper;

import com.shoplab.chat.api.AssistantSettings;
import com.shoplab.chat.api.ServedPrompt;
import com.shoplab.chat.infrastructure.in.rest.dto.AssistantSettingsResponse;
import com.shoplab.chat.infrastructure.in.rest.dto.AssistantSettingsResponse.ServedPromptItem;

/** Explicit mapper between {@link AssistantSettings} and {@link AssistantSettingsResponse}. */
public final class AssistantSettingsRestMapper {

    private AssistantSettingsRestMapper() {
    }

    public static AssistantSettingsResponse toResponse(AssistantSettings settings) {
        return new AssistantSettingsResponse(
                settings.topK(),
                settings.similarityThreshold(),
                settings.maxContextCharacters(),
                settings.prompts().stream().map(AssistantSettingsRestMapper::toPromptItem).toList());
    }

    private static ServedPromptItem toPromptItem(ServedPrompt prompt) {
        return new ServedPromptItem(prompt.name(), prompt.version(), prompt.source());
    }
}
