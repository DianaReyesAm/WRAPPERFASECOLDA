package com.bolivar.service.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsultaPolizaRequest {

    private String soatApiKey;
    private String soatApiToken;
    private String placa;
    private String motor;
    private String vin;

    @Override
    public String toString() {
        return "ConsultaPolizaRequest{" +
                ", placa='" + placa + '\'' +
                ", motor='" + motor + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }
}
