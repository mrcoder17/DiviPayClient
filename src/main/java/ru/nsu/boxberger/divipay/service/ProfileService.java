package ru.nsu.boxberger.divipay.service;

import org.springframework.http.*;
import ru.nsu.boxberger.divipay.model.ProfileModel;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

import java.util.List;

public class ProfileService extends BaseService{
//    public List<ProfileModel> getAllUsers;

    public ProfileModel getProfileData(String username) {
        String url = ServerUrls.USERS_URL + /* "?username=" +*/ username;
        ResponseEntity<ProfileModel> responseEntity = requestToServer(null, url, HttpMethod.GET, ProfileModel.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Failed to retrieve profile data. Status code: " + responseEntity.getStatusCodeValue());
        }
    }

    public void updateProfileData(ProfileModel profileModel) {
        String url = ServerUrls.USERS_URL;
        ResponseEntity<Void> responseEntity = requestToServer(profileModel, url, HttpMethod.PUT, Void.class);
        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Failed to update profile data. Status code: " + responseEntity.getStatusCodeValue());
        }
    }

    public String getAuthenticatedUsername() {
        return "1233";
    }
}
