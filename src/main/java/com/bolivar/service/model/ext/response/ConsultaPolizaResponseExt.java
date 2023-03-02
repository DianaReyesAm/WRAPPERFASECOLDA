package com.bolivar.service.model.ext.response;

import com.bolivar.service.model.response.ConsultaPolizaDetail;
import com.bolivar.service.model.response.FasecoldaResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultaPolizaResponseExt implements FasecoldaResponse {

    @JsonProperty("encontroDatos")
    private Integer encontroDatos;

    @JsonProperty("respuesta")
    private List<ConsultaPolizaDetailExt> respuesta;


    public ConsultaPolizaResponseExt() {
    }


    public ConsultaPolizaResponseExt(Integer encontroDatos, List<ConsultaPolizaDetailExt> respuesta) {
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


    public List<ConsultaPolizaDetailExt> getRespuesta() {
        return respuesta;
    }


    public void setRespuesta(List<ConsultaPolizaDetailExt> respuesta) {
        this.respuesta = respuesta;
    }


}
