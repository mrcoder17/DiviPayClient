package ru.nsu.boxberger.divipay.api;

import org.springframework.web.reactive.function.client.WebClient;
import ru.nsu.boxberger.divipay.model.RegistrationModel;
public class RegistrationApiClient {
    private static final String REGISTRATION_URL = "http://localhost:8080/registration";
    private final WebClient webClient;

    public RegistrationApiClient() {
        this.webClient = WebClient.create();
    }

}
