package com.bolivar.service.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;


@NoArgsConstructor
@Data
public class RegistroSoatResponse implements FasecoldaResponse {
    @JsonProperty("Radicado")
    private String radicado;
    @JsonProperty("Advertencias")
    private Map advertencias;

    public RegistroSoatResponse(String radicado, Map advertencias) {
        this.radicado = radicado;
        if(advertencias!=null) {
            this.advertencias = advertencias;
        }else{
            this.advertencias=new HashMap();
            this.advertencias.put("sin_advertencias","0");
        }
    }
}
