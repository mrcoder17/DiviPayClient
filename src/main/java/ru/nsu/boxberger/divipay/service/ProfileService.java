package ru.nsu.boxberger.divipay.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import ru.nsu.boxberger.divipay.model.ProfileModel;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

public class ProfileService extends BaseService{

    public ProfileModel getProfileData(Long id) {
        String url = ServerUrls.USERS_URL + "/" + id;
        ParameterizedTypeReference<ProfileModel> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<ProfileModel> responseEntity = requestToServer(null, url, HttpMethod.GET, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Failed to retrieve profile data. Status code: ///// " + responseEntity.getStatusCodeValue());
        }
    }

    public void updateProfileData(Long userID, ProfileModel profileModel) {
        String url = ServerUrls.USERS_URL + "/" + userID;
        ParameterizedTypeReference<ProfileModel> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<ProfileModel> responseEntity = requestToServer(profileModel, url, HttpMethod.PUT, responseType);

        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Failed to update profile data. Status code: //////" + responseEntity.getStatusCodeValue());
        }
    }
}
