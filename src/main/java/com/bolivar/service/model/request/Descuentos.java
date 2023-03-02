package com.bolivar.service.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Descuentos {
    private BigDecimal tipoDescuento;
    private BigDecimal descuentoComercial;
    private BigDecimal descuentoLey;

}
