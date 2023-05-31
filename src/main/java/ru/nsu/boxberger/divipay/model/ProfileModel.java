package ru.nsu.boxberger.divipay.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class ProfileModel {
    private ObservableList<String> usernames;
    private String name;
    private String username;
    private String password;
    private String avatar;
    private String phone;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public ProfileModel(){
        usernames = FXCollections.observableArrayList();
    }

    public ObservableList<String> getUsernames() {
        return usernames;
    }
}

