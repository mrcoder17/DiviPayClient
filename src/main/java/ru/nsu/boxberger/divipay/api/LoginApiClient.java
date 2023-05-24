package ru.nsu.boxberger.divipay.api;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import ru.nsu.boxberger.divipay.model.LoginRequest;

public class LoginApiClient {
    private static final String LOGIN_URL = "http://localhost:8080/api/login";
    public void login(LoginRequest loginRequest) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<LoginRequest> requestEntity = new HttpEntity<>(loginRequest, httpHeaders);

        ResponseEntity<Void> responseEntity = restTemplate.exchange(LOGIN_URL, HttpMethod.POST, requestEntity, Void.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Login successful.");
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
    }


}
