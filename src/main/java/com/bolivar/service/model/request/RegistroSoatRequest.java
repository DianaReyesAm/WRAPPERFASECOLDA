package com.bolivar.service.model.request;
import com.bolivar.service.model.response.FasecoldaResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroSoatRequest implements FasecoldaResponse {
    private DatosPoliza datosPoliza;
    private Vehiculo vehiculo;
    private Propietario propietario;
    private ContribucionTrans contribucionesTransferencias;
    private Descuentos descuentos;
}
