package com.shoplab.chat.domain.exception;

import com.shoplab.chat.shared.exception.BusinessException;
import com.shoplab.chat.shared.exception.ResponseCodeEnum;

/** The feedback has already been promoted to a golden case (or the golden case id is already assigned). */
public class FeedbackAlreadyPromotedException extends BusinessException {

    public FeedbackAlreadyPromotedException() {
        super(ResponseCodeEnum.FEEDBACK_ALREADY_PROMOTED);
    }
}
