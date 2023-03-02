package com.bolivar.service.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(value = {"status"}, ignoreUnknown = true)
public class ErrorResponseRegistro implements IErrorResponse  {

    public ErrorResponseRegistro(String cod, String error) {
        this.desError = error;
        this.codError = cod;
    }

    public ErrorResponseRegistro(String exception) {
        this.exception = exception;
    }

    @JsonIgnore
    private Integer status;

    @JsonProperty("codigo")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String codError;

    @JsonProperty("mensaje")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String desError;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String exception;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String request;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String response;

}
