package com.shoplab.chat.application.usecase;

import com.shoplab.chat.application.port.in.ListFeedbackQuery;
import com.shoplab.chat.application.port.in.ListFeedbackServicePort;
import com.shoplab.chat.application.port.out.FeedbackStorePort;
import com.shoplab.chat.config.FeedbackProperties;
import com.shoplab.chat.domain.model.FeedbackListing;
import com.shoplab.chat.domain.model.constants.FeedbackConstants;
import com.shoplab.chat.domain.model.enums.FeedbackRating;
import com.shoplab.chat.shared.exception.BusinessException;
import com.shoplab.chat.shared.exception.ResponseCodeEnum;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/** Lists customer feedback entries joined with turn context for review and golden-case promotion in admin-eval. */
@Service
public class ListFeedbackUseCase implements ListFeedbackServicePort {

    private final FeedbackStorePort store;
    private final FeedbackProperties properties;

    public ListFeedbackUseCase(FeedbackStorePort store, FeedbackProperties properties) {
        this.store = store;
        this.properties = properties;
    }

    @Override
    public Mono<FeedbackListing> list(ListFeedbackQuery query) {
        return Mono.defer(() -> {
            if (query == null
                    || query.limit() < 1
                    || query.limit() > FeedbackConstants.MAX_LIST_LIMIT) {
                throw new BusinessException(ResponseCodeEnum.INVALID_FEEDBACK);
            }
            FeedbackRating rating = query.rating() == null ? FeedbackRating.DOWN : query.rating();
            ListFeedbackQuery normalized = new ListFeedbackQuery(rating, query.promoted(), query.limit());
            return store.list(normalized, properties.baseGoldenCaseNumber());
        });
    }
}
