package com.bolivar.service.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ObtieneEstadoRadicadoResponse implements FasecoldaResponse  {
    @JsonProperty("radicado")
    private String radicado;
    @JsonProperty("poliza")
    private String poliza;
    @JsonProperty("tipoMovimiento")
    private String tipoMovimiento;
    @JsonProperty("consecutivoNovedad")
    private Integer consecutivoNovedad;
    @JsonProperty("estado")
    private String estado;
    @JsonProperty("fechaRecibido")
    private String fechaRecibido;
    @JsonProperty("motivoRechazo")
    private String motivoRechazo;
}
