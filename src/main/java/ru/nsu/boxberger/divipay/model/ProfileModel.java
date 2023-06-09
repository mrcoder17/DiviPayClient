package ru.nsu.boxberger.divipay.model;

public class ProfileModel extends UserRequest {

    private static ProfileModel instance;

    private Long userID;
    private String name;
    private String username;
    private String password;
    private String avatar;
    private String phone;

    public static ProfileModel getInstance() {
        if (instance == null) {
            instance = new ProfileModel();
        }
        return instance;
    }

    @Override
    public Long getUserID() {
        return userID;
    }

    @Override
    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

