package com.bolivar.service.mapper;

import com.bolivar.service.model.ext.response.ConsultaPolizaDetailExt;
import com.bolivar.service.model.response.ConsultaPolizaDetail;

import java.util.ArrayList;
import java.util.List;

public class ConsultaPolizaMapper {
    public static List<ConsultaPolizaDetail> map(List<ConsultaPolizaDetailExt> detail) {
        List<ConsultaPolizaDetail> result = new ArrayList<ConsultaPolizaDetail>();
        if (detail != null) {
            for (ConsultaPolizaDetailExt data : detail) {
                ConsultaPolizaDetail info = new ConsultaPolizaDetail();
                info.setCompania(data.getCompania());
                info.setEstado(data.getEstado());
                info.setNumeroPoliza(data.getNumeroPoliza());
                info.setFechaInicioVigencia(data.getFechaInicioVigencia());
                info.setFechaFinVigencia(data.getFechaFinVigencia());
                info.setPlaca(data.getPlaca());
                info.setVin(data.getVin());
                info.setMotor(data.getMotor());
                info.setChasis(data.getChasis());
                info.setCruzoPor(data.getCruzoPor());
                info.setDiasParaVencer(data.getDiasParaVencer());
                result.add(info);
            }

        }

        return result;
    }
}
