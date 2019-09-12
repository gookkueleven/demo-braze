package com.example.demo.configurations;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.Duration;

@Configuration
public class Resilience4JConfiguration {

    @Bean
    @Primary
    @Qualifier("mainCircuit")
    public CircuitBreaker createCircuitBreaker(CircuitBreakerRegistry registry) {
        return registry.circuitBreaker("testCustomCircuitBreaker");
    }

    @Bean
    @Qualifier("secondCircuit")
    public CircuitBreaker createSecondCircuitBreaker(CircuitBreakerRegistry registry) {
        return registry.circuitBreaker("testCustomCircuitBreaker2");
    }

    @Bean
    public CircuitBreakerRegistry createRegistry(CircuitBreakerConfig config) {
        return CircuitBreakerRegistry.of(config);
    }

    @Bean
    public CircuitBreakerConfig createCustomConfig() {
        return CircuitBreakerConfig.custom()
                .ringBufferSizeInClosedState(100)
                .ringBufferSizeInHalfOpenState(10)
                .waitDurationInOpenState(Duration.ofMinutes(10))
                .failureRateThreshold(80)
                .build();
    }
}
