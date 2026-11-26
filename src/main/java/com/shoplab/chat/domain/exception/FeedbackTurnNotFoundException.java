package com.shoplab.chat.domain.exception;

import com.shoplab.chat.shared.exception.BusinessException;
import com.shoplab.chat.shared.exception.ResponseCodeEnum;

/** There is no completed chat turn or recorded feedback with that turn identifier. */
public class FeedbackTurnNotFoundException extends BusinessException {

    public FeedbackTurnNotFoundException() {
        super(ResponseCodeEnum.FEEDBACK_TURN_NOT_FOUND);
    }
}
