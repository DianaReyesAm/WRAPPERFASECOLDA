package com.bolivar.service.controller;

import com.bolivar.service.exception.TokenException;
import com.bolivar.service.mapper.ConsultaPolizaMapper;
import com.bolivar.service.model.ErrorResponse;
import com.bolivar.service.model.ErrorResponseObtieneConsecutivo;
import com.bolivar.service.model.GlobalResponse;
import com.bolivar.service.model.ext.response.ConsultaPolizaResponseExt;
import com.bolivar.service.model.ext.response.RegistroSoatResponseExt;
import com.bolivar.service.model.request.*;
import com.bolivar.service.model.response.ConsultaPolizaResponse;
import com.bolivar.service.model.response.ObtieneConsecutivoResponse;
import com.bolivar.service.model.response.ObtieneEstadoRadicadoResponse;
import com.bolivar.service.model.response.RegistroSoatResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.client.urlconnection.URLConnectionClientHandler;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import lombok.extern.java.Log;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.core.MultivaluedMap;

import static com.bolivar.service.config.PropertiesManager.*;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Log
@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class FasecoldaConsumerClientImpl implements FasecoldaConsumerClient {

    public GlobalResponse consultaPoliza(ConsultaPolizaRequest request, Boolean trace) {

        ConsultaPolizaResponse respOK = null;
        ConsultaPolizaResponseExt fasecoldaResponse = null;
        ErrorResponse respError = null;
        ObjectMapper objectMapper = new ObjectMapper();
        String apiResponse = "{}";
        String apiRequest = "{}";

        try {
            apiRequest = objectMapper.writeValueAsString(request);
            MultivaluedMap<String, String> queryParams = createExternalParams(request);

            String apiToken = generaToken(getTokenRequest());
            if (apiToken == null) {
                throw new NullPointerException("EL TOKEN VIENE NULO");
            }

            ClientResponse response = getResource()
                    .path(getProperty(FASECOLDA_CONSULTA_POLIZA))
                    .queryParams(queryParams)
                    .header("Content-Type", APPLICATION_JSON)
                    .header("Authorization", "Bearer " + apiToken)
                    .get(ClientResponse.class);

            log.info(":: Llamado a servicio " + getProperty(FASECOLDA_URI) + "/" + getProperty(FASECOLDA_CONSULTA_POLIZA) + " con status = " + response.getStatus() + " ::");
            log.info(":: Parametros = " + request.toString() + " ::");

            apiResponse = response.getEntity(String.class);

            if (response.getStatus() == 200) {
                log.info("STATUS 200 - > Mapping to Respuesta.class");

                fasecoldaResponse = objectMapper.readValue(apiResponse, ConsultaPolizaResponseExt.class);
                respOK = new ConsultaPolizaResponse(fasecoldaResponse.getEncontroDatos(), ConsultaPolizaMapper.map(fasecoldaResponse.getRespuesta()));
            } else {
                log.info("NOT STATUS 200 - > Mapping to ErrorResponse.class");

                respError = objectMapper.readValue(apiResponse, ErrorResponse.class);
                respError.setStatus(response.getStatus());
                if (trace) {
                    respError.setResponse(apiResponse);
                    respError.setRequest(apiRequest);
                }
            }

        } catch (Exception e) {
            respError = new ErrorResponse("WPR001", e.getMessage());
            respError.setStatus(500);
            if (trace) {
                respError.setResponse(apiResponse);
                respError.setRequest(apiRequest);
            }
            e.printStackTrace();
        }
        return new GlobalResponse(respOK, respError);

    }

    @Override
    public GlobalResponse novedadSoat(NovedadSoatRequest request, String apiKey, String token, Boolean trace) {
        RegistroSoatResponse respOK = null;
        ErrorResponse respError = null;
        ObjectMapper objectMapper = new ObjectMapper();
        String apiResponse = "{}";
        String apiRequest = "{}";

        try {
            apiRequest = objectMapper.writeValueAsString(request);

            String apiToken = generaToken(getTokenRequest());
            if (apiToken == null) {
                throw new NullPointerException("EL TOKEN VIENE NULO");
            }

            ClientResponse response = getResource()

                    .path(getProperty(FASECOLDA_NOVEDAD_SOAT))
                    .header("Content-Type", APPLICATION_JSON)
                    .header("Authorization", "Bearer " + apiToken)
                    .post(ClientResponse.class, apiRequest);


            log.info(":: Llamado a servicio " + getProperty(FASECOLDA_URI) + "/" + getProperty(FASECOLDA_NOVEDAD_SOAT) + " con status = " + response.getStatus() + " ::");
            apiResponse = response.getEntity(String.class);

            if (response.getStatus() == 200 || response.getStatus() == 201) {
                log.info("STATUS 200 - > Mapping to Respuesta.class");

                RegistroSoatResponseExt ext = objectMapper.readValue(apiResponse, RegistroSoatResponseExt.class);
                respOK = new RegistroSoatResponse(ext.getRadicado(), ext.getAdvertencias());
            } else {
                log.info("NOT STATUS 200 - > Mapping to ErrorResponse.class");
                respError = objectMapper.readValue(apiResponse, ErrorResponse.class);
                respError.setStatus(response.getStatus());
                if (trace) {
                    respError.setResponse(apiResponse);
                    respError.setRequest(apiRequest);
                }
            }

        } catch (NullPointerException n) {
            respError = new ErrorResponse("TOKEN001", n.getMessage());
            respError.setStatus(500);
            n.printStackTrace();

        } catch (Exception e) {
            respError = new ErrorResponse("WPR002", e.getMessage());
            respError.setStatus(500);
            if (trace) {
                respError.setResponse(apiResponse);
                respError.setRequest(apiRequest);
            }
            e.printStackTrace();
        }
        return new GlobalResponse(respOK, respError);
    }

    @Override
    public GlobalResponse registroSoat(RegistroSoatRequest request, String apiKey, String token, Boolean trace) {
        RegistroSoatResponse respOK = null;
        ErrorResponse respError = null;
        ObjectMapper objectMapper = new ObjectMapper();
        String apiResponse = "{}";
        String apiRequest = "{}";

        try {
            apiRequest = objectMapper.writeValueAsString(request);

            String apiToken = generaToken(getTokenRequest());
            if (apiToken == null) {
                throw new NullPointerException("EL TOKEN VIENE NULO");
            }

            ClientResponse response = getResource()
                    .path(getProperty(FASECOLDA_REGISTRAR_SOAT))
                    .header("Content-Type", APPLICATION_JSON)
                    .header("Authorization", "Bearer " + apiToken)
                    .post(ClientResponse.class, apiRequest);

            log.info(":: Llamado a servicio " + getProperty(FASECOLDA_URI) + "/" + getProperty(FASECOLDA_REGISTRAR_SOAT) + " con status = " + response.getStatus() + " ::");
            apiResponse = response.getEntity(String.class);


            if (response.getStatus() == 200 || response.getStatus() == 201) {
                log.info("STATUS 200 - > Mapping to Respuesta.class");

                RegistroSoatResponseExt ext = objectMapper.readValue(apiResponse, RegistroSoatResponseExt.class);
                respOK = new RegistroSoatResponse(ext.getRadicado(), ext.getAdvertencias());
            } else {
                log.info("NOT STATUS 200 - > Mapping to ErrorResponse.class");

                respError = objectMapper.readValue(apiResponse, ErrorResponse.class);
                respError.setStatus(response.getStatus());
                if (trace) {
                    respError.setResponse(apiResponse);
                    respError.setRequest(apiRequest);
                }
            }

        } catch (TokenException n) {
            respError = new ErrorResponse("TOKEN002", n.getCause() != null ? n.getCause().getMessage() : n.getMessage());
            respError.setStatus(500);
            n.printStackTrace();

        } catch (Exception e) {
            respError = new ErrorResponse("WPR003", e.getMessage());
            respError.setStatus(500);
            if (trace) {
                respError.setResponse(apiResponse);
                respError.setRequest(apiRequest);
            }
            e.printStackTrace();
        }
        return new GlobalResponse(respOK, respError);
    }

    private MultivaluedMap<String, String> createExternalParams(ConsultaPolizaRequest request) {
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();

        if (request.getPlaca() != null) {
            queryParams.add("placa", request.getPlaca().toUpperCase());
        }

        if (request.getMotor() != null) {
            queryParams.add("motor", request.getMotor().toUpperCase());
        }

        if (request.getVin() != null) {
            queryParams.add("vin", request.getVin().toUpperCase());
        }
        return queryParams;
    }

    private WebResource getResource() {
        Client wsFasecoldaClient = Client.create(getConfig());
        wsFasecoldaClient.setConnectTimeout(FASECOLDA_TIME_OUT); //DREYESAM: SE COLOCA TIME OUT DEL SERVICIO.
        wsFasecoldaClient.setReadTimeout(FASECOLDA_TIME_OUT);//DREYESAM: SE COLOCA TIME OUT DEL SERVICIO.
        WebResource resource = wsFasecoldaClient.resource(getProperty(FASECOLDA_URI));
        return resource;
    }

    private ClientConfig getConfig() {
        ClientConfig config = new DefaultClientConfig();
        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        config.getFeatures().put(URLConnectionClientHandler.PROPERTY_HTTP_URL_CONNECTION_SET_METHOD_WORKAROUND, true);
        return config;
    }

    // AJUSTES DIANA PARA TOKEN

    @Override
    public String generaToken(GeneraTokenRequest request) throws TokenException {
        String responseToken = null;
        ErrorResponse respError = null;
        ObjectMapper objectMapper = new ObjectMapper();
        String apiResponse = "{}";
        String apiRequest = "{}";

        try {
            apiRequest = objectMapper.writeValueAsString(request);

            ClientResponse response = getResource()
                    .path(getProperty(FASECOLDA_GENERAR_TOKEN))
                    .header("Content-Type", APPLICATION_JSON)
                    .post(ClientResponse.class, apiRequest);

            log.info(":: Llamado a servicio " + getProperty(FASECOLDA_URI) + "/" + getProperty(FASECOLDA_GENERAR_TOKEN) + " con status = " + response.getStatus() + " ::");
            responseToken = response.getEntity(String.class);


            if (response.getStatus() == 200) {
                responseToken = responseToken.replace("\"", "");
                log.info("STATUS 200 - > TOKEN GENERADO CORRECTAMENTE----->[" + responseToken + "]");
                return responseToken;
            } else {
                log.info("NOT STATUS 200 - > Mapping to ErrorResponse.class");

                respError = objectMapper.readValue(apiResponse, ErrorResponse.class);
                respError.setStatus(response.getStatus());

                throw new TokenException("Token Service NOT STATUS " + response.getStatus() + " - >" + responseToken, respError);
            }

        } catch (Exception e) {
            respError = new ErrorResponse("WPR004", e.getMessage());
            respError.setStatus(500);
            e.printStackTrace();
            throw new TokenException("NOT STATUS 200 - > Mapping to ErrorResponse.class", e, respError);
        }
        //return null;
    }

    public GeneraTokenRequest getTokenRequest() {
        GeneraTokenRequest generaTokenRequest = new GeneraTokenRequest();
        generaTokenRequest.setUsuario(getProperty(FASECOLDA_USUARIO_TOKEN));
        generaTokenRequest.setClave(getProperty(FASECOLDA_CLAVE_TOKEN));
        generaTokenRequest.setServicio(getProperty(FASECOLDA_SERVICIO_TOKEN));

        return generaTokenRequest;

    }

    @Override
    public GlobalResponse obtieneConsecutivo(ObtieneConsecutivoRequest request, Boolean trace) {
        ObtieneConsecutivoResponse respOK = null;
        ErrorResponseObtieneConsecutivo respError = null;
        ObjectMapper objectMapper = new ObjectMapper();
        String apiResponse = "{}";
        String apiRequest = "{}";

        try {
            apiRequest = objectMapper.writeValueAsString(request);

            String apiToken = generaToken(getTokenRequest());

            ClientResponse response = getResource()
                    .path(getProperty(FASECOLDA_OBTENER_CONSECUTIVO))
                    .header("Content-Type", APPLICATION_JSON)
                    .header("Authorization", "Bearer " + apiToken)
                    .post(ClientResponse.class, apiRequest);

            log.info(":: Llamado a servicio " + getProperty(FASECOLDA_URI) + "/" + getProperty(FASECOLDA_OBTENER_CONSECUTIVO) + " con status = " + response.getStatus() + " ::");
            apiResponse = response.getEntity(String.class);


            if (response.getStatus() == 200 || response.getStatus() == 201) {
                log.info("STATUS 200 - > Mapping to Respuesta.class");
                Integer consecutivo = objectMapper.readValue(apiResponse, Integer.class);
                respOK = new ObtieneConsecutivoResponse(consecutivo);
            } else {
                log.info("NOT STATUS 200 - > Mapping to ErrorResponse.class");

                respError = objectMapper.readValue(apiResponse, ErrorResponseObtieneConsecutivo.class);
                respError.setStatus(response.getStatus());
                if (trace) {
                    respError.setResponse(apiResponse);
                    respError.setRequest(apiRequest);
                }
            }

        } catch (TokenException n) {
            respError = new ErrorResponseObtieneConsecutivo("TOKEN002", n.getCause() != null ? n.getCause().getMessage() : n.getMessage());
            respError.setStatus(500);
            n.printStackTrace();

        } catch (Exception e) {
            respError = new ErrorResponseObtieneConsecutivo("WPR003", e.getMessage());
            respError.setStatus(500);
            if (trace) {
                respError.setResponse(apiResponse);
                respError.setRequest(apiRequest);
            }
            e.printStackTrace();
        }
        return new GlobalResponse(respOK, respError);
    }


//    public static void main(String[] args) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            String apiRequest = objectMapper.writeValueAsString(new FasecoldaConsumerClientImpl().getTokenRequest());
//            log.info("API REQUEST--->" + apiRequest);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }


    // Servicio que me indica en que estado se encuentra mi radicado.

    public GlobalResponse consultaEstadoRadicado(String radicado, Boolean trace) {

        ObtieneEstadoRadicadoResponse respOK = null;
        ErrorResponseObtieneConsecutivo respError = null;
        ObjectMapper objectMapper = new ObjectMapper();
        String apiResponse = "{}";
        String apiRequest = "{}";

        try {

            apiRequest = objectMapper.writeValueAsString(radicado);
            String apiToken = generaToken(getTokenRequest());
            MultivaluedMap<String, String> parameter = new MultivaluedMapImpl();

            if (radicado != null) {
                parameter.add("radicado", radicado);
            }

            ClientResponse response = getResource()
                    .path(getProperty(FASECOLDA_CONSULTAR_ESTADO_RADICADO))
                    .queryParams(parameter)
                    .header("Content-Type", APPLICATION_JSON)
                    .header("Authorization", "Bearer " + apiToken)
                    .get(ClientResponse.class);

            log.info(":: Llamado a servicio " + getProperty(FASECOLDA_URI) + "/" + getProperty(FASECOLDA_OBTENER_CONSECUTIVO) + " con status = " + response.getStatus() + " ::");
            log.info(":: Parametros = " + radicado.toString() + " ::");

            apiResponse = response.getEntity(String.class);

            if (response.getStatus() == 200 || response.getStatus() == 201) {
                log.info("STATUS 200 - > Mapping to Respuesta.class");
                respOK = objectMapper.readValue(apiResponse, ObtieneEstadoRadicadoResponse.class);
            } else {
                log.info("NOT STATUS 200 - > Mapping to ErrorResponse.class");

                respError = objectMapper.readValue(apiResponse, ErrorResponseObtieneConsecutivo.class);
                respError.setStatus(response.getStatus());
                if (trace) {
                    respError.setResponse(apiResponse);
                    respError.setRequest(apiRequest);
                }
            }

        } catch (TokenException n) {
            respError = new ErrorResponseObtieneConsecutivo("TOKEN003", n.getCause() != null ? n.getCause().getMessage() : n.getMessage());
            respError.setStatus(500);
            n.printStackTrace();

        } catch (Exception e) {
            respError = new ErrorResponseObtieneConsecutivo("WPR005", e.getMessage());
            respError.setStatus(500);
            if (trace) {
                respError.setResponse(apiResponse);
                respError.setRequest(apiRequest);
            }
            e.printStackTrace();
        }
        return new GlobalResponse(respOK, respError);

    }


}
