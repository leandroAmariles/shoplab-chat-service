package com.shoplab.chat.domain.model.enums;

import java.util.Locale;

/** The step of a turn that failed. */
public enum FailureStage {
    RETRIEVAL,
    GENERATION,
    TOOL;

    public String traceValue() {
        return name().toLowerCase(Locale.ROOT);
    }
}
