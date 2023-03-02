package com.bolivar.service.config;

import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    public static final String FASECOLDA_URI = "fasecolda.api.host";

    public static final String FASECOLDA_CONSULTA_POLIZA = "fasecolda.api.consultapoliza";

    public static final String FASECOLDA_NOVEDAD_SOAT="fasecolda.api.novedadsoat";

    public static final String FASECOLDA_REGISTRAR_SOAT="fasecolda.api.registrosoat";

    public static final String FASECOLDA_GENERAR_TOKEN="fasecolda.api.generatoken";

    public static final String FASECOLDA_USUARIO_TOKEN="fasecolda.api.user";

    public static final String FASECOLDA_CLAVE_TOKEN="fasecolda.api.clave";

    public static final String FASECOLDA_SERVICIO_TOKEN="fasecolda.api.servicio";

    public static final String FASECOLDA_OBTENER_CONSECUTIVO="fasecolda.api.obtieneconsecutivo";

    public static final String FASECOLDA_CONSULTAR_ESTADO_RADICADO="fasecolda.api.obtenerestadoradicado";

    public static final Integer FASECOLDA_TIME_OUT=5000; //DREYESAM: AGREGO EL VALOR DE LOS MILISEGUNDOS.

    private static Properties properties;

    public static String getProperty(String key) {
        if(properties == null) {
            properties = new Properties();
            try {
                properties.load(PropertiesManager.class.getResourceAsStream("/app.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties.getProperty(key);
    }
}
