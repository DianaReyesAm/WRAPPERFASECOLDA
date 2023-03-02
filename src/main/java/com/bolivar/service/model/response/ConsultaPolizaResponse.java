package com.bolivar.service.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultaPolizaResponse implements FasecoldaResponse {

    @JsonProperty("EncontroDatos")
    private Integer encontroDatos;

    @JsonProperty("Respuesta")
    private List<ConsultaPolizaDetail> respuesta;


    public ConsultaPolizaResponse() {
    }


    public ConsultaPolizaResponse(Integer encontroDatos, List<ConsultaPolizaDetail> respuesta) {
        super();
        this.encontroDatos = encontroDatos;
        this.respuesta = respuesta;
    }


    public Integer getEncontroDatos() {
        return encontroDatos;
    }


    public void setEncontroDatos(Integer encontroDatos) {
        this.encontroDatos = encontroDatos;
    }


    public List<ConsultaPolizaDetail> getRespuesta() {
        return respuesta;
    }


    public void setRespuesta(List<ConsultaPolizaDetail> respuesta) {
        this.respuesta = respuesta;
    }


}
