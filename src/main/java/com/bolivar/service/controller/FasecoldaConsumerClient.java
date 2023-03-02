package com.bolivar.service.controller;

import javax.ejb.Local;

import com.bolivar.service.exception.TokenException;
import com.bolivar.service.model.GlobalResponse;
import com.bolivar.service.model.request.*;

@Local
public interface FasecoldaConsumerClient {

	GlobalResponse consultaPoliza(ConsultaPolizaRequest request, Boolean trace);

	GlobalResponse novedadSoat(NovedadSoatRequest request, String apiKey, String token, Boolean trace);

	GlobalResponse registroSoat(RegistroSoatRequest request, String apiKey, String token, Boolean trace);

	GlobalResponse obtieneConsecutivo (ObtieneConsecutivoRequest request, Boolean trace);

	GlobalResponse consultaEstadoRadicado(String request, Boolean trace);

	String generaToken(GeneraTokenRequest request) throws TokenException;
}
