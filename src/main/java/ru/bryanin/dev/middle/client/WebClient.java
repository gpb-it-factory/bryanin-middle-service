package ru.bryanin.dev.middle.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class WebClient {

    @Value("${backend-service.baseURL}")
    private String backendServiceBaseURL;
    private final RestClient restClient;

    public WebClient() {
        restClient = RestClient.builder().baseUrl(backendServiceBaseURL).build();
    }

    public ResponseEntity<?> registrationResponse(Long telegramId) {
        String json = "{" +
                "\"telegramId\"" + ":" + "\"" + telegramId + "\"" +
                '}';
        System.out.println(json);
        ResponseEntity<?> result = restClient
                .post()
                .uri(backendServiceBaseURL + "/users")
                .accept(APPLICATION_JSON)
                .body(json)
                .retrieve()
                .toBodilessEntity();
        return result;
    }
}
