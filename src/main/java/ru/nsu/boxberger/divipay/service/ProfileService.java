package ru.nsu.boxberger.divipay.service;

import org.springframework.http.*;
import ru.nsu.boxberger.divipay.model.ProfileData;
import ru.nsu.boxberger.divipay.model.ProfileModel;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

import java.util.List;

public class ProfileService extends BaseService{
    public List<ProfileModel> getAllUsers;

    public ProfileData getProfileData(ProfileData profileData) {
        ResponseEntity<ProfileData> responseEntity = requestToServer(profileData, ServerUrls.USERS_URL, HttpMethod.POST, ProfileData.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Failed to retrieve profile data. Status code: " + responseEntity.getStatusCodeValue());
        }
    }
}
