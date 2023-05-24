package ru.nsu.boxberger.divipay.model;

public class ProfileModel {
    public void updateProfileData(ProfileData profileData) {
    }

    public void changePassword(String userId, String newPassword) {
    }

    public ProfileData getProfileData(String nickname) {
        ProfileData profileData = new ProfileData(nickname);
        profileData.setName("John Doe");
        profileData.setAge(30);
        return profileData;
    }
}

