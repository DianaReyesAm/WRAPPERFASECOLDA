package com.bolivar.service.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ObtieneConsecutivoResponse implements FasecoldaResponse  {
    @JsonProperty("consecutivo")
    private Integer consecutivo;
}
