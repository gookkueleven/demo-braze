package com.example.demo.configurations;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;

@Data
@Configuration
public class BrazeConfiguration {

    @Value("${braze.api.key}")
    private String apiKey;

    @Value("${braze.host.name}")
    private String hostName;

    @Value("${braze.endpoint.user.track}")
    private String userTrackEndPoint;

    @Value("${braze.endpoint.user.delete}")
    private String userDeleteEndPoint;

    public String getUserTrackEndPoint() {
        return UriComponentsBuilder.fromUriString(hostName)
                .path(userTrackEndPoint)
                .toUriString();
    }

    public String getUserDeleteEndPoint() {
        return UriComponentsBuilder.fromUriString(hostName)
                .path(userDeleteEndPoint)
                .toUriString();
    }
}
