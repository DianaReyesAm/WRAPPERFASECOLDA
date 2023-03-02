package com.bolivar.service.exception;

import com.bolivar.service.model.ErrorResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenException extends Exception {
    private ErrorResponse errorResponse;

    public TokenException(String message, Throwable cause, ErrorResponse response) {
        super(message, cause);
        this.errorResponse = response;
    }

    public TokenException(String message, ErrorResponse response) {
        super(message);
        this.errorResponse = response;
    }
}
