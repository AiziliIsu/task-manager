package com.example.taskmanager.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class NullKeySerializer extends JsonSerializer<Object> {
    @Override
    public void serialize(Object key, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        // If key is null, write "unknown"; otherwise, write the key's string representation
        gen.writeFieldName(key == null ? "unknown" : key.toString());
    }
}
