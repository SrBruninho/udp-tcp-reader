package com.gora.udptcpreader.service;

import lombok.RequiredArgsConstructor;
import org.ff4j.FF4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static com.gora.udptcpreader.config.FF4JConfig.GEOCODE_NOMINATIM;

@Service
@RequiredArgsConstructor
public class GeocodingService {

    private final WebClient webClient;
    private final FF4j ff4j;

    private static final String NOMINATIM_URL = "https://nominatim.openstreetmap.org/reverse";

    public String getAddress(double latitude, double longitude){
        if(!ff4j.check(GEOCODE_NOMINATIM))
            return GEOCODE_NOMINATIM + " unable";

        Mono<NominatimAddressDTO> address = webClient.get()
                .uri(buildUrlForReverseNominatim(longitude, latitude))
                .header("User-Agent", "udp-tcp-reader-example/1.0")
                .header("Accept-Language", "en")
                .retrieve()
                .bodyToMono(NominatimAddressDTO.class);

        return Objects.requireNonNull(address.block()).display_name;
    }

    private String buildUrlForReverseNominatim(double longitude, double latitude){
        return UriComponentsBuilder
                .fromUriString(GeocodingService.NOMINATIM_URL)
                .queryParam("lat", latitude)
                .queryParam("lon", longitude)
                .queryParam("format", MediaType.APPLICATION_JSON.getSubtype())
                .queryParam("addressdetails", 1)
                .build()
                .toUriString();
    }

    public static class NominatimAddressDTO {
        public String display_name;
    }

}
