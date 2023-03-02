package com.bolivar.service.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Propietario {
    private String tipoIdentificacion;
    private String identificacion;
    private String nombre;
}
