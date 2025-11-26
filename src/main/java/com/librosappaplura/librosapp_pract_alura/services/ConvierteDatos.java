package com.librosappaplura.librosapp_pract_alura.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos {
    private final ObjectMapper objectMapper= new ObjectMapper();

    @Override
    public <T> T convertdata(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json.toString(), clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
