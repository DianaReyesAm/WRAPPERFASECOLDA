package com.bolivar.service.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NovedadSoatRequest {
    private String tipoNovedad;
    private String fechaNovedad;
    private BigDecimal consecutivoNovedad;
    private String numeroPolizaReemplaza;
    private PolizaNovedad polizaNovedad;


}
