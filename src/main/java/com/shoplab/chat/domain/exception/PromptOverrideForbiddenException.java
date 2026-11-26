package com.shoplab.chat.domain.exception;

import com.shoplab.chat.shared.exception.BusinessException;
import com.shoplab.chat.shared.exception.ResponseCodeEnum;

/** The request fixes prompt versions without being allowed to: the capability is off or the token is wrong. */
public class PromptOverrideForbiddenException extends BusinessException {

    public PromptOverrideForbiddenException() {
        super(ResponseCodeEnum.PROMPT_OVERRIDE_FORBIDDEN);
    }
}
