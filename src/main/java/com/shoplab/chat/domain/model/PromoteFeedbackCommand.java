package com.shoplab.chat.domain.model;

/** Command to promote a negative feedback turn to a golden dataset case. */
public record PromoteFeedbackCommand(String turnId, GoldenCaseDraft draft) {
}
