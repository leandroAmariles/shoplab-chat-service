package com.shoplab.chat.application.port.in;

import com.shoplab.chat.domain.model.enums.FeedbackRating;

/** Query filters to list recorded feedback turns for review and golden-case promotion. */
public record ListFeedbackQuery(FeedbackRating rating, Boolean promoted, int limit) {
}
