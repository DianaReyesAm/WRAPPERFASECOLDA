package com.bolivar.service.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehiculo {
    private String placa;
    private String numeroMotor;
    private String numeroChasis;
    private String vin;
    private Integer modelo;
    private String marca;
    private Integer clase;
    private Integer servicio;
    private Integer cilindraje;
    private Integer capacidad;
    private Integer numeroPasajeros;
    private Integer pais;
    private Integer tipoCombustible;
    private Integer tipoCarroceria;
    private String  fechaMatricula;
    private String  organismoTransito;
}
