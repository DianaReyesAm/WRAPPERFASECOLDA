package com.bolivar.service.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DatosPoliza {
    private Integer compania;
    private String numeroPapeleria;
    private String numeroPoliza;
    private String fechaExpedicion;
    private String fechaInicioVigencia;
    private String fechaFinVigencia;
    private Integer codigoTarifaSOAT;
    private Integer municipioExpedicion;
    private Integer departamentoExpedicion;
    private Integer municipioTomador;
    private Integer departamentoTomador;
    private String fechaContabilizacion;
    private BigDecimal valorPrima;
    private BigDecimal valorComision;
    private BigDecimal canalComercializacion;
    private String identificacionIntermediaro;


}
