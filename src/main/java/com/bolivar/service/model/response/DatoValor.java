package com.bolivar.service.model.response;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DatoValor {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String codigo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String valor;

}
