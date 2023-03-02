package com.bolivar.service.model;

import com.bolivar.service.model.response.FasecoldaResponse;

public class GlobalResponse {
    private FasecoldaResponse response;
    private IErrorResponse error;

    public GlobalResponse() {
    }

    public GlobalResponse(FasecoldaResponse response, IErrorResponse error) {
        this.response = response;
        this.error = error;
    }

    public FasecoldaResponse getResponse() {
        return response;
    }

    public void setResponse(FasecoldaResponse response) {
        this.response = response;
    }

    public IErrorResponse  getError() {
        return error;
    }

    public void setError(IErrorResponse  error) {
        this.error = error;
    }
}
