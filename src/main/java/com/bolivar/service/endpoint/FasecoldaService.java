package com.bolivar.service.endpoint;

import com.bolivar.service.controller.FasecoldaConsumerClient;
import com.bolivar.service.model.ErrorResponse;
import com.bolivar.service.model.GlobalResponse;
import com.bolivar.service.model.request.ConsultaPolizaRequest;
import com.bolivar.service.model.request.NovedadSoatRequest;
import com.bolivar.service.model.request.ObtieneConsecutivoRequest;
import com.bolivar.service.model.request.RegistroSoatRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.apache.log4j.BasicConfigurator;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/api")
@Log
public class FasecoldaService {


    @EJB
    private FasecoldaConsumerClient fasecoldaConsumerClient;

    @GET
    @Path("/consultapoliza")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response consultaPoliza(
            @HeaderParam("SOAT-API-TOKEN") String soatApiToken,
            @HeaderParam("SOAT-API-KEY") String soatApiKey,
            @HeaderParam("trace-request-response") String trace,
            @QueryParam(value = "placa") String placa,
            @QueryParam(value = "motor") String motor,
            @QueryParam(value = "vin") String vin) {

        BasicConfigurator.configure();

        GlobalResponse response = fasecoldaConsumerClient.consultaPoliza(getRequest(soatApiToken, soatApiKey, placa, motor, vin), trace(trace));

        return Response
                .status(response.getResponse() != null ? 200 : response.getError().getStatus())
                .entity(response.getResponse() != null ? response.getResponse() : response.getError())
                .build();
    }

    private ConsultaPolizaRequest getRequest(String soatApiToken, String soatApiKey, String placa, String motor, String vin) {
        return new ConsultaPolizaRequest(soatApiKey, soatApiToken, placa, motor, vin);
    }

    @POST
    @Path("/novedadpolizaxcompania")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response novedadSoat(
            @HeaderParam("SOAT-API-TOKEN") String soatApiToken,
            @HeaderParam("SOAT-API-KEY") String soatApiKey,
            @HeaderParam("trace-request-response") String trace,
            MultivaluedMap<String, String> params) {
        try {
            GlobalResponse response = fasecoldaConsumerClient.novedadSoat(mapRequestNovedadSoat(params), soatApiKey, soatApiToken, trace(trace));
            return Response
                    .status(response.getResponse() != null ? 200 : response.getError().getStatus())
                    .entity(response.getResponse() != null ? response.getResponse() : response.getError())
                    .build();
        } catch (Exception ex) {
            return Response
                    .status(500)
                    .entity(new ErrorResponse("WRP999", ex.getMessage()))
                    .build();
        }
    }

    public NovedadSoatRequest mapRequestNovedadSoat(MultivaluedMap<String, String> params) throws Exception {
        String json = "{}";
        for (String key : params.keySet()) {
            if (key != null && !key.isEmpty()) {
                json = key;
            }
        }
        return new ObjectMapper().readValue(json, NovedadSoatRequest.class);
    }

    @POST
    @Path("/registrarpoliza")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response registroSoat(
            @HeaderParam("SOAT-API-TOKEN") String soatApiToken,
            @HeaderParam("SOAT-API-KEY") String soatApiKey,
            @HeaderParam("trace-request-response") String trace,
            MultivaluedMap<String, String> params) {
        try {
            GlobalResponse response = fasecoldaConsumerClient.registroSoat(mapRequestRegistroSoat(params), soatApiKey, soatApiToken, trace(trace));
            return Response
                    .status(response.getResponse() != null ? 200 : response.getError().getStatus())
                    .entity(response.getResponse() != null ? response.getResponse() : response.getError())
                    .build();
        } catch (Exception ex) {
            return Response
                    .status(500)
                    .entity(new ErrorResponse("WRP999", ex.getMessage()))
                    .build();
        }
    }

    public RegistroSoatRequest mapRequestRegistroSoat(MultivaluedMap<String, String> params) throws Exception {
        String json = "{}";
        for (String key : params.keySet()) {
            if (key != null && !key.isEmpty()) {
                json = key;
            }
        }
        return new ObjectMapper().readValue(json, RegistroSoatRequest.class);
    }

    private Boolean trace(String trace) {
        return trace != null && !trace.equals("");
    }

    //dreyesam:se realiza nuevo metodo que va a obtener el consecutivo de la póliza.

    @POST
    @Path("/obtenerconsecutivo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response obtenerConsecutivo(
            @HeaderParam("trace-request-response") String trace,
            ObtieneConsecutivoRequest request) {
        try {
            GlobalResponse response = fasecoldaConsumerClient.obtieneConsecutivo(request, trace(trace));
            return Response
                    .status(response.getResponse() != null ? 200 : response.getError().getStatus())
                    .entity(response.getResponse() != null ? response.getResponse() : response.getError())
                    .build();
        } catch (Exception ex) {
            return Response
                    .status(500)
                    .entity(new ErrorResponse("WRP987", ex.getMessage()))
                    .build();
        }
    }

    @GET
    @Path("/consultaEstadoRadicado")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response consultaEstadoRadicado(
            @HeaderParam("trace-request-response") String trace,
            @QueryParam(value = "radicado") String radicado)
            {
                try {
                    GlobalResponse response = fasecoldaConsumerClient.consultaEstadoRadicado(radicado, trace(trace));
                    return Response
                            .status(response.getResponse() != null ? 200 : response.getError().getStatus())
                            .entity(response.getResponse() != null ? response.getResponse() : response.getError())
                            .build();
                } catch (Exception ex) {
                    return Response
                            .status(500)
                            .entity(new ErrorResponse("WRP987", ex.getMessage()))
                            .build();
                }
    }


}
