package ru.nsu.boxberger.divipay.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import ru.nsu.boxberger.divipay.model.AuthorizationRequest;
import ru.nsu.boxberger.divipay.model.ProfileModel;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

public class AuthorizationService extends BaseService{

    ProfileModel profile = ProfileModel.getInstance();

    public void login(AuthorizationRequest authorizationRequest) {
        ParameterizedTypeReference<Void> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<Void> responseEntity = requestToServer(authorizationRequest, ServerUrls.LOGIN_URL, HttpMethod.POST, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Login successful.");
            profile.setUsername(authorizationRequest.getUsername());
            profile.setPassword(authorizationRequest.getPassword());
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
    }
    public void registration(AuthorizationRequest authorizationRequest) {
        ParameterizedTypeReference<Void> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<Void> responseEntity = requestToServer(authorizationRequest, ServerUrls.REGISTRATION_URL, HttpMethod.POST, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Registration successful.");
            profile.setUsername(authorizationRequest.getUsername());
            profile.setPassword(authorizationRequest.getPassword());
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
    }
}
