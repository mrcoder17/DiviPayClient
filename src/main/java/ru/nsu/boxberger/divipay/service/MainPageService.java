package ru.nsu.boxberger.divipay.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.http.*;
import ru.nsu.boxberger.divipay.model.ProfileRequest;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

import java.util.List;
import java.util.Objects;

public class MainPageService extends BaseService {

    public List<String> getUsernamesFromServer() {
        String url = ServerUrls.USERS_URL;
        ParameterizedTypeReference<List<String>> responseType = new ParameterizedTypeReference<>() {};

        ResponseEntity<List<String>> responseEntity = requestToServer(null, url, HttpMethod.GET, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Failed to retrieve usernames from server. Status code: " + responseEntity.getStatusCodeValue());
        }
    }
}
