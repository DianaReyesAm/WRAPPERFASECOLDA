package com.bolivar.service.model.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusinessError {
    private Long id;
    private String descripcion;
    private String tipo;
    private String msgErrorOrcl;
    private String msgErrorOrcl1;
}
