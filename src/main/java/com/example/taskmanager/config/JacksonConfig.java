package com.example.taskmanager.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();

        // Register custom serializer for null keys
        module.addKeySerializer(Object.class, new NullKeySerializer());

        // Register the module with the ObjectMapper
        mapper.registerModule(module);
        return mapper;
    }
}
