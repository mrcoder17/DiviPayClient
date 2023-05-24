package ru.nsu.boxberger.divipay.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest {
    @JsonProperty ("username")
    private String username;
    @JsonProperty ("password")
    private String password;


    public LoginRequest() {
    }

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
//    @Json

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
