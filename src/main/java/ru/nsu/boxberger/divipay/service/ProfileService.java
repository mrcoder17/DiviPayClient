package ru.nsu.boxberger.divipay.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import ru.nsu.boxberger.divipay.model.ProfileModel;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

public class ProfileService extends BaseService {

    public void updateProfileData(Long userID, ProfileModel profileModel) {
        String url = ServerUrls.USERS_URL + "/" + userID;
        ParameterizedTypeReference<ProfileModel> responseType = new ParameterizedTypeReference<>() {
        };
        ResponseEntity<ProfileModel> responseEntity = requestToServer(profileModel, url, HttpMethod.PUT, responseType);

        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Failed to update profile data. Status code: " + responseEntity.getStatusCode().value());
        }
    }
}
