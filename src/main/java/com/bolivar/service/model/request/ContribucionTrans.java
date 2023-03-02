package com.bolivar.service.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContribucionTrans {
    private BigDecimal valorContribucionFOSYGA;
    private BigDecimal valorTransferenciaFONSAT;
    private BigDecimal valorTransferenciaAgenciaNacionalSeguridadVial;

}
