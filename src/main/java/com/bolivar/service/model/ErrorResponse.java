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
public class ErrorResponse implements  IErrorResponse {

    public ErrorResponse(String cod, String error) {
        this.desError = error;
        this.codError = cod;
    }

    public ErrorResponse(String exception) {
        this.exception = exception;
    }

    @JsonIgnore
    private Integer status;

    @JsonProperty("CodError")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String codError;

    @JsonProperty("DesError")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String desError;

    @JsonProperty("codigo")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String codigo;

    @JsonProperty("mensaje")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String mensaje;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String exception;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String request;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String response;

    public String getCodError() {
        if (codError==null){
            return codigo;
        }else{
        return codError;
        }
    }

    public String getDesError() {
        if (desError==null){
            return mensaje;
        }else {
            return desError;
        }
    }
}
