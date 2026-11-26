package com.shoplab.chat.application.port.in;

import com.shoplab.chat.domain.model.FeedbackRecord;
import com.shoplab.chat.domain.model.SubmitFeedbackCommand;
import reactor.core.publisher.Mono;

/** Inbound port to record or update customer feedback on a completed chat turn. */
public interface SubmitFeedbackServicePort {

    Mono<FeedbackRecord> submit(SubmitFeedbackCommand command);
}
