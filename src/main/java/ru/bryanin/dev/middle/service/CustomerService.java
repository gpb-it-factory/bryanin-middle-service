package ru.bryanin.dev.middle.service;

import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.bryanin.dev.middle.client.WebClient;

import static ru.bryanin.dev.middle.utils.BotResponse.*;

@Service
public class CustomerService {

    private final WebClient webClient;

    public CustomerService(WebClient webClient) {
        this.webClient = webClient;
    }

    public String registerCustomer(@NonNull Long telegramId) {
        try {
            ResponseEntity<?> responseEntity = webClient.registrationResponse(telegramId);
            if(responseEntity.getStatusCode().value() == 204) {
                return CODE_204.getDescription();
            };
        } catch (Exception e) {
            if (e.getMessage().contains("409")) {
                return CODE_409.getDescription();
            } else if (e.getMessage().contains("400") || e.getMessage().contains("401") || e.getMessage().contains("403") || e.getMessage().contains("404") || e.getMessage().contains("405")) {
                return CODE_4xx.getDescription();
            } else if (e.getMessage().contains("500") || e.getMessage().contains("502") || e.getMessage().contains("503")) {
                return CODE_5xx.getDescription();
            }
            return UNKNOWN_ERROR.getDescription();
        }
        return UNKNOWN_ERROR.getDescription();
    }


}
