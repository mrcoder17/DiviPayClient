package ru.nsu.boxberger.divipay.service;

import org.springframework.http.*;
import ru.nsu.boxberger.divipay.model.AuthorizationRequest;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

public class AuthorizationService extends BaseService{

    public void login(AuthorizationRequest authorizationRequest) {
        ResponseEntity<AuthorizationRequest> responseEntity = requestToServer(authorizationRequest, ServerUrls.LOGIN_URL, HttpMethod.POST, AuthorizationRequest.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Login successful.");
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
    }
    public void registration(AuthorizationRequest authorizationRequest) {
        ResponseEntity<AuthorizationRequest> responseEntity = requestToServer(authorizationRequest, ServerUrls.REGISTRATION_URL, HttpMethod.POST, AuthorizationRequest.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Registration successful.");
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
    }
}
