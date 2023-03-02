package com.bolivar.service.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PolizaNovedad {

    private DatosPoliza datosPoliza;
    private Vehiculo vehiculo;
    private Propietario propietario;
    private ContribucionTrans contribucionesTransferencias;
    private Descuentos descuentos;

}
