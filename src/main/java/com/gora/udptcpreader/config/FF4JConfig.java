package com.gora.udptcpreader.config;

import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FF4JConfig {

    public static final String GEOCODE_NOMINATIM = "geocodeNominatim";

    @Bean
    public FF4j ff4j() {
        FF4j ff4j = new FF4j();
        ff4j.createFeature(new Feature(GEOCODE_NOMINATIM, false));
        ff4j.setEnableAudit(true);
        ff4j.setAutocreate(true);

        return ff4j;
    }
}
