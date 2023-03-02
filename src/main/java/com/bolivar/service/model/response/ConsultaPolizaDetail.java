package com.bolivar.service.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultaPolizaDetail {

    @JsonProperty("Compania")
    private String compania;
    @JsonProperty("Estado")
    private String estado;
    @JsonProperty("NumeroPoliza")
    private String numeroPoliza;
    @JsonProperty("FechaInicioVigencia")
    private String fechaInicioVigencia;
    @JsonProperty("FechaFinVigencia")
    private String fechaFinVigencia;
    @JsonProperty("Placa")
    private String placa;
    @JsonProperty("Vin")
    private String vin;
    @JsonProperty("Motor")
    private String motor;
    @JsonProperty("Chasis")
    private String chasis;
    @JsonProperty("CruzoPor")
    private String cruzoPor;
    @JsonProperty("DiasParaVencer")
    private String diasParaVencer;

    public ConsultaPolizaDetail() {
    }

    public ConsultaPolizaDetail(String compania, String estado, String numeroPoliza, String fechaInicioVigencia,
                                String fechaFinVigencia, String placa, String vin, String motor, String chasis, String cruzoPor,
                                String diasParaVencer) {
        super();
        this.compania = compania;
        this.estado = estado;
        this.numeroPoliza = numeroPoliza;
        this.fechaInicioVigencia = fechaInicioVigencia;
        this.fechaFinVigencia = fechaFinVigencia;
        this.placa = placa;
        this.vin = vin;
        this.motor = motor;
        this.chasis = chasis;
        this.cruzoPor = cruzoPor;
        this.diasParaVencer = diasParaVencer;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public String getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(String fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public String getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    public void setFechaFinVigencia(String fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getCruzoPor() {
        return cruzoPor;
    }

    public void setCruzoPor(String cruzoPor) {
        this.cruzoPor = cruzoPor;
    }

    public String getDiasParaVencer() {
        return diasParaVencer;
    }

    public void setDiasParaVencer(String diasParaVencer) {
        this.diasParaVencer = diasParaVencer;
    }


}
