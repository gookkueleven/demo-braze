package com.example.demo.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TestSerializer extends JsonSerializer<String> {

    @Value("${thai.currency.thai-symbol}")
    private String currencySymbol;

    @Override
    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
       jsonGenerator.writeString(String.format("%s %s", currencySymbol, s));
    }
}
