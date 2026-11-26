package com.shoplab.chat.application.usecase;

import com.shoplab.chat.api.AssistantSettings;
import com.shoplab.chat.api.AssistantSettingsApi;
import com.shoplab.chat.application.port.in.GetAssistantSettingsServicePort;
import reactor.core.publisher.Mono;

/** Reads active assistant settings reactively from in-memory state without blocking I/O. */
public class GetAssistantSettingsUseCase implements GetAssistantSettingsServicePort {

    private final AssistantSettingsApi settingsApi;

    public GetAssistantSettingsUseCase(AssistantSettingsApi settingsApi) {
        this.settingsApi = settingsApi;
    }

    @Override
    public Mono<AssistantSettings> current() {
        return Mono.fromSupplier(settingsApi::current);
    }
}
