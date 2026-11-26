package com.shoplab.chat.infrastructure.out.prompts;

import static org.assertj.core.api.Assertions.assertThat;

import com.shoplab.chat.application.usecase.PromptValidator;
import com.shoplab.chat.domain.exception.PromptOverrideException;
import com.shoplab.chat.domain.model.enums.PromptName;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class DefaultPromptCatalogTests {

    private final DefaultPromptCatalog catalog =
            new DefaultPromptCatalog(new PromptDefaults(new PromptValidator(20_000)));

    @Test
    void alwaysServesTheDefaultText() {
        for (PromptName name : PromptName.values()) {
            assertThat(catalog.current(name).reference().isDefault()).isTrue();
            assertThat(catalog.current(name).text()).isNotBlank();
        }
    }

    @Test
    void aVersionCannotBeFixedBecauseThereAreNoVersions() {
        StepVerifier.create(catalog.pinned(PromptName.CHAT_SYSTEM, 1))
                .expectError(PromptOverrideException.class)
                .verify();
    }
}
