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
        ParameterizedTypeReference<UserRequest> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<UserRequest> responseEntity = requestToServer(userRequest, ServerUrls.LOGIN_URL, HttpMethod.POST, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Login successful.");
            UserRequest user = responseEntity.getBody();

            profile.setUserID(user.getUserID());
            profile.setUsername(user.getUsername());
            profile.setPassword(user.getPassword());
            profile.setAvatar(user.getAvatar());

            if (user.getName() != null) profile.setName(user.getName());
            if (user.getPhone() != null) profile.setPhone(user.getPhone());
            if (user.getDebt() != null) profile.setDebt(user.getDebt());
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
    }
    public void registration(String username, String password) {
        UserRequest user = new UserRequest(username, password);
        ParameterizedTypeReference<UserRequest> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<UserRequest> responseEntity = requestToServer(user, ServerUrls.REGISTRATION_URL, HttpMethod.POST, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Registration successful.");
            user = responseEntity.getBody();
            profile.setUserID(user.getUserID());
            profile.setUsername(username);
            profile.setPassword(password);
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
    }
}
