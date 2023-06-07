package ru.nsu.boxberger.divipay.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest {

    @JsonProperty ("userID")
    private Long userID;

    @JsonProperty ("debt")
    private Double debt;

    @JsonProperty("name")
    private String name;

    @JsonProperty ("username")
    private String username;

    @JsonProperty ("password")
    private String password;

    @JsonProperty ("avatar")
    private String avatar;

    @JsonProperty ("phone")
    private String phone;

    public UserRequest (String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Пользователь " + username +
                " с именем " + name +
                ", телефон для перевода: " + phone;
    }

    public UserRequest() {

    }

    public Long getUserID() {
        return userID;
    }

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

    public Double getDebt() {
        return debt;
    }

    public void setDebt(Double debt) {
        this.debt = debt;
    }
}
