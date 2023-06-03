package ru.nsu.boxberger.divipay.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import ru.nsu.boxberger.divipay.model.ProfileModel;
import ru.nsu.boxberger.divipay.model.UserRequest;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

public class AuthorizationService extends BaseService{

    ProfileModel profile = ProfileModel.getInstance();

    public void login(String username, String password) {
        UserRequest userRequest = new UserRequest(username, password);
        ParameterizedTypeReference<Long> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<Long> responseEntity = requestToServer(userRequest, ServerUrls.LOGIN_URL, HttpMethod.POST, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Login successful.");
            Long userID = responseEntity.getBody();
            if (userID != null) {
                profile.setUserID(userID);
                profile.setUsername(username);
                profile.setPassword(password);
            }
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
    }
    public void registration(String username, String password) {
        UserRequest userRequest = new UserRequest(username, password);
        ParameterizedTypeReference<Long> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<Long> responseEntity = requestToServer(userRequest, ServerUrls.REGISTRATION_URL, HttpMethod.POST, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Registration successful.");
            Long userID = responseEntity.getBody();
            if (userID != null) {
                profile.setUserID(userID);
                profile.setUsername(username);
                profile.setPassword(password);
            }
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
    }
}
