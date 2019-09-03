package com.example.demo.models.request;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Setter;

@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserTrackRequest extends BaseBrazeRequest {

    @JsonProperty("attributes")
    private List<Map<String, String>> userAttributesList;

    @JsonProperty("events")
    private List<Map<String, String>> eventAttributesList;

    @JsonProperty("purchases")
    private List<Map<String, String>> purchaseAttributesList;
}
