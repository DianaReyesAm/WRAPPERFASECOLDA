package com.bolivar.service.model.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DataHeaderResponse {
    private int codRespuesta;
    private List<BusinessError> errores;

}
