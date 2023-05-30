package ru.nsu.boxberger.divipay.model;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProfileModel {
    private ObservableList<String> usernames;

    public ProfileModel(){
        usernames = FXCollections.observableArrayList();
    }

    public ObservableList<String> getUsernames() {
        return usernames;
    }

    public void updateProfileData(ProfileData profileData) {
    }

    public void changePassword(String userId, String newPassword) {
    }

    public ProfileData getProfileData(String username) {
        ProfileData profileData = new ProfileData(username);
        return profileData;
    }

    public String getName() {
        return "ss";
    }
}

