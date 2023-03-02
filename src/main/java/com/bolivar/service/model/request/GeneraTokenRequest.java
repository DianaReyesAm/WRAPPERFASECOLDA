package com.bolivar.service.model.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data


public class GeneraTokenRequest {
    String usuario;
    String clave;
    String servicio;
}
