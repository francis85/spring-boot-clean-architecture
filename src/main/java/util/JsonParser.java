/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author fraviola
 */
@Slf4j
public class JsonParser {

    private final static ObjectMapper mapper = new ObjectMapper()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    public static String toJson(Object object) throws Exception {

        try {
            return mapper.writeValueAsString(object);
        } catch (Exception ex) {
            logErrorParsing(ex);
            throw ex;
        }
    }

    public static <T> T toObject(String json, TypeReference<T> typeReference) throws Exception {
        try {
            return mapper.readValue(json, typeReference);
        } catch (Exception ex) {
            logErrorParsing(ex);
            throw ex;
        }
    }

    public static List<String> jsonToList(String json) throws Exception {

        try {
            return mapper.readValue(json, mapper.getTypeFactory()
                    .constructCollectionType(List.class, String.class));
        } catch (Exception ex) {
            logErrorParsing(ex);
            throw ex;
        }
    }

    private static void logErrorParsing(Exception e) {
        log.error("Error parsing json: {}", e.getMessage());
    }

}
