package com.bolivar.service.model.ext.response;

import com.bolivar.service.model.response.FasecoldaResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import static com.fasterxml.jackson.annotation.JsonInclude.Include;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroSoatResponseExt implements FasecoldaResponse {
    @JsonProperty("radicado")
    private String radicado;
    @JsonInclude(Include.NON_NULL)
    @JsonProperty("advertencias")
    private Map advertencias;

}
