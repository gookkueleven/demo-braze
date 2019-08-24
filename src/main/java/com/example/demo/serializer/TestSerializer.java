package com.example.demo.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@JsonComponent
public class TestSerializer extends JsonSerializer<String> {

    @Value("${thai.currency.thai-symbol}")
    private String thaiCurrencySymbol;

    @Override
    public void serialize(String stringValue, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (stringValue != null) {
            jsonGenerator.writeString(String.format("%s %s", thaiCurrencySymbol, stringValue));
        }
    }
}
